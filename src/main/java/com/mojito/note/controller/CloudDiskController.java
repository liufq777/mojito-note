package com.mojito.note.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mojito.common.BaseHelper;
import com.mojito.common.Response;
import com.mojito.common.util.DateUtils;
import com.mojito.note.pojo.dto.CloudDiskDto;
import com.mojito.note.pojo.entity.CloudDiskDo;
import com.mojito.note.service.CloudDiskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liufengqiang
 * @date 2020-12-10 18:42:27
 */
@RestController
@RequestMapping("/cloud-disk")
public class CloudDiskController {

    @Resource
    private CloudDiskService cloudDiskService;

    /**
     * 文件列表
     */
    @GetMapping
    public Response list(@RequestParam(defaultValue = "0") Integer sortType, Long parentId) {
        LambdaQueryWrapper<CloudDiskDo> queryWrapper = new QueryWrapper<CloudDiskDo>().lambda();
        if (parentId != null) {
            queryWrapper.eq(CloudDiskDo::getParentId, parentId);
        }
        List<CloudDiskDo> cloudDiskDos = cloudDiskService.list(queryWrapper.orderByDesc(CloudDiskDo::getCreatedAt));
        List<CloudDiskDto> dtos = cloudDiskDos.stream().map(o -> {
            CloudDiskDto dto = BaseHelper.r2t(o, CloudDiskDto.class);
            dto.setCreatedAt(DateUtils.formatPretty(o.getCreatedAt()));
            return dto;
        }).collect(Collectors.toList());
        return Response.ok(dtos);
    }
}
