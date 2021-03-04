package com.mojito.note.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mojito.common.Response;
import com.mojito.note.pojo.entity.VideoParse;
import com.mojito.note.service.VideoParseService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executors;

/**
 * @author liufengqiang
 * @date 2021-01-11 15:15:55
 */
@RestController
@RequestMapping("/video")
@Slf4j
public class VideoParseController {

    @Resource
    private VideoParseService videoParseService;
    @Value(value = "${spring.profiles.active}")
    private String profiles;

    /**
     * 视频解析列表
     */
    @GetMapping
    public Response list() {
        log.info("test");
        return Response.ok(videoParseService.list(Wrappers.<VideoParse>lambdaQuery().orderByDesc(VideoParse::getId)));
    }

    /**
     * 视频解析
     */
    @PostMapping("/parse")
    public Response parse(@RequestParam String videoUrl) {
        Assert.isTrue(StringUtils.isNotBlank(videoUrl), "视频地址不能为空");

        String videoDir = String.valueOf(System.currentTimeMillis());
        VideoParse videoParse = new VideoParse();
        videoParse.setVideoUrl(videoUrl.trim());
        videoParseService.add(videoParse);

        String scripDir;
        String param1;
        if ("dev".equals(profiles)) {
            String rootPath = this.getClass().getResource("/").getPath();
            scripDir = new File(rootPath, "video-download").getAbsolutePath();
            param1 = "video/" + videoDir;
        } else {
            scripDir = "/root/mojito-web/video-download";
            param1 = "/root/nginx/html/" + videoDir;
        }
        log.info("脚本地址，{}", scripDir);

        Executors.newSingleThreadExecutor().execute(() -> {
            try {
                ProcessBuilder processBuilder = new ProcessBuilder(scripDir, param1, videoUrl.trim());
                processBuilder.redirectErrorStream(true);
                log.info("解析脚本：{}", processBuilder.command());
                Process process = processBuilder.start();

                Executors.newSingleThreadExecutor().execute(() -> {
                    InputStream is = process.getInputStream();
                    String out = consumeInputStream(is);
                    log.info("解析日志：" + out);
                });

                if (process.waitFor() != 0) {
                    log.error("视频解析异常");
                    process.destroy();
                }
            } catch (IOException | InterruptedException e) {
                videoParse.setParseStatus(2);
                log.error("解析异常", e);
            } finally {
                log.info("执行完成，{}", param1);

                File[] files = new File(param1).listFiles();
                if (files != null && files.length > 0) {
                    String videoName = "";
                    if (files.length > 1) {
                        for (File f : files) {
                            String name = f.getName();
                            if (!"xml".equals(name.substring(name.lastIndexOf(".") + 1))) {
                                videoName = name;
                                break;
                            }
                        }
                    } else {
                        videoName = files[0].getName();
                    }

                    videoParse.setVideoName(videoName);
                    videoParse.setFilePath(videoDir + File.separator + videoParse.getVideoName());
                    videoParse.setParseStatus(1);
                } else {
                    videoParse.setParseStatus(2);
                }
                videoParseService.updateById(videoParse);
            }
        });
        return Response.ok();
    }

    private String consumeInputStream(InputStream is) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String s;
            StringBuilder sb = new StringBuilder();
            while ((s = br.readLine()) != null) {
                System.out.println(s);
                sb.append(s);
            }
            return sb.toString();
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * 视频下载
     */
    @GetMapping("/{id}/download")
    public void download(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response) {
        VideoParse videoParse = videoParseService.getById(id);
        Assert.notNull(videoParse, "记录不存在");

        File videoFile = new File(videoParse.getFilePath());
        File[] files = videoFile.listFiles();
        Assert.isTrue(files != null && files.length > 0, "下载失败");

        try {
            InputStream stream = new BufferedInputStream(new FileInputStream(files[0]));
            byte[] buff = new byte[1024];
            int length;
            long totalLength = 0L;
            response.setContentType("application/octet-stream");
            response.setCharacterEncoding("UTF-8");

            String encoding = request.getCharacterEncoding();
            if (StringUtils.isBlank(encoding)) {
                encoding = StandardCharsets.UTF_8.toString();
            }
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(files[0].getName(), encoding));
            ServletOutputStream responseOutputStream = response.getOutputStream();
            while ((length = stream.read(buff)) > 0) {
                totalLength += length;
                responseOutputStream.write(buff, 0, length);
            }
            response.setHeader("Content-Length", Long.toString(totalLength));
            stream.close();
            responseOutputStream.flush();
            responseOutputStream.close();
        } catch (Exception e) {
            log.error("下载异常", e);
        }
    }

    /**
     * 删除视频解析
     */
    @DeleteMapping("/{id}")
    public Response delete(@PathVariable Long id) {
        videoParseService.removeById(id);
        return Response.ok();
    }
}
