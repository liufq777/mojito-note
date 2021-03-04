package com.mojito.note.service.impl;//package com.mojito.note.service.impl;
//
//import com.mojito.note.pojo.table.PersonFriends;
//import com.mojito.note.service.PersonFriendsService;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
///**
// * description
// *
// * @author liufengqiang <liufengqiang@touchealth.com>
// * @date 2019-12-17 19:33
// */
//@Service
//public class PersonFriendsServiceImpl implements PersonFriendsService {
//
////    @Resource
////    private PersonFriendsRepository personFriendsRepository;
//
//    @Override
//    public void save(PersonFriends personFriendsBo) {
////        if (personFriendsBo.getCreatedAt() == null) {
////            personFriendsBo.setCreatedAt(new Date());
////        }
////        if (personFriendsBo.getUpdatedAt() == null) {
////            personFriendsBo.setUpdatedAt(new Date());
////        }
////        if (personFriendsBo.getDeletedFlg() == null) {
////            personFriendsBo.setDeletedFlg(0L);
////        }
////        personFriendsRepository.save(BaseHelper.r2t(personFriendsBo, PersonFriends.class));
//    }
//
//    @Override
//    public List<PersonFriends> listByUserId(Long userId) {
////        return BaseHelper.r2t(personFriendsRepository.findByUserIdOrderByCreatedAtDesc(userId), PersonFriendsBo.class);
//        return null;
//    }
//
//    @Override
//    public List<PersonFriends> listAll() {
////        return BaseHelper.r2t(personFriendsRepository.findByDeletedFlgOrderByCreatedAtDesc(0L), PersonFriendsBo.class);
//        return null;
//    }
//
//    @Override
//    public PersonFriends findById(Long id) {
////        return BaseHelper.r2t(personFriendsRepository.findByIdAndDeletedFlg(id, 0L), PersonFriendsBo.class);
//        return null;
//    }
//}
