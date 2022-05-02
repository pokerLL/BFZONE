package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import JDB.JdbTools;
import model.*;

public class zoneView {

	public JPanel getArticleEditPanel(Article a) throws SQLException {
		JPanel p = new JPanel();
		p.setLayout(null);

		int y_1 = 30, height = 30;
		JLabel t1 = null;
		JComboBox bookbox = null;
		if (a.getId() == -1) {
			t1 = new JLabel("���鼮:");
			t1.setBounds(30, y_1, 80, height);
			bookbox = new JComboBox();
			bookbox.addItem("--�������鼮--");
			bookbox.setBounds(120, y_1, 140, height);
			ArrayList<Book> bl = globalVar.com.loadBooks(globalVar.user.getId());
//			ArrayList<Book> bl = globalVar.com.loadBooks(2);
			for (Book b : bl) {
				bookbox.addItem(b.getName());
			}
			bookbox.setSelectedIndex(0);
			p.add(t1);
			p.add(bookbox);
		} else {
			t1 = new JLabel("�Ѱ��鼮 : " + globalVar.book_mp.get(a.getBook_id()));
			t1.setBounds(30, y_1, 220, height);
			p.add(t1);
		}

		JLabel t2 = new JLabel("����");
		t2.setBounds(280, y_1, 30, height);
		JTextField titlefield = new JTextField(20);
		titlefield.setBounds(320, y_1, 200, height);

		JLabel t3 = new JLabel("��ǰ�û� : " + globalVar.user.getName());
//		JLabel t3 = new JLabel("��ǰ�û� : " + "admin");
		t3.setBounds(540, y_1, 100, height);

		JTextArea textarea = new JTextArea(30, 30);
		textarea.setText("���ڴ���������");
		textarea.setLineWrap(true);
		textarea.setBounds(30, 80, 670, 650);

		if (a.getId() != -1) {
			titlefield.setText(a.getTitle());
			textarea.setText(a.getContent());
		}

		JButton clearbtn = new JButton("����");
		clearbtn.setBounds(500, 745, 80, 25);
		JComboBox box = bookbox;
		clearbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO �Զ����ɵķ������
				if (a.getId() == -1) {
//					bookbox.setSelectedIndex(0);
					textarea.setText("���ڴ���������");
				} else {
					titlefield.setText(a.getTitle());
					textarea.setText(a.getContent());
				}
			}

		});

		JButton okbtn = new JButton("ȷ�Ϸ���");
		okbtn.setMnemonic(KeyEvent.VK_ENTER);
		okbtn.setBounds(600, 745, 100, 25);
		okbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				a.setId(-1);
				a.setTitle(titlefield.getText());
				a.setContent(textarea.getText());
				a.setUser_id(globalVar.user.getId());
				if (globalVar.book_mp_rev.get(box.getSelectedItem()) == null) {
					JOptionPane.showMessageDialog(p, "���һ���鼮", "��ʾ", 3);
					return;
				}
				
				a.setBook_id(globalVar.book_mp_rev.get(box.getSelectedItem()));
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// �������ڸ�ʽ
				a.setDate(df.format(new Date()));
				try {
					globalVar.com.pushModify(a);
				} catch (SQLException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "�����ɹ�", "��ʾ", 3);
			}

		});

		p.add(t2);
		p.add(titlefield);
		p.add(t3);
		p.add(textarea);
		p.add(clearbtn);
		p.add(okbtn);

		p.setBounds(30, 30, 800, 700);
		p.setVisible(true);

		return p;
	}

	JPanel articlePanel(Article a) {
		int[] morecnt = new int[2];
		int id = a.getId();
		String book_name = globalVar.book_mp.get(a.getBook_id());
		String user_name = globalVar.user_mp.get(a.getUser_id());
		int follow = a.getFollow();
		String title = a.getTitle();
		String date = a.getDate();
		String content = a.getContent();

		JPanel p = new JPanel();

		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel titlelab = new JLabel("���� : " + title);
		titlelab.setPreferredSize(new Dimension(250, 35));
		JLabel booknamelab = new JLabel("���� : " + book_name);
		booknamelab.setPreferredSize(new Dimension(150, 35));
		JLabel usernamelab = new JLabel("���� : " + user_name);
		usernamelab.setPreferredSize(new Dimension(150, 35));
		JLabel datelab = new JLabel("�������� : " + date);
		datelab.setPreferredSize(new Dimension(150, 35));
		p1.add(titlelab);
		p1.add(booknamelab);
		p1.add(usernamelab);
		p1.add(datelab);

		JTextArea text = new JTextArea(content.substring(0, min(230,content.length())), 3, 60);
		text.setEditable(false);
		text.setLineWrap(true);

		JButton followbtn = new JButton("��  " + follow);
		followbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String sql = "update article set follow = follow + 1 where id = " + a.getId() + ";";
				try {
					JdbTools.stmt.executeUpdate(sql);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				followbtn.setText("�� " + (follow + 1));
			}
		});
		JButton diswbtn = new JButton("��");

		JButton commentbtn = new JButton("�鿴�򷢲�����");
		JPanel comp = new JPanel();
		comp.setLayout(new FlowLayout(FlowLayout.LEFT));
//		comp.setBackground(Color.RED);
//		comp.setPreferredSize(new Dimension(300, 0));

		JButton morebtn = new JButton("ȫ��չ��");
		morebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (morecnt[0] % 2 == 1)
					text.setText(content.substring(0, min(230,content.length())));
				else {
					text.setText(content);
					morebtn.setText("��ԭ");
				}
				morecnt[0] = morecnt[0] + 1;
			}
		});

		JPanel p2 = new JPanel();
		p2.add(followbtn);
		p2.add(morebtn);
		p2.add(diswbtn);
		p2.add(commentbtn);

		commentbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (morecnt[1] % 2 == 0) {
					JTextField comfield = new JTextField(50);
					comfield.setText("���ڴ���������..");
					JButton comb = new JButton("ȷ�Ϸ���");
					comb.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							String res = comfield.getText();
							if(res.length()==0||res.contains("���ڴ�����")) {
								JOptionPane.showMessageDialog(null, "�����������ٳ��Է���", "��ʾ", 3);
							}
							comfield.setText("");
							Comments com = new Comments();
							com.setContent(res);
							com.setArticle_id(a.getId());
							com.setUser_id(globalVar.user.getId());
							
							SimpleDateFormat fs = new SimpleDateFormat("yyyy-MM-dd");
							com.setDate(fs.format(new Date()));
							try {
								globalVar.com.pushModify(com);
							} catch (SQLException e) {
								// TODO �Զ����ɵ� catch ��
								e.printStackTrace();
							}
							JOptionPane.showMessageDialog(null, "���۷����ɹ�", "��ʾ", 3);
							commentbtn.doClick();
							commentbtn.doClick();
						}
						
					});
					comb.removeAll();
					JPanel pp = new JPanel();
//					pp.setLayout(new BoxLayout(pp, BoxLayout.Y_AXIS));
//					pp.setBorder(null);
					pp.setPreferredSize((new Dimension(670, 620)));
					ArrayList<Comments> cl;
					try {
						cl = globalVar.com.loadComments(a.getId(), "article");
						for (Comments com : cl) {
							
							JPanel ppp = new JPanel();
							JLabel l0 = new JLabel(" ID ��" + com.getId());
//							JLabel l1 = new JLabel(" ʱ�䣺" + com.getDate());
//							System.out.println(com.getUser_id());
							JLabel l2 = new JLabel(" �û��� " + globalVar.user_mp.get(com.getUser_id()));
							JLabel l3 = new JLabel(" ��������" + com.getFollow());
							JLabel l4 = new JLabel(" ���ݣ�" + com.getContent());
							
							l0.setPreferredSize(new Dimension(60, 25));
//							l1.setPreferredSize(new Dimension(120, 25));
							l2.setPreferredSize(new Dimension(90, 25));
							l3.setPreferredSize(new Dimension(70, 25));
							l4.setPreferredSize(new Dimension(280, 25));
							JButton jb = new JButton("����");
							jb.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									String sql = "update comments set follow = follow+1 where id = "+com.getId()+";";
									try {
										JdbTools.stmt.executeUpdate(sql);
										jb.setEnabled(false);
										l3.setText(" ��������" + (com.getFollow()+1));
									} catch (SQLException e) {
										// TODO �Զ����ɵ� catch ��
										e.printStackTrace();
									}
								}
								
							});
							ppp.add(l0);
//							ppp.add(l1);
							ppp.add(l2);
							ppp.add(l3);
							ppp.add(l4);
							ppp.add(jb);
							ppp.setPreferredSize(new Dimension(700,30));
							pp.add(ppp);

						}
					} catch (SQLException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
					
					JScrollPane comsc = new JScrollPane(pp);
					comsc.setPreferredSize(new Dimension(700, 150));
					comp.add(comfield);
					comp.add(comb);
					comp.add(comsc);
					comp.setPreferredSize(new Dimension(700, 190));
					p.add(comp);
//					commentbtn.setText("��ԭ");

				} else {
					p.remove(comp);
				}
				morecnt[1] = morecnt[1] + 1;
				p.revalidate();
			}
		});

		p.add(p1);
		p.add(text);
		p.add(p2);

		p.setBackground(Color.CYAN);
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.setVisible(true);

		return p;
	}

	private int min(int i, int length) {
		// TODO �Զ����ɵķ������
		return (i<length?i:length);
	}

	JPanel getarticleView() throws SQLException {
		JPanel p = new JPanel();
		p.setPreferredSize(new Dimension(840, 6000));

		ArrayList<Article> al = globalVar.com.loadArticles(-1, "user");

		for (Article a : al) {
			p.add(articlePanel(a));
		}

		JScrollPane sc = new JScrollPane(p);
		sc.setPreferredSize(new Dimension(850, 850));

		JPanel panel = new JPanel();
		panel.add(sc);
		panel.setBounds(245, 0, 850, 850);
		panel.setVisible(true);

		return panel;
	}

	JPanel getzoneView() throws SQLException {
		JPanel p = new JPanel();
		p.setLayout(null);
		JPanel ap = getarticleView();
		p.add(ap);

		JLabel userlabl = new JLabel("��ǰ�û�    �� " + globalVar.user.getName());
		userlabl.setBounds(30, 30, 200, 25);
		p.add(userlabl);
		ArrayList<Book> bl = globalVar.com.loadBooks(-1);

		int cnt = 0, h = 20, width = 150, height = 25;
		for (Book b : bl) {
			JLabel j = new JLabel(b.getName() + " : " + b.article_id_list.size());
			j.setBounds(30, 60 + cnt * h, width, height);
			p.add(j);
			cnt += 1;
		}

		if (globalVar.user.getAuthority() != 2) {
			JButton newbtn = new JButton("��������");
			newbtn.setBounds(30, 60 + cnt * h + 50, 150, height);
			newbtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO �Զ����ɵķ������
					JDialog frame = new JDialog();
					frame.setBounds(450, 30, 820, 920);
					try {
						frame.add(getArticleEditPanel(new Article()));
					} catch (SQLException e) {
						e.printStackTrace();
					}
					frame.setModalityType(JDialog.ModalityType.APPLICATION_MODAL);
					frame.setVisible(true);
				}

			});
			p.add(newbtn);
		}

		p.setVisible(true);

		return p;
	}
}
