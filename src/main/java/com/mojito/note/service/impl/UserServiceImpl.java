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
//            user.setNickname(constsLibraryService.findRandomName());
            user.setNickname("新增用户");
            user.setDeletedFlg(0L);
        }
        user.setLastLoginAt(new Date());
        saveOrUpdate(user);
        return user;
    }
//public class UserServiceImpl implements UserService {

//    @Resource
//    private UserRepository userRepository;
//    @Resource
//    private ConstsLibraryService constsLibraryService;

//    @Override
//    public void save(UserDo userBo) {
////        userRepository.save(BaseHelper.r2t(userBo, SysUser.class));
//    }
//
//    @Override
//    public UserDo findById(Long userId) {
////        SysUser sysUser = userRepository.findByIdAndDeletedFlg(userId, 0L);
////        if (StringUtils.isEmpty(sysUser.getPortrait())) {
////            sysUser.setPortrait(constsLibraryService.findByConstsKeyOne(ConstsKeyEnum.KEY_DEFAULT_PORTRAIT.getValue()));
////        }
////        return BaseHelper.r2t(sysUser, UserBo.class);
//        return null;
//    }
//
//    @Override
//    public UserDo findByMobileNo(String mobileNo) {
////        SysUser user = userRepository.findByMobileNoAndDeletedFlg(mobileNo, 0L);
////        if (user == null) {
////            user = new SysUser();
////            user.setMobileNo(mobileNo);
////            user.setNickname(constsLibraryService.findRandomName());
////            user.setDeletedFlg(0L);
////            user.setCreatedAt(new Date());
////            user.setUpdatedAt(new Date());
////            user.setLastLoginAt(new Date());
////        }
////        user.setLastLoginAt(new Date());
////        userRepository.save(user);
////        return BaseHelper.r2t(user, UserBo.class);
//        return null;
//    }
//
//    @Override
//    public UserDo findByPermission(Integer permission, Long userId) {
////        UserBo userBo;
////        if (PermissionEnum.PERMISSION_ANONYMITY.getValue().equals(permission)) {
////            userBo = new UserBo();
////            userBo.setId(null);
////            userBo.setNickname(constsLibraryService.findRandomName());
////            userBo.setPortrait(constsLibraryService.findByConstsKey(ConstsKeyEnum.KEY_PORTRAIT_URL.getValue()));
////        } else {
////            userBo = findById(userId);
////        }
////        return userBo;
//        return null;
//    }
}
