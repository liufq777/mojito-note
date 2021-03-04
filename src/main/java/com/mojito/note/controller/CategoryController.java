package com.mojito.note.controller;//package com.mojito.note.comtroller;
//
//import com.mojito.common.BaseHelper;
//import com.mojito.common.Response;
//import com.mojito.note.helper.PermissionHelper;
//import com.mojito.note.pojo.dto.CategoryDto;
//import com.mojito.note.pojo.param.CategoryParam;
//import com.mojito.note.pojo.request.CategoryRequest;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//import javax.validation.Valid;
//import java.util.Date;
//import java.util.LinkedList;
//import java.util.List;
//
///**
// * description 分类接口
// *
// * @author liufengqiang <liufengqiang@touchealth.com>
// * @date 2020-08-12 13:40
// */
//@RestController
//@RequestMapping("/category")
//public class CategoryController {
//
//    @Resource
//    private CategoryService categoryService;
//
//    /**
//     * 分类列表
//     *
//     * @param moduleType 模块类型 0.笔记 1.todo
//     */
//    @GetMapping
//    public Response list(@RequestAttribute Long loginId, @RequestParam Long userId, @RequestParam Integer moduleType) {
//        new LinkedList();
//        CategoryParam param = new CategoryParam();
//        param.setModuleType(moduleType);
//        param.setUserId(userId);
//        param.setPermissions(PermissionHelper.getPermission(userId, loginId));
//        List<Category> categories = categoryService.listByParam(param);
//        return Response.ok(BaseHelper.r2t(categories, CategoryDto.class));
//    }
//
//    /**
//     * 新增分类
//     */
//    @PostMapping
//    public Response add(@RequestAttribute Long loginId, @RequestBody @Valid CategoryRequest request) {
//        Category category = new Category();
//        category.setUserId(loginId);
//        category.setName(request.getName());
//        category.setModuleType(request.getModuleType());
//        categoryService.add(category);
//        return Response.ok();
//    }
//
//    /**
//     * 删除分类
//     */
//    @DeleteMapping("/{id}")
//    public Response delete(@RequestAttribute Long loginId, @PathVariable Long id) {
//        Category category = categoryService.findById(id);
//        Assert.notNull(category, "记录已存在");
//        category.setDeletedAt(new Date());
//        category.setDeletedFlg(category.getId());
//        categoryService.update(category);
//        return Response.ok();
//    }
//}
