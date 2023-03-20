import java.io.*;
import java.sql.*;
import javax.swing.*;

class SbillReport
{
	public SbillReport(int num)
	{
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
   		Connection con=DriverManager.getConnection("Jdbc:mysql://localhost:3306/fertilizer","root","1234");
    		Statement st=con.createStatement();

    		BufferedWriter bw=new BufferedWriter(new FileWriter("SbillReport.html"));
    		bw.write("<html>");
    		bw.write("<title>  </title>");
    		bw.write("<head>   </head>");
    		bw.write("<body>");
		ResultSet rs=st.executeQuery("select * from  Customer where Cust_id =  " + num);
		
		if(rs.next())
		{	
        		bw.write("<table align=center  border=1 width=50% height=12% background=sagar.png><tr><td width=13% background=png.jpg><td><h2 align=center><font color='Red'>SAGAR KRUSHI SHEVA KENDRA</tr></table>");
		
			bw.write("<table align=center  border=1 width=50% height=5% bgcolor=pink><tr><td><h4 align=center><font color='green'>SAKUR-SANGAMNER,AHEMADNAGAR  </tr></table>");
    		
                	bw.write("<table align=center  border=1 width=50% height=5% bgcolor=pink><tr><td><h4 align=left><font color='Blue'>Bill No: "+rs.getString(1)+"<td width=35%><h4><font color='Blue'>Date: "+"</tr></table>");
    		
			bw.write("<table align=center  border=1 width=50% height=5% bgcolor=pink><tr><td><h3><font color='Blue'>Name: "+rs.getString(2)+"<td width=35%><h4><font color='Blue'>Mobile No:"+rs.getString(4)+"</tr></table>");
    			
                	bw.write("<table align=center  border=1 width=50% height=5% bgcolor=pink><tr><td><h3><font color='Blue'>Address: "+rs.getString(3)+"</tr></table>");
    		}
    		
               
    		bw.write("<table border=2 cellpadding=10 align=center width=50% background=fer.jpg>");
    		
    		              	
		bw.write("<tr>");
		int tot=0;			
		bw.write("<th><font color='Blue'>Sr.No");
		bw.write("<th><font color='Blue'>Product Name");
		bw.write("<th><font color='Blue'>Qty");
		bw.write("<th><font color='Blue'>Rate");
		bw.write("<th><font color='Blue'>Total");
			
		ResultSet rs1=st.executeQuery("select * from SalesBill where Cust_id = "+ num);	
		bw.write("</tr>");
			try {
				
		while(rs1.next())
		{
	       		bw.write("<tr>");
			
      			bw.write("<td><font color='Blue'>"+rs1.getString(1));
			bw.write("<td><font color='Blue'>"+rs1.getString(7));
			bw.write("<td><font color='Blue'>"+rs1.getString(8));
			bw.write("<td><font color='Blue'>"+rs1.getString(9));

			bw.write("<td><font color='Blue'>"+rs1.getString(12));
          		tot=Integer.parseInt(rs1.getString(13));
			 
			bw.write("</tr>");
		}
    	
			
		
 
		bw.write("</tr>");
    	}catch(Exception e)
		{
			System.out.print("\n Error="+e);
		}	
			bw.write("<tr>");

            bw.write("<td>");
	bw.write("<td>");
	bw.write("<td>");
	bw.write("<td><font color='Blue'>Total");
	bw.write("<td><font color='Blue'>"+rs1.getString(13));
			
		bw.write("</table>");
			
		bw.write("<table align=center  border=1 width=50% height=5% bgcolor=pink><tr><td><h4 align='left'><font color='Blue'>Customer Signature.................<h4 align='right'><font color='Blue'>Authorised Signature:-.................</tr></table>");
		
    	
		
		Runtime r=Runtime.getRuntime();
		r.exec("explorer SbillReport.html");
		bw.close();
		}
		catch(Exception e)
		{
			System.out.print("\n Error="+e);
		}
	}
	
}