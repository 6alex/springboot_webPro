package com.wen.dao.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author Alex.wen123
 * @since 2018-10-16
 */
@TableName("t_user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "uid", type = IdType.AUTO)
	private Integer uid;
	private String username;
	private String password;
	private Set<Role> roles = new HashSet<>();

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", roles=" + roles + "]";
	}


}
