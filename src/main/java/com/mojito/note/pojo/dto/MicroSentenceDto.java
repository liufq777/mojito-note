package com.mojito.note.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Set;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2020-01-18 21:33
 */
@Data
@AllArgsConstructor
public class MicroSentenceDto {

    /** 标签列表 */
    private Set<String> tags;
    /** 佳句列表 */
    private List<MicroSentence> sentences;
    /** 标题列表 */
    private List<String> titles;

    @Data
    public static class MicroSentence {

        private Long id;
        /** 用户id */
        private Long userId;
        /** 标签 */
        private List<String> tags;
        /** 来源出处 */
        private String source;
        /** 作者 */
        private String author;
        /** 内容 */
        private String content;
        /** 背景图地址 */
        private String imageUrl;
        /** 是否点赞 */
        private Boolean isFavour = false;
        /** 点赞数 */
        private Integer favourNum = 0;
        /** 评论数 */
        private Integer commentNum = 0;
    }
}
