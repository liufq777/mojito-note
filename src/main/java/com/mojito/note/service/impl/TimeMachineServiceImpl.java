package com.mojito.note.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mojito.note.mapper.TimeMachineMapper;
import com.mojito.note.pojo.entity.TimeMachine;
import com.mojito.note.service.TimeMachineService;
import org.springframework.stereotype.Service;

/**
 * @author liufengqiang
 * @date 2020-11-20 17:36:43
 */
@Service
public class TimeMachineServiceImpl extends ServiceImpl<TimeMachineMapper, TimeMachine> implements TimeMachineService {
}
