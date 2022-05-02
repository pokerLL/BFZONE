package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.globalVar;

public class msgView {
	String abt = "\t关于我们\r\n广东铂亚信息技术有限公司成立于1999年，自成立以来，一直致力于专业的生物特征识别技术研究、应用产品开发及市场推广，是专业从事人脸识别、智能视频分析、数字图像处理、计算机视觉分析、行为模式识别等多领域技术研发及应用的高科技企业，是广东省最早从事软件开发的企业之一，荣获多种荣誉资质。2015年1月，与珠海欧比特宇航科技股份有限公司（股票代码300053）进行资产重组，成为其独立的全资子公司。成立至今，铂亚在知名度、产品、销售能力、售后服务等各方面，都取得了长足的发展。已分别在北京、上海、武汉、成都、西宁、深圳等多地成立分公司或办事处。\r\n"
			+ "多年以来，铂亚公司一直坚持持续创新的发展理念，通过产学研联动发展模式，打造勇于创新的团队，对产品科研及技术创新投入大量资金，使得铂亚公司在产品研发方面取得了突破性的进展。公司的系列产品已广泛应用于公共安全、国家安全、政府机关、司法及金融等诸多领域。在未来,铂亚公司将不断的提升产品技术，扩大智能识别在安全领域的应用，为建设中国和谐社会而努力。\r\n"
			+ "2013年铂亚公司成立了智能交通事业部，并确立了智能交通及平安城市将作为铂亚今后的核心业务发展方向之一，在充分消化吸收国内外先进的交通技术、设备的基础上，结合我国城市交通的复杂状况，致力于开发适合中国城市发展的ITS产品和解决方案。智能交通事业部以“引领智能交通、缔造平安生活”为宗旨，为城市道路交通和安全的改善提供全套解决方案，成为卓越的智慧城市方案提供商。\r\n"
			+ "公司原在广州天河软件园区内办公，为给员工提供更舒适和宽广的工作环境，公司领导毅然放弃天河的成熟环境，搬迁到番禺天安科技园，购置园区总部2号楼12楼整层，并计划在番禺合适地点购置厂房。铂亚热忱欢迎各方有志之士加入，共同成长、进步！";

	JPanel getmsgView() throws SQLException {
		JPanel p = new JPanel();
		p.setLayout(null);
		p.setBounds(0, 0, 1150, 850);

		JTextArea aboutus = new JTextArea(abt);
		aboutus.setBounds(50, 150, 370, 850);

		aboutus.setLineWrap(true);
		aboutus.setOpaque(false);
		p.add(aboutus);

		JTextArea msg = new JTextArea(20, 50);
		msg.setLineWrap(true);
		msg.setEditable(false);
		msg.setText(globalVar.com.getMsgs());
		JScrollPane scrollPane = new JScrollPane(msg);
		scrollPane.setBounds(450, 150, 620, 400);
		p.add(scrollPane);

		JTextField text = new JTextField(20);
		text.setBounds(450, 560, 450, 30);
		JButton okbtn = new JButton("匿名留言");
		okbtn.setMnemonic(KeyEvent.VK_ENTER);
		okbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
				String date = df.format(new Date());
				String content = text.getText();

				try {
					globalVar.com.pushModify(date, content);
					msg.append("[ " + date + " ] : " + content + "\r\n");
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				text.setText("");
			}

		});
		okbtn.setBounds(960, 560, 100, 30);

		p.add(text);
		p.add(okbtn);

		p.setVisible(true);
		return p;

	}
}
