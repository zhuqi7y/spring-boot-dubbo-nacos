package com.youzi.modules.example.query;

import com.youzi.common.query.PageQuery;

/**
 * @Description: 示例查询对象
 * @author: zhuqi
 * @date: 2020年07月22日 11:28
 */
public class ExampleQuery extends PageQuery {
    private Integer type;
    private String title;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
