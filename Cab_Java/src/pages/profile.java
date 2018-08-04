package pages;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class profile
{
	static JLabel l1=new JLabel("WELCOME TO HOME PAGE");
	static JFrame jp;
	static JButton bookp = new JButton("Book a Cab");;
	static JButton historyp = new JButton("Check History");
	static JButton backbtn=new JButton("Back");

	profile()
	{	
		jp=new JFrame("Welcome Page");
		jp.setSize(850,520);
		jp.setLocationRelativeTo(null);
		jp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jp.setContentPane(new JLabel(new ImageIcon(System.getProperty("user.dir")+"/src/resouce/login.jpg")));
		jp.setLayout(null);
		Font f1 = new Font("SansSerif", Font.ITALIC, 30);
		jp.add(backbtn);
		backbtn.setBounds(20,20,80,20);
		jp.setBackground(Color.WHITE);
		l1.setFont(f1);
		bookp.setFont(f1);
		historyp.setFont(f1);
		jp.add(bookp);
		jp.add(historyp);
		jp.add(l1);
		mainlistener ml=new mainlistener();
		backbtn.addActionListener(ml);
		bookp.addActionListener(ml);
		historyp.addActionListener(ml);
		l1.setBounds(200,20,500,30);
		bookp.setBounds(100,200,300,100);
		historyp.setBounds(450,200,300,100);
		jp.setVisible(true);
	}
}
