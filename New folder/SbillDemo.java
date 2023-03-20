import java.awt.event.ItemListener;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class SbillDemo extends JFrame implements ActionListener//,ItemListener
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14;
	List li1,li2,li3,li4,li5,li6,li7,li8;
	JComboBox cb1,cb2;
	JButton b1,b2,b3,b4,b5;	
	
        java.util.Date d=new java.util.Date();
	Connection cn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;

	SbillDemo()
	{
		setSize(720,700);
		setLocation(250,10);
		setTitle("Sales Demo...........");
		JLabel ll=new JLabel(new ImageIcon("bag.jpg"));
         	ll.setBounds(-170,-75,1366,730);
			
		setLayout(null);
		
             		
		
		l1=new JLabel("SALES BILL");
		l2=new JLabel("Cust Id");
		l3=new JLabel("Date");
		l4=new JLabel("Customer");
		l5=new JLabel("Sr.No");
		l6=new JLabel("Product Name");
		l7=new JLabel("Quantity");
		l8=new JLabel("Rate");
		l9=new JLabel("Mfg.Date");
		l10=new JLabel("Expiry Date");
		l11=new JLabel("Total");
		l12=new JLabel("Total");
		l13=new JLabel("Discount");
		l14=new JLabel("Netpay");
		l15=new JLabel("Address");
		l16=new JLabel("Contact No");
		l17=new JLabel("Prod Type");
		

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
		t13=new JTextField(15);
		t14=new JTextField(15);			
				
		
		li1=new List();	
		li2=new List();	
		li3=new List();	
		li4=new List();	
		li5=new List();	
		li6=new List();	
		li7=new List();
		li8=new List();

		cb1=new JComboBox();
		cb2=new JComboBox();
		cb2.addItem("Click here");	
		cb2.addItem("Pest");
                cb2.addItem("fertilizers");          
                cb2.addItem("chemicals");       
                cb2.addItem("seeds");
                cb2.addItem("BioChemicals");
                cb2.addItem("Biofertilizers");
                cb2.addItem("Other");
		cb1.setEditable(true);
		
		
		b1=new JButton("ADD");
		b2=new JButton("SAVE");
		b3=new JButton("PRINT");
		b4=new JButton("SERACH");
		b5=new JButton("BACK");

		l1.setBounds(270,0,200,70);
		l1.setFont(new Font("Times New Roman", 1, 24));
    		l1.setForeground(new Color(255,0,0));
	        l2.setBounds(35,65,150,20);
		t1.setBounds(150,65,150,20);

		l3.setBounds(360,65,150,20);
		t2.setBounds(425,65,150,20);
		l4.setBounds(35,95,150,20);
		t12.setBounds(150,95,150,20);
		l15.setBounds(35,122,150,20);
		t13.setBounds(150,122,150,20);
		l16.setBounds(360,95,150,20);
		t14.setBounds(425,95,150,20);
		
		l17.setBounds(360,125,150,20);
		cb2.setBounds(425,125,150,20);

		l5.setBounds(35,150,150,20);
		t3.setBounds(35,180,70,20);
		l6.setBounds(135,150,150,20);
		cb1.setBounds(120,180,150,20);
		l7.setBounds(285,150,150,20);
		t4.setBounds(280,180,70,20);
		l8.setBounds(365,150,150,20);
		t5.setBounds(360,180,70,20);
		l9.setBounds(445,150,150,20);
		t6.setBounds(440,180,70,20);
		l10.setBounds(520,150,150,20);
		t7.setBounds(520,180,70,20);
		l11.setBounds(610,150,150,20);
		t8.setBounds(600,180,70,20);
		
		li1.setBounds(35,330,70,150);
		li2.setBounds(120,330,150,150);
		li3.setBounds(280,330,70,150);
		li4.setBounds(360,330,70,150);
		li5.setBounds(440,330,70,150);	
		li6.setBounds(520,330,70,150);			
		li7.setBounds(600,330,70,150);
		
		l12.setBounds(500,490,150,20);
		t9.setBounds(550,490,120,20);
		l13.setBounds(500,520,150,20);
		t10.setBounds(550,520,120,20);
		l14.setBounds(500,550,120,20);
		t11.setBounds(550,550,120,20);			

		b1.setBounds(35,580,120,30);
		b2.setBounds(162,580,120,30);
		b3.setBounds(292,580,120,30);
		b4.setBounds(420,580,120,30);
		b5.setBounds(550,580,120,30);
                
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
                                pst=cn.prepareStatement("select * from SalesBill");
                                rs=pst.executeQuery();
                                while(rs.next())
                                {
				t1.setText(""+rs.getString(1));
			        int no=Integer.parseInt(t1.getText());
             		        no++;
				t1.setText(""+no);
				
                                }
                                 rs.close();
				pst=cn.prepareStatement("select * from  customer");
            			rs=pst.executeQuery();
                                while(rs.next())
                                {
                                      
               				 	t12.setText(""+rs.getString(2));
						t13.setText(""+rs.getString(3));
						t14.setText(""+rs.getString(4));                		
		
                        	}
				rs.close();
				pst=cn.prepareStatement("select * from Product");
                                 rs=pst.executeQuery();
                                 while(rs.next())
                                {		  			
                                	cb1.addItem(""+rs.getString(2));
                                   
                                }
                                rs.close(); 
				
		}
		catch(Exception ae)
		{
			JOptionPane.showMessageDialog(null,"Error="+ae);
		}                                      
		


		add(l1);add(l2);add(l3);add(l4);add(l5);add(l6);add(l7);add(l8);add(l9);add(l10);add(l11);add(l12);add(l13);add(l14);add(l15);add(l16);add(l17);
		add(t1);add(t2);add(t3);add(t4);add(t5);add(t6);add(t7);add(t8);add(t9);add(t10);add(t12);add(t13);add(t14);
		add(cb1);add(cb2);
		add(li1);add(li2);add(li3);add(li4);add(li5);add(li6);add(li7);add(l14);add(t11);
		add(b1);add(b2);add(b3);add(b4);add(b5);add(ll);
		
		
		

		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);		
		b5.addActionListener(this);
		
		t8.setEditable(false);
		t9.setEditable(false);
		t10.setEditable(false);
		t11.setEditable(false);

		setVisible(true);	
	}
	public static void  main(String args[])
	{

		new SbillDemo();
	}
	
	 public void itemStateChanged(ItemEvent aa)

	{
 	 	String ss=cb1.getSelectedItem().toString();
		t1.setText(ss);	
	}	

	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b2)
		{
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				cn=DriverManager.getConnection("Jdbc:mysql://localhost:3306/fertilizer","root","1234");

			        for(int i=0;i<li1.getItemCount();i++)
                                {  
				
				pst=cn.prepareStatement("insert into SalesBill values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				pst.setInt(1,Integer.parseInt(t1.getText()));
				pst.setString(2,t2.getText());
				pst.setString(3,t12.getText());
				pst.setString(4,t14.getText());
				pst.setString(5,t13.getText());
				
						
				pst.setString(6,li1.getItem(i));
				pst.setString(7,li2.getItem(i));
				pst.setString(8,li3.getItem(i));
				pst.setString(9,li4.getItem(i));
				pst.setString(10,li5.getItem(i));
				pst.setString(11,li6.getItem(i));
				pst.setString(12,li7.getItem(i));
			
				pst.setInt(13,Integer.parseInt(t9.getText()));
				pst.setInt(14,Integer.parseInt(t10.getText()));
				pst.setInt(15,Integer.parseInt(t11.getText()));
				
				pst.executeUpdate();
			       }	
                                JOptionPane.showMessageDialog(null,"Record Inserted Successfully......");
					
			}
			catch(Exception ae)
			{
				JOptionPane.showMessageDialog(null,"Error="+ae);
			}			

		}
		
		if(e.getSource()==b1)
		{
			int sum=0;
			li1.add(t3.getText());
			li2.add(cb1.getSelectedItem().toString());
			li3.add(t4.getText());
			li4.add(t5.getText());
			li5.add(t6.getText());
			li6.add(t7.getText());
		
			t8.setText(""+Integer.parseInt(t4.getText())*Integer.parseInt(t5.getText()));
		
			li7.add(t8.getText());

			for(int i=0;i<li7.getItemCount();i++)
			{
				 sum=sum+(Integer.parseInt(li7.getItem(i)));
			}	
		
			t9.setText(""+sum);
			
			int dis=sum/10;
			t10.setText(""+dis);

			int netp=sum-dis;
			t11.setText(""+netp);

			int no=Integer.parseInt(t3.getText());
              		no++;
             		t3.setText(""+no);
			t4.setText("");
             		t5.setText("");
			t6.setText("");
             	 	t7.setText("");
              		t8.setText("");



		}
                if(e.getSource()==b4)
		{
//                	try{
//			int num=Integer.parseInt(JOptionPane.showInputDialog(null,"Plz Enter CUST  ID to serach Record"));
//			SbillReport pbr=new SbillReport(num);
//		}
//                	catch(Exception ae)
//        			{
//        				JOptionPane.showMessageDialog(null,"Error="+ae);
//                }
                	
                	
                	
                	   try	
   		          	{
            				int num=Integer.parseInt(JOptionPane.showInputDialog(null,"Plz Enter CUST  ID to serach Record"));
            				SbillReport pbr=new SbillReport(num);
   					 pst=cn.prepareStatement("select * from   Customer where Cust_id =" + num);
              				 rs=pst.executeQuery();
               				 if(rs.next())
               				{
                  				 
               					 
               					 
               					 
               					 t1.setText(""+rs.getInt(1));
                  				 	t12.setText(rs.getString(2));
   						t14.setText(rs.getString(4));
                  				 	t13.setText(rs.getString(3));
                  				 	
   						
   						
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
		if(e.getSource()==b3)
		{
			try {
			SbillReport sr=new SbillReport(Integer.parseInt(t1.getText()));
		   } 
			catch(Exception ae)
			{
				JOptionPane.showMessageDialog(null,"Error="+ae);
				
			}
		}
			
	}
		
}

