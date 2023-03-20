

import java.io.*;
import java.sql.*;
import javax.swing.*;

class SorderRep
{
	public SorderRep()
	{
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
			
    		Connection con=DriverManager.getConnection("Jdbc:mysql://localhost:3306/fertilizer","root","1234");
    		
    		Statement st=con.createStatement();
    		
    		BufferedWriter bw=new BufferedWriter(new FileWriter("SorderRep.html"));
    		bw.write("<html>");
    		bw.write("<title>  </title>");
    		bw.write("<head>   </head>");
    		bw.write("<body>");
    		bw.write("<h1><center> <font color='purple'>SAGAR KRUSHI SEVA KENDRA</font></center></h1>");
    		bw.write("<h1><center> <font color='purple'>SHOP</font></center></h1>");
    		bw.write("<h3><center> <font color='red'>SAKUT,SANGAMNER</font></center></h1>");
    		bw.write("<h2><center> <font color='green'>SALES ORDER REPORT </font></center></h1>");
    		bw.write("<hr color=black size=5>");
    		bw.write("<table border=0 cellpadding=10 align=center>");
    		
    		ResultSet rs=st.executeQuery("select * from purchesorder");
    		
			ResultSetMetaData rsmd=rs.getMetaData();
		
			int col=rsmd.getColumnCount();
			
			bw.write("<tr>");
			for(int i=1;i<=col;i++)
			{
				bw.write("<th><font color='Blue'>"+rsmd.getColumnName(i));
			}
			while(rs.next())
			{
				bw.write("<tr>");
				for(int i=1;i<=col;i++)
				{
					bw.write("<td><font color='Blue'>"+rs.getString(i));
				}
			}
			bw.write("</table>");
			bw.write("<hr color=black size=2>");
			bw.write("<h3 align='right'><font color='Blue'>Authorised Signature:-.................</h3>");
			
			Runtime r=Runtime.getRuntime();
			r.exec("explorer PurchesRep.html");
			bw.close();
		}
		catch(Exception e)
		{
			System.out.print("\n Error="+e);
		}
	}
	public static void main(String arg[])
	{
		SorderRep ob=new SorderRep();
	}
}