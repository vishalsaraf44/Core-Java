package pages;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class cabrent
{
	static JFrame jf2;
	static JLabel l1=new JLabel("BOOK CAB FOR SURE....!!!!!");
	static JLabel cabtype=new JLabel("Cab Type : ");
	static JLabel picaddress =new JLabel("Source Address : ");
	static JLabel desaddress=new JLabel("Destination Address : ");
	static JLabel date=new JLabel("Date : ");
	static JLabel time=new JLabel("Time : ");
	static JLabel passenger=new JLabel("Passengers : ");
	
	static String[] types = {"Mini", "Micro", "Prime"};
	static JComboBox<String> cabtypetxt=new JComboBox<String>(types);
	static JTextField datetxt=new JTextField("dd/mm/yyyy",10);
	static JTextField timetxt=new JTextField("hh/mm",10);
	static JTextField picaddresstxt=new JTextField(30);
	static JTextField desaddresstxt=new JTextField(30);
	static JTextField passengertxt=new JTextField(30);
	static JButton book=new JButton("Book");
	static JButton backbtn=new JButton("Back");

	cabrent()
	{
		jf2=new JFrame("Book Your Cab");
		jf2.setSize(850,520);
		jf2.setLocationRelativeTo(null);
		jf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf2.setContentPane(new JLabel(new ImageIcon(System.getProperty("user.dir")+"/src/resouce/login.jpg")));
		jf2.setLayout(null);
		Font f1 = new Font("SansSerif", Font.ITALIC, 40);
		Font f2 = new Font("SansSerif", Font.ITALIC, 30);
		Font f3 = new Font("SansSerif", Font.ITALIC, 35);
		jf2.add(backbtn);
		backbtn.setBounds(20,20,80,20);
		jf2.setBackground(Color.WHITE);
		l1.setFont(f1);
		cabtype.setFont(f2);
		picaddress.setFont(f2);
		desaddress.setFont(f2);
		cabtypetxt.setFont(f1);
		cabtypetxt.setBackground(Color.white);
		picaddresstxt.setFont(f1);
		desaddresstxt.setFont(f1);
		date.setFont(f2);
		datetxt.setFont(f2);
		time.setFont(f2);
		timetxt.setFont(f2);
		passenger.setFont(f2);
		passengertxt.setFont(f1);
		book.setFont(f1);

		mainlistener cl=new mainlistener();
		backbtn.addActionListener(cl);
		jf2.add(l1);
		jf2.add(cabtype);
		jf2.add(picaddress);
		jf2.add(desaddress);
		jf2.add(cabtypetxt);	
		jf2.add(datetxt);
		jf2.add(timetxt);
		jf2.add(picaddresstxt);
		jf2.add(desaddresstxt);
		jf2.add(date);
		jf2.add(time);
		jf2.add(passenger);
		jf2.add(passengertxt);
		jf2.add(book);
		
		mainlistener m=new mainlistener();
		book.addActionListener(m);
		
		l1.setBounds(120,20,500,70);
		cabtype.setBounds(40,100,300,40);
		picaddress.setBounds(40,150,300,40);
		desaddress.setBounds(40,200,300,40);
		date.setBounds(40,250,300,40);
		time.setBounds(40,300,300,40);
		passenger.setBounds(40,350,300,40);
		
		cabtypetxt.setBounds(340,100,280,40);
		picaddresstxt.setBounds(340,150,280,40);
		desaddresstxt.setBounds(340,200,280,40);
		datetxt.setBounds(340,250,280,40);
		timetxt.setBounds(340,300,280,40);
		passengertxt.setBounds(340,350,280,40);
	
		book.setBounds(280,400,200,50);
	
		jf2.setVisible(true);	
	}
}