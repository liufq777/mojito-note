package com.mojito.note.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mojito.note.mapper.TodoPlanMapper;
import com.mojito.note.pojo.entity.TodoPlan;
import com.mojito.note.service.TodoPlanService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2019-12-22 20:36
 */
@Service
public class TodoPlanServiceImpl extends ServiceImpl<TodoPlanMapper, TodoPlan> implements TodoPlanService {

    @Override
    public List<TodoPlan> listByUserId(Long userId) {
        return list(new QueryWrapper<TodoPlan>().lambda()
                .eq(TodoPlan::getUserId, userId)
                .orderByAsc(TodoPlan::getIsFinish)
                .orderByDesc(TodoPlan::getUpdatedAt));
    }
}
