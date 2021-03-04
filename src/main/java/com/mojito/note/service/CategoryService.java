package com.mojito.note.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mojito.note.pojo.entity.CategoryDo;

import java.util.List;
import java.util.Set;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2020-08-12 13:42
 */
public interface CategoryService extends IService<CategoryDo> {

    /**
     * 根据moduleType查询
     * @param moduleType
     * @return
     */
    List<CategoryDo> listByModuleType(int moduleType);

    /**
     * 根据分类名查询
     * @param userId
     * @param categoryName
     * @param moduleType
     * @return
     */
    CategoryDo getByCategoryName(Long userId, String categoryName, Integer moduleType);

    /**
     * 更新更新时间
     * @param id
     */
    void updateUpdateAt(Long id);
}
