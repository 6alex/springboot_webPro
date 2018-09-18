package com.wen.dao.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 权限-角色中间表
 * </p>
 *
 * @author Alex.wen123
 * @since 2018-09-18
 */
@TableName("t_module_role")
public class ModuleRole implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer rid;
    private Integer mid;


    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    @Override
    public String toString() {
        return "ModuleRole{" +
        "rid=" + rid +
        ", mid=" + mid +
        "}";
    }
}
