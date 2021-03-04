package com.mojito.note.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mojito.note.mapper.CloudDiskMapper;
import com.mojito.note.pojo.entity.CloudDiskDo;
import com.mojito.note.service.CloudDiskService;
import org.springframework.stereotype.Service;

/**
 * @author liufengqiang
 * @date 2020-12-10 18:44:11
 */
@Service
public class CloudDiskServiceImpl extends ServiceImpl<CloudDiskMapper, CloudDiskDo> implements CloudDiskService {
}
