import java.awt.*;
import java.awt.event.*;
import java.awt.event.ItemListener;
import java.sql.*;
import javax.swing.*;
import java.util.*;

public class SuppDemo extends JFrame implements ActionListener//,ItemListener
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
  	JTextField t1,t2,t4,t5;
	JTextArea t3;
  	JButton b1,b2,b3,b4,b5;
	JComboBox cb1,cb2;
	
	Connection cn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
  
	SuppDemo()
    	{
      		
		setSize(700,650);
		setLocation(325,35);
		setLayout(null);
		JLabel ll=new JLabel(new ImageIcon("agro1.png"));
         	ll.setBounds(-270,-85,1366,730);		
		           		
		l1=new JLabel("SUPPLIER_DETAILS");
      		l2=new JLabel("Supplier_ID");
      		l3=new JLabel("Supplier_Name");
		l4=new JLabel("Adeeress");
		l5=new JLabel("Contact_No");
		l6=new JLabel("Email_ID");
     		l7=new JLabel("Company");
		l8=new JLabel("Type_of_Prod");
		
		
		t1=new JTextField(20);
      		t2=new JTextField(20);
    		t3=new JTextArea();
		t4=new JTextField(20);
		t5=new JTextField(20);
		
		
	        cb1=new JComboBox();
	        cb1.addItem("click here");
                cb1.addItem("Rallis India LTD");          
                cb1.addItem("D-Agro India LTD");       
              	cb1.addItem("RCF India LTD");
		cb2=new JComboBox(); 
		cb2.addItem("click here");
		cb2.addItem("Pest");
                cb2.addItem("fertilizers");          
                cb2.addItem("chemicals");       
                cb2.addItem("seeds");
                cb2.addItem("BioChemicals");
                cb2.addItem("Biofertilizers");
                cb2.addItem("Other");     
               
		b1=new JButton("ADD");
      		b2=new JButton("SAVE");
      		b3=new JButton("EDIT");
      		b4=new JButton("SEARCH");
		b5=new JButton("EXIT");
		
		
		l1.setBounds(200, 30, 320, 28);
		l1.setFont(new Font("Times New Roman", 1, 24));
    		l1.setForeground(new Color(255,0,0));

		l2.setBounds(35,100,150,20);
       		l2.setFont(new Font("Times New Roman", 0, 14));
        	l2.setForeground(new Color(0, 0, 102));
       		t1.setBounds(200,100,100,20);
		t1.setFont(new Font("Times New Roman", 0, 14));
        	t1.setForeground(new Color(0, 0, 102));		

		l3.setBounds(35,140,150,20);
		l3.setFont(new Font("Times New Roman", 0, 14));
        	l3.setForeground(new Color(0, 0, 102));
       		t2.setBounds(200,140,250,20);
		t2.setFont(new Font("Times New Roman", 0, 14));
        	t2.setForeground(new Color(0, 0, 102));
		
		l4.setBounds(35,180,150,20);
		l4.setFont(new Font("Times New Roman", 0, 14));
        	l4.setForeground(new Color(0, 0, 102));
       		t3.setBounds(200,180,250,60);
		t3.setFont(new Font("Times New Roman", 0, 14));
        	t3.setForeground(new Color(0, 0, 102));
		
		l5.setBounds(35,260,150,20);
		l5.setFont(new Font("Times New Roman", 0, 14));
        	l5.setForeground(new Color(0, 0, 102));
       		t4.setBounds(200,260,150,20);
		t4.setFont(new Font("Times New Roman", 0, 14));
        	t4.setForeground(new Color(0, 0, 102));	
	
       		l6.setBounds(35,300,150,20);
		l6.setFont(new Font("Times New Roman", 0, 14));
        	l6.setForeground(new Color(0, 0, 102));
       		t5.setBounds(200,300,150,20);
		t5.setFont(new Font("Times New Roman", 0, 14));
        	t5.setForeground(new Color(0, 0, 102));			

		l7.setBounds(35,340,150,20);
		l7.setFont(new Font("Times New Roman", 0, 14));
        	l7.setForeground(new Color(0, 0, 102));
       		cb1.setBounds(200,340,150,20);
		cb1.setFont(new Font("Times New Roman", 0, 14));
        	cb1.setForeground(new Color(0, 0, 102));	

		l8.setBounds(35,380,150,20);
		l8.setFont(new Font("Times New Roman", 0, 14));
        	l8.setForeground(new Color(0, 0, 102));
       		cb2.setBounds(200,380,150,20);
		cb2.setFont(new Font("Times New Roman", 0, 14));
        	cb2.setForeground(new Color(0, 0, 102));		

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
		
		
		add(l1);add(l2);add(l3);add(l4);add(l5);add(l6);add(l7);add(l8);
		add(t1);add(t2);add(t3);add(t4);add(t5);

		add(b1);add(b2);
		add(b3);add(b4);add(b5);
	      	
		
      		add(cb1);add(cb2);add(ll);
		
		  try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				cn=DriverManager.getConnection("Jdbc:mysql://localhost:3306/fertilizer","root","1234");
				pst=cn.prepareStatement("select * from  Supplier");
            			rs=pst.executeQuery();
                                while(rs.next())
                                {
                                      
               				 	t1.setText(""+rs.getString(1));
                				t2.setText(rs.getString(2));
               				 	t3.setText(rs.getString(3));
						t4.setText(rs.getString(4));
						t5.setText(rs.getString(5));
						cb1.setSelectedItem(""+rs.getString(6));
						cb2.setSelectedItem(""+rs.getString(7));
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
		new SuppDemo();
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
			t5.setText("");
			String sa="+91";
			t4.setText(sa);
              		
                }
		if(e.getSource()==b2)
		{
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				cn=DriverManager.getConnection("Jdbc:mysql://localhost:3306/fertilizer","root","1234");
				
				pst=cn.prepareStatement("insert into Supplier values(?,?,?,?,?,?,?)");
				
				pst.setInt(1,Integer.parseInt(t1.getText()));
				pst.setString(2,t2.getText());
				pst.setString(3,t3.getText());
				pst.setString(4,t4.getText());
				pst.setString(5,t5.getText());
				pst.setString(6,cb1.getSelectedItem().toString());
				pst.setString(7,cb2.getSelectedItem().toString());
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null,"Record Inserted Successfully");
					
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
                        	        pst=cn.prepareStatement("update  Supplier set   Supp_name=?,Supp_addr=?,Supp_mno=?,Supp_eid=?,Supp_comp=?,Supp_type_pro=?   where Supp_id=?");
               			
					pst.setString(1,t2.getText());
					pst.setString(2,t3.getText());
					pst.setString(3,t4.getText());
					pst.setString(4,t5.getText());
					pst.setString(5,cb1.getSelectedItem().toString());
					pst.setString(6,cb2.getSelectedItem().toString());
					pst.setInt(7,Integer.parseInt(t1.getText()));
					
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
         				int num=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the Supplier id to display info....."));
					 pst=cn.prepareStatement("select * from  Supplier  where Supp_id="+num);
           				 rs=pst.executeQuery();
            				 if(rs.next())
            				{
               				 	t1.setText(""+rs.getInt(1));
                				t2.setText(rs.getString(2));
               				 	t3.setText(rs.getString(3));
               				 	t4.setText(rs.getString(4));
               				 	t5.setText(rs.getString(5));
						cb1.setSelectedItem(""+rs.getString(6));
						cb2.setSelectedItem(""+rs.getString(7));
               				 	
						//cb1.(rs.getString(5),0);
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