package product_database.dao;

import java.sql.*;

public class productDao 
{
	public boolean check_barcode(String barcode_given) throws Exception
	{
		String url="jdbc:mysql://localhost:3306/3w?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
		String uname="root";
		String pass="5623";
		String query="select * from products where barcode=";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,uname,pass);
			query=query + "'" + barcode_given + "'";
			PreparedStatement st = con.prepareStatement(query);
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				String barcode_inbase=rs.getString("barcode");
				
				if (barcode_given.equals(barcode_inbase)) {
					return true;
				}
			}
			st.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	public void add_product(String barcode_given, String name_given, String color_given, String desc_given) throws Exception
	{
		String url="jdbc:mysql://localhost:3306/3w?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
		String uname="root";
		String pass="5623";
		String query="insert into products values(?,?,?,?)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,uname,pass);
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, barcode_given);
			st.setString(2, name_given);
			st.setString(3, color_given);
			st.setString(4, desc_given);
			
			int count = st.executeUpdate();
			
			st.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
