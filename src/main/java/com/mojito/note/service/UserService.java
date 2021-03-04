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

    //    void save(SysUser userBo);
//
//    SysUser findById(Long userId);
//
    UserDo getByMobileNo(String mobileNo);
//
//    /**
//     * 根据笔记权限返回用户信息
//     * @param permission
//     * @param userId
//     * @return
//     */
//    SysUser findByPermission(Integer permission, Long userId);
}
