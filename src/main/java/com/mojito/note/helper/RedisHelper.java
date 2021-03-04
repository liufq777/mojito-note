package com.mojito.note.helper;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2020-05-13 16:25
 */
public class RedisHelper {

    /** 保存用户点赞数据的key */
    public static final String MAP_KEY_USER_LIKED = "map_user_liked";
    public static final String MAP_USER_LIKED_COUNT = "map_user_liked_count";

    public static String getFavourKey(Long userId, Long dataId) {
        return userId + ":" + dataId;
    }
}
