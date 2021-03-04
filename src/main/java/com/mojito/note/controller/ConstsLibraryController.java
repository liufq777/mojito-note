package com.mojito.note.controller;//package com.mojito.note.comtroller;
//
//import com.mojito.common.Response;
//import com.mojito.note.pojo.entity.ConstsLibrary;
//import com.mojito.note.pojo.request.ConstsLibraryRequest;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import javax.validation.Valid;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * description 常量库
// *
// * @author liufengqiang <liufengqiang@touchealth.com>
// * @date 2019-12-18 16:50
// */
//@RestController
//@RequestMapping("/consts-library")
//public class ConstsLibraryController {
//
//    @Resource
//    private ConstsLibraryService constsLibraryService;
//
//    @PostMapping
//    public Response save(@Valid @RequestBody ConstsLibraryRequest request) {
//        List<ConstsLibrary> constsLibraryBos = Arrays.stream(request.getValue().split(",")).map(o -> {
//            ConstsLibrary constsLibraryBo = new ConstsLibrary();
//            constsLibraryBo.setConstsKey(request.getConstsKey());
//            constsLibraryBo.setValue(o);
//            return constsLibraryBo;
//        }).collect(Collectors.toList());
//        constsLibraryService.save(constsLibraryBos);
//        return Response.ok();
//    }
//}
