package com.mojito.note.pojo.request;

import lombok.Getter;
import lombok.Setter;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2019-12-18 13:35
 */
@Getter
@Setter
public class UserRequest {

    /** 昵称 */
    private String nickname;
    /** 个性签名 */
    private String signature;
}
