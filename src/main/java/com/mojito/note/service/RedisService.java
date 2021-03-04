package com.mojito.note.service;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2020-05-13 16:07
 */
public interface RedisService {

    /**
     * 点赞
     *
     * @param userId 点赞人
     * @param dataId 点赞数据
     */
    void favour(Long userId, Long dataId);

    /**
     * 查询用户点赞数据
     *
     * @param userId 用户id
     */
    void findFavourByUserId(Long userId);
}
