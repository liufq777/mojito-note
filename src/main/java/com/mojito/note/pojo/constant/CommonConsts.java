package com.mojito.note.pojo.constant;

/**
 * description 通用常量
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2020-05-18 11:48
 */
public class CommonConsts {

    /** 查询范围 0.当前用户 1.所有用户 */
    public static final int QUERY_RANGE_USER_CURRENT = 0;
    public static final int QUERY_RANGE_USER_ALL = 1;

    /** 评论模块-笔记 */
    public static final Integer COMMENT_MODULE_NOTE = 0;
    /** 评论模块-朋友圈 */
    public static final Integer COMMENT_MODULE_FRIENDS = 1;
    /** 评论模块-微话 */
    public static final Integer COMMENT_MODULE_MICRO_SENTENCE = 2;

    /** 七牛参数 */
    public static final String QINIU_ACCESS_KEY = "kZoKDxJl-y3bGrNR4VKDkTqXY6SljjvtbUJWNk8M";
    public static final String QINIU_SECRET_KEY = "y451XkKxrXvB5JqdSWmHQMa7HsJUoP3llGU3ouqa";
    public static final String QINIU_BUCKET = "charles-web";
}
