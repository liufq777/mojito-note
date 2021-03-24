package com.mojito.note.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mojito.note.pojo.entity.UserDo;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2019-12-17 21:42
 */
public interface UserService extends IService<UserDo> {

    /**
     * 验证码登录
     * @param mobileNo
     * @return
     */
    UserDo getByMobileNo(String mobileNo);
}
