package com.mojito.note.service.impl;

import com.mojito.note.helper.RedisHelper;
import com.mojito.note.service.RedisService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2020-05-13 16:08
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Resource
    RedisTemplate redisTemplate;

    @Override
    public void favour(Long userId, Long dataId) {
        redisTemplate.opsForHash().put(RedisHelper.MAP_KEY_USER_LIKED, RedisHelper.getFavourKey(userId, dataId), 1);
    }

    @Override
    public void findFavourByUserId(Long userId) {
//        redisTemplate
    }
}
