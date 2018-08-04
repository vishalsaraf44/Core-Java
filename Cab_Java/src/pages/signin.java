package pages;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class signin
{
	static JFrame jf1;
	static JLabel l1=new JLabel("Username : ");
	static JLabel l2=new JLabel("Password : ");
	static JTextField user=new JTextField(40);
	static JPasswordField password=new JPasswordField(40);
	static JButton login=new JButton("Sign In");
	static JButton backbtn=new JButton("Back");

	signin()
	{
		jf1=new JFrame("Sign In");
		jf1.setSize(850,520);
		jf1.setLocationRelativeTo(null);
		jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf1.setContentPane(new JLabel(new ImageIcon(System.getProperty("user.dir")+"/src/resouce/login.jpg")));
		jf1.setLayout(null);
		jf1.setBackground(Color.WHITE);
		Font f1 = new Font("SansSerif", Font.ITALIC, 40);
		Font f2 = new Font("SansSerif", Font.ITALIC, 20);
		jf1.add(backbtn);
		backbtn.setBounds(20,20,80,20);
		backbtn.setBackground(Color.white);
		login.setBackground(Color.white);
		l1.setFont(f2);
		l2.setFont(f2);
		jf1.setFont(f1);
		jf1.add(l1);
		jf1.add(l2);
		jf1.add(user);
		jf1.add(login);
		jf1.add(password);
		mainlistener m=new mainlistener();
		backbtn.addActionListener(m);
		login.addActionListener(m);
		l1.setBounds(300,100,300,20);
		user.setBounds(300,130,300,30);
		l2.setBounds(300,170,300,20);
		password.setBounds(300,200,300,30);
		login.setBounds(380,250,150,30);
		jf1.setVisible(true);
	}
}

