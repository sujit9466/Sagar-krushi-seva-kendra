import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class LoginDemo extends JFrame implements ActionListener
{																						
	
	JLabel l1,l2,l3;
	JTextField t1;
	JPasswordField t2;
	JButton b1,b2;int c=0;
	
	LoginDemo()
	{
		
		
		
		setSize(1366,730);
		
		setLayout(null);
		setTitle("Login");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		ImageIcon ll=new ImageIcon(" ");
		Image img= ll.getImage();
		Image temp_img=img.getScaledInstance(1366, 730, Image.SCALE_SMOOTH);
		ll= new ImageIcon(temp_img);
		JLabel background= new JLabel("", ll,JLabel.CENTER);
	    
	
		background.setBounds(0,0,1366,730);

		

     	add(background);
     	  
		
		
		
		Font f =new Font("Serif", Font.BOLD,60);
		
			JPanel heading;
			heading =new JPanel();
			heading.setBackground(new Color(0,0,0,80));
			heading.setBounds(0,0,1366,100);
			JLabel name = new JLabel("Sagar Krushi seva Kendra");
			name.setForeground(Color.ORANGE);
			name.setBounds(200,50,400,50);
			name.setFont(f);
			heading.add(name);
	     	background.add(heading);

		
	    	

		
			
		
			
			l1=new JLabel("Username");
			l2=new JLabel("Password");
			l3=new JLabel("Login");
			
			t1=new JTextField(20);
			t2=new JPasswordField(20);
			

			b1=new JButton("Login");
			b2=new JButton("Clear");

			l1.setBounds(310,300,150,25);
			t1.setBounds(400,300,150,25);
			l2.setBounds(310,350,150,25);
			t2.setBounds(400,350,150,25);
			b1.setBounds(330,400,100,25);
			b2.setBounds(440,400,100,25);

			l3.setBounds(370,250,150,25);
			l3.setFont(new Font("Times New Roman", 1, 24));
	    		l3.setForeground(new Color(255,0,0));

			add(l1);add(t1);add(l2);add(l3);add(t2);
			add(b1);add(b2);

			b1.addActionListener(this);
			b2.addActionListener(this);
			setVisible(true);
			
			

		
     	
		
		
	}
	public void actionPerformed(ActionEvent e)
	{
		String s="sujit";
		String s1="1234";		

		if(e.getSource()==b1)
		{
			if(c<3)
			{			
				if(s.equals(t1.getText())&&s1.equals(t2.getText()))
					{
					JOptionPane.showMessageDialog(null,"Login Successful");
					KskDemo d=new KskDemo();
					
					}
					else
					JOptionPane.showMessageDialog(null,"invalid id");
					c++;
					setVisible(false);
				
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Please Enter Valid id......");
				 System.exit(0);;
			}
			
		}
		if(e.getSource()==b2)			
		{
			t1.setText("");
			t2.setText("");
		}
	}
	public static void main(String aa[])
	{
		new LoginDemo();

	}
}