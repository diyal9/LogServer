package com.diyal.util;

/**
 * @ClassName:     DBConn.java
 * @Description:   数据库链�?
 * @author diyalyin
 *         email: diyalyin@lunabox.cn
 *         company:  Lunabox Mobile Technology Co.,Ltd
 * @date 2014-3-23
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConn {
	private static String driverName = ""; // 数据库驱动
	private static String url = ""; // 连接URL
	private static String username = ""; // DB user
	private static String password = ""; // DB pwd
	public static Connection connection = null; // 定义连接对象

	public static Connection getConn() {
		driverName = ConfigBean.getDrivername().trim();
		url = ConfigBean.getConnectURL().trim();
		username = ConfigBean.getUserName().trim();
		password = ConfigBean.getPassword().trim();
		try {
			Class.forName(driverName).newInstance(); // 加载数据库驱动
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception ex) {
			System.out.println("数据库连接失败" + ex.toString());
		}
		return connection;
	}

	public static Statement createStatement(Connection conn) {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stmt;
	}

	public static PreparedStatement prepare(Connection conn, String sql) {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}

	public static void close(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Statement statement) {
		try {
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(PreparedStatement statement) {
		try {
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		Connection conn = DBConn.getConn();
		java.sql.PreparedStatement pstm = null;

	}

}
