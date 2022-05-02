package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import JDB.JdbTools;

public class Comments {

	private int id;
	private int article_id;
	private int user_id;
	private int follow;

	private String content;
	private String date;
	
	public Comments(int id) throws SQLException {
		String sql = "select * from bf.comments where id = " + id + ";";
		System.out.println(sql);
		ResultSet it = JdbTools.stmt.executeQuery(sql);
		while (it.next()) {
			this.setId(it.getInt("id"));
			this.setUser_id(it.getInt("user_id"));
			this.setArticle_id(it.getInt("article_id"));
			this.setFollow(it.getInt("follow"));
			/**/
			this.setContent(it.getString("content"));
			this.setDate(it.getString("date"));
		}
	}

	public Comments() {
		// TODO 自动生成的构造函数存根
		id = -1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getArticle_id() {
		return article_id;
	}

	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getFollow() {
		return follow;
	}

	public void setFollow(int follow) {
		this.follow = follow;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Comments [id=" + id + ", article_int=" +  article_id+ ", user_id=" + user_id + ", follow=" + follow
				+ ", content=" + content + ", date=" + date + "]";
	}

}
