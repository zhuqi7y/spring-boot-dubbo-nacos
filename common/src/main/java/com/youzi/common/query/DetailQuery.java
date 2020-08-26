package com.youzi.common.query;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Description: TODO
 * @author: zhuqi
 * @date: 2020年08月26日 14:43
 */
public class DetailQuery implements Serializable {

    @NotNull(message = "参数不能为空")
    @Min(value = 0, message = "参数格式不正确")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
