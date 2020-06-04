package cn.xh.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class JDBCUtil {
	static Connection conn = null;

	static {
		// 初始化porperties文件
		ResourceBundle bundle = ResourceBundle.getBundle("jdbcConfig");
		String dirver = bundle.getString("driverManager");
		String url = bundle.getString("url");
		String user = bundle.getString("user");
		String password = bundle.getString("password");
		// 注册驱动
		try {
			Class.forName(dirver);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return conn;
	}
	
	public static void release(ResultSet set, Statement stmt, Connection connection) throws SQLException {
		if (set != null) {
			set.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (connection != null) {
			connection.close();
		}
	}
}
