package vn.nbb.quanly;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import nv.nbb.connectdata;

public class htmlThanhToan  {


	
	private String htmlThongbao="";
	public htmlThanhToan(String tenks, String ten,String cmnd, String gia) {
	
		
		
	
		if(ten != null && gia != null && tenks !=null && cmnd !=null) {
		try {
			Connection con = connectdata.getCon();
		
			PreparedStatement ps = con.prepareStatement("INSERT INTO giaodich (tenks, idnguoidung, cmnd, giaks) VALUES ('"+tenks+"', '"+ten+"', '"+cmnd+"', '"+gia+"')");
			System.out.print(ps);
			int rows = ps.executeUpdate();
			this.htmlThongbao="alert('Đặt phòng thành công')";
			
			
		}

		catch(Exception e)
		{
			this.htmlThongbao="alert('Bạn phải nhập đúng chứng minh nhân dân')";
			e.printStackTrace();
		}
		}
	}
	public String getHtmlThongbao() {
		return htmlThongbao;
	}
}

