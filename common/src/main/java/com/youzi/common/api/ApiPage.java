package com.youzi.common.api;

import java.util.List;

/**
 * @Description: api接口分页数据封装
 * @author: zhuqi
 * @date: 2020年07月31日 16:47
 */
public class ApiPage<T> {
    //当前页
    private Integer pageNum;
    //每页的数量
    private Integer pageSize;
    //总页数
    private Integer pages;
    //总记录数
    private Long total;
    //结果集
    private List<T> list;

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

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
