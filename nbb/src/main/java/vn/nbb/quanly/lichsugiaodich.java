package vn.nbb.quanly;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import nv.nbb.connectdata;

public class lichsugiaodich  {


	
	private String htmlgiaodich="";
	public lichsugiaodich(String idnguoidung) {
	
		
		
	
		if(!idnguoidung.equals("Tài khoản")) {
			try {
				Connection con = connectdata.getCon();
			
				PreparedStatement ps = con.prepareStatement("SELECT giaodich.idgiaodich , giaodich.tenks FROM giaodich INNER JOIN nguoidung ON giaodich.idnguoidung = nguoidung.idnguoidung WHERE nguoidung.idnguoidung='"+idnguoidung+"' ORDER BY idgiaodich DESC");
				System.out.println(ps);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next())
				{
				String idgiaodich = rs.getString(1);
				String tenks = rs.getString(2);
					
				htmlgiaodich=htmlgiaodich+"mã thành toán : "+idgiaodich+" khách sạn : "+tenks+"";
					
						
					}
				
			
				}
			
				

			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		}
		
	
	public String getHtmlThongbao() {
		return htmlgiaodich;
	}
}


