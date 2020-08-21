package com.youzi.modules.sys.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: TODO
 * @author: zhuqi
 * @date: 2020年08月20日 9:15
 */
public class SysInfoVo implements Serializable {

    private String title;
    private String href;
    private String image;
    private String icon;
    private String target;
    private List<SysInfoVo> child;

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

    public List<SysInfoVo> getChild() {
        return child;
    }

    public void setChild(List<SysInfoVo> child) {
        this.child = child;
    }
}
