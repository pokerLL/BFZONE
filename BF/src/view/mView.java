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

		panel.add(getAle("�û�         ", usertext));

		JTextField psdtext = new JTextField(20);

		panel.add(getAle("����         ", psdtext));

		JTextField repsdtext = new JTextField(20);
		panel.add(getAle("ȷ������", repsdtext));

		JTextField gendertext = new JTextField(20);
		panel.add(getAle("�Ա�         ", gendertext));

		JTextField birthdaytext = new JTextField(20);
		panel.add(getAle("����         ", birthdaytext));

		JTextField citytext = new JTextField(20);
		panel.add(getAle("����         ", citytext));

		if (user.getId() != -1) {
			usertext.setText(user.getName());
			psdtext.setText(user.getPsd());
			repsdtext.setText(user.getPsd());
			gendertext.setText(user.getGender());
			birthdaytext.setText(user.getBirthday());
			citytext.setText(user.getCity());
		}

		JButton clearButton = new JButton("����");

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

		JButton okButton = new JButton("ȷ��");
		okButton.setMnemonic(KeyEvent.VK_ENTER);
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (psdtext.getText().equals(repsdtext.getText())==false) {
					JOptionPane.showMessageDialog(null, "����ǰ��һ��", "��ʾ", 3);
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
					JOptionPane.showMessageDialog(null, "��ӳɹ�", "��ʾ", 3);

				} catch (SQLException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
			}
		});

		Dimension preferredSize = new Dimension(120, 25); // ���óߴ�
		clearButton.setPreferredSize(preferredSize); // ���ð�ť��С
		okButton.setPreferredSize(preferredSize);

		panel.add(clearButton);
		panel.add(okButton);
		return panel;
	}
	
	public JPanel commentsView(Comments com) {
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		Dimension preferredSize = new Dimension(100, 35);
		
		
		JLabel userlab =  new JLabel("���û�");
		userlab.setPreferredSize(preferredSize);
		JLabel articlelab =  new JLabel("������");
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
		
		
		
		JLabel followlab =  new JLabel("��ͬ��");
		followlab.setPreferredSize(preferredSize);
		JTextField followfield = new JTextField(30);
		followfield.setText(String.valueOf(com.getFollow()));
		
		JLabel datelab =  new JLabel("��������");
		datelab.setPreferredSize(preferredSize);
		JTextField datefield = new JTextField(30);
		datefield.setText(com.getDate());
		
		JLabel contlab = new JLabel("����");
		contlab.setPreferredSize(preferredSize);
		JTextArea contarea = new JTextArea(5,30);
		contarea.setText(com.getContent());
		
		p.add(followlab);
		p.add(followfield);
		p.add(datelab);
		p.add(datefield);
		p.add(contlab);
		p.add(contarea);
		
		
		

		JButton clearButton = new JButton("����");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				followfield.setText(String.valueOf(com.getFollow()));
				datefield.setText(com.getDate());
				contarea.setText(com.getContent());
			}
		});

		JButton okButton = new JButton("ȷ��");
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
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
			}
		});

		Dimension Size = new Dimension(120, 25); // ���óߴ�
		clearButton.setPreferredSize(Size); // ���ð�ť��С
		okButton.setPreferredSize(Size);

		p.add(clearButton);
		p.add(okButton);
		p.setPreferredSize(new Dimension(480,400));
		return p;
	}

	JPanel getAle(String s, JTextField j) {
		JLabel label = new JLabel(s);
		JPanel panel = new JPanel();
		Dimension preferredSize = new Dimension(1150, 35); // ���óߴ�
		panel.add(label);
		panel.add(j);
		panel.setVisible(true);
		panel.setPreferredSize(preferredSize);
		panel.setOpaque(false);
		return panel;
	}
}
