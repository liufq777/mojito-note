package com.mojito.note.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mojito.note.pojo.entity.TodoPlan;

import java.util.List;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2019-12-22 20:36
 */
public interface TodoPlanService extends IService<TodoPlan> {

    /**
     * 根据用户id查询
     * @param userId
     * @return
     */
    List<TodoPlan> listByUserId(Long userId);
}
