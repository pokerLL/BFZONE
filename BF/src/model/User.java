package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import JDB.JdbTools;

public class User {
	/*
	 * -2 密码错误 -1 以删除,拒绝访问 0 管理员 1 正常账号 2 游客账号
	 */
	private int id;
	private String name;
	private String psd;
	private int authority = 2;
	private int logcnt;
	private String birthday;
	private String city;
	private String gender;

	public User() {
		// TODO 自动生成的构造函数存根
		id = -1;
		name = birthday = city = gender = psd = "";
	}

	// 根据传入的账号密码尝试创建一个User类并返回,如果验证失败则将权限设置成-1
	public User(String name, String password) throws SQLException {

		this.authority = -1;
		String sql = "select * from bf.user where name = '" + name + "';";
//		System.out.println(sql);
		ResultSet it = JdbTools.stmt.executeQuery(sql);
		if (it.next()) {
			if (password.equals(it.getString("psd"))) {
				this.id = it.getInt("id");
				this.name = name;
				this.psd = it.getString("psd");
				this.authority = it.getInt("authority");
				this.logcnt = it.getInt("logcnt");
				this.birthday = it.getString("birthday");
				this.city = it.getString("city");
				this.gender = it.getString("gender");
				sql = "update user set logcnt = logcnt+1 where id = '" + this.id + "';";
				JdbTools.stmt2.executeUpdate(sql);
			}
		}
		
	}

	public User(int id) throws SQLException {
		this.authority = -1;
		String sql = "select * from bf.user where id = '" + id + "';";
//		System.out.println(sql);
		ResultSet it = JdbTools.stmt.executeQuery(sql);
		if (it.next()) {
				this.id = it.getInt("id");
				this.name = it.getString("name");
				this.psd = it.getString("psd");
				this.authority = it.getInt("authority");
				this.logcnt = it.getInt("logcnt");
				this.birthday = it.getString("birthday");
				this.city = it.getString("city");
				this.gender = it.getString("gender");
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPsd() {
		return psd;
	}

	public void setPsd(String psd) {
		this.psd = psd;
	}

	public int getAuthority() {
		return authority;
	}

	public void setAuthority(int authority) {
		this.authority = authority;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getLogcnt() {
		return logcnt;
	}

	public void setLogcnt(int logcnt) {
		this.logcnt = logcnt;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + psd + ", authority=" + authority + ", birthday=" + birthday
				+ ", city=" + city + ", gender=" + gender + "]";
	}

}
