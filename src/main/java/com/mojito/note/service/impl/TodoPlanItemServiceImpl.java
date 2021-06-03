package com.mojito.note.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mojito.note.mapper.TodoPlanItemMapper;
import com.mojito.note.pojo.entity.TodoPlanItem;
import com.mojito.note.service.TodoPlanItemService;
import org.springframework.stereotype.Service;

/**
 * @author liufengqiang
 * @date 2021-06-02 13:44:47
 */
@Service
public class TodoPlanItemServiceImpl extends ServiceImpl<TodoPlanItemMapper, TodoPlanItem> implements TodoPlanItemService {
}
