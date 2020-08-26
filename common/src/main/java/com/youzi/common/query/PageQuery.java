package com.youzi.common.query;

import java.io.Serializable;
import java.util.Optional;

/**
 * @Description: 通用分页查询层
 * @author: zhuqi
 * @date: 2020年07月22日 14:57
 */
public class PageQuery implements Serializable {
    private Integer pageNum;
    private Integer pageSize;
    private boolean pageSizeZero = false;

    public Integer getPageNum() {
        return Optional.ofNullable(pageNum).orElse(1);
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        //设置默认值10和最大值200
        return Optional.ofNullable(pageSize).map(ps -> ps > 200 ? 200 : ps).orElse(10);
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isPageSizeZero() {
        return pageSizeZero;
    }

    public void setPageSizeZero(boolean pageSizeZero) {
        this.pageSizeZero = pageSizeZero;
    }
}
