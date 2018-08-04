package pages;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;


public class main
{
	static JFrame j1;
	static JButton start;
	public static void main(String ar[]) throws Exception
	{
		j1=new JFrame("Cab Rental Service");
		j1.setSize(850,520);
		j1.setLocationRelativeTo(null);
		j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j1.setContentPane(new JLabel(new ImageIcon(System.getProperty("user.dir")+"/src/resouce/start.png")));
		j1.setLayout(null);
		start = new JButton();
		start.setContentAreaFilled(false);
		start.setBorderPainted(false);
		j1.add(start);
		mainlistener ml=new mainlistener();
		start.addActionListener(ml);
		//start.setBounds(350,450,150,30);
		start.setBounds(0,0,850,520);
		j1.setVisible(true);
		Thread.sleep(1000);
		start.doClick();
	}
}