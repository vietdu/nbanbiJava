package vn.nbb.quanly;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import nv.nbb.connectdata;

public class htmlTen {
	private String iddangky;
	private String mkdangky;
	public htmlTen(String iddangky , String mkdangky) {
		this.iddangky=iddangky;
		this.mkdangky=mkdangky;
	}
	private String htmluser="";
	public String getTen() {
	try {
		Connection con = connectdata.getCon();
	
		PreparedStatement ps = con.prepareStatement("SELECT * from nguoidung");
		System.out.println(ps);
		ResultSet rs = ps.executeQuery();
		
		

		while(rs.next())
		{
			String id = rs.getString(1);
			String mail =rs.getString(2);
			int sdtt = rs.getInt(3);
			String mk = rs.getString(4);
		
			System.out.println(id);
			System.out.println(this.iddangky);
			System.out.println(mk);
			if(id.equals(this.iddangky) && mk.equals(this.mkdangky)) {
				return id;
				
				
			}
		}
	}
		
	
		

	
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return "Tài khoản";
	
}
}

