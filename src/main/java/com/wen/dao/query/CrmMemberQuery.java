package com.wen.dao.query;

import java.math.BigInteger;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author Alex.wen123
 * @since 2018-05-23
 */
public class CrmMemberQuery extends BaseQuery {

	/**
	 * 用户id
	 */

	private BigInteger id;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 年龄
	 */
	private Integer age;
	/**
	 * 电子邮箱
	 */
	private String email;
	/**
	 * 手机号码
	 */
	private String mobile;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 真实姓名
	 */
	private String name;
	/**
	 * 身份证号
	 */
	private String idcard;
	/**
	 * 个人简介
	 */
	private String resume;
	/**
	 * 照片
	 */
	private String photo;
	/**
	 * 状态 1:正常 2:禁用 0:删除
	 */
	private Integer state;
	/**
	 * 创建时间
	 */
	private Date addTime;
	/**
	 * 更新时间
	 */
	private Date updatedTime;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	@Override
	public String toString() {
		return "CrmMember{" + "id=" + id + ", username=" + username + ", password=" + password + ", sex=" + sex
				+ ", age=" + age + ", email=" + email + ", mobile=" + mobile + ", address=" + address + ", name=" + name
				+ ", idcard=" + idcard + ", resume=" + resume + ", photo=" + photo + ", state=" + state + ", addTime="
				+ addTime + ", updatedTime=" + updatedTime + "}";
	}
}
