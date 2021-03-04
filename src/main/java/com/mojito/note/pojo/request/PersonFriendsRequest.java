package com.mojito.note.pojo.request;

import com.mojito.note.pojo.constant.PermissionEnum;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2019-12-17 19:20
 */
@Getter
@Setter
public class PersonFriendsRequest {

    /** 内容 */
    @NotBlank
    private String content;
    /** 权限
     * @see PermissionEnum */
    private Integer permission = PermissionEnum.PUBLIC.getValue();
}
