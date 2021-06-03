package vn.nbb.quanly;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import nv.nbb.connectdata;

public class htmlChuyenbay {
	private int i;
	private String htmlBay="";
	private String duongbay;
	private String jQbay1="";
	private String jQbay2="";
	public htmlChuyenbay(String duongbay,int i) {
		this.duongbay=duongbay;
		this.i=i;
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
			
			jQbay1 =jQbay1+"\r\n click"+id+"=document.getElementById('"+id+"'),";
			jQbay2=jQbay2+"   \r\n click"+id+".addEventListener('click', (event)=>{\r\n"
					+"  const result2 = document.querySelector('.resulttt');\r\n"
					+ "  result2.textContent = `${event.target.value}`;\r\n"
					+ "      hienthithanhtoan.classList.add('thanhtoanshow')\r\n"
					+ "   })";
			
			
			htmlBay = htmlBay+"<br>"+"        <div value='"+gia+"' id='"+id+"' class='grid wide container thequan' style='cursor: pointer;'>\r\n"
					+ "                                                    <div value='"+gia+"' class='prolayer-fly' >\r\n"
					+ "                                                   <div value='"+gia+"' class='prolayer3'>              \r\n"
					+ "                                                   <img src='"+anh+"' width='40' height='10' alt=''>\r\n"
					+ "                                                   </div>\r\n"
					+ "                                                   <div value='"+gia+"' class='block-content'>\r\n"
					+ "                                                   <div value='"+gia+"' class='prolay-full' style='display: flex;'>\r\n"
					+ "                                                   <div value='"+gia+"' class='prolayze'  title='8:40 AM on SAT, MAY 29 '>\r\n"
					+ "                                                      <b>"+batdau+"</b><br>\r\n"
					+ "                                                      <p>"+tenhang+"</p>\r\n"
					+ "                                                   </div>\r\n"
					+ "                                                   <div value='"+gia+"' class='list-fly'>\r\n"
					+ "                                                      <h6 style='color: #79b18a;'>"+tgbay+"</h6>\r\n"
					+ "                                                      <p>"+tendb+"</p>\r\n"
					+ "                                                   </div>\r\n"
					+ "                                                   <div value='"+gia+"' class='list-skyline'>\r\n"
					+ "                                                      <h6 style='color: #79b18a;'>Nonstop</h6>\r\n"
					+ "                                                   </div>\r\n"
					+ "                                                   <div value='"+gia+"' class='list-money'>\r\n"
					+ "                                                      <h6 style='color: #79b18a;'>"+gia+"</h6>\r\n"
					+ "                                                      <p>round trip</p>\r\n"
					+ "                                                   </div>\r\n"
					+ "                                                   </div>\r\n"
					+ "                                                    <div  value='"+gia+"' class='content-sp' style='display: none;'>\r\n"
					+ "                                                <div value='"+gia+"' class='content'>\r\n"
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
	if(i==0)
	{
	return htmlBay;
	}
	else if(i==1) {
		return jQbay1;
	}
	else {
		return jQbay2;
	}
	
	}
}
