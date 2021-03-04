package com.mojito.note.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.mojito.common.BaseHelper;
import com.mojito.common.Response;
import com.mojito.common.util.DateUtils;
import com.mojito.common.util.IgnorePropertiesUtils;
import com.mojito.note.pojo.dto.TodoListDto;
import com.mojito.note.pojo.entity.CategoryDo;
import com.mojito.note.pojo.entity.TodoPlan;
import com.mojito.note.pojo.param.CategoryParam;
import com.mojito.note.pojo.request.TodoPlanRequest;
import com.mojito.note.service.CategoryService;
import com.mojito.note.service.TodoPlanService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * description todo计划
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2019-12-20 13:36
 */
@RestController
@RequestMapping("/todo-plan")
public class TodoPlanController {

    @Resource
    private TodoPlanService todoPlanService;
    @Resource
    private CategoryService categoryService;

    /**
     * todo列表
     */
    @GetMapping
    public Response list() {
        List<TodoPlan> todoPlans = todoPlanService.listByUserId(1L);
        if (CollectionUtils.isEmpty(todoPlans)) {
            return Response.ok();
        }

        Map<Long, List<TodoListDto.TodoDto>> noteMap = new HashMap<>();
        todoPlans.forEach(o -> {
            List<TodoListDto.TodoDto> noteDtos = noteMap.get(o.getCategoryId());
            if (noteDtos == null) {
                noteDtos = new ArrayList<>();
            }
            TodoListDto.TodoDto todoDto = BaseHelper.r2t(o, TodoListDto.TodoDto.class);
            try {
                String[] split = o.getContent().split("\n");
                for (int i = 0; i < split.length; i++) {
                    if (StringUtils.isNotBlank(split[i]) && StringUtils.isBlank(todoDto.getTitle())) {
                        todoDto.setTitle(split[i]);
                    }
                    if (i != 0 && StringUtils.isNotBlank(split[i]) && StringUtils.isBlank(todoDto.getDescribe())) {
                        todoDto.setDescribe(split[i]);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            todoDto.setCreatedAt(DateUtils.formatPretty(o.getCreatedAt()));
            noteDtos.add(todoDto);
            noteMap.put(o.getCategoryId(), noteDtos);
        });

        List<CategoryDo> categories = categoryService.listByModuleType(1);
        List<TodoListDto> dtos = categories.stream().map(o -> {
            TodoListDto dto = BaseHelper.r2t(o, TodoListDto.class);
            dto.setTodos(noteMap.get(o.getId()));
            return dto;
        }).collect(Collectors.toList());
        return Response.ok(dtos);
    }

    /**
     * 新增/编辑todo
     */
    @PostMapping
    public Response save(@RequestAttribute Long loginId, @RequestBody TodoPlanRequest request) {
        TodoPlan todoPlanBo;
        if (request.getId() == null) {
            todoPlanBo = BaseHelper.r2t(request, TodoPlan.class);
            todoPlanBo.setUserId(loginId);

            if (request.getCategoryId() == null) {
                if (StringUtils.isNotBlank(request.getCategoryName())) {
                    CategoryParam param = new CategoryParam();
                    param.setUserId(loginId);
                    param.setName(request.getCategoryName());
                    CategoryDo category = categoryService.getByCategoryName(loginId, request.getCategoryName(), 1);
                    todoPlanBo.setCategoryId(category.getId());
                } else {
                    return Response.error("分类id和分类名不能都为空");
                }
            }
        } else {
            todoPlanBo = todoPlanService.getById(request.getId());
            BeanUtils.copyProperties(request, todoPlanBo, IgnorePropertiesUtils.getNullPropertyNames(request));
            todoPlanBo.setUpdatedAt(LocalDateTime.now());
        }
        todoPlanService.saveOrUpdate(todoPlanBo);

        categoryService.updateUpdateAt(todoPlanBo.getCategoryId());
        return Response.ok();
    }

    /**
     * 完成/未完成todo
     */
    @PutMapping("/{id}/finish")
    public Response finish(@RequestAttribute Long loginId, @PathVariable Long id) {
        TodoPlan todoPlanBo = todoPlanService.getById(id);
        Assert.notNull(todoPlanBo, "记录不存在");
        Assert.isTrue(loginId.equals(todoPlanBo.getUserId()), "没有权限");

        todoPlanService.update(new UpdateWrapper<TodoPlan>().lambda()
                .set(TodoPlan::getIsFinish, !todoPlanBo.getIsFinish())
                .eq(TodoPlan::getId, id));

        categoryService.updateUpdateAt(todoPlanBo.getCategoryId());
        return Response.ok();
    }

    /**
     * 删除todo
     */
    @DeleteMapping("/{id}")
    public Response delete(@RequestAttribute Long loginId, @PathVariable Long id) {
        TodoPlan todoPlanBo = todoPlanService.getById(id);
        Assert.notNull(todoPlanBo, "记录不存在");

        Assert.isTrue(loginId.equals(todoPlanBo.getUserId()), "没有权限");
        todoPlanService.removeById(id);

        categoryService.updateUpdateAt(todoPlanBo.getCategoryId());
        return Response.ok();
    }
}
