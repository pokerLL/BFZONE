package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import model.Article;
import model.Book;
import model.Comments;
import model.User;
import model.globalVar;

public class mangView {
	int x_1 = 20, y_1 = 30, z_1 = 125;
	int x_2 = 950, y_2 = 350, z_2 = 50;
	JTable table;
	JScrollPane sc;

	public JPanel getmangView() throws SQLException {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		table = getTable("user");
		JScrollPane sc = new JScrollPane(table);
		sc.setBounds(x_1, 100, x_2 - 50, 850 - y_1 - 175);

		panel.add(sc);
		JButton usermbtn = new JButton("用户管理");
		JButton bookmbtn = new JButton("书籍管理");
		JButton artmbtn = new JButton("文章管理");
		JButton commbtn = new JButton("评论管理");
		
		int width = 125, height = 50;

		usermbtn.setBounds(x_1, y_1, width, height);
		bookmbtn.setBounds(x_1 + z_1 * 1, y_1, width, height);
		artmbtn.setBounds(x_1 + z_1 * 2, y_1, width, height);
		commbtn.setBounds(x_1 + z_1 * 3, y_1, width, height);

		panel.add(usermbtn);
		panel.add(bookmbtn);
		panel.add(artmbtn);
		panel.add(commbtn);

		JButton editbtn = new JButton("  编辑  ");
		editbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
//				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int[] selected = table.getSelectedRows();
				System.out.println(selected.length);
				String d = table.getColumnName(1);
				if(selected.length==0)
				{
					JOptionPane.showMessageDialog(null, "请至少选择一行再点击编辑按钮", "提示", 3);
					return ;
				}
				for (int i : selected) {
					JDialog frame = new JDialog();// 构造一个新的JFrame，作为新窗口。
					if (d == "用户名") {
						frame.setBounds(420, 0, 500, 1000);
						try {
							User user = new User((int) table.getValueAt(i, 0));
							frame.add(new mView().SingupPanel(user));
							frame.setModalityType(JDialog.ModalityType.APPLICATION_MODAL);
							frame.setVisible(true);
						} catch (SQLException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}
						
					} else if (d == "书名") {
						
						frame.setBounds(420, 150, 500, 500);
						try {
							Book book = new Book((int) table.getValueAt(i, 0));
							frame.add(new bookView().getbookEditView(book));
							frame.setModalityType(JDialog.ModalityType.APPLICATION_MODAL);
							frame.setVisible(true);
						} catch (SQLException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}
					} else if (d == "标题") {
						
						frame.setBounds(420, 30, 820, 920);
						try {
							Article article = new Article((int) table.getValueAt(i, 0));
							frame.add(new zoneView().getArticleEditPanel(article));
							frame.setModalityType(JDialog.ModalityType.APPLICATION_MODAL);
							frame.setVisible(true);
						} catch (SQLException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}
					} else {
						frame.setBounds(420, 30, 500, 420);
						try {
							Comments com = new Comments((int) table.getValueAt(i, 0));
							frame.add(new mView().commentsView(com));
							frame.setModalityType(JDialog.ModalityType.APPLICATION_MODAL);
							frame.setVisible(true);
						} catch (SQLException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}
						
						
					}
				}
			}
		});
		JButton deletebtn = new JButton("  删除  ");
		deletebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				int[] selected = table.getSelectedRows();
				String d = table.getColumnName(1);
				String dbname = "";
				if (d == "用户名")
					dbname = "user";
				else if (d == "书名")
					dbname = "book";
				else if (d == "标题")
					dbname = "article";
				else
					dbname = "comments";
				for (int i : selected) {
					try {
//						System.out.println( );
						globalVar.com.deleteById(dbname,(int) table.getValueAt(i, 0));
					} catch (SQLException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
				}
			}
		});

		JButton newbtn = new JButton("  增加  ");
		newbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				String d = table.getColumnName(1);
				JDialog frame = new JDialog();// 构造一个新的JFrame，作为新窗口。
				if (d == "用户名") {
					frame.setBounds(420, 0, 500, 1000);
					frame.add(new mView().SingupPanel(new User()));
					frame.setModalityType(JDialog.ModalityType.APPLICATION_MODAL);
					frame.setVisible(true);
				} else if (d == "书名") {
					frame.setBounds(420, 150, 500, 500);
					try {
						frame.add(new bookView().getbookEditView(new Book()));
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					frame.setModalityType(JDialog.ModalityType.APPLICATION_MODAL);
					frame.setVisible(true);
				} else if (d == "标题") {
					frame.setBounds(420, 30, 820, 920);
					try {
						frame.add(new zoneView().getArticleEditPanel(new Article()));
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					frame.setModalityType(JDialog.ModalityType.APPLICATION_MODAL);
					frame.setVisible(true);
				} else {
					frame.setBounds(420, 30, 500, 420);
					Comments com = new Comments();
					frame.add(new mView().commentsView(com));
					frame.setModalityType(JDialog.ModalityType.APPLICATION_MODAL);
					frame.setVisible(true);
				}

			}
		});

		editbtn.setBounds(x_2, y_2, width, height);
		deletebtn.setBounds(x_2, y_2 + z_2, width, height);
		newbtn.setBounds(x_2, y_2 + z_2 * 2, width, height);

		panel.add(editbtn);
		panel.add(deletebtn);
		panel.add(newbtn);
		
		usermbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
//				panel.remove();
				try {
					globalVar.ini();
					panel.removeAll();
					panel.add(usermbtn);
					panel.add(bookmbtn);
					panel.add(artmbtn);
					panel.add(commbtn);
					panel.add(editbtn);
					panel.add(deletebtn);
					panel.add(newbtn);
					table = getTable("user");
					JScrollPane sc = new JScrollPane(table);
					sc.setBounds(x_1, 100, x_2 - 50, 850 - y_1 - 175);
					panel.add(sc);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		
		bookmbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
//				panel.remove();
				try {
					globalVar.ini();
					panel.removeAll();
					panel.add(usermbtn);
					panel.add(bookmbtn);
					panel.add(artmbtn);
					panel.add(commbtn);
					panel.add(editbtn);
					panel.add(deletebtn);
					panel.add(newbtn);
					table = getTable("book");
					JScrollPane sc = new JScrollPane(table);
					sc.setBounds(x_1, 100, x_2 - 50, 850 - y_1 - 175);
					panel.add(sc);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		
		artmbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
//				panel.remove();
				try {
					globalVar.ini();
					panel.removeAll();
					panel.add(usermbtn);
					panel.add(bookmbtn);
					panel.add(artmbtn);
					panel.add(commbtn);
					panel.add(editbtn);
					panel.add(deletebtn);
					panel.add(newbtn);
					table =getTable("article");
					JScrollPane sc = new JScrollPane(table);
					sc.setBounds(x_1, 100, x_2 - 50, 850 - y_1 - 175);
					panel.add(sc);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		
		commbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
//				panel.remove();
				try {
					globalVar.ini();
					panel.removeAll();
					panel.add(usermbtn);
					panel.add(bookmbtn);
					panel.add(artmbtn);
					panel.add(commbtn);
					panel.add(editbtn);
					panel.add(deletebtn);
					panel.add(newbtn);
					table = getTable("");
					JScrollPane sc = new JScrollPane(table);
					sc.setBounds(x_1, 100, x_2 - 50, 850 - y_1 - 175);
					panel.add(sc);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		

		panel.setBounds(0, 0, 1150, 850);
		panel.setVisible(true);
		return panel;
	}

	JTable getTable(String op) throws SQLException {
		JTable table = null;

		if (op == "user") {
			String colname[] = { "id", "用户名", "密码", "已登录次数", "相关文章数", "相关评论数" };
			ArrayList<User> ul = globalVar.com.loadUsers();
			int len1 = ul.size(), len2 = colname.length;
			Object[][] date = new Object[len1][len2];
			for (int i = 0; i < len1; i++) {
				date[i][0] = ul.get(i).getId();
				date[i][1] = ul.get(i).getName();
				date[i][2] = ul.get(i).getPsd();
				date[i][3] = ul.get(i).getLogcnt();
				date[i][4] = 0;
				date[i][5] = 0;
			}
			table = new JTable(date, colname);
		} else if (op == "book") {
			String colname[] = { "id", "书名", "IBSN", "作者", "出版社", "类别", "所有人", "相关评论数", "添加日期", "描述" };
			ArrayList<Book> l = globalVar.com.loadBooks(-1);
			int len1 = l.size(), len2 = colname.length;
			Object[][] date = new Object[len1][len2];
			for (int i = 0; i < len1; i++) {
				date[i][0] = l.get(i).getId();
				date[i][1] = l.get(i).getName();
				date[i][2] = l.get(i).getIBSN();
				date[i][3] = l.get(i).getAuthor();
				date[i][4] = l.get(i).getPublisher();
				date[i][5] = globalVar.catg_mp.get(l.get(i).getCategory_id());
				date[i][6] = globalVar.user_mp.get(l.get(i).getUser_id());
				date[i][7] = 0;
				date[i][8] = l.get(i).getDate();
				date[i][9] = l.get(i).getDescription();
			}
			table = new JTable(date, colname);
		} else if (op == "article") {
			String colname[] = { "id", "标题", "概述", "点赞数", "关联书籍", "发布用户", "发布日期" };
			ArrayList<Article> l = globalVar.com.loadArticles(-1, "user");
			int len1 = l.size(), len2 = colname.length;
			Object[][] date = new Object[len1][len2];
			for (int i = 0; i < len1; i++) {
				date[i][0] = l.get(i).getId();
				date[i][1] = l.get(i).getTitle();
				date[i][2] = l.get(i).getContent().substring(0, 50);
				date[i][3] = l.get(i).getFollow();
				date[i][4] = globalVar.book_mp.get(l.get(i).getBook_id());
				date[i][5] = globalVar.user_mp.get(l.get(i).getUser_id());
				date[i][6] = l.get(i).getDate();
			}
			table = new JTable(date, colname);
		} else {
			String colname[] = { "id", "内容", "点赞数", "关联文章", "发布用户", "发布日期" };
			ArrayList<Comments> l = globalVar.com.loadComments(-1, "user");
			int len1 = l.size(), len2 = colname.length;
			Object[][] date = new Object[len1][len2];
			for (int i = 0; i < len1; i++) {
				date[i][0] = l.get(i).getId();
				date[i][1] = l.get(i).getContent();
				date[i][2] = l.get(i).getFollow();
				date[i][3] = globalVar.article_mp.get(l.get(i).getArticle_id());
				date[i][4] = globalVar.user_mp.get(l.get(i).getUser_id());
				date[i][5] = l.get(i).getDate();
			}
			table = new JTable(date, colname);
		}

//		JScrollPane sc = new JScrollPane(table);
//		sc.setBounds(x_1, 100, x_2 - 50, 850 - y_1 - 175);
		return table;
	}
}
