package com.youzi.common.query;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Description: 通用删除查询对象
 * @author: zhuqi
 * @date: 2020年07月22日 16:12
 */
public class DeleteQuery implements Serializable {

    @NotBlank(message = "ids不能为空")
    private String ids;

    private Long deleteSysUserid;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public Long getDeleteSysUserid() {
        return deleteSysUserid;
    }

    public void setDeleteSysUserid(Long deleteSysUserid) {
        this.deleteSysUserid = deleteSysUserid;
    }
}
