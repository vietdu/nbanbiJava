package vn.nbb.quanly;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import nv.nbb.connectdata;

public class htmlKhachsan {
	private String timdiadiem;
	public htmlKhachsan(String timdiadiem) {
		this.timdiadiem=timdiadiem;
	}
	private String htmlks="";
	public String getHtmlKhachsan() {
	try {
		Connection con = connectdata.getCon();
	
		PreparedStatement ps = con.prepareStatement("SELECT datphong.id, datphong.tenks, datphong.gia, datphong.soluong ,khachsan.tieude, khachsan.vitri, khachsan.gioithieu FROM datphong INNER JOIN khachsan ON datphong.tenks = khachsan.tenks WHERE khachsan.vitri LIKE '%"+timdiadiem+"%'");
		ResultSet rs = ps.executeQuery();
		
		

		while(rs.next())
		{
			int id = rs.getInt(1);
			String tenks=rs.getString(2);
			String gia = rs.getString(3);
			int soluong = rs.getInt(4);
			String tieude = rs.getString(5);
			String vitri = rs.getString(6);
			String gioithieu = rs.getString(7);
	

			htmlks = htmlks+" <div value='"+tenks+"' class='col hihi '>\r\n"
					+ "                       <div class='p-1 border dulich bg-light '>\r\n"
					+ "\r\n"
					+ "                        <div class='row  ' >\r\n"
					+ "                            <div class='col-sm anhdulich '>\r\n"
					+ "                                <div class='container d-flex justify-content-center'>\r\n"
					+ "                                    <div class='card p-2 my-4'> <img src='anh/haian1.jpg' height='560' id='ha1'>\r\n"
					+ "                                        <div class='text-white'>\r\n"
					+ "                                            <h4 style='color:aliceblue'>"+tieude+"</h4>\r\n"
					+ "                                        </div>\r\n"
					+ "                                        <div class='text-muted'>\r\n"
					+ "                                            <p style='color:aliceblue'>"+gioithieu+"</p>\r\n"
					+ "                                        </div>\r\n"
					+ "                                        <div class='d-flex flex-row justify-content-between align-items-center'>\r\n"
					+ "                                             <span  id='"+tenks+"1'>\r\n"
					+ "                                                <hr class='first'></span>\r\n"
					+ "                                                <span id='"+tenks+"2'>\r\n"
					+ "                                                <hr ></span>\r\n"
					+ "                                                <span id='"+tenks+"3'>\r\n"
					+ "                                                <hr ></span>\r\n"
					+ "                                             </div> <button type='button' class='btn btn-primary mt-3 mb-1' id='san1' ><span>"+gia+" </span></button>\r\n"
					+ "                                    </div>\r\n"
					+ "                                </div>\r\n"
					+ "                           \r\n"
					+ "                              </div>\r\n"
					+ "                              \r\n"
					+ "\r\n"
					+ "                         \r\n"
					+ "                     \r\n"
					+ "            \r\n"
					+ "                    </div>\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "                       </div>\r\n"
					+ "                      </div>";
		}
	
		

	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return htmlks;
	
	}
}


