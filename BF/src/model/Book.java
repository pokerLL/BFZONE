package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import JDB.JdbTools;

public class Book {
	private int id;
	private int category_id;
	private int user_id;

	private String Name;
	private String IBSN;
	private String Author;
	private String Publisher;
	private String Date;
	private String description;

	public ArrayList<Integer> article_id_list;

	public Book(int id) throws SQLException {
		if (globalVar.book_mp.containsKey(id) == false) {
			System.out.println("book id does not exist");
			return;

		}
		String sql = "select * from bf.book where id = " + id + ";";

		ResultSet res = JdbTools.stmt.executeQuery(sql);

		while (res.next()) {
			this.id = res.getInt("id");
			this.category_id = res.getInt("category_id");
			this.user_id = res.getInt("user_id");
			//
			this.IBSN = res.getString("IBSN");
			this.Author = res.getString("Author");
			this.Name = res.getString("Name");
			this.Publisher = res.getString("Publisher");
			this.Date = res.getString("Date");
			this.description = res.getString("description");

		}

	}

	public Book() {
		// TODO 自动生成的构造函数存根
		this.id = -1;
		this.category_id = 0;
		this.user_id = 0;
		this.IBSN = "";
		this.Author = "";
		this.Name = "";
		this.Publisher = "";
		this.Date = "";
		this.description = "";
	}

	public void loadArticleIds() throws SQLException {
		String sql = "select id from bf.article where book_id = " + id + ";";
		ResultSet it = JdbTools.stmt2.executeQuery(sql);
		article_id_list = new ArrayList<>();
		while (it.next()) {
			article_id_list.add(it.getInt("id"));
		}
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", category_id=" + category_id + ", user_id=" + user_id + ", Name=" + Name + ", IBSN="
				+ IBSN + ", Author=" + Author + ", Publisher=" + Publisher + ", Date=" + Date + ", description="
				+ description + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getIBSN() {
		return IBSN;
	}

	public void setIBSN(String iBSN) {
		IBSN = iBSN;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public String getPublisher() {
		return Publisher;
	}

	public void setPublisher(String publisher) {
		Publisher = publisher;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
