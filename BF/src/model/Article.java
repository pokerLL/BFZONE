package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import JDB.JdbTools;

public class Article {
	private int id;
	private int book_id;
	private int user_id;
	private int follow;

	private String Title;
	private String Date;
	private String Content;

	public ArrayList<Integer> comment_id_list;

	public Article(int id) throws SQLException {
		if (globalVar.article_mp.containsKey(id) == false) {
			System.out.println("article id does not exist");
			return;
		}

		String sql = "select * from bf.article where id = " + id + ";";
		ResultSet res = JdbTools.stmt.executeQuery(sql);

		while (res.next()) {
			this.id = res.getInt("id");
			this.book_id = res.getInt("book_id");
			this.user_id = res.getInt("user_id");
			this.follow = res.getInt("follow");
			/**/
			this.Title = res.getString("Title");
			this.Date = res.getString("Date");
			this.Content = res.getString("Content");

		}

		sql = "select id from bf.comments where article_id = " + id + ";";

		res = JdbTools.stmt.executeQuery(sql);
		comment_id_list = new ArrayList<>();
		while (res.next()) {
			int idx = res.getInt("id");
			System.out.println(idx);
			this.comment_id_list.add(idx);
		}
	}

	public Article() {
		// TODO �Զ����ɵĹ��캯�����
		this.id = -1;
//		this.book_id = 2;
//		this.user_id = 2;
//		this.follow = 3;
//		/**/
//		this.Title = "����ڽ�ʬ��ص�ĩ������";
//		this.Date = "1999-1127";
//		this.Content = "����ɥʬ������������ͼ�������������������ʱ�䡣 ��������Ҫ����һֻ���������˫����������԰������ɸ�������ʣ����ҿ��Ա�����ı��������˺��� ͼ����ֻ������Ͳ����������ھ�Ʒ�깺�����ǡ�\r\n" + 
//				"������\r\n" + 
//				"�������Ǳز����ٵģ������ĸ��п���������ɱɥʬ������ǿ����һ����ǣ�һ��Ҫ�ö̱��ģ�����������������խ�Ļ�����ʹ�á�ǹе���㵽ǹе�ɲ��Ǽ����׵����飬�����ںܶ�ʱ��ǹ���ᱩ¶���λ�á�\r\n" + 
//				"������\r\n" + 
//				"��ץ��һЩ����ʳ�õĶ���ʱ�������Ҫ�������������ǿ����ƶ��ˡ�ͼΪ95ʽ��ǹ����Ķ๦�̵ܴ��������ϵĿ������ڵ��������ʹ�ã����Ե���������ǯ�ӣ������ϵľ��Ҳ�����������һЩС�Ͳ��ϡ�\r\n" + 
//				"�ƹ⴦�����ˮƿ\r\n" + 
//				"����ˮƿ���ӽ�ʵ����Ҫǿ�����ǣ������ѡ�ƹ⴦�����ƿ�ӣ��������������ڹ۲�ĳ��ĳ���ʱ�򲻻���Ϊ���ⷴ�����¶λ�á�\r\n" + 
//				"��ɽЬ\r\n" + 
//				"���ֵ�ɽЬ�����з������ܣ����ҷǳ���ʵ���Ա����㲿������������ǳ������Ļ���Ӷ�������Ų�����������Ҫ���鷳��\r\n" + 
//				"ѹ������\r\n" + 
//				"����������ѹ��ʳƷ�����ǲ����ױ��ʡ���Ȼζ�����ҹ�ά����������Լ���취��ȡά���أ�ȱ��ά��������������������\r\n" + 
//				"������\r\n" + 
//				"׼��һЩ���������ɿ����������ĸ�����ʳƷ������״̬���䲻���ֲ��ò������˶�ʱ�����ǻ������ó��ġ����ң����ǿ��԰���ȹ��Ѱ��Ķ��졣\r\n" + 
//				"һ���Դ���\r\n" + 
//				"׼�������Ĵ��������ֺ��ã����Ҳ�������Ϊ����׼��ȼ�ϡ�һ�Ѵ������ܹ������úܳ�һ��ʱ���ˣ����Һ��ִ����ǳ����ײ�����\r\n" + 
//				"ҹ���ж�ʱ����õ��ģ����ҵ��㷢���о�Ԯֱ��������������Ԯʱ������Ҫ����һ֧�ֵ������źš���Ȼ�ˣ���Ҳ��Ҫ׼��һЩ��ء�";
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
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

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public ArrayList<Integer> getComment_list() {
		return comment_id_list;
	}

	public void setComment_list(ArrayList<Integer> comment_id_list) {
		this.comment_id_list = comment_id_list;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", book_id=" + book_id + ", user_id=" + user_id + ", follow=" + follow + ", Title="
				+ Title + ", Date=" + Date + ", Content=" + Content + ", comment_id_list=" + comment_id_list + "]";
	}

}
