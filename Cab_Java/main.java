import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class mainlistener implements ActionListener
{ 
	public void actionPerformed(ActionEvent e) 	
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cabbooking","root","Vish123");	
			if(e.getSource()==main.start)
			{
				start st=new start();
				main.j1.setVisible(false);
			}
			else if(e.getSource()==signin.backbtn)
			{
				start n=new start();
				signin.jf1.setVisible(false);
			}
			else if(e.getSource()==signup.backbtn)
			{
				start n=new start();
				signup.jf.setVisible(false);
			}
			else if(e.getSource()==cabrent.backbtn)
			{
				profile n=new profile();
				cabrent.jf2.setVisible(false);
			}
			else if(e.getSource()==profile.backbtn)
			{
				signin n=new signin();
				profile.jp.setVisible(false);
			}
			else if(e.getSource()==history.backbtn)
			{
				profile n=new profile();
				history.jh.setVisible(false);
			}
			else if(e.getSource()==start.signin)
			{
				signin s=new signin();
				start.j.setVisible(false);
			}
			else if(e.getSource()==start.signup)
			{
				signup s1=new signup();
				start.j.setVisible(false);
			}
			else if(e.getSource()==signup.b1)
			{
				PreparedStatement pst = con.prepareStatement("insert into customer values (?,?,?,?)");
				pst.setString(1, signup.name.getText());
			 	pst.setString(2, signup.email.getText());
			 	pst.setString(3, signup.user.getText());
				pst.setString(4, signup.password.getText());
			 	pst.executeUpdate();
			 	JOptionPane.showMessageDialog(signup.jf, "Thank you for your submission ACCOUNT WILL BE CREATED 				AUTOMATICALLY");
			}
			else if(e.getSource()==signin.login)
			{
				PreparedStatement pst1 = con.prepareStatement("select password from customer where user=? and password=?");
				pst1.setString(1,signin.user.getText());
				pst1.setString(2,signin.password.getText());
				ResultSet rst=pst1.executeQuery();
				if(rst.next())
				{
					profile p=new profile();
					signin.jf1.setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(signin.jf1, "Wrong Password/Username");
				}
			}
			else if(e.getSource()==cabrent.book)
			{
				long c= System.currentTimeMillis();
    			c++;
				PreparedStatement pst=con.prepareStatement("insert into data values(?,?,?,?,?,?,?)");
				pst.setLong(1,c);
				pst.setString(2,cabrent.sourcetxt.getText());
				pst.setString(3,cabrent.cabtypetxt.getText());
				pst.setString(4,cabrent.picaddresstxt.getText());
				pst.setString(5,cabrent.datetxt.getText());
				pst.setString(6,cabrent.timetxt.getText());
				pst.setInt(7,Integer.parseInt(cabrent.passengertxt.getText()));
				pst.executeUpdate();
				JOptionPane.showMessageDialog(cabrent.jf2, "Cab Booked.Your Unique Code is : " +c);
			}
			else if(e.getSource()==profile.bookp)
			{
				cabrent c=new cabrent();
				profile.jp.setVisible(false);
			}
			else if(e.getSource()==profile.historyp)
			{
				history h=new history();
				profile.jp.setVisible(false);
			}
			else if(e.getSource()==history.print)
			{
				if(history.bookingnumber.getText().toString().equals(""))
				{
					JOptionPane.showMessageDialog(history.jh, "Oops!!! Enter the Unique Booking Number!! ");
				}
				else
				{
					String Name=null;
					String Source=null;
					String Address=null;
					String Date=null;
					String Time=null;	
					String cab=null;
					PreparedStatement ps=con.prepareStatement("Select Source, CabType, Address, Date, Time from data where BookingId=?");	
					ps.setLong(1,Long.parseLong(history.bookingnumber.getText()));
					ResultSet rs=ps.executeQuery();
					while(rs.next())
					{
						Source=rs.getString(1);
						cab=rs.getString(2);
						Address=rs.getString(3);
						Date=rs.getString(4);
						Time=rs.getString(5);
					}
					PreparedStatement ps1=con.prepareStatement("Select Name from customer where user=?");
					ps1.setString(1,signin.user.getText());
					ResultSet rs1=ps1.executeQuery();
					while(rs1.next())
					{
						Name=rs1.getString("Name");
					}
					JOptionPane.showMessageDialog(history.jh, "Source : "+Source+ "\nAddress : "+Address+"\nAt : "+Time+ "\nOn : "+Date+"\n.Thank you for booking a cab");
				}
			}
		}
		catch(Exception p)
		{
			System.out.println("\n"+p);
		}	
	}
}

class main
{
	static JFrame j1;
	static JButton start;
	public static void main(String ar[])
	{
		j1=new JFrame("Cab Booking");
		j1.setSize(850,520);
		j1.setLocationRelativeTo(null);
		j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j1.setContentPane(new JLabel(new ImageIcon("start.png")));
		j1.setLayout(null);
		start = new JButton("Start");
		j1.add(start);
		mainlistener ml=new mainlistener();
		start.addActionListener(ml);
		start.setBounds(350,450,150,30);
		j1.setVisible(true);
	}
}

class start
{
	static JFrame j;
	static JButton signin = new JButton("Sign In");;
	static JButton signup = new JButton("Sign Up");;

	start()
	{	
		j=new JFrame("Cab Booking");
		j.setSize(850,520);
		j.setLocationRelativeTo(null);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setContentPane(new JLabel(new ImageIcon("icon.png")));
		j.setLayout(null);
		Font f1 = new Font("SansSerif", Font.ITALIC, 30); 
		signin.setFont(f1);
		signup.setFont(f1);
		j.add(signin);
		j.add(signup);
		mainlistener ml=new mainlistener();
		signin.addActionListener(ml);
		signup.addActionListener(ml);
		signin.setBounds(550,0,150,65);
		signup.setBounds(700,0,150,65);
		j.setVisible(true);
	}
}

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
		Font f1 = new Font("SansSerif", Font.ITALIC, 40);
		Font f2 = new Font("SansSerif", Font.ITALIC, 20);
		jf.setContentPane(new JLabel(new ImageIcon("icon.png")));
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

class signin
{
	static JFrame jf1;
	static JLabel l1=new JLabel("Username : ");
	static JLabel l2=new JLabel("Password : ");
	static JTextField user=new JTextField(40);
	static JPasswordField password=new JPasswordField(40);
	static JButton login=new JButton("Log In");
	static JButton backbtn=new JButton("Back");

	signin()
	{
		jf1=new JFrame("Login");
		jf1.setSize(850,520);
		jf1.setLocationRelativeTo(null);
		jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf1.setContentPane(new JLabel(new ImageIcon("icon.png")));
		jf1.setLayout(null);
		Font f1 = new Font("SansSerif", Font.ITALIC, 40);
		Font f2 = new Font("SansSerif", Font.ITALIC, 20);
		jf1.add(backbtn);
		backbtn.setBounds(20,20,80,20);

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
		login.setBounds(340,250,150,30);
		jf1.setVisible(true);
	}
}
class profile
{
	static JLabel l1=new JLabel("WELCOME TO HOME PAGE");
	static JFrame jp;
	static JButton bookp;
	static JButton historyp;
	static JButton backbtn=new JButton("Back");

	profile()
	{	
		jp=new JFrame("Welcome Page");
		jp.setSize(850,520);
		jp.setLocationRelativeTo(null);
		jp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jp.setContentPane(new JLabel(new ImageIcon("627037.jpg")));
		jp.setLayout(null);
		Font f1 = new Font("SansSerif", Font.ITALIC, 30);
		bookp = new JButton("Book a New Cab");
		jp.add(backbtn);
		backbtn.setBounds(20,20,80,20);

		historyp = new JButton("To Check History");
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

class cabrent
{
	static JFrame jf2;
	static JLabel l1=new JLabel("BOOK CAB FOR SURE....!!!!!");
	static JLabel source=new JLabel("City Name : ");
	static JLabel cabtype=new JLabel("Cab Type : ");
	static JLabel picaddress =new JLabel("Picking Address : ");
	static JLabel date=new JLabel("Date : ");
	static JLabel time=new JLabel("Time : ");
	static JLabel passenger=new JLabel("Passengers : ");
	static JTextField sourcetxt=new JTextField(30);
	static JTextField cabtypetxt=new JTextField(30);
	static JTextField datetxt=new JTextField("dd/mm/yyyy",10);
	static JTextField timetxt=new JTextField("hh/mm",10);
	static JTextField picaddresstxt=new JTextField(30);
	static JTextField passengertxt=new JTextField(30);
	static JButton book=new JButton("Book");
	static JButton backbtn=new JButton("Back");

	cabrent()
	{
		jf2=new JFrame("Book");
		jf2.setSize(850,520);
		jf2.setLocationRelativeTo(null);
		jf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf2.setContentPane(new JLabel(new ImageIcon("icon.png")));
		jf2.setLayout(null);
		Font f1 = new Font("SansSerif", Font.ITALIC, 40);
		Font f2 = new Font("SansSerif", Font.ITALIC, 30);
		Font f3 = new Font("SansSerif", Font.ITALIC, 35);
		jf2.add(backbtn);
		backbtn.setBounds(20,20,80,20);

		l1.setFont(f1);
		source.setFont(f1);
		cabtype.setFont(f1);
		picaddress.setFont(f3);
		sourcetxt.setFont(f1);
		cabtypetxt.setFont(f1);
		picaddresstxt.setFont(f1);
		date.setFont(f1);
		datetxt.setFont(f2);
		time.setFont(f1);
		timetxt.setFont(f2);
		passenger.setFont(f1);
		passengertxt.setFont(f1);
		book.setFont(f1);

		mainlistener cl=new mainlistener();
		backbtn.addActionListener(cl);
		jf2.add(l1);
		jf2.add(source);
		jf2.add(cabtype);
		jf2.add(picaddress);
		jf2.add(sourcetxt);
		jf2.add(cabtypetxt);	
		jf2.add(datetxt);
		jf2.add(timetxt);
		jf2.add(picaddresstxt);
		jf2.add(date);
		jf2.add(time);
		jf2.add(passenger);
		jf2.add(passengertxt);
		jf2.add(book);
		
		mainlistener m=new mainlistener();
		book.addActionListener(m);
		
		l1.setBounds(120,20,500,70);
		source.setBounds(40,100,300,40);
		cabtype.setBounds(40,150,300,40);
		picaddress.setBounds(40,200,300,40);
		date.setBounds(40,250,300,40);
		time.setBounds(40,300,300,40);
		passenger.setBounds(40,350,300,40);
		
		sourcetxt.setBounds(340,100,280,40);
		cabtypetxt.setBounds(340,150,280,40);
		picaddresstxt.setBounds(340,200,280,40);
		datetxt.setBounds(340,250,280,40);
		timetxt.setBounds(340,300,280,40);
		passengertxt.setBounds(340,350,280,40);
	
		book.setBounds(280,400,200,50);
	
		jf2.setVisible(true);	
	}
}

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
		jh.setContentPane(new JLabel(new ImageIcon("icon.png")));
		jh.setLayout(null);
		jh.add(bookingnumber);
		jh.add(print);
		mainlistener cb=new mainlistener();
		backbtn.addActionListener(cb);
		print.addActionListener(cb);
		JLabel l1=new JLabel("Please Enter Your Unique Booking Number");
		Font f1 = new Font("SansSerif", Font.BOLD, 20);
		Font f2 = new Font("SansSerif", Font.BOLD, 40);
		l1.setFont(f1);
		bookingnumber.setFont(f2);
		jh.add(backbtn);
		jh.add(l1);
		backbtn.setBounds(20,20,80,20);
		l1.setBounds(240,50,500,80);
		bookingnumber.setBounds(330,120,180,50);
		print.setBounds(350,200,140,20);
		jh.setVisible(true);
	}
}
