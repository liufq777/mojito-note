package com.mojito.note.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mojito.note.mapper.UserMapper;
import com.mojito.note.pojo.entity.UserDo;
import com.mojito.note.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2019-12-17 21:43
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDo> implements UserService {

    @Override
    public UserDo getByMobileNo(String mobileNo) {
        UserDo user = getOne(new QueryWrapper<UserDo>().lambda().eq(UserDo::getMobileNo, mobileNo));
        if (user == null) {
            user = new UserDo();
            user.setMobileNo(mobileNo);
            user.setNickname("新增用户");
            user.setDeletedFlg(0L);
        }
        user.setLastLoginAt(new Date());
        saveOrUpdate(user);
        return user;
    }
}
