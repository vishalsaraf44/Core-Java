package pages;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class signup
{
	static JFrame jf;
	static JLabel l1=new JLabel("Full Name");
	static JLabel l2=new JLabel("User Name");
	static JLabel l3=new JLabel("Password");
	static JLabel l4=new JLabel("Email");
	static JLabel l5=new JLabel("Repeat Password");
	static JTextField name=new JTextField(40);
	static JTextField email=new JTextField(40);
	static JTextField user=new JTextField(40);
	static JPasswordField password=new JPasswordField(40);
	static JPasswordField repeatpass=new JPasswordField(40);
	static JButton b1=new JButton("Create account");
	static JButton backbtn=new JButton("Back");
	signup()
	{
		jf=new JFrame("Sign Up");
		jf.setSize(850,520);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLayout(null);
		jf.setBackground(Color.WHITE);
		Font f1 = new Font("SansSerif", Font.ITALIC, 40);
		Font f2 = new Font("SansSerif", Font.ITALIC, 20);
		jf.setContentPane(new JLabel(new ImageIcon(System.getProperty("user.dir")+"/src/resouce/login.jpg")));
		jf.setFont(f1);
		l1.setFont(f2);
		l2.setFont(f2);
		l3.setFont(f2);
		l4.setFont(f2);
		l5.setFont(f2);
		user.setFont(f2);
		name.setFont(f2);
		email.setFont(f2);
		password.setFont(f2);
		repeatpass.setFont(f2);
		jf.add(name);
		jf.add(backbtn);
		jf.add(email);
		jf.add(l1);
		jf.add(l2);
		jf.add(l3);
		jf.add(user);
		jf.add(b1);
		jf.add(l4);
		jf.add(l5);
		b1.setFont(f2);
		jf.add(password);
		jf.add(repeatpass);
		mainlistener a=new mainlistener();
		b1.addActionListener(a);
		backbtn.addActionListener(a);
		l1.setBounds(280,50,300,20);
		l2.setBounds(280,120,300,20);
		l3.setBounds(280,250,300,20);
		l4.setBounds(280,190,300,20);
		l5.setBounds(280,320,300,20);
		backbtn.setBounds(20,20,80,20);
		name.setBounds(280,80,300,30);
		email.setBounds(280,210,300,30);
		user.setBounds(280,150,300,30);
		password.setBounds(280,280,300,30);
		repeatpass.setBounds(280,350,300,30);

		b1.setBounds(450,380,200,40);

		jf.setVisible(true);
	}
}