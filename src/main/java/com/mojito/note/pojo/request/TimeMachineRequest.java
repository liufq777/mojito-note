package com.mojito.note.pojo.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author liufengqiang
 * @date 2020-11-20 17:38:46
 */
@Data
public class TimeMachineRequest {

    /** 内容 */
    @NotNull(message = "内容不能为空")
    private String content;
    /** 图片url */
    private List<String> imageUrls;
}
