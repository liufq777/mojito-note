package com.mojito.note.controller;

import com.mojito.common.BaseHelper;
import com.mojito.common.Response;
import com.mojito.note.pojo.dto.FileDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * description 远程控制
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2019-12-13 11:22
 */
@Slf4j
@RestController
@RequestMapping("/remote-access")
public class RemoteAccessController {

    @GetMapping
    @CrossOrigin
    public Response index(String path, Boolean isDirectory) {
        File file;
        if (StringUtils.isEmpty(path) || "undefined".equals(path)) {
//            file = new File(RemoteAccessController.class.getResource("/").getPath());
            file = new File("/Users/charles/Documents");
        } else {
            file = new File(path);
        }
        log.info(file.getPath());
        if (isDirectory == null || isDirectory) {
            FileDto dto = new FileDto();
            dto.setCurrentPath(file.getPath());
            dto.setLastPath(file.getPath().substring(0, file.getPath().lastIndexOf(File.separator)));
            dto.setChildFiles(Arrays.stream(Objects.requireNonNull(file.listFiles())).map(o -> {
                FileDto.ChildFileDto childFileDto = BaseHelper.r2t(o, FileDto.ChildFileDto.class);
                childFileDto.setIsDirectory(o.isDirectory());
                return childFileDto;
            }).collect(Collectors.toList()));
            return Response.ok(dto);
        } else {
            String extension = file.getPath().substring(file.getPath().lastIndexOf("."));
            if (Arrays.asList("txt", "text", "properties").contains(extension)) {
                return Response.ok();
            } else {
                return Response.ok();
            }
        }
    }
}
