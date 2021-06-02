package vn.nbb.quanly;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import nv.nbb.connectdata;

public class htmlBanner {
	public htmlBanner() {
		
	}
	private String htmlbn="";
	public String getHtmlBanner() {
	try {
		Connection con = connectdata.getCon();
	
		PreparedStatement ps = con.prepareStatement("select * from banner");
		ResultSet rs = ps.executeQuery();
		
		

		while(rs.next())
		{
			int id = rs.getInt(1);
			String tieude = rs.getString(2);
			String noidung = rs.getString(3);
			String anh = rs.getString(4);
			String loai = rs.getString(5);
	

			htmlbn = htmlbn+"                    <div value='"+id+"' class='carousel-item '>\r\n"
					+ "                            <div class='mask flex-center'>\r\n"
					+ "                                <div class='container'>\r\n"
					+ "                                    <div class='row align-items-center'>\r\n"
					+ "                                        <div class='col-md-7 col-12 order-md-1 order-2'>\r\n"
					+ "                                            <h4>"+tieude+"</h4>\r\n"
					+ "                                            <p>"+noidung+"</p> <br> <a href='"+loai+"'>ĐẶT NGAY</a>\r\n"
					+ "                                        </div>\r\n"
					+ "                                        <div class='col-md-5 col-12 order-md-2 order-1'><img src='"+anh+"' class='mx-auto' alt='slide'></div>\r\n"
					+ "                                    </div>\r\n"
					+ "                                </div>\r\n"
					+ "                            </div>\r\n"
					+ "                        </div>";
		}
	
		

	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return htmlbn;
	
	}
}


