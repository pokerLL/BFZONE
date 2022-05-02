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
		// TODO 自动生成的构造函数存根
		this.id = -1;
//		this.book_id = 2;
//		this.user_id = 2;
//		this.follow = 3;
//		/**/
//		this.Title = "如何在僵尸遍地的末世生存";
//		this.Date = "1999-1127";
//		this.Content = "假如丧尸病毒爆发，本图集可以让你生存更长的时间。 首先你需要这样一只容量超大的双肩包，它可以帮你容纳更多的物资，并且可以保护你的背部不受伤害。 图上这只包属于筒包，你可以在军品店购买到它们。\r\n" + 
//				"求生斧\r\n" + 
//				"求生斧是必不可少的，锋利的斧刃可以让你秒杀丧尸，这里强调的一点就是，一定要用短柄的，这样可以让你在狭窄的环境中使用。枪械？搞到枪械可不是件容易的事情，并且在很多时候枪声会暴露你的位置。\r\n" + 
//				"求生刀\r\n" + 
//				"你抓到一些可以食用的动物时，你就需要用求生刀把它们开肠破肚了。图为95式步枪所配的多功能刺刀，刀身上的窟窿套在刀鞘上组合使用，可以当做剪刀或钳子，刀背上的锯齿也可以允许你锯一些小型材料。\r\n" + 
//				"哑光处理过的水瓶\r\n" + 
//				"这种水瓶更加结实，需要强调的是，最好挑选哑光处理过的瓶子，这样可以让你在观察某人某物的时候不会因为阳光反射而暴露位置。\r\n" + 
//				"登山鞋\r\n" + 
//				"这种登山鞋不仅有防滑功能，并且非常厚实可以保护足部。它可以让你非常安静的活动，从而不必因脚步声引来不必要的麻烦。\r\n" + 
//				"压缩干粮\r\n" + 
//				"尽量带这种压缩食品，它们不容易变质。虽然味道不敢恭维……你必须自己想办法摄取维生素，缺乏维生素让你变得容易生病。\r\n" + 
//				"能量棒\r\n" + 
//				"准备一些能量棒、巧克力棒这样的高热量食品。在你状态极其不好又不得不剧烈运动时，他们会派上用场的。并且，他们可以帮你度过难熬的冬天。\r\n" + 
//				"一次性打火机\r\n" + 
//				"准备这样的打火机，简单又好用，并且不用特意为它们准备燃料。一把打火机就能够让你用很长一段时间了，并且何种打火机非常容易补给。\r\n" + 
//				"夜间行动时你会用到的，并且当你发现有救援直升机或是其他救援时，你需要这样一支手电来打信号。当然了，你也需要准备一些电池。";
		
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
