package pages;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class history 
{
	static JFrame jh=new JFrame();
	static JButton print=new JButton("Print Invoice");
	static JTextField bookingnumber =new JTextField();
	static JButton backbtn=new JButton("Back");

	history()
	{
		jh=new JFrame("History");
		jh.setSize(850,520);
		jh.setLocationRelativeTo(null);
		jh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jh.setContentPane(new JLabel(new ImageIcon(System.getProperty("user.dir")+"/src/resouce/login.jpg")));
		jh.setLayout(null);
		jh.add(bookingnumber);
		jh.add(print);
		jh.setBackground(Color.white);
		mainlistener cb=new mainlistener();
		backbtn.addActionListener(cb);
		print.addActionListener(cb);
		JLabel l1=new JLabel("Please Enter Your Unique Booking Number");
		Font f1 = new Font("SansSerif", Font.BOLD, 20);
		//Font f2 = new Font("SansSerif", Font.BOLD, 20);
		l1.setFont(f1);
		bookingnumber.setFont(f1);
		jh.add(backbtn);
		jh.add(l1);
		backbtn.setBounds(20,20,80,20);
		l1.setBounds(240,50,500,80);
		bookingnumber.setBounds(300,120,250,50);
		print.setBounds(350,200,140,20);
		jh.setVisible(true);
	}
}