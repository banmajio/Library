package cn.xh.domain;

import java.io.Serializable;

/*
 * 用户实体类
 */
public class User implements Serializable {

	private String id;// id
	private String username; // 用户名
	private String password; // 密码
	private String name; // 姓名
	private String sex; // 性别
	private String tel; // 电话
	private String address; // 地址

	public User() {
		super();
	}

	public User(String id, String username, String password, String name, String sex, String tel, String address) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.tel = tel;
		this.address = address;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name + ", sex="
				+ sex + ", tel=" + tel + ", address=" + address + "]";
	}

}
