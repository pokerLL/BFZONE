package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Comments;
import model.User;
import model.globalVar;

public class mView {
	public JPanel SingupPanel(User user) {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JPanel p = new JPanel();
		p.setOpaque(false);
		p.setPreferredSize(new Dimension(1150, 300));
		panel.add(p);

		JTextField usertext = new JTextField(20);

		panel.add(getAle("用户         ", usertext));

		JTextField psdtext = new JTextField(20);

		panel.add(getAle("密码         ", psdtext));

		JTextField repsdtext = new JTextField(20);
		panel.add(getAle("确认密码", repsdtext));

		JTextField gendertext = new JTextField(20);
		panel.add(getAle("性别         ", gendertext));

		JTextField birthdaytext = new JTextField(20);
		panel.add(getAle("生日         ", birthdaytext));

		JTextField citytext = new JTextField(20);
		panel.add(getAle("城市         ", citytext));

		if (user.getId() != -1) {
			usertext.setText(user.getName());
			psdtext.setText(user.getPsd());
			repsdtext.setText(user.getPsd());
			gendertext.setText(user.getGender());
			birthdaytext.setText(user.getBirthday());
			citytext.setText(user.getCity());
		}

		JButton clearButton = new JButton("重置");

		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usertext.setText(user.getName());
				psdtext.setText(user.getPsd());
				repsdtext.setText(user.getPsd());
				gendertext.setText(user.getGender());
				birthdaytext.setText(user.getBirthday());
				citytext.setText(user.getCity());
			}
		});

		JButton okButton = new JButton("确认");
		okButton.setMnemonic(KeyEvent.VK_ENTER);
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (psdtext.getText().equals(repsdtext.getText())==false) {
					JOptionPane.showMessageDialog(null, "密码前后不一致", "提示", 3);
					return;
				}
				User user = new User();
				user.setId(-1);
				user.setAuthority(1);
				user.setName(usertext.getText());
				user.setPsd(psdtext.getText());
				user.setGender(gendertext.getText());
				user.setBirthday(birthdaytext.getText());
				user.setCity(citytext.getText());
				try {
					globalVar.com.pushModify(user);
					globalVar.user = user;
					globalVar.user.setId(10000000);
					JOptionPane.showMessageDialog(null, "添加成功", "提示", 3);

				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});

		Dimension preferredSize = new Dimension(120, 25); // 设置尺寸
		clearButton.setPreferredSize(preferredSize); // 设置按钮大小
		okButton.setPreferredSize(preferredSize);

		panel.add(clearButton);
		panel.add(okButton);
		return panel;
	}
	
	public JPanel commentsView(Comments com) {
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		Dimension preferredSize = new Dimension(100, 35);
		
		
		JLabel userlab =  new JLabel("绑定用户");
		userlab.setPreferredSize(preferredSize);
		JLabel articlelab =  new JLabel("绑定文章");
		articlelab.setPreferredSize(preferredSize);
		JComboBox userbox = new JComboBox();
		JComboBox articlebox = new JComboBox();
		Set<String> ul = globalVar.user_mp_rev.keySet();
		for(String i : ul) {
			userbox.addItem(i);
		}
		Set<String> al = globalVar.article_mp_rev.keySet();
		for(String i : al) {
			articlebox.addItem(i);
		}
		p.add(userlab);
		p.add(userbox);
		p.add(articlelab);
		p.add(articlebox);
		
		
		
		JLabel followlab =  new JLabel("赞同数");
		followlab.setPreferredSize(preferredSize);
		JTextField followfield = new JTextField(30);
		followfield.setText(String.valueOf(com.getFollow()));
		
		JLabel datelab =  new JLabel("发布日期");
		datelab.setPreferredSize(preferredSize);
		JTextField datefield = new JTextField(30);
		datefield.setText(com.getDate());
		
		JLabel contlab = new JLabel("内容");
		contlab.setPreferredSize(preferredSize);
		JTextArea contarea = new JTextArea(5,30);
		contarea.setText(com.getContent());
		
		p.add(followlab);
		p.add(followfield);
		p.add(datelab);
		p.add(datefield);
		p.add(contlab);
		p.add(contarea);
		
		
		

		JButton clearButton = new JButton("重置");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				followfield.setText(String.valueOf(com.getFollow()));
				datefield.setText(com.getDate());
				contarea.setText(com.getContent());
			}
		});

		JButton okButton = new JButton("确认");
		okButton.setMnemonic(KeyEvent.VK_ENTER);
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				com.setUser_id(globalVar.user_mp_rev.get(userbox.getSelectedItem()));
				com.setArticle_id(globalVar.article_mp_rev.get(articlebox.getSelectedItem()));
				com.setFollow(Integer.parseInt(followfield.getText()));
				com.setDate(datefield.getText());
				com.setContent(contarea.getText());
				try {
					globalVar.com.pushModify(com);
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});

		Dimension Size = new Dimension(120, 25); // 设置尺寸
		clearButton.setPreferredSize(Size); // 设置按钮大小
		okButton.setPreferredSize(Size);

		p.add(clearButton);
		p.add(okButton);
		p.setPreferredSize(new Dimension(480,400));
		return p;
	}

	JPanel getAle(String s, JTextField j) {
		JLabel label = new JLabel(s);
		JPanel panel = new JPanel();
		Dimension preferredSize = new Dimension(1150, 35); // 设置尺寸
		panel.add(label);
		panel.add(j);
		panel.setVisible(true);
		panel.setPreferredSize(preferredSize);
		panel.setOpaque(false);
		return panel;
	}
}
