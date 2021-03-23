package com.mojito.note.pojo.dto;

import lombok.Data;

import java.util.List;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2020-07-22 14:28
 */
@Data
public class CategoryDto {

    private Long id;
    /** 分类名 */
    private String name;
    /** todo数量 */
    private Integer num;

    private List<NoteListDto> notes;

    public CategoryDto(String name, List<NoteListDto> notes) {
        this.name = name;
        this.notes = notes;
    }
}
