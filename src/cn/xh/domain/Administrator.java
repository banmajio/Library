package cn.xh.domain;

import java.io.Serializable;

/*
 * 管理员实体类
 */
public class Administrator implements Serializable {

	private String username; // 管理员用户名
	private String password; // 管理员密码
	private String name; // 管理员姓名
	private String sex; // 管理员性别
	private String tel; // 管理员电话

	public Administrator() {
		super();
	}

	public Administrator(String username, String password, String name, String sex, String tel) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.tel = tel;
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

	@Override
	public String toString() {
		return "Administrator [username=" + username + ", password=" + password + ", name=" + name + ", sex=" + sex
				+ ", tel=" + tel + "]";
	}

}
