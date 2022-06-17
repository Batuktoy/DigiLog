package qrGaller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MyQuery {
	
	static Connection getConnection() 
	{
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost/qr_generator";
			Class.forName(driver);
			return DriverManager.getConnection(url,"root","");
		} catch (Exception e) {
			System.out.println("Connection Failed! " + e);
		}
		
		return null;
	}
	
	 public ArrayList<QR_images> BindTable(){
	        
		   ArrayList<QR_images> list = new ArrayList<QR_images>();
		   Connection con = getConnection();
		   java.sql.Statement stmt;
		   ResultSet rsS;
		   
		   try {
		   stmt = con.createStatement();
		   rsS = stmt.executeQuery("SELECT `ID_NUMBER`, `NAME`, `IMAGE`, `PICTURE`, `C_NUMBER`, `COURSE`, `ADDRESS` FROM `qr_code`");
		   
		   QR_images p;
		   while(rsS.next()){
		   p = new QR_images(
		   rsS.getString("ID_NUMBER"),
		   rsS.getString("NAME"),
		   rsS.getBytes("IMAGE"),
		   rsS.getBytes("PICTURE"),
		   rsS.getString("C_NUMBER"),
		   rsS.getString("COURSE"),
		   rsS.getString("ADDRESS")
		   );
		   list.add(p);
		   }
		   
		   } catch (SQLException ex) {
			   System.out.println("Error"+ ex);;
		   }
		   return list;
		   }
	 
	 
	 
}
