package com.youzi.modules.example.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Description: 示例对象
 * @author: zhuqi
 * @date: 2020年07月22日 10:48
 */
public class Example implements Serializable {
    private Integer id;
    private String title;
    private Integer type;
    private String content;
    private LocalDateTime addTime;
    private LocalDateTime updateTime;
    private LocalDateTime deleteTime;
    private boolean enabled;
    private String remark;
    private Long orderby;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getAddTime() {
        return addTime;
    }

    public void setAddTime(LocalDateTime addTime) {
        this.addTime = addTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public LocalDateTime getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(LocalDateTime deleteTime) {
        this.deleteTime = deleteTime;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getOrderby() {
        return orderby;
    }

    public void setOrderby(Long orderby) {
        this.orderby = orderby;
    }
}
