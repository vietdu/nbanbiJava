package vn.nbb.quanly;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import nv.nbb.connectdata;

public class htmlKhachsan {
	private String timdiadiem;
	
	public htmlKhachsan(String timdiadiem,int i) {
		this.timdiadiem=timdiadiem;
		this.i =i;
	}
	private int i;
	private String htmlks="";
	private String jQtt1="";
	private String jQtt2="";
	private String jQks="";
	public String getHtmlKhachsan() {
	try {
		Connection con = connectdata.getCon();
	
		PreparedStatement ps = con.prepareStatement("SELECT datphong.id, datphong.tenks, datphong.gia, datphong.soluong ,khachsan.tieude, khachsan.vitri, khachsan.gioithieu FROM datphong INNER JOIN khachsan ON datphong.tenks = khachsan.tenks WHERE khachsan.vitri LIKE '%"+timdiadiem+"%' AND datphong.soluong > 0");
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
			
			jQtt1=jQtt1+",\r\n"
					+ "    click"+tenks+"1=document.getElementById('s"+tenks+"1')";
			jQtt2=jQtt2+" \r\n   click"+tenks+"1.addEventListener('click', (event)=>{\r\n"
					+"  const result = document.querySelector('.resulttt');\r\n"
					+"  const resultx = document.querySelector('.namett');\r\n"
					+"var text = `${event.target.value}`;\r\n"
					+ "var number = text.match(/\\d/g);\r\n"
					+ "number = number.join(\"\");\r\n"
					+ "  result.textContent = number+' vnd';\r\n"
					+"var tenks = text.replace(/\\d+/g,'');"
					+ "  resultx.textContent = tenks;\r\n"
					+"document.getElementById('tttenks').value=tenks;"
					+"document.getElementById('giaks').value=number;"
					+ "      hienthithanhtoan.classList.add('thanhtoanshow')\r\n"
					+ "   })";
			
			
			jQks=jQks +"          $('#"+tenks+"11').click(function(){\r\n"
					+ "            $('#"+tenks+"1').attr('src', 'anh/"+tenks+"1.jpg');\r\n"
					+ "          });\r\n"
					+ "          $('#"+tenks+"12').click(function(){\r\n"
					+ "            $('#"+tenks+"1').attr('src', 'anh/"+tenks+"2.jpg');\r\n"
					+ "          });\r\n"
					+ "          $('#"+tenks+"13').click(function(){\r\n"
					+ "            $('#"+tenks+"1').attr('src', 'anh/"+tenks+"3.jpg');\r\n"
					+ "          });";

			htmlks = htmlks+" <div value='"+tenks+"' class='col hihi '>\r\n"
					+ "                       <div class='p-1  dulich  '>\r\n"
					+ "\r\n"
					+ "                        <div class='row  ' >\r\n"
					+ "                            <div class='col-sm anhdulich '>\r\n"
					+ "                                <div class='container d-flex justify-content-center'>\r\n"
					+ "                                    <div class='card p-2 my-4'> <img src='anh/"+tenks+"1.jpg' height='560' id='"+tenks+"1'>\r\n"
					+ "                                        <div class='text-white'>\r\n"
					+ "                                            <h4 style='color:aliceblue'>"+tieude+"</h4>\r\n"
					+ "                                        </div>\r\n"
					+ "                                        <div class='text-muted'>\r\n"
					+ "                                            <p style='color:aliceblue'>"+gioithieu+"</p>\r\n"
					+ "                                        </div>\r\n"
					+ "                                        <div class='d-flex flex-row justify-content-between align-items-center'>\r\n"
					+ "                                             <span  id='"+tenks+"11'>\r\n"
					+ "                                                <hr class='first'></span>\r\n"
					+ "                                                <span id='"+tenks+"12'>\r\n"
					+ "                                                <hr ></span>\r\n"
					+ "                                                <span id='"+tenks+"13'>\r\n"
					+ "                                                <hr ></span>\r\n"
					+ "                                             </div> <button type='button' class='btn btn-primary mt-3 mb-1' id='s"+tenks+"1' value='"+gia+""+tenks+"' ><span>"+gia+" vnd </span></button>\r\n"
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
	if(i==0) {
	return htmlks;
	}
	else if(i==1) {
		return jQks;
	}
	else if(i==2) {
		return jQtt1;
	}
	else {
		return jQtt2;
	}
	
	}
}


