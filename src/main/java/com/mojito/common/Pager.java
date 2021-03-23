package com.mojito.common;

import lombok.Data;

import java.util.List;

/**
 * @author liufengqiang
 * @date 2020-10-25 10:22:30
 */
@Data
public class Pager<T> {

    /** 分页大小 */
    private int pageSize = 10;
    /** 分页数 */
    private int pageNo = 1;
    /** 分页数据 */
    private List<T> content;
    /** 总页数 */
    private long totalPages;
    /** 总条数 */
    private long totalElements;

//    public void setPage(Page page) {
//        this.content = page.getContent();
//        this.totalPages = page.getTotalPages();
//        this.totalElements = page.getTotalElements();
//    }
}
