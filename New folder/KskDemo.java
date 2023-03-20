import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

class KskDemo extends JFrame implements ActionListener 
{
	JMenuBar jmb;
	JMenu jm1,jm2,jm3,jm4,jm5;
	JMenuItem i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12,i13,i14;
	
	KskDemo()
	{
		setSize(1366,730);
		//setLocation(325,0);
		setLayout(null);
		
		
		jmb=new JMenuBar();
		
		jm1=new JMenu("Master Data         ");
		jm2=new JMenu("Transaction Data        ");
		jm3=new JMenu("Report Data          ");
		jm4=new JMenu("Utility              ");
		jm5=new JMenu("Exit");
		ImageIcon ll=new ImageIcon("sagar.jpg ");
		Image img= ll.getImage();
		Image temp_img=img.getScaledInstance(1366, 730, Image.SCALE_SMOOTH);
		ll= new ImageIcon(temp_img);
		JLabel background= new JLabel("", ll,JLabel.CENTER);
	    background.setBounds(0,40,1366,700);
        //background.add(login);
     	add(background);
     	
     	
//		JLabel ll=new JLabel(new ImageIcon("sagar.jpg "));
//         	ll.setBounds(0,0,1366,730);
//	add(ll);

		i1=new JMenuItem("Company");
		i2=new JMenuItem("Product");
		i3=new JMenuItem("Customer");
		i4=new JMenuItem("Purches Bill");
		i5=new JMenuItem("sales Bill");
		i6=new JMenuItem("Cust Details Report");
		i7=new JMenuItem("Supplie Details Report");
		i8=new JMenuItem("Product Details Report");
		i13=new JMenuItem("Order Detail Report");
		
		i9=new JMenuItem("Purches Detail Report");
		i10=new JMenuItem("Sales Order Report");
		i11=new JMenuItem("Calculator");
		i12=new JMenuItem("Quit");
		i14=new JMenuItem("Purches Order");
		
		
		jmb.add(jm1);
				
			jm1.add(i1);
			jm1.add(i2);
			jm1.add(i3);
			jm1.add(i14);
		
		jmb.add(jm2);
			jm2.add(i4);
			jm2.add(i5);
		jmb.add(jm3);
			jm3.add(i6);
			jm3.add(i7);
			jm3.add(i8);
			jm3.add(i13);
			jm3.add(i9);
			jm3.add(i10);
			
		jmb.add(jm4);
			jm4.add(i11);
		jmb.add(jm5);
			jm5.add(i12);
			
		jmb.setBounds(0,0,1366,40);
		add(jmb);
		
	
		
		
		
		
		i1.addActionListener(this);
		i2.addActionListener(this);
		i3.addActionListener(this);
		i4.addActionListener(this);
		i5.addActionListener(this);
		i6.addActionListener(this);
		i7.addActionListener(this);
		i8.addActionListener(this);
		i9.addActionListener(this);
		i10.addActionListener(this);
		i11.addActionListener(this);
		i12.addActionListener(this);
		i13.addActionListener(this);
		i14.addActionListener(this);
		
		setVisible(true);
	
	}
		
	public static void main(String arg[])
	{
			new KskDemo();
	}
		
	

        public void actionPerformed(ActionEvent e)
        {
    	        if(e.getSource()==i1)
		{
			SuppDemo sd=new SuppDemo();
			

		}
		if(e.getSource()==i2)
		{
			ProdDemo pd=new ProdDemo();
			

		}
		if(e.getSource()==i3)
		{
			CustDemo cd =new CustDemo();
			
		}
		if(e.getSource()==i14)
		{
			PorderDemo cd =new PorderDemo();
			
		}
		if(e.getSource()==i4)
		{
			PbillDemo1 pbd=new PbillDemo1();
		

		}
		if(e.getSource()==i5)
		{
			SbillDemo sbd=new SbillDemo();
		

		}
		if(e.getSource()==i6)
		{
			CustReport cr=new CustReport();
			

		}
		if(e.getSource()==i7)
		{
			SuppReport sr=new SuppReport();
			

		}
		if(e.getSource()==i8)
		{
			ProdReport pr=new ProdReport();
			

		}
		if(e.getSource()==i13)
		{
			OrderReport or=new OrderReport();
			

		}
		
		if(e.getSource()==i9)
		{
			
			Preport po=new Preport();
			
			
//			try
//			{
//			Runtime r=Runtime.getRuntime();
//			r.exec("explorer Preport.java");
//			}
//		catch(Exception ae)
//		{
//			System.out.print("\n Error="+ae);
//		}

		}
		if(e.getSource()==i10)
		{
			SorderRep sp=new SorderRep();
		}
//			try
//			{
//			Runtime r=Runtime.getRuntime();
//			r.exec("explorer SorderRep.java");
//			
//						
//			}
//				catch(Exception ae)
//			{
//			
//			}
//		}
		if(e.getSource()==i11)
		{
			try
			{
			Runtime r=Runtime.getRuntime();
			r.exec(" calc.exe      ");			

			}
			catch(Exception aa)
			{
			}
			

		}
		if(e.getSource()==i12)
		{
			int option;
			option=JOptionPane.showConfirmDialog(null,"Do You Really Want To EXIT!!!","ok",JOptionPane.YES_NO_OPTION);
			if(option==JOptionPane.YES_OPTION)
			{
	
				System.exit(0);
			}
		}

		
	}
}
		
				
				
		
	
