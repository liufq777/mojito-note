package com.mojito.note.service.impl;//package com.mojito.note.service.impl;
//
//import com.mojito.note.pojo.enums.ConstsKeyEnum;
//import com.mojito.note.pojo.table.ConstsLibrary;
//import com.mojito.note.service.ConstsLibraryService;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
///**
// * description
// *
// * @author liufengqiang <liufengqiang@touchealth.com>
// * @date 2019-12-18 17:23
// */
//@Service
//public class ConstsLibraryServiceImpl implements ConstsLibraryService {
//
////    @Resource
////    private ConstsLibraryRepository constsLibraryRepository;
//
//    @Override
//    public void save(List<ConstsLibrary> constsLibraryBos) {
////        constsLibraryRepository.saveAll(BaseHelper.r2t(constsLibraryBos, ConstsLibrary.class));
//    }
//
//    @Override
//    public String findByConstsKey(String constsKey) {
////        List<ConstsLibrary> constsLibraries = constsLibraryRepository.findByConstsKey(constsKey);
////        return constsLibraries.get(new Random().nextInt(constsLibraries.size())).getValue();
//        return null;
//    }
//
//    @Override
//    public String findByConstsKeyOne(String constsKey) {
////        return constsLibraryRepository.findByConstsKey(constsKey).get(0).getValue();
//        return null;
//    }
//
//    @Override
//    public String findRandomName() {
//        return findByConstsKey(ConstsKeyEnum.KEY_ADJECTIVE.getValue()) + findByConstsKey(ConstsKeyEnum.KEY_NAME.getValue());
//    }
//}
