package vn.nbb.quanly;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import nv.nbb.connectdata;

public class htmlThongbao  {
	private String iddangky;
	private String email;
	private int sdt;
	private String mkdangky;
	
	private String htmlThongbao;
	public htmlThongbao(String iddangky,String email,int sdt, String mkdangky) {
		this.iddangky = iddangky;
		this.email = email;
		this.sdt = sdt;
		this.mkdangky=mkdangky;
		if(iddangky != null && email != null && mkdangky !=null) {
		try {
			Connection con = connectdata.getCon();
		
			PreparedStatement ps = con.prepareStatement("insert into nguoidung value ('"+iddangky+"','"+email+"',"+sdt+",'"+mkdangky+"')");
			System.out.print(ps);
			int rows = ps.executeUpdate();
			this.htmlThongbao="alert('Đăng ký thành công')";
			
			
		}

		catch(Exception e)
		{
			this.htmlThongbao="alert('Đăng ký không thành công - Tên ID đã có người sử dụng')";
			e.printStackTrace();
		}
		}
	}
	public String getHtmlThongbao() {
		return htmlThongbao;
	}
}


