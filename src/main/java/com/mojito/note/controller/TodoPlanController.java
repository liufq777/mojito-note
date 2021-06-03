package com.mojito.note.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mojito.common.BaseHelper;
import com.mojito.common.Response;
import com.mojito.common.util.DateUtils;
import com.mojito.note.pojo.dto.TodoPlanDto;
import com.mojito.note.pojo.entity.TodoPlan;
import com.mojito.note.pojo.entity.TodoPlanItem;
import com.mojito.note.pojo.request.TodoPlanRequest;
import com.mojito.note.service.TodoPlanItemService;
import com.mojito.note.service.TodoPlanService;
import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
    private TodoPlanItemService todoPlanItemService;

    /**
     * 计划列表
     */
    @GetMapping
    public Response list(@RequestAttribute Long loginId) {
        List<TodoPlan> todoPlans = todoPlanService.list(Wrappers.<TodoPlan>lambdaQuery()
                .eq(TodoPlan::getUserId, loginId)
                .orderByDesc(TodoPlan::getUpdatedAt));
        if (CollectionUtils.isEmpty(todoPlans)) {
            return Response.ok();
        }

        List<TodoPlanItem> todoPlanItems = todoPlanItemService.list(Wrappers.<TodoPlanItem>lambdaQuery()
                .in(TodoPlanItem::getTodoPlanId, todoPlans.stream().map(TodoPlan::getId).collect(Collectors.toList()))
                .orderByAsc(TodoPlanItem::getIsComplete)
                .orderByDesc(TodoPlanItem::getUpdatedAt));
        Map<Long, List<TodoPlanItem>> todoPlanItemMap = todoPlanItems.stream().collect(Collectors.groupingBy(TodoPlanItem::getTodoPlanId));
        LinkedHashMap<String, List<TodoPlan>> todoPlanMap = todoPlans.stream().collect(Collectors.groupingBy(TodoPlan::getCategory, LinkedHashMap::new, Collectors.toList()));

        List<TodoPlanDto> dtos = new ArrayList<>();
        todoPlanMap.forEach((k, v) -> {
            List<TodoPlanDto.TodoDto> todoDtos = v.stream().map(o -> {
                TodoPlanDto.TodoDto todoDto = BaseHelper.r2t(o, TodoPlanDto.TodoDto.class);
                todoDto.setTodoPlanItems(BaseHelper.r2t(todoPlanItemMap.get(o.getId()), TodoPlanDto.TodoPlanItemDto.class));
                todoDto.setCreatedAt(DateUtils.formatPretty(o.getCreatedAt()));
                return todoDto;
            }).collect(Collectors.toList());
            dtos.add(new TodoPlanDto(k, todoDtos));
        });
        return Response.ok(dtos);
    }

    /**
     * 新增计划
     */
    @PostMapping
    public Response save(@RequestAttribute Long loginId, @Valid @RequestBody TodoPlanRequest request) {
        if (request.getId() != null) {
            TodoPlan todoPlan = todoPlanService.getById(request.getId());
            BeanUtils.copyProperties(request, todoPlan);
            todoPlanService.updateById(todoPlan);

            if (StringUtils.isNotBlank(request.getTodoPlanItem())) {
                TodoPlanItem todoPlanItem = new TodoPlanItem();
                todoPlanItem.setUserId(loginId);
                todoPlanItem.setTodoPlanId(request.getId());
                todoPlanItem.setContent(request.getTodoPlanItem());
                todoPlanItemService.save(todoPlanItem);
            }
        }
        return Response.ok();
    }

    /**
     * 删除计划项
     */
    @DeleteMapping("/item/{id}")
    public Response delete(@RequestAttribute Long loginId, @PathVariable Long id) {
        TodoPlanItem todoPlanItem = todoPlanItemService.getById(id);
        Assert.notNull(todoPlanItem, "记录不存在");
        Assert.isTrue(loginId.equals(todoPlanItem.getUserId()), "没有权限");
        todoPlanItemService.removeById(id);
        return Response.ok();
    }

    /**
     * 更新完成状态
     */
    @PutMapping("/item/{id}/is-complete")
    public Response finish(@RequestAttribute Long loginId, @PathVariable Long id) {
        TodoPlanItem todoPlanItem = todoPlanItemService.getById(id);
        Assert.notNull(todoPlanItem, "记录不存在");
        Assert.isTrue(loginId.equals(todoPlanItem.getUserId()), "没有权限");

        todoPlanItemService.update(Wrappers.<TodoPlanItem>lambdaUpdate()
                .set(TodoPlanItem::getIsComplete, !todoPlanItem.getIsComplete())
                .eq(TodoPlanItem::getId, id));
        return Response.ok();
    }
}
