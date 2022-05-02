package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import JDB.JdbTools;

public class Command {

	public String getMsgs() throws SQLException {
		String res = "";

		String sql = "select * from bf.msg ;";
		ResultSet it = JdbTools.stmt.executeQuery(sql);
		while (it.next()) {
			try {
				res += "[ " + it.getString("date") + " ] : " + it.getString("content") + "\r\n";
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}

		return res;
	}

	// 根据用户身份,id,以及传入的对象 删除书籍,文章或评论
	boolean delete(User user, Book book, int id) throws SQLException {

		if (user.getAuthority() == 0 || user.getId() == book.getUser_id()) {
			String x = Integer.toString(id);
			if (id == -1)
				x = "%";
			String sql = "delete from bf.book where id like '" + x + "';";
			JdbTools.stmt.executeUpdate(sql);
			globalVar.book_mp.remove(book.getId());
			globalVar.book_mp_rev.remove(book.getName());
			return true;
		}
		return false;
	}

	// 根据用户身份,id,以及传入的对象 删除书籍,文章或评论
	boolean delete(User user, Article article, int id) throws SQLException {

		if (user.getAuthority() == 0 || user.getId() == article.getUser_id()) {
			String x = Integer.toString(id);
			if (id == -1)
				x = "%";
			String sql = "delete from bf.article where id like '" + x + "';";
			JdbTools.stmt.executeUpdate(sql);
			globalVar.article_mp.remove(article.getId());
			globalVar.article_mp_rev.remove(article.getTitle());
			return true;
		}
		return false;
	}

	// 根据用户身份,id,以及传入的对象 删除书籍,文章或评论
	boolean delete(User user, Comments comment, int id) throws SQLException {

		if (user.getAuthority() == 0 || user.getId() == comment.getUser_id()) {
			String x = Integer.toString(id);
			if (id == -1)
				x = "%";
			String sql = "delete from bf.comment where id like '" + x + "';";
			JdbTools.stmt.executeUpdate(sql);
			return true;
		}
		return false;
	}

	// 返回一个加载了所有用户的数组
	public ArrayList<User> loadUsers() throws SQLException {
		ArrayList<User> user_list = new ArrayList<>();
		String sql = "select * from bf.user ;";
		// System.out.println(sql);
		ResultSet it = JdbTools.stmt.executeQuery(sql);
		while (it.next()) {
			User user = new User();
			user.setId(it.getInt("id"));
			user.setName(it.getString("name"));
			user.setPsd(it.getString("psd"));
			user.setAuthority(it.getInt("authority"));
			user.setBirthday(it.getString("birthday"));
			user.setCity(it.getString("city"));
			user.setGender(it.getString("gender"));
			user.setLogcnt(it.getInt("logcnt"));
			user_list.add(user);
		}
		return user_list;
	}

	// 根据传入的用户id返回对应的书籍数组
	public ArrayList<Book> loadBooks(int id) throws SQLException {
		ArrayList<Book> bl = new ArrayList<>();

		String x = Integer.toString(id);
		if (id == -1)
			x = "%";
		String sql = "select * from bf.book where user_id like '" + x + "';";
		ResultSet it = JdbTools.stmt.executeQuery(sql);
		while (it.next()) {
			Book book = new Book();
			book.setId(it.getInt("id"));
			book.setCategory_id(it.getInt("category_id"));
			book.setUser_id(it.getInt("user_id"));

			book.setName(it.getString("name"));
			book.setIBSN(it.getString("ibsn"));
			book.setAuthor(it.getString("author"));
			book.setPublisher(it.getString("publisher"));
			book.setDate(it.getString("date"));
			book.setDescription(it.getString("description"));

			book.loadArticleIds();

			bl.add(book);
		}
		return bl;
	}

	// 根据传入的？id返回对应的文章数组
	public ArrayList<Article> loadArticles(int id, String dbname) throws SQLException {
		ArrayList<Article> al = new ArrayList<>();

		String x = Integer.toString(id);
		if (id == -1)
			x = "%";
		String sql = "select * from bf.article where " + dbname + "_id like '" + x + "';";
		ResultSet it = JdbTools.stmt.executeQuery(sql);
		while (it.next()) {
			Article at = new Article();
			at.setId(it.getInt("id"));
			at.setBook_id(it.getInt("book_id"));
			at.setUser_id(it.getInt("user_id"));
			at.setFollow(it.getInt("follow"));

			at.setTitle(it.getString("Title"));
			at.setDate(it.getString("date"));
			at.setContent(it.getString("content"));
			al.add(at);
		}
		return al;
	}

	// 根据传入的？id返回对应的评论数组
	public ArrayList<Comments> loadComments(int id, String dbname) throws SQLException {
		ArrayList<Comments> coml = new ArrayList<>();
		String x = Integer.toString(id);
		if (id == -1)
			x = "%";
		String sql = "select * from bf.comments where " + dbname + "_id like '" + x + "';";
		// System.out.println(sql);
		ResultSet it = JdbTools.stmt.executeQuery(sql);
		while (it.next()) {
			Comments comments = new Comments();
			comments.setId(it.getInt("id"));
			comments.setUser_id(it.getInt("user_id"));
			comments.setArticle_id(it.getInt("article_id"));
			comments.setFollow(it.getInt("follow"));
			/**/
			comments.setContent(it.getString("content"));
			comments.setDate(it.getString("date"));
			coml.add(comments);
		}

		return coml;
	}

	// 传入 id : 依据id将另一个表中所有以这个id为外键的数据项删除
	public void deleteIndById(String srcdb, String estdb, int id) throws SQLException {
		String sql = "delete from bf." + estdb + " where " + srcdb + "_id = " + id + ";";
		// System.out.println(sql);
		JdbTools.stmt.executeUpdate(sql);
	}

	// 传入 id 数组 : 删除某个表中对应id的项
	public void deleteById(String dbname, ArrayList<Integer> arr) throws SQLException {
		String id_list = "( ";
		int len = arr.size();
		for (int i = 0; i < len; i++) {
			id_list += arr.get(i);
			if (i != len - 1)
				id_list += ",";
		}

		id_list += ")";
		String sql = "delete from bf" + dbname + "where id in " + id_list + ";";
		// System.out.println(sql);
		JdbTools.stmt.executeUpdate(sql);
	}

	// 传入 id : 删除某个表中对应id的项
	public void deleteById(String dbname, int id) throws SQLException {
		String sql = "delete from bf." + dbname + " where id = " + id + ";";
		// System.out.println(sql);
		JdbTools.stmt.executeUpdate(sql);
	}

	// pushModify
	public void pushModify(Book book) throws SQLException {
		int id = book.getId();
		int category_id = book.getCategory_id();
		int user_id = book.getUser_id();

		String name = book.getName();
		String ibsn = book.getIBSN();
		String author = book.getAuthor();
		String publisher = book.getPublisher();
		String date = book.getDate();
		String description = book.getDescription();

		deleteById("book", id);

		String sql = "insert into bf.book (category_id,user_id,name,ibsn,author,publisher,date,description)values" + "("
				+ category_id + "," + user_id + ",'" + name + "','" + ibsn + "','" + author + "','" + publisher + "','"
				+ date + "','" + description + "');";
//			System.out.println(sql);
		JdbTools.stmt.executeUpdate(sql);
	}

	// pushModify
	public void pushModify(Article article) throws SQLException {
		int id = article.getId();
		int book_id = article.getBook_id();
		int user_id = article.getUser_id();
		int follow = article.getFollow();

		String title = article.getTitle();
		String date = article.getDate();
		String content = article.getContent();

		if (id != -1)
			deleteById("article", id);

		String sql = "insert into bf.article (book_id,user_id,follow,title,date,content)values" + "(" + book_id + ","
				+ user_id + ",'" + follow + "','" + title + "','" + date + "','" + content + "');";
//		System.out.println(sql);
		JdbTools.stmt.executeUpdate(sql);

	}

	// pushModify
	public void pushModify(User user) throws SQLException {
		int id = user.getId();
		int authority = user.getAuthority();

		String name = user.getName();
		String psd = user.getPsd();
		String birthday = user.getBirthday();
		String city = user.getCity();
		String gender = user.getGender();

		String sql;
		if (id != -1) {
			deleteById("user", id);
		}

		sql = "insert into bf.user (authority,name,psd,birthday,city,gender) values (" + authority + ",'" + name + "','"
				+ psd + "','" + birthday + "','" + city + "','" + gender + "')";

		System.out.println(sql);
		JdbTools.stmt.executeUpdate(sql);
	}

	public void pushModify(Comments com) throws SQLException {
		int id = com.getId();
		int article_id = com.getArticle_id();
		int user_id = com.getUser_id();
		int follow = com.getFollow();

		String content = com.getContent();
		String date = com.getDate();

		if (id != -1) {
			deleteById("comments", id);
		}
		String sql = "INSERT INTO bf.comments (article_id,user_id,follow,content,date) VALUES(" + article_id + ","
				+ user_id + "," + follow + ",'" + content + "','" + date + "');";

//		System.out.println(sql);
		JdbTools.stmt.executeUpdate(sql);
	}

	// pushModify
	public void pushModify(String date, String content) throws SQLException {
		String sql = "insert into bf.msg (date,content)  values ('" + date + "','" + content + "');";
		System.out.println(sql);
		JdbTools.stmt.executeUpdate(sql);
	}

	public boolean checkDelete(String dbname, int id) throws SQLException {
		String sql = "select from bf." + dbname + " where id = " + id + ";";
		// System.out.println(sql);
		ResultSet it = JdbTools.stmt.executeQuery(sql);
		while (it.next()) {
//			return it.getString("authority")
			return false;
		}

		return true;
	}
}
