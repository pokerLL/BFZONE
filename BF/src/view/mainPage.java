package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.*;

import model.*;

//BorderLayout 
public class mainPage {
	private JFrame mainFrame;
	private JPanel leftPanel;
	private JPanel rightPanel;
	JButton mangerbtn;
	JButton zonebtn;
	JButton bookbtn;
	JButton msgbtn;
	JButton loginbtn;
	JButton singupbtn;
	JButton visbtn;
	int x_1 = 35;

	public mainPage() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		mainFrame = new JFrame("");
		mainFrame.setResizable(false);
		mainFrame.setLayout(new BorderLayout());
		mainFrame.setBounds(200, 150, 1450, 850);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		leftPanel = LPanel();// 300 850
		leftPanel.setBackground(Color.PINK);
		mainFrame.add(leftPanel, BorderLayout.WEST);
		rightPanel = RPanel();// 1150 850
		rightPanel.setBackground(Color.ORANGE);
		mainFrame.add(rightPanel, BorderLayout.CENTER);

		// disableTool(false);
		mainFrame.setVisible(true);
		
	}

	JPanel LPanel() {
		
		JPanel p = new JPanel();
		p.setPreferredSize(new Dimension(300, 850));
		p.setLayout(null);
		p.add(Box.createVerticalStrut(300), BorderLayout.NORTH);

		mangerbtn = new JButton("    管理面板    ");
		mangerbtn.setBounds(x_1, 230 + 50, 200, 25);
		mangerbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// System.out.println("clicking...");
				mainFrame.remove(rightPanel);
				try {
					rightPanel = new mangView().getmangView();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				rightPanel.setVisible(true);
//				rightPanel.setBackground(Color.ORANGE);
				mainFrame.add(rightPanel, BorderLayout.CENTER);
				mainFrame.revalidate();
			}

		});

		zonebtn = new JButton("    前往空间    ");
		zonebtn.setBounds(x_1, 270 + 50, 200, 25);
		zonebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// System.out.println("clicking...");
				mainFrame.remove(rightPanel);
				try {
					rightPanel = new zoneView().getzoneView();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				rightPanel.setVisible(true);
//				rightPanel.setBackground(Color.ORANGE);
				mainFrame.add(rightPanel, BorderLayout.CENTER);
				mainFrame.revalidate();
			}

		});

		bookbtn = new JButton("    浏览书籍    ");
		bookbtn.setBounds(x_1, 310 + 50, 200, 25);
		bookbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// System.out.println("clicking...");
				mainFrame.remove(rightPanel);
				try {
					// System.out.println("clickinging...");
					rightPanel = new bookView().getbookView();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				rightPanel.setVisible(true);
//				rightPanel.setBackground(Color.ORANGE);
				mainFrame.add(rightPanel, BorderLayout.CENTER);
				mainFrame.revalidate();
			}

		});

		msgbtn = new JButton("    匿名留言    ");
		msgbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainFrame.remove(rightPanel);
				try {
					rightPanel = new msgView().getmsgView();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				rightPanel.setVisible(true);
				rightPanel.setBackground(Color.ORANGE);
				mainFrame.add(rightPanel, BorderLayout.CENTER);
				mainFrame.revalidate();

			}

		});
		msgbtn.setBounds(x_1, 350 + 50, 200, 25);
		Boolean b = false;
		mangerbtn.setEnabled(b);
		zonebtn.setEnabled(b);
		bookbtn.setEnabled(b);
		msgbtn.setEnabled(b);

		loginbtn = new JButton("    登录    ");
		loginbtn.setMnemonic(KeyEvent.VK_ENTER);
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainFrame.remove(rightPanel);
				rightPanel = LoginPanel();
				rightPanel.setVisible(true);
				rightPanel.setBackground(Color.ORANGE);
				mainFrame.add(rightPanel, BorderLayout.CENTER);
				mainFrame.revalidate();
			}

		});
		loginbtn.setBounds(x_1, 720, 200, 25);

		singupbtn = new JButton("注册");
		singupbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainFrame.remove(rightPanel);
				rightPanel = SingupPanel();
				rightPanel.setVisible(true);
				rightPanel.setBackground(Color.ORANGE);
				mainFrame.add(rightPanel, BorderLayout.CENTER);
				mainFrame.revalidate();
			}

		});
		singupbtn.setBounds(x_1, 755, 80, 25);

		visbtn = new JButton("游客访问 ");
		visbtn.setBounds(130, 755, 105, 25);
		visbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				globalVar.user = new User();
				globalVar.user.setAuthority(2);
				globalVar.user.setName("游客");
				JOptionPane.showMessageDialog(rightPanel, "欢迎使用游客身份登录,在此身份下只可访问空间和使用留言板功能!", "欢迎", 3);
				zonebtn.doClick();
				disableLog(false);
				//disableTool(false);
				Boolean b = false;
				mangerbtn.setEnabled(b);
				bookbtn.setEnabled(b);
				mainFrame.revalidate();
			}

		});

		p.add(mangerbtn);
		p.add(zonebtn);
		p.add(bookbtn);
		p.add(msgbtn);
		p.add(loginbtn);
		p.add(singupbtn);
		p.add(visbtn);

		p.setVisible(true);
		return p;
	}

	JPanel RPanel() {
		JPanel p = new JPanel();
		p.setVisible(true);
		return p;
	}

	JPanel LoginPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		int X = 460, Y = 350;

		JLabel userLabel = new JLabel("User:");

		userLabel.setBounds(10 + X, 20 + Y, 80, 25);
		panel.add(userLabel);

		JTextField userText = new JTextField(20);
		userText.setBounds(100 + X, 20 + Y, 165, 25);
		panel.add(userText);

		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(10 + X, 50 + Y, 80, 25);
		panel.add(passwordLabel);

		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(100 + X, 50 + Y, 165, 25);
		panel.add(passwordText);

		// 创建登录按钮
		JButton clearButton = new JButton("重置");
		clearButton.setBounds(10 + X, 80 + Y, 80, 25);
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userText.setText("");
				passwordText.setText("");
			}
		});

		//
		JButton logButton = new JButton("登录");
		logButton.setMnemonic(KeyEvent.VK_ENTER);
		logButton.setBounds(100 + X, 80 + Y, 80, 25);
		logButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = userText.getText();
				String psd = String.valueOf(passwordText.getPassword());
				// 尝试登录
//				 System.out.println(user + "\t" + psd);
				try {
					globalVar.user = new User(user, psd);
//					System.out.println(globalVar.user.toString());
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
//				globalVar.user =  new User();

				if (globalVar.user.getAuthority() == -2) {
					JOptionPane.showMessageDialog(rightPanel, "密码错误，请重新输入密码", "问题", 3);
					passwordText.setText("");

				} else if (globalVar.user.getAuthority() == -1) {
					JOptionPane.showMessageDialog(rightPanel, "无此账号或账号已被管理员封禁，拒绝访问，谢谢使用" + globalVar.user.getName(),
							"问题", 3);

					clearButton.doClick();
				} else if (globalVar.user.getAuthority() == 0) {
					JOptionPane.showMessageDialog(rightPanel, "欢迎管理员登录", "欢迎", 3);
					Boolean b = true;
					mangerbtn.setEnabled(b);
					zonebtn.setEnabled(b);
					bookbtn.setEnabled(b);
					msgbtn.setEnabled(b);
					mangerbtn.doClick();
					disableLog(false);
					// disableTool(true);
					clearButton.doClick();
				} else if (globalVar.user.getAuthority() == 1) {
					JOptionPane.showMessageDialog(rightPanel, "欢迎用戶" + globalVar.user.getName() + "登录", "欢迎", 3);
					Boolean b = true;
					mangerbtn.setEnabled(b);
					zonebtn.setEnabled(b);
					bookbtn.setEnabled(b);
					msgbtn.setEnabled(b);
					bookbtn.doClick();
					clearButton.doClick();
					disableLog(false);
					// disableTool(true);
				}

			}
		});

		JButton signupButton = new JButton("注册");
		signupButton.setBounds(190 + X, 80 + Y, 80, 25);
		signupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				singupbtn.doClick();
			}
		});

		panel.add(clearButton);
		panel.add(logButton);
		panel.add(signupButton);
		return panel;
	}

	JPanel SingupPanel() {
//		final int X = 100, Y = 100;
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JPanel p = new JPanel();
		p.setOpaque(false);
		p.setPreferredSize(new Dimension(1150, 300));
		panel.add(p);

		JTextField usertext = new JTextField(20);
		panel.add(getAle("用户         ", usertext));

		JPasswordField psdtext = new JPasswordField(20);
		panel.add(getAle("密码         ", psdtext));

		JPasswordField repsdtext = new JPasswordField(20);
		panel.add(getAle("确认密码", repsdtext));

		JTextField gendertext = new JTextField(20);
		panel.add(getAle("性别         ", gendertext));

		JTextField birthdaytext = new JTextField(20);
		panel.add(getAle("生日         ", birthdaytext));

		JTextField citytext = new JTextField(20);
		panel.add(getAle("城市         ", citytext));

		JButton clearButton = new JButton("重置");

		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usertext.setText("");
				psdtext.setText("");
				repsdtext.setText("");
				gendertext.setText("");
				birthdaytext.setText("");
				citytext.setText("");
			}
		});

		JButton okButton = new JButton("确认注册");
		okButton.setMnemonic(KeyEvent.VK_ENTER);
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (psdtext.getText().equals(repsdtext.getText()) == false) {
					JOptionPane.showMessageDialog(null, "密码前后不一致", "提示", 3);
					return;
				}

				User user = new User();
				user.setId(-1);
				user.setAuthority(1);
				user.setName(usertext.getText());
				user.setPsd(String.valueOf(psdtext.getPassword()));
				user.setGender(gendertext.getText());
				user.setBirthday(birthdaytext.getText());
				user.setCity(citytext.getText());
				try {
					globalVar.com.pushModify(user);
					globalVar.user = user;
					globalVar.user.setId(10000000);
					JOptionPane.showMessageDialog(rightPanel, "欢迎用戶" + globalVar.user.getName() + "登录", "欢迎", 3);
					bookbtn.doClick();
					clearButton.doClick();
					disableLog(false);
					// disableTool(true);
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

	void disableTool(boolean b) {
//		mangerbtn.setEnabled(b);
//		zonebtn.setEnabled(b);
//		bookbtn.setEnabled(b);
//		msgbtn.setEnabled(b);
	}

	void disableLog(boolean b) {
		loginbtn.setEnabled(b);
		singupbtn.setEnabled(b);
		visbtn.setEnabled(b);
	}
}
