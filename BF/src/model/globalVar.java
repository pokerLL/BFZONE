package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import JDB.JdbTools;

public class globalVar {
	public static User user;
	public static Command com = new Command();
	
	public static HashMap<Integer, String> catg_mp = new HashMap<>();
	public static HashMap<Integer, String> user_mp = new HashMap<>();
	public static HashMap<Integer, String> article_mp = new HashMap<>();
	public static HashMap<Integer, String> book_mp = new HashMap<>();

	public static HashMap<String, Integer> catg_mp_rev = new HashMap<>();
	public static HashMap<String, Integer> user_mp_rev = new HashMap<>();
	public static HashMap<String, Integer> article_mp_rev = new HashMap<>();
	public static HashMap<String, Integer> book_mp_rev = new HashMap<>();

	public static void iniuser() {
		String sql = "select id,name from bf.user order by id;";
		try {
			ResultSet it = JdbTools.stmt.executeQuery(sql);
			while (it.next()) {
				String name = it.getString("name");
				Integer id = it.getInt("id");
//				System.out.println(name + "\t" + id);
				user_mp.put(id, name);
				user_mp_rev.put(name, id);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	public static void inicatg() {
		String sql = "select id,name from bf.category;";
		try {
			ResultSet it = JdbTools.stmt.executeQuery(sql);
			while (it.next()) {
				String name = it.getString("name");
				Integer id = it.getInt("id");
//				System.out.println(name + "  " + id);
				catg_mp.put(id, name);
				catg_mp_rev.put(name, id);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	public static void iniarticle() {
		String sql = "select id,title from bf.article;";
		try {
			ResultSet it = JdbTools.stmt.executeQuery(sql);
			while (it.next()) {
				String name = it.getString("title");
				Integer id = it.getInt("id");
//				System.out.println(name + "  " + id);
				article_mp.put(id, name);
				article_mp_rev.put(name, id);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}

	public static void inibook() {
		String sql = "select id,name from bf.book;";
		try {
			ResultSet it = JdbTools.stmt.executeQuery(sql);
			while (it.next()) {
				String name = it.getString("name");
				Integer id = it.getInt("id");
//				System.out.println(name + "  " + id);
				book_mp.put(id, name);
				book_mp_rev.put(name, id);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	public static void ini() {
//		System.out.println("#########  USER  ##########");
		iniuser();
//		System.out.println("#########  CATG  ##########");
		inicatg();
//		System.out.println("#########  ARTI  ##########");
		iniarticle();
//		System.out.println("#########  BOOK  ##########");
		inibook();
//		System.out.println("#########  END    ##########");
	}

	public globalVar() {
		ini();
	}

	public void close() {
		JdbTools.close();
	}
}
