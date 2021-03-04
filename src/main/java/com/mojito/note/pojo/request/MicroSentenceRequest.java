package com.mojito.note.pojo.request;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2020-04-18 09:53
 */
@Getter
@Setter
public class MicroSentenceRequest {

    /** 分类 */
    private String category;
    /** 标签 */
    private List<String> tags;
    /** 来源出处 */
    private String source;
    /** 作者 */
    private String author;
    /** 内容 */
    @NotBlank(message = "内容不能为空")
    private String content;
    /** 感受 */
    private String feel;
    /** 背景图地址 */
    private String imageUrl;
}
