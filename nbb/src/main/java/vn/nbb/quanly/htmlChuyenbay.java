package vn.nbb.quanly;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import nv.nbb.connectdata;

public class htmlChuyenbay {
	private String htmlBay="";
	private String duongbay;
	public htmlChuyenbay(String duongbay) {
		this.duongbay=duongbay;
	}
	public String getHtmlBay() {
	
	try {
		Connection con = connectdata.getCon();
		System.out.println("SELECT chuyenbay.id, chuyenbay.tenhang, chuyenbay.batdau, chuyenbay.tendb, chuyenbay.soluong, chuyenbay.gia, duongbay.tgbay, hangbay.anh FROM ((chuyenbay INNER JOIN duongbay ON chuyenbay.tendb = duongbay.tendb) INNER JOIN hangbay ON chuyenbay.tenhang = hangbay.tenhang) where chuyenbay.tendb='"+duongbay+"'");
	
		PreparedStatement ps = con.prepareStatement("SELECT chuyenbay.id, chuyenbay.tenhang, chuyenbay.batdau, chuyenbay.tendb, chuyenbay.soluong, chuyenbay.gia, duongbay.tgbay, hangbay.anh FROM ((chuyenbay INNER JOIN duongbay ON chuyenbay.tendb = duongbay.tendb) INNER JOIN hangbay ON chuyenbay.tenhang = hangbay.tenhang) where chuyenbay.tendb='"+duongbay+"'AND chuyenbay.soluong > 0");
		ResultSet rs = ps.executeQuery();
		
		

		while(rs.next())
		{
			int id = rs.getInt(1);
			String tenhang = rs.getString(2);
			String batdau = rs.getString(3);
			String tendb = rs.getString(4);
			String soluong = rs.getString(5);
			String gia = rs.getString(6);
			String tgbay=rs.getString(7);
			String anh = rs.getString(8);
			System.out.println(anh);
			htmlBay = htmlBay+"<br>"+"        <div value='"+id+"' class='grid wide container thequan'>\r\n"
					+ "                                                    <div class='prolayer-fly' >\r\n"
					+ "                                                   <div class='prolayer3'>              \r\n"
					+ "                                                   <img src='"+anh+"' width='40' height='10' alt=''>\r\n"
					+ "                                                   </div>\r\n"
					+ "                                                   <div class='block-content'>\r\n"
					+ "                                                   <div class='prolay-full' style='display: flex;'>\r\n"
					+ "                                                   <div class='prolayze'  id='bay5' title='8:40 AM on SAT, MAY 29 '>\r\n"
					+ "                                                      <b>"+batdau+"</b><br>\r\n"
					+ "                                                      <p>"+tenhang+"</p>\r\n"
					+ "                                                   </div>\r\n"
					+ "                                                   <div class='list-fly'>\r\n"
					+ "                                                      <h6 style='color: #79b18a;'>"+tgbay+"</h6>\r\n"
					+ "                                                      <p>"+tendb+"</p>\r\n"
					+ "                                                   </div>\r\n"
					+ "                                                   <div class='list-skyline'>\r\n"
					+ "                                                      <h6 style='color: #79b18a;'>Nonstop</h6>\r\n"
					+ "                                                   </div>\r\n"
					+ "                                                   <div class='list-money'>\r\n"
					+ "                                                      <h6 style='color: #79b18a;'>"+gia+"</h6>\r\n"
					+ "                                                      <p>round trip</p>\r\n"
					+ "                                                   </div>\r\n"
					+ "                                                   </div>\r\n"
					+ "                                                    <div class='content-sp' style='display: none;'>\r\n"
					+ "                                                <div class='content'>\r\n"
					+ "                                                          <p>SGN-DAD</p>\r\n"
					+ "                                                          <p>round trip</p>\r\n"
					+ "                                                </div>\r\n"
					+ "                                                <div class='content'>\r\n"
					+ "                                                    <h6 style='color: #79b18a;'>&nbsp;&nbsp;&nbsp;Nonstop</h6>\r\n"
					+ "                                                      <h6 style='color: #79b18a;'>"+tgbay+"</h6>\r\n"
					+ "                                                      <p></p>\r\n"
					+ "                                                </div>\r\n"
					+ "                                              </div>\r\n"
					+ "                                                   </div>\r\n"
					+ "                                                   </div>\r\n"
					+ "                                                   </div>";
		
		}
	
		

	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return htmlBay;
	
	}
}
