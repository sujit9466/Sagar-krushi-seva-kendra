import java.awt.*;
import java.awt.event.*;
import java.awt.event.ItemListener;
import java.sql.*;
import javax.swing.*;
import java.util.*;

class CustDemo extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6;
  	JTextField t1,t2,t4;
	JTextArea t3;
  	JButton b1,b2,b3,b4,b5,b6;
	JComboBox cb1;
	
	Connection cn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
  
	CustDemo()
    	{
      		
		setSize(700,650);
		setLocation(325,35);
		setLayout(null);
		
		JLabel ll=new JLabel(new ImageIcon("agroi.png"));
         	ll.setBounds(-270,-90,1366,800);
		
		
             		
		l1=new JLabel("CUSTOMER DETAIL'S");
      		l2=new JLabel("Custemer ID");
      		l3=new JLabel("Custemer Name");
		l4=new JLabel("Adeeress");
		l5=new JLabel("Contact No");
		l6=new JLabel("Type of Cust");
		
		
		t1=new JTextField(20);
      		t2=new JTextField(20);
    		t3=new JTextArea();
		t4=new JTextField(20);
		
		
	        cb1=new JComboBox();
	        cb1.addItem("click here");
                cb1.addItem("Regular");
		cb1.addItem("NonRegular");
               
               
               
		b1=new JButton("ADD");
      		b2=new JButton("SAVE");
      		b3=new JButton("EDIT");
      		b4=new JButton("SEARCH");
		b5=new JButton("EXIT");
		
		
		
		l1.setBounds(200, 30, 320, 28);
		l1.setFont(new Font("Times New Roman", 1, 24));
    		l1.setForeground(new Color(255,0,0));

		l2.setBounds(35,120,150,20);
       		l2.setFont(new Font("Times New Roman", 0, 14));
        	l2.setForeground(new Color(0, 0, 102));
       		t1.setBounds(200,120,100,20);
		t1.setFont(new Font("Times New Roman", 0, 14));
        	t1.setForeground(new Color(0, 0, 102));		

		l3.setBounds(35,160,150,20);
		l3.setFont(new Font("Times New Roman", 0, 14));
        	l3.setForeground(new Color(0, 0, 102));
       		t2.setBounds(200,160,250,20);
		t2.setFont(new Font("Times New Roman", 0, 14));
        	t2.setForeground(new Color(0, 0, 102));
		
		l4.setBounds(35,200,150,20);
		l4.setFont(new Font("Times New Roman", 0, 14));
        	l4.setForeground(new Color(0, 0, 102));
       		t3.setBounds(200,200,250,60);
		t3.setFont(new Font("Times New Roman", 0, 14));
        	t3.setForeground(new Color(0, 0, 102));
		
		l5.setBounds(35,280,150,20);
		l5.setFont(new Font("Times New Roman", 0, 14));
        	l5.setForeground(new Color(0, 0, 102));
       		t4.setBounds(200,280,150,20);
		t4.setFont(new Font("Times New Roman", 0, 14));
        	t4.setForeground(new Color(0, 0, 102));	
	
       		l6.setBounds(35,320,150,20);
		l6.setFont(new Font("Times New Roman", 0, 14));
        	l6.setForeground(new Color(0, 0, 102));
       		cb1.setBounds(200,320,150,20);
		cb1.setFont(new Font("Times New Roman", 0, 14));
        	cb1.setForeground(new Color(0, 0, 102));			

		
		b1.setBounds(35,470,100,25);
		b1.setForeground(new Color(0, 0, 102));		

		b2.setBounds(150,470,100,25);
		b2.setForeground(new Color(0, 0, 102));
		
		b3.setBounds(275,470,100,25);
		b3.setForeground(new Color(0, 0, 102));		

		b4.setBounds(400,470,100,25);
		b4.setForeground(new Color(0, 0, 102));
		
		b5.setBounds(520,470,100,25);
		b5.setForeground(new Color(0, 0, 102));
		
		add(l1);add(l2);add(l3);add(l4);add(l5);add(l6);
		add(t1);add(t2);add(t3);add(t4);
	      	

		add(b1);add(b2);
		add(b3);add(b4);add(b5);
	      	
		
      		add(cb1); 
	add(ll);


		try
			{
			Class.forName("com.mysql.cj.jdbc.Driver");
				cn=DriverManager.getConnection("Jdbc:mysql://localhost:3306/fertilizer","root","1234");
                                pst=cn.prepareStatement("select * from  Customer");
            			rs=pst.executeQuery();
                                while(rs.next())
                                {
                                      
               				 	t1.setText(""+rs.getString(1));
                				t2.setText(rs.getString(2));
               				 	t3.setText(rs.getString(3));
						t4.setText(rs.getString(4));
						cb1.setSelectedItem(""+rs.getString(5));
						
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
		
		
			
		
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
 		
		
    	}
	  
    	
	public static void main(String ddd[])
	{	
		new CustDemo();
    	}

         public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
         	 {
              		int no=Integer.parseInt(t1.getText());
              		no++;
             		t1.setText(""+no);
             		t2.setText("");
             	 	t3.setText("");
			
              		t4.setText("");
			String nn="+91";
			t4.setText(nn);
              		
                }

		if(e.getSource()==b2)
		{
			try
			{
				
				pst=cn.prepareStatement("insert into Customer values(?,?,?,?,?)");
				pst.setInt(1,Integer.parseInt(t1.getText()));
				pst.setString(2,t2.getText());
				pst.setString(3,t3.getText());
				pst.setString(4,t4.getText());
				pst.setString(5,cb1.getSelectedItem().toString());
				
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null,"Record Inserted Successfully......");
					
			}
			catch(Exception ae)
			{
				JOptionPane.showMessageDialog(null,"Error="+ae);
			}
		}

		if(e.getSource()==b3)
		{
			int option;
			option=JOptionPane.showConfirmDialog(null,"Do You Really Want To Edit The Record!!!","ok",JOptionPane.YES_NO_OPTION);
			if(option==JOptionPane.YES_OPTION)
			{
				try
            			{
             				pst=cn.prepareStatement("update  Customer set   Cust_name=?,Cust_addr=?,Cust_mno=?,Cust_type=?   where Cust_id=?");
               			
					pst.setString(1,t2.getText());
					pst.setString(2,t3.getText());	
					pst.setString(3,t4.getText());
					pst.setString(4,cb1.getSelectedItem().toString());
					pst.setInt(5,Integer.parseInt(t1.getText()));
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Record Updated Successfully......");
					
				}
				catch(Exception ae)
				{
					JOptionPane.showMessageDialog(null,"Error="+ae);
				}
			}
		}

		if(e.getSource()==b4)
        	{
        
     			    try	
		          	{
         				 int num=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the cust id to display info....."));
					 pst=cn.prepareStatement("select * from  Customer  where Cust_id="+num);
           				 rs=pst.executeQuery();
            				 if(rs.next())
            				{
               				 	t1.setText(""+rs.getInt(1));
                				t2.setText(rs.getString(2));
               				 	t3.setText(rs.getString(3));
               				 	t4.setText(rs.getString(4));
						cb1.setSelectedItem(""+rs.getString(5));
						
             				}
            		 		else
            				{
               					 JOptionPane.showMessageDialog(null,"Record not found...");
             				}
         					rs.close();
				}
                       		 catch(Exception ae)
                      		 {
                           		 JOptionPane.showMessageDialog(null,"Error in connn="+ae);
                      		 }
		}
		if(e.getSource()==b5)
		{
			
			
			setVisible(false);
			
		}		

	}
}			