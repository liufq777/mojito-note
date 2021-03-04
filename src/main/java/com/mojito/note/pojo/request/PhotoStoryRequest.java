package com.mojito.note.pojo.request;

import lombok.Getter;
import lombok.Setter;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2020-01-23 10:18
 */
@Getter
@Setter
public class PhotoStoryRequest {

    private Long id;
    /** 照片URL */
    private String photoUrl;
    /** 感想 */
    private String impression;
}
