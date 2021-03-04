package com.mojito.note.controller;

import com.mojito.common.Response;
import com.mojito.note.pojo.constant.CommonConsts;
import com.qiniu.util.Auth;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2020-08-21 09:40
 */
@RestController
@RequestMapping("/qiniu")
public class QiniuController {

    /**
     * 获取七牛上传凭证
     * @return
     */
    @GetMapping("/token")
    public Response token() {
        Auth auth = Auth.create(CommonConsts.QINIU_ACCESS_KEY, CommonConsts.QINIU_SECRET_KEY);
        String upToken = auth.uploadToken(CommonConsts.QINIU_BUCKET);
        return Response.ok(upToken);
    }
}
