package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Book;
import model.globalVar;

public class bookView {

	JPanel bookPanel(Book b) {
		JPanel p = new JPanel();
		p.setLayout(null);
		p.setPreferredSize(new Dimension(200, 300));
		JLabel name = new JLabel(b.getName());
		JLabel author = new JLabel(b.getAuthor());
		JLabel publisher = new JLabel(b.getPublisher());
		JLabel artnum = new JLabel("相关文章数 ：" + b.article_id_list.size());

		name.setBounds(20, 190, 120, 20);
		author.setBounds(20, 210, 120, 20);
		publisher.setBounds(20, 230, 120, 20);
		artnum.setBounds(20, 250, 120, 20);

//		System.out.println(name.getText() + ";;;;");
		p.add(name);
		p.add(author);
		p.add(publisher);
		p.add(artnum);

		JButton editbtn = new JButton("编辑");
		JButton deletebtn = new JButton("删除");
		editbtn.setBounds(20, 275, 80, 25);
		deletebtn.setBounds(110, 275, 80, 25);
		editbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JDialog frame = new JDialog();// 构造一个新的JFrame，作为新窗口。
				frame.setBounds(420, 150, 500, 800);
				try {
					frame.add(getbookEditView(b));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// 参数 APPLICATION_MODAL：阻塞同一 Java 应用程序中的所有顶层窗口（它自己的子层次
				frame.setModalityType(JDialog.ModalityType.APPLICATION_MODAL); // 设置模式类型。
				frame.setVisible(true);
			}

		});

		p.add(editbtn);
		p.add(deletebtn);

		p.setVisible(true);
		final Random r = new Random();
		p.setBackground(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256), r.nextInt(256)));
		return p;
	}

	JPanel getAle(String s, JTextField j, Dimension preferredSize) {
		JLabel label = new JLabel(s);
		label.setPreferredSize(new Dimension(60, 30));
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel.add(label);
		panel.add(j);
		panel.setVisible(true);
		panel.setPreferredSize(preferredSize);
		panel.setOpaque(false);
		return panel;
	}

	JPanel getbookView() throws SQLException {
		JPanel p = new JPanel();
		JPanel bp = new JPanel();
		bp.setPreferredSize(new Dimension(1150, 6000));

		ArrayList<Book> bl = globalVar.com.loadBooks(globalVar.user.getId());
		for (Book b : bl) {
//			System.out.println(b.toString());
			bp.add(bookPanel(b));
		}

		JPanel newPanel = new JPanel();
		newPanel.setPreferredSize(new Dimension(200, 300));
		newPanel.setLayout(null);
		newPanel.setBackground(Color.YELLOW);
		JButton newbtn = new JButton("添加新书");
		newbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JDialog frame = new JDialog();// 构造一个新的JFrame，作为新窗口。
				frame.setBounds(420, 150, 500, 800);
				try {
					frame.add(getbookEditView(new Book()));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// 参数 APPLICATION_MODAL：阻塞同一 Java 应用程序中的所有顶层窗口（它自己的子层次
				frame.setModalityType(JDialog.ModalityType.APPLICATION_MODAL); // 设置模式类型。
				frame.setVisible(true);
			}

		});
		newbtn.setBounds(50, 140, 100, 25);
		newPanel.add(newbtn);
		newPanel.setVisible(true);

		bp.add(newPanel);

		JScrollPane sc = new JScrollPane(bp);
		sc.setPreferredSize(new Dimension(1150, 850));

		p.add(sc);
		p.setBounds(0, 0, 1150, 850);
		p.setVisible(true);

		return p;
	}

	JPanel getbookEditView(Book b) throws SQLException {

		JPanel p = new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.LEFT));

		Dimension preferredSize = new Dimension(450, 40); // 设置尺寸

		JTextField idtext = new JTextField(30);
		idtext.setText(String.valueOf(b.getId()));
//								"书名           "
		JPanel idpanel = getAle("ID", idtext, preferredSize);

		JTextField nametext = new JTextField(30);
		nametext.setText(b.getName());
		JPanel namepanel = getAle("书名", nametext, preferredSize);

		JTextField ibsntext = new JTextField(30);
		ibsntext.setText(String.valueOf(b.getIBSN()));
		JPanel ibsnpanel = getAle("IBSN", ibsntext, preferredSize);

		JLabel catglab = new JLabel(" 选择分类");
		catglab.setPreferredSize(new Dimension(65, 30));
		JComboBox catgbox = new JComboBox();
		catgbox.setPreferredSize(new Dimension(335, 30));
		catgbox.addItem("---请选择书的分类---");
		for (String s : globalVar.catg_mp_rev.keySet()) {
			catgbox.addItem(s);
		}

		JTextField authortext = new JTextField(30);
		authortext.setText(b.getAuthor());
		JPanel authorpanel = getAle("作者", authortext, preferredSize);

		JTextField publishertext = new JTextField(30);
		publishertext.setText(b.getPublisher());
		JPanel publisherpanel = getAle("出版社", publishertext, preferredSize);

		JTextField datetext = new JTextField(30);
		datetext.setText(b.getDate());
		JPanel datepanel = getAle("出版日期", datetext, preferredSize);

		JTextArea desctext = new JTextArea(10, 30);
		desctext.setLineWrap(true);
		desctext.setText(b.getDescription());
		JScrollPane sc = new JScrollPane(desctext);
		sc.setPreferredSize(new Dimension(360, 100));

		p.add(idpanel);
		p.add(namepanel);
		p.add(ibsnpanel);
		p.add(catglab);
		p.add(catgbox);
		p.add(authorpanel);
		p.add(publisherpanel);
		p.add(datepanel);
		p.add(new JLabel("  描述          "));
		p.add(sc);

		JButton backbtn = new JButton("还原");
		JButton okbtn = new JButton("确认");
		backbtn.setPreferredSize(new Dimension(200, 30));
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				idtext.setText(String.valueOf(b.getId()));
				nametext.setText(b.getName());
				authortext.setText(b.getAuthor());
				publishertext.setText(b.getPublisher());
				datetext.setText(b.getDate());
				desctext.setText(b.getDescription());
			}

		});
		okbtn.setPreferredSize(new Dimension(200, 30));
		okbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				b.setId(Integer.parseInt(idtext.getText()));
				b.setName(nametext.getText());
				b.setIBSN(ibsntext.getText());
				b.setAuthor(authortext.getText());
				b.setPublisher(publishertext.getText());
				b.setDate(datetext.getText());
				b.setDescription(desctext.getText());
				b.setUser_id(globalVar.user.getId());
				if (globalVar.catg_mp_rev.get(catgbox.getSelectedItem()) == null) {
					JOptionPane.showMessageDialog(p, "请为书籍选择一个种类", "提示", 3);
					return;
				}
				b.setCategory_id(globalVar.catg_mp_rev.get(catgbox.getSelectedItem()));

				try {
					globalVar.com.pushModify(b);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
//					JOptionPane.showMessageDialog(null, "添加失敗", "提示", 3);
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(p, "操作成功", "提示", 3);
			}

		});

		p.add(backbtn);
		p.add(okbtn);

		p.setPreferredSize(new Dimension(450, 600));

		p.setVisible(true);

		return p;
	}
}
