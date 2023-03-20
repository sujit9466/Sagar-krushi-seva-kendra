
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class PorderDemo extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
	List li1,li2,li3,li4,li5,li6;
	JComboBox cb1,cb2;
	JButton b1,b2,b3,b4,b5;	
	
        java.util.Date d=new java.util.Date();
	Connection cn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	JFrame ff=new JFrame();
	
	PorderDemo()
	{
		setSize(720,700);
		setLocation(250,10);
		setTitle("Purches Demo...........");
		
		
		JLabel ll=new JLabel(new ImageIcon("sprey.jpg"));
         	ll.setBounds(-170,-75,1366,730);
			
		setLayout(null);
				
		l1=new JLabel("PURCHES ORDER DETAIL");
		l2=new JLabel("Order Id");
		l3=new JLabel("Order Date");
		l4=new JLabel("company/Supplier");
		l5=new JLabel("Sr.No");
		l6=new JLabel("Product Name");
		l7=new JLabel("Quantity");
		l8=new JLabel("Rate");
		l9=new JLabel("Lot No");
		
		l10=new JLabel("Due Date");
		l11=new JLabel("Company name");
		

		t1=new JTextField(15);
		t2=new JTextField(15);
		t3=new JTextField(15);
		t4=new JTextField(15);
		t5=new JTextField(15);
		t6=new JTextField(15);
		t7=new JTextField(15);
		t8=new JTextField(15);
		t9=new JTextField(15);
		t10=new JTextField(15);
		t11=new JTextField(15);
		t12=new JTextField(15);
		

	        li1=new List();	
		li2=new List();	
		li3=new List();	
		li4=new List();	
		li5=new List();	
		
		

		cb1=new JComboBox();
		cb2=new JComboBox();
		cb1.setEditable(true);	
		cb2.setEditable(true);


		b1=new JButton("ADD");
		b2=new JButton("SAVE");
		b3=new JButton("EDIT");
		b4=new JButton("CLEAR");
		b5=new JButton("EXIT");

		l1.setBounds(190,0,320,70);
		l1.setFont(new Font("Times New Roman", 1, 24));
    		l1.setForeground(new Color(255,0,0));
	        
		l2.setBounds(35,75,150,20);
		t1.setBounds(150,70,150,20);
		l3.setBounds(360,70,150,20);
		t2.setBounds(450,70,150,20);
		l10.setBounds(360,100,150,20);
		t11.setBounds(450,100,150,20);
		

		l4.setBounds(35,100,150,20);
		cb1.setBounds(150,100,150,20);
		l11.setBounds(35,130,150,20);
		t12.setBounds(150,130,150,20);
		

		l5.setBounds(35,150,150,20);
		t3.setBounds(35,180,70,20);
		l6.setBounds(155,150,150,20);
		cb2.setBounds(150,180,150,20);
		l7.setBounds(345,150,150,20);
		t4.setBounds(340,180,70,20);
		l8.setBounds(455,150,150,20);
		t5.setBounds(450,180,70,20);
		l9.setBounds(565,150,150,20);
		t6.setBounds(560,180,70,20);
		
		li1.setBounds(35,330,70,150);
		li2.setBounds(150,330,150,150);
		li3.setBounds(340,330,70,150);
		li4.setBounds(450,330,70,150);
		li5.setBounds(560,330,70,150);	
				
		
		
		
		b1.setBounds(35,580,120,30);
		b2.setBounds(162,580,120,30);
		b3.setBounds(292,580,120,30);
		b4.setBounds(420,580,120,30);
		b5.setBounds(550,580,120,30);
		
		add(l1);add(l2);add(l3);add(l4);add(l5);add(l6);add(l7);add(l8);add(l9);add(l10);add(l10);add(l11);
		add(t1);add(t2);add(t3);add(t4);add(t5);add(t6);add(t7);add(t8);add(t9);add(t10);add(t11);add(t12);
		add(cb1);add(cb2);
		add(li1);add(li2);add(li3);add(li4);add(li5);
		add(b1);add(b2);add(b3);add(b4);add(b5);add(ll);
		
		
		
			
                       
                int s=+d.getDay()+3;
                int s2=+d.getMonth()+1;
		int s3=+d.getYear()+1900;
		String s4=""+s+"/"+s2+"/"+s3;
                t2.setText(s4);
		
		int nu=1;	
	        t3.setText(""+nu);
                
		 try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection("Jdbc:mysql://localhost:3306/fertilizer","root","1234");
                       
			pst=cn.prepareStatement("select * from PurchesOrder");
                        rs=pst.executeQuery();
                        while(rs.next())
                        {
				t1.setText(""+rs.getString(1));
				
			        int no=Integer.parseInt(t1.getText());
             		        no++;
				t1.setText(""+no);
				
                        }
                         rs.close();
			pst=cn.prepareStatement("select * from Supplier");
                        rs=pst.executeQuery();
                        while(rs.next())
                        {		  			
                        	cb1.addItem(""+rs.getString(2));	
				t12.setText(rs.getString(6));
			
                        }
                        rs.close();
			
			pst=cn.prepareStatement("select * from Product");
                        rs=pst.executeQuery();
                        while(rs.next())
                        {		  			
                               cb2.addItem(""+rs.getString(2));
                                   
                        }
                        rs.close();
				
				
		}
		catch(Exception ae)
		{
			JOptionPane.showMessageDialog(null,"Error="+ae);
		}                                      
			
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);		
		b5.addActionListener(this);
		
		
		
	setVisible(true);	
	}
	public static void  main(String args[])
	{

		new PorderDemo();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			
			li1.add(t3.getText());
			li2.add(cb2.getSelectedItem().toString());
			li3.add(t4.getText());
			li4.add(t5.getText());
			li5.add(t6.getText());
			
			int no=Integer.parseInt(t3.getText());
              		no++;
             		t3.setText(""+no);
			t4.setText("");
             		t5.setText("");
			t6.setText("");
			
		}
	
		if(e.getSource()==b2)
		{
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				cn=DriverManager.getConnection("Jdbc:mysql://localhost:3306/fertilizer","root","1234");

			        for(int i=0;i<li1.getItemCount();i++)
                                {  
				
				pst=cn.prepareStatement("insert into PurchesOrder values(?,?,?,?,?,?,?,?,?,?)");
				pst.setString(1,t1.getText());
				pst.setString(2,cb1.getSelectedItem().toString());
				pst.setString(3,t12.getText());
				
				pst.setString(4,t2.getText());
				pst.setString(5,t11.getText());
				

				pst.setString(6,li1.getItem(i));
				pst.setString(7,li2.getItem(i));
				pst.setString(8,li3.getItem(i));
				pst.setString(9,li4.getItem(i));
				pst.setString(10,li5.getItem(i));
				
			
				
				pst.executeUpdate();
			       }	
                                JOptionPane.showMessageDialog(null,"Record Inserted Successfully......");
					
			}
			catch(Exception ae)
			{
				JOptionPane.showMessageDialog(null,"Error="+ae);
			}			

		}
		if(e.getSource()==b3)
		{
		 try
            			{
				 for(int i=0;i<li1.getItemCount();i++)
                                {  
             			pst=cn.prepareStatement("update  PurchesOrder set   Sup_name=?,Sup_comp=?,Ord_date=?,Due_date=?,Sr_no=?,Prod_name=?,Prod_Qua=?,Rate=?,lot_no   where Ord_id=?");
               			
				
				pst.setString(1,cb1.getSelectedItem().toString());
				pst.setString(2,t12.getText());
				
				pst.setString(3,t2.getText());
				pst.setString(4,t11.getText());
				

				pst.setString(5,li1.getItem(i));
				pst.setString(6,li2.getItem(i));
				pst.setString(7,li3.getItem(i));
				pst.setString(8,li4.getItem(i));
				pst.setString(9,li5.getItem(i));
				pst.setString(10,t1.getText());
				pst.executeUpdate();
				}	
				JOptionPane.showMessageDialog(null,"Record Updated Successfully......");
					
				}
				catch(Exception ae)
				{
					JOptionPane.showMessageDialog(null,"Error="+ae);
				}
		}
		if(e.getSource()==b4)
        	{	
		       
			
			t1.setText("");
				
        		t3.setText("");
			t4.setText("");
             		t5.setText("");
			t6.setText("");
			
				
		}
		if(e.getSource()==b5)
        	{	
		       
		setVisible(false);
		}

	}
}