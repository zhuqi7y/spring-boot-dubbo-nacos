package com.youzi.modules.sys.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Description: TODO
 * @author: zhuqi
 * @date: 2020年08月20日 9:10
 */
public class SysInfo implements Serializable {

    private Integer id;
    private String title;
    private String href;
    private String image;
    private String icon;
    private String target;
    private Integer parent;
    private Integer level;
    private Integer type;
    private LocalDateTime addTime;
    private Integer addUserid;
    private LocalDateTime updateTime;
    private Integer updateUserid;
    private LocalDateTime deleteTime;
    private Integer deleteUserid;
    private Boolean enabled;

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

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public LocalDateTime getAddTime() {
        return addTime;
    }

    public void setAddTime(LocalDateTime addTime) {
        this.addTime = addTime;
    }

    public Integer getAddUserid() {
        return addUserid;
    }

    public void setAddUserid(Integer addUserid) {
        this.addUserid = addUserid;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateUserid() {
        return updateUserid;
    }

    public void setUpdateUserid(Integer updateUserid) {
        this.updateUserid = updateUserid;
    }

    public LocalDateTime getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(LocalDateTime deleteTime) {
        this.deleteTime = deleteTime;
    }

    public Integer getDeleteUserid() {
        return deleteUserid;
    }

    public void setDeleteUserid(Integer deleteUserid) {
        this.deleteUserid = deleteUserid;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
