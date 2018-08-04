package pages;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

class mainlistener implements ActionListener
{ 
	public void actionPerformed(ActionEvent e) 	
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cabbooking?useSSL=false","root","Vish123");	
			if(e.getSource()==main.start)
			{
				start st=new start();
				main.j1.setVisible(false);
			}
			else if(e.getSource()==signin.backbtn)
			{
				//start n=new start();
				signin.jf1.setVisible(false);
				start.j.setVisible(true);
			}
			else if(e.getSource()==signup.backbtn)
			{
				//start n=new start();
				signup.jf.setVisible(false);
				start.j.setVisible(true);
			}
			else if(e.getSource()==cabrent.backbtn)
			{
				//profile n=new profile();
				cabrent.jf2.setVisible(false);
				profile.jp.setVisible(true);
			}
			else if(e.getSource()==profile.backbtn)
			{
				//signin n=new signin();
				profile.jp.setVisible(false);
				signin.jf1.setVisible(true);
			}
			else if(e.getSource()==history.backbtn)
			{
				//profile n=new profile();
				history.jh.setVisible(false);
				profile.jp.setVisible(true);
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
				pst.setString(2,cabrent.cabtypetxt.getSelectedItem().toString());
				pst.setString(3,cabrent.datetxt.getText());
				pst.setString(4,cabrent.timetxt.getText());
				pst.setInt(5,Integer.parseInt(cabrent.passengertxt.getText()));
				pst.setString(6,cabrent.picaddresstxt.getText());
				pst.setString(7,cabrent.desaddresstxt.getText());
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
					String PickupSource=null;
					String DropAddress=null;
					String Date=null;
					String Time=null;	
					String cab=null;
					PreparedStatement ps=con.prepareStatement("Select PickupAddress, CabType, DropAddress, Date, Time from data where BookingId=?");	
					ps.setLong(1,Long.parseLong(history.bookingnumber.getText()));
					ResultSet rs=ps.executeQuery();
					while(rs.next())
					{
						PickupSource=rs.getString(1);
						cab=rs.getString(2);
						DropAddress=rs.getString(3);
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
					JOptionPane.showMessageDialog(history.jh, "Source : "+PickupSource+ "\nDestination : "+DropAddress+"\nAt : "+Time+ "\nOn : "+Date+"\nThank you for booking a cab");
				}
			}
		}
		catch(Exception p)
		{
			System.out.println("\n"+p);
		}	
	}
}