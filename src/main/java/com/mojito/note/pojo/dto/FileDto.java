package com.mojito.note.pojo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * description
 *
 * @author liufengqiang <liufengqiang@touchealth.com>
 * @date 2019-12-19 20:00
 */
@Getter
@Setter
public class FileDto {

    private String currentPath;
    private String lastPath;
    private List<ChildFileDto> childFiles;

    @Getter
    @Setter
    public static class ChildFileDto {

        private Boolean isDirectory;
        private String name;
    }
}
