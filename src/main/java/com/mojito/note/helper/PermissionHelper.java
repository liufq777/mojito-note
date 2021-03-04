package com.mojito.note.helper;

import com.mojito.note.pojo.constant.PermissionEnum;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2020-08-14 12:55
 */
public class PermissionHelper {

    public static List<Integer> getPermission(Long userId, Long loginId) {
        if (userId == null) {
            return Arrays.asList(PermissionEnum.PUBLIC.getValue(), PermissionEnum.ANONYMITY.getValue());
        } else if (!loginId.equals(userId)) {
            return Collections.singletonList(PermissionEnum.PUBLIC.getValue());
        } else {
            return Arrays.asList(PermissionEnum.PUBLIC.getValue(), PermissionEnum.ANONYMITY.getValue(), PermissionEnum.PRIVATE.getValue());
        }
    }
}
