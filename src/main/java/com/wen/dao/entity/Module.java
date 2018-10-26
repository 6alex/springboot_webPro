package com.wen.dao.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author Alex.wen123
 * @since 2018-10-16
 */
@TableName("t_module")
public class Module implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 权限id
     */
    @TableId(value = "mid", type = IdType.AUTO)
    private Integer mid;
    /**
     * 权限名
     */
    private String mname;
    
    private Set<Role> roles=new HashSet<>();


    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }
    
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Module [mid=" + mid + ", mname=" + mname + ", roles=" + roles + "]";
	}
	
	

}
