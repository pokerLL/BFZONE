package JDB;

import java.sql.*;

public class JdbTools {
	private static String account = "root";
	private static String password = "123456";

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
//	static final String DB_URL = "jdbc:mysql://localhost:3306/";
	static final String DB_URL = "jdbc:mysql://localhost:3306/bf?useSSL=false&serverTimezone=GMT&allowPublicKeyRetrieval=true";
	// grant all privileges on *.* to root@'localhost' identified by '123456';
	public static Connection conn = null;
	public static Statement stmt = null;
	public static Statement stmt2 = null;

	static {
		ini();
	}

	public static void ini() {
		close();
		try {
			// ע�� JDBC ����
			Class.forName(JDBC_DRIVER);
			// ������
			System.out.println("�������ݿ�...");
			conn = DriverManager.getConnection(DB_URL, account, password);
			stmt = conn.createStatement();
			stmt2 = conn.createStatement();
			conn.setAutoCommit(true);
//			System.out.println("�������ݿ�ɹ�");
		} catch (SQLException se) {
			// ���� JDBC ����
			se.printStackTrace();
		} catch (Exception e) {
			// ���� Class.forName ����
			e.printStackTrace();
		}
	}

	// �ر����ݿ�����
	public static void close() {
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException se2) {
		} // ʲô������
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		System.out.println("���ݿ������ѹر�.");
	}

	public static String getAccount() {
		return account;
	}

	public static void setAccount(String account) {
		JdbTools.account = account;
	}

	public static void setPassword(String password) {
		JdbTools.password = password;
	}
}
