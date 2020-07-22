package com.youzi.common.query;

/**
 * @Description: 通用分页查询层
 * @author: zhuqi
 * @date: 2020年07月22日 14:57
 */
public class PageQuery {
    private Integer pageNum;
    private Integer pageSize;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
