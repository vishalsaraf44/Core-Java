package pages;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class start
{
	static JFrame j;
	static JButton signin = new JButton("Sign In");;
	static JButton signup = new JButton("Sign Up");;
	static JLabel NeedACarOnRent=new JLabel("Need A Car On Rent ?");
	start()
	{	
		j=new JFrame("Cab Rental Service");
		j.setSize(850,520);
		j.setLocationRelativeTo(null);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setContentPane(new JLabel(new ImageIcon(System.getProperty("user.dir")+"/src/resouce/login.jpg")));
		j.setLayout(null);
		j.setBackground(Color.WHITE);
		Font f1 = new Font("SansSerif", Font.ITALIC, 40); 
		NeedACarOnRent.setFont(f1);
		NeedACarOnRent.setHorizontalAlignment(JLabel.CENTER);
		signin.setFont(f1);
		signup.setFont(f1);
		signin.setContentAreaFilled(false);
		//signin.setBorderPainted(false);
		signup.setContentAreaFilled(false);
		//signup.setBorderPainted(false);
		j.add(NeedACarOnRent);
		j.add(signin);
		j.add(signup);
		mainlistener ml=new mainlistener();
		signin.addActionListener(ml);
		signup.addActionListener(ml);
		NeedACarOnRent.setBounds(0, 0, 600, 50);
		signup.setBounds(0,100,200,155);
		signin.setBounds(650,100,200,155);
		j.setVisible(true);
	}
}
