package com.mojito.note.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mojito.note.mapper.CategoryMapper;
import com.mojito.note.pojo.entity.CategoryDo;
import com.mojito.note.service.CategoryService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2020-08-12 13:42
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, CategoryDo> implements CategoryService {

    @Override
    public List<CategoryDo> listByModuleType(int moduleType) {
        return list(new QueryWrapper<CategoryDo>().lambda().eq(CategoryDo::getModuleType, moduleType).orderByDesc(CategoryDo::getUpdatedAt));
    }

    @Override
    public CategoryDo getByCategoryName(Long userId, String categoryName, Integer moduleType) {
        return getOne(new QueryWrapper<CategoryDo>().lambda()
                .eq(CategoryDo::getUserId, userId)
                .eq(CategoryDo::getName, categoryName)
                .eq(CategoryDo::getModuleType, moduleType));
    }

    @Override
    public void updateUpdateAt(Long id) {
        update(new UpdateWrapper<CategoryDo>().lambda().set(CategoryDo::getUpdatedAt, LocalDateTime.now()).eq(CategoryDo::getId, id));
    }
}
