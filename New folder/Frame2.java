
import java.awt.print.*;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class PbillDemo extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
	List li1,li2,li3,li4,li5,li6,li7,li8;
	JComboBox cb1,cb2;
	JButton b1,b2,b3,b4,b5;	
	
        java.util.Date d=new java.util.Date();
	Connection cn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;

	void Demo()
	{
		setSize(720,700);
		setLocation(250,10);
		setTitle("Purches Demo...........");
			
		setLayout(null);
				
		l1=new JLabel("PURCHES BILL");
		l2=new JLabel("Purches Id");
		l3=new JLabel("Date");
		l4=new JLabel("company/Supplier");
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
		cb1.addItem("RCF");
		cb2.addItem("Uria");


		b1=new JButton("ADD");
		b2=new JButton("SAVE");
		b3=new JButton("PRINT");
		b4=new JButton("EXIT");
		b5=new JButton("BACK");

		l1.setBounds(270,0,200,70);
		l1.setFont(new Font("Times New Roman", 1, 24));
    		l1.setForeground(new Color(255,0,0));
	        l2.setBounds(35,75,150,20);

		t1.setBounds(150,75,150,20);
		l3.setBounds(360,75,150,20);
		t2.setBounds(400,75,150,20);
		l4.setBounds(35,105,150,20);
		cb1.setBounds(150,105,150,20);
		l5.setBounds(35,150,150,20);
		t3.setBounds(35,180,70,20);
		l6.setBounds(135,150,150,20);
		cb2.setBounds(120,180,150,20);
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
		
		li1.setBounds(35,230,70,250);
		li2.setBounds(120,230,150,250);
		li3.setBounds(280,230,70,250);
		li4.setBounds(360,230,70,250);
		li5.setBounds(440,230,70,250);	
		li6.setBounds(520,230,70,250);			
		li7.setBounds(600,230,70,250);
		
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
		
		add(l1);add(l2);add(l3);add(l4);add(l5);add(l6);add(l7);add(l8);add(l9);add(l10);add(l11);add(l12);add(l13);
		add(t1);add(t2);add(t3);add(t4);add(t5);add(t6);add(t7);add(t8);add(t9);add(t10);
		add(cb1);add(cb2);
		add(li1);add(li2);add(li3);add(li4);add(li5);add(li6);add(li7);add(l14);add(t11);
		add(b1);add(b2);add(b3);add(b4);add(b5);
		
		setBackground(Color.cyan);
		
		li1.setBackground(Color.cyan);add(li1);
		
			
                       
                         int s=+d.getDay()+24;
		         int s2=+d.getMonth()+1;
		         int s3=+d.getYear()+1900;
		         String s4=""+s+"/"+s2+"/"+s3;
                         t2.setText(s4);
                       try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				cn=DriverManager.getConnection("Jdbc:mysql://localhost:3306/fertilizer","root","1234");
                                pst=cn.prepareStatement("select * from product");
                                rs=pst.executeQuery();
                                while(rs.next())
                                {
				   t1.setText(""+rs.getString(1));
                                   cb2.addItem(""+rs.getString(2));
                                   cb1.addItem(""+rs.getString(5));
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
		
		t8.setEditable(false);
		t9.setEditable(false);
		t10.setEditable(false);
		t11.setEditable(false);

		
		



		setVisible(true);	
	}
	public static void  main(String args[])
	{

		new 	PbillDemo();
	}
	public void actionPerformed(ActionEvent e)
	{
		int sum=0;
		if(e.getSource()==b1)
		{
			
			li1.add(t3.getText());
			li2.add(cb2.getSelectedItem().toString());
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
			//t9.setText("");
             	 	//t10.setText("");
              		//t11.setText("");


          		
		}

		if(e.getSource()==b2)
		{
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				cn=DriverManager.getConnection("Jdbc:mysql://localhost:3306/fertilizer","root","1234");
				
				pst=cn.prepareStatement("insert into purches values(?,?,?,?,?,?,?,?,?,?,?,?)");
				
				pst.setString(1,t1.getText());
				pst.setString(2,t2.getText());
				pst.setString(3,cb1.getSelectedItem().toString());
				pst.setInt(4,Integer.parseInt(t3.getText()));
				pst.setString(5,cb2.getSelectedItem().toString());
				pst.setInt(6,Integer.parseInt(t4.getText()));
				pst.setInt(7,Integer.parseInt(t5.getText()));
				pst.setString(8,t6.getText());
				pst.setString(9,t7.getText());
				pst.setInt(10,Integer.parseInt(t9.getText()));
				pst.setInt(11,Integer.parseInt(t10.getText()));
				pst.setInt(12,Integer.parseInt(t11.getText()));
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null,"Record Inserted Successfully......");
					
			}
			catch(Exception ae)
			{
				JOptionPane.showMessageDialog(null,"Error="+ae);
			}			

		}

		if(e.getSource()==b4)
		{
			
			KskDemo aa=new KskDemo();
			setVisible(false);
		}

		if(e.getSource()==b5)
		{
			setVisible(false);
			ProdDemo p=new ProdDemo();
		}
		
		if(e.getSource()==b3)
		{
			PrinterJob pj=PrinterJob.getPrinterJob();
			pj.printDialog();
		}
	
	}
}