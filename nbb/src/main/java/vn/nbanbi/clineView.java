package vn.nbanbi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nv.nbb.connectdata;
import vn.nbb.quanly.htmlBanner;
import vn.nbb.quanly.htmlChuyenbay;
import vn.nbb.quanly.htmlKhachsan;
import vn.nbb.quanly.htmlTen;
import vn.nbb.quanly.htmlThanhToan;
import vn.nbb.quanly.htmlThongbao;
import vn.nbb.quanly.lichsugiaodich;


@WebServlet(urlPatterns = {"/trangchu"})
public class clineView  extends HttpServlet{
	String jQbay1;
	String jQbay2;
	String jQks;
	String jQtt1;
	String jQtt2;
	String htmlBay;
	String htmlbn;
	String htmlks;
	String maildn;

	
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		
		
		String gadi,gaden;
		String diadiem="da nang";
		String duongbay;
		String email ,iddangky,mkdangky,iddangnhap,mkdangnhap;	
		String ten="Tài khoản";
		String tendn;
		String tttenks;
		String giaks;
		String cmnd;
		String lsgd;
		
		
		int sdt=0;
		
		String htmlTB;

		String tbtt;
		
		email=req.getParameter("email");	
		iddangky=req.getParameter("iddangky");	
		mkdangky=req.getParameter("mkdangky");
		iddangnhap=req.getParameter("iddangnhap");
		mkdangnhap=req.getParameter("mkdangnhap");
		


		tttenks=req.getParameter("tttenks");
		giaks=req.getParameter("giaks");
		cmnd=req.getParameter("cmnd");
		
		
		System.out.println(giaks);
		System.out.println(tttenks);
		System.out.print(cmnd);
		System.out.println(ten);
		
		System.out.println(email);
		System.out.println(sdt);
		System.out.println(iddangky);
		System.out.println(mkdangky);
		
		gadi=req.getParameter("gadi");
		gaden= req.getParameter("gaden");
		diadiem=req.getParameter("timdiadiem");
		System.out.println(diadiem);
		if(diadiem ==null) {
			diadiem="da nang";
		}
		
		duongbay= gadi+"-"+gaden;
		
		System.out.println(duongbay);
		
		htmlChuyenbay chuyenbay = new htmlChuyenbay(duongbay, 0);
		htmlBay=chuyenbay.getHtmlBay();
		htmlChuyenbay chuyenbay2 = new htmlChuyenbay(duongbay, 1);
		jQbay1=chuyenbay2.getHtmlBay();
		htmlChuyenbay chuyenbay3 = new htmlChuyenbay(duongbay, 2);
		jQbay2=chuyenbay3.getHtmlBay();
		htmlBanner htmlBan = new htmlBanner();
		htmlbn = htmlBan.getHtmlBanner();
		htmlKhachsan htmlksan = new htmlKhachsan(diadiem, 0);
		htmlks =htmlksan.getHtmlKhachsan();
		htmlKhachsan jQueryKS = new htmlKhachsan(diadiem, 1);
		jQks =jQueryKS.getHtmlKhachsan();
		htmlKhachsan jQueryKS1 = new htmlKhachsan(diadiem, 2);
		jQtt1 =jQueryKS1.getHtmlKhachsan();
		htmlKhachsan jQueryKS2 = new htmlKhachsan(diadiem, 3);
		jQtt2 =jQueryKS2.getHtmlKhachsan();
		System.out.println(jQbay1);
		System.out.println(jQbay2);
		htmlThongbao dkThongbao = new htmlThongbao(iddangky,email,sdt,mkdangky);
		
		htmlTB = dkThongbao.getHtmlThongbao();

		
	
		htmlTen htmlten = new htmlTen(iddangky,mkdangky);
	
		htmlTen htmltendn = new htmlTen(iddangnhap,mkdangnhap);
		
		if(iddangky !=null  ) {
			ten=htmlten.getTen();
		}
		 if(iddangnhap !=null) {
			ten=htmltendn.getTen();
		}
		
	
		if(!ten.equals("Tài khoản") ) {
			
			try {
				Connection con = connectdata.getCon();
			
				PreparedStatement ps = con.prepareStatement("SELECT * from nguoidung");
		
				ResultSet rs = ps.executeQuery();
				
				

				while(rs.next())
				{
					String id = rs.getString(1);
					
					int sdtt = rs.getInt(3);
					String mk = rs.getString(4);
					
				

					if(id.equals(ten)) {
						String mail =rs.getString(2);
						this.maildn=mail;
						Cookie coki = new Cookie("du", id);
						coki.setMaxAge(200);

						System.out.println("=============================================");
						System.out.println(coki.getName());
						System.out.println("=============================================");
						resp.addCookie(coki);
					
						
					}
				}
			}
				
			
				

			
			catch(Exception e)
			{
				e.printStackTrace();
			}
			

		}
		Cookie[] cokis = req.getCookies();
		if(cokis != null)
		{
		for(Cookie c : cokis) {
			if(c.getName().equals("du")) {
				ten=c.getValue();
			}
		}
		}
		
		
		
		
		
		System.out.println("------------------------------");
		System.out.println(ten);
		if(cmnd!=null) {
		htmlThanhToan ThanhToan = new htmlThanhToan(tttenks, ten,cmnd, giaks);
		htmlTB = ThanhToan.getHtmlThongbao();
		}
		System.out.println("------------------------------");
		
		lichsugiaodich lssss = new lichsugiaodich(ten);
		lsgd = lssss.getHtmlThongbao();
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println(lsgd);
		
		
		String htmldn="";
		System.out.println("-----------------=========================---------------");
		System.out.println(ten);
		
		if(ten.equals("Tài khoản")) {
		
	htmldn="  <form action='' class='form1 dangnhapwi showdangnhap'  id='dangnhap-menu' >\r\n"
			+ "                        <div class='container'>\r\n"
			+ "                            <div class='row'>\r\n"
			+ "                                <div class='offset-md-2 col-lg-5 col-md-7 offset-lg-4 offset-md-3'>\r\n"
			+ "                                    <div class='panel border bg-white'>\r\n"
			+ "                                        <div class='panel-heading'>\r\n"
			+ "                                            <h3 class='pt-3 font-weight-bold'>Đăng nhập</h3>\r\n"
			+ "                                        </div>\r\n"
			+ "                                        <div class='panel-body p-3'>\r\n"
			+ "                                            <form action='login_script.php' method='POST'>\r\n"
			+ "                                                <div class='form-group py-2'>\r\n"
			+ "                                                    <div class='input-field'> <span class='far fa-user p-2'></span> <input name='iddangnhap' type='text' placeholder='Tên ID' required> </div>\r\n"
			+ "                                                </div>\r\n"
			+ "                                                <div class='form-group py-1 pb-2'>\r\n"
			+ "                                                    <div class='input-field'> <span class='fas fa-lock px-2'></span> <input name='mkdangnhap' type='password' placeholder='Nhập mật khẩu' required> <button class='btn bg-white text-muted'> <span class='far fa-eye-slash'></span> </button> </div>\r\n"
			+ "                                                </div>\r\n"
			+ "                                                <div class='form-inline'> <input type='checkbox' name='remember' id='remember'> <label for='remember' class='text-muted'>Nhớ mật khẩu</label> <a href='#' id='forgot' class='font-weight-bold'>Quên mật khẩu?</a> </div>\r\n"
			+ "                                                <div class='btn btn-primary btn-block mt-3' id='dangnhap'><button style='background-color:#0d6dfd00;border:none'>Đăng nhập</button></div>\r\n"
			+ "                                                <div class='text-center pt-4 text-muted'>Bạn chưa có tài khoản? <a href='#' id='dangnhap2'>Đăng ký</a> </div>\r\n"
			+ "                                            </form>\r\n"
			+ "                                        </div>\r\n"
			+ "                                        <div class='mx-3 my-2 py-2 bordert'>\r\n"
			+ "                                            <div class='text-center py-3'> <a href='https://wwww.facebook.com' target='_blank' class='px-2'> <img src='anh/fb.png' alt=''> </a> <a href='https://www.google.com' target='_blank' class='px-2'> <img src='anh/google.png' alt=''> </a> <a href='https://www.github.com' target='_blank' class='px-2'> <img src='anh/github.png' alt=''> </a> </div>\r\n"
			+ "                                        </div>\r\n"
			+ "                                    </div>\r\n"
			+ "                                </div>\r\n"
			+ "                            </div>\r\n"
			+ "                        </div>\r\n"
			+ "                    </form>";
		
		}
		
		else {
			htmldn="                 <form  class='form1 dangnhapwi showdangnhap'  id='dangnhap-menu' >\r\n"
					+ "                        <div class='container'>\r\n"
					+ "                            <div class='row'>\r\n"
					+ "                                <div class='offset-md-2 col-lg-5 col-md-7 offset-lg-4 offset-md-3'>\r\n"
					+ "                                    <div class='panel border bg-white'>\r\n"
					+ "                                        <div class='panel-heading'>\r\n"
					+ "                                            <h3 class='pt-3 font-weight-bold' style='color:#000080'>"+ten+"</h3>\r\n"
					
					+ "                                        </div>\r\n"
					+ "                                        <div class='panel-heading'>\r\n"
					+ "                                            <h5 class='pt-3 font-weight-bold text-center' style='color:#4682B4'>"+this.maildn+"</h5>\r\n"
					
					+ "                                        </div>\r\n"
					+ "                                        <div class='panel-heading'>\r\n"
					+ "  <img src='anh/giphy.gif' alt='Girl in a jacket' width='240' height='240'>"
					
					+ "                                        </div>\r\n"
					
					+ "                                        <div class='panel-body p-3'>\r\n"
					+ "                                            <form action='login_script.php' method='POST'>\r\n"
					+ "                                             \r\n"
					+ "                                                <div class='btn btn-primary btn-block mt-3' id='dangnhap' style=\"visibility: hidden;\"><button style='background-color:#0d6dfd00;border:none'>Đăng nhập</button></div>\r\n"
					+"<div class='text-center pt-4 text-muted'>"
					+lsgd
					+"</div>"
					+ "                                                <div class='text-center pt-4 text-muted'>Bạn muốn thoát tài khoản? <a href='#' id='dangnhap2'>Đăng ký lại</a> </div>\r\n"
					+ "                                            </form>\r\n"
					+ "                                        </div>\r\n"
					+ "                                        <div class='mx-3 my-2 py-2 '>\r\n"
					+ "                                            <div class='text-center py-3'> <a href='https://wwww.facebook.com' target='_blank' class='px-2'> <img src='anh/fb.png' alt=''> </a> <a href='https://www.google.com' target='_blank' class='px-2'> <img src='anh/google.png' alt=''> </a> <a href='https://www.github.com' target='_blank' class='px-2'> <img src='anh/github.png' alt=''> </a> </div>\r\n"
					+ "                                        </div>\r\n"
					+ "                                    </div>\r\n"
					+ "                                </div>\r\n"
					+ "                            </div>\r\n"
					+ "                        </div>\r\n"
					+ "                    </form>";
		}

		

		PrintWriter pw= resp.getWriter();
	String html="<!DOCTYPE html>\r\n"
				+ "<html lang='vi'>\r\n"
				+ "    <head>\r\n"
				+ "        <meta charset='UTF-8'>\r\n"
				+ "        <meta name='viewport' content='width=device-width, initial-scale=1.0'>\r\n"
				+ "        <title>GLoser</title>\r\n"
				+ "\r\n"
				+ "        <link rel='stylesheet' href='css/styles2.css'>\r\n"
				+ "\r\n"
				+ "        <link href='https://cdn.jsdelivr.net/npm/boxicons@2.0.5/css/boxicons.min.css' rel='stylesheet'>\r\n"
				+ "        <link href='https://use.fontawesome.com/releases/v5.7.2/css/all.css' rel='stylesheet'>\r\n"
				+ "        <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x' crossorigin='anonymous'>\r\n"
				+ "        <link rel='icon' href='anh/logo.png' sizes='16x16' type='png'> \r\n"
				+ "        <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>\r\n"
				+ "        <script>\r\n"
				+htmlTB
			
				+ "\r\n"
				+ "var images = ['anh/kiquan1.jpg', 'anh/kiquan2.jpg', 'anh/kiquan3.jpg', 'anh/kiquan5.jpg',];\r\n"
				+ "  $(function () {\r\n"
				+ "      var i = 0;\r\n"
				+ "      $('#dvImage').css('background-image', 'url(' + images[i] + ')');\r\n"
				+ "      setInterval(function () {\r\n"
				+ "          i++;\r\n"
				+ "          if (i == images.length) {\r\n"
				+ "              i = 0;\r\n"
				+ "          }\r\n"
				+ "          $('#dvImage').fadeOut('slow', function () {\r\n"
				+ "              $(this).css('background-image', 'url(' + images[i] + ')');\r\n"
				+ "              $(this).fadeIn('slow');\r\n"
				+ "          });\r\n"
				+ "      }, 20000);\r\n"
				+ "  });\r\n"
				+ "           \r\n"
				+ "        $(document).ready(function(){\r\n"
				+ "            $('#myCarousel').carousel({\r\n"
				+ "interval: 6000,\r\n"
				+ "});\r\n"
				+ jQks
				
				+ "          \r\n"
				+ "        });\r\n"
				+ "\r\n"
				+ "        \r\n"
				+ "        </script>\r\n"
				+ "  \r\n"
				+ "\r\n"
				+ "    </head>\r\n"
				+ "\r\n"
				+ "        <body>\r\n"
				+ "\r\n"
				+ "        <header class='l-header'>\r\n"
				+ "            <nav class='nav bd-grid'>\r\n"
				+ "   \r\n"
				+ "                <div>\r\n"
				+ "                    <a href='#' class='nav__logo' style='text-decoration: none;font-size:24'>GL</a>\r\n"
				+ "                </div>\r\n"
				+ "                <div class='thongbao' >\r\n"
				
				+ "                   <a  style='text-decoration: none' href='#Booking' class='nav__link '><i class='bx bxs-plane' ></i> CHUYẾN BAY</a>\r\n"
				+ "                    \r\n"
				+ "                    <a style='text-decoration: none' href='#yasuo' class='nav__link dancach'><i class='bx bx-heart-circle'></i> KHÁM PHÁ</a>\r\n"
				+ "                 <a style='text-decoration: none' href='#bannerkhachsan' class='nav__link active'><i class='bx bx-home-circle'></i> KHÁCH SẠN</a>\r\n"
				+ "            </div>\r\n"
				+ "\r\n"
				+ "        \r\n"
				+"\r\n"
				+ "        <form action ='trangchu#bannerkhachsan' class='diadiem'>\r\n"
				+ "            <div class='main-search-input-wrap'   >\r\n"
				+ "                <div class='main-search-input fl-wrap '>\r\n"
				+ "                    <div > <input type='text' value='' name='timdiadiem' placeholder='Bạn muốn đến...'  class='nuttk'> </div> \r\n"
				+ "                    <button  class='main-search-button '><i class='bx bx-search-alt'style='font-size:28px;color: rgb(38, 0, 255);'></i> </button>\r\n"
				+ "                </div>\r\n"
				+ "            </div>\r\n"
				+ "        </form>"
				+ "    \r\n"
				+ "                <div class='nav__toggle' id='nav-toggle'>\r\n"
				+ "                    <i class='bx bx-customize'></i>\r\n"
				+ "                   \r\n"
				+ "                </div>\r\n"
				+ "                \r\n"
				+ "\r\n"
				+ "                <div class='nav__menu' id='nav-menu'>\r\n"
				+ "                 \r\n"
				+ "                     <div style='text-align: center;cursor: pointer; '>\r\n"
				+ "                  \r\n"
				+ "               \r\n"
				+ "\r\n"
				+ "                \r\n"
				+ "                        <a style='text-decoration: none ;color:#2f3569;'  class='' id='dangnhap1'><i class='bx bx-user font-weight-bold'></i> "+ten+"</a>\r\n"
				+ "                        <a style='text-decoration: none;color:#2f3569'  class='dancach1 ' id='outtkbay1' ><i class='bx bxs-plane-alt font-weight-bold'></i> Chuyến bay</a>\r\n"
				+ "       \r\n"
				+ "                    \r\n"
				+ "                </div>\r\n"
				+ "                \r\n"
				+ "   \r\n"
				+ "                <form action='' class='form dangky' id='dangky-menu'>\r\n"
				+ "                    \r\n"
				+ "                    <div class='form__out'>\r\n"
				+ "                        <br>                       \r\n"
				+ "                     </div>\r\n"
				+ "                    <div class='form__div'>\r\n"
				+ "                    \r\n"
				+ "                        <input type='text' name='email' class='form__input' required placeholder=' '>\r\n"
				+ "                        <label for='' class='form__label'>Email</label>\r\n"
				+ "                    </div>\r\n"
				+ "                    <div class='form__div'>\r\n"
				+ "                        <input type='text' name='sdt' class='form__input' required placeholder=' '>\r\n"
				+ "                        <label for='' class='form__label'>Số điện thoại</label>\r\n"
				+ "                    </div>\r\n"
				+ "                    <div class='form__div'>\r\n"
				+ "                        <input type='text' name='iddangky' class='form__input' required placeholder=' '>\r\n"
				+ "                        <label for='' class='form__label'>Tên ID</label>\r\n"
				+ "                    </div>\r\n"
				+ "    \r\n"
				+ "                    <div class='form__div'>\r\n"
				+ "                        <input type='password' name='mkdangky' class='form__input' required  placeholder=' '>\r\n"
				+ "                        <label for='' class='form__label'>Mật khẩu</label>\r\n"
				+ "                    </div>\r\n"
				+ "    \r\n"
				+ "                  \r\n"
				+ " <button class='btn btn-primary btn-block mt-3' id='dangnhap3' style='width: 240px;'>Đăng ký</button>\r\n"
				+ "                    </form>\r\n"
				+htmldn
				+ "         \r\n"
				+ "  \r\n"
				+ "                    <form method='GET' action ='trangchu#Booking'class='tkbay' id='tkbay'  >\r\n"
				+ "                        <div>\r\n"
				+ "                           <br>                    \r\n"
				+ "                         </div>\r\n"
				+ "\r\n"
				+ "                        <div class='the shadow mb-5 bg-white rounded'>\r\n"
				+ "                            <div class='the-body'>\r\n"
				+ "                                <p class='the-title text-center shadow mb-5 rounded' style='background-color: #2f3569;'>Tìm chyến bay</p>\r\n"
				+ "                                <div class='icons text-center'>\r\n"
				+ "                                    <i class='bx bxs-plane ' style='color:#c1c9da;font-size: 30px;'></i>\r\n"
				+ "                                <hr>\r\n"
				+ "                              \r\n"
				+ "                                <div class='row mb-3 mt-3'>  <label class='radiobtn' style='color:#10505b'><input type='checkbox' name='gender' value='male' style='color:#10505b'>Khứ hồi</label> </div>\r\n"
				+ "                                <div class='row'>\r\n"
				+ "                                    <div class='col-sm-6' > <select name='gadi' class='browser-default custom-select mb-4' id='select' required style='color:#10505b'>\r\n"
				+ "                                            <option value='' disabled='' selected='' name='gadi' style='color:#10505b'>Gas đi</option>\r\n"
				+ "                                            <option value='DAD' style='color:#777a80'>DAD</option>\r\n"
				+ "                                            <option value='HAN' style='color:#777a80'>HAN</option>\r\n"
				+ "                                            <option value='SGN' style='color:#777a80'>SGN</option>\r\n"
				+ "                                        </select> </div>\r\n"
				+ "                                    <div class='col-sm-6'> <select name='gaden' class='browser-default custom-select mb-4' id='select' required style='color:#10505b'>\r\n"
				+ "                                            <option value='' disabled='' selected='' style='color:#10505b' >Gas đến</option>\r\n"
				+ "                                            <option value='DAD' style='color:#777a80'>DAD</option>\r\n"
				+ "                                            <option value='HAN' style='color:#777a80'>HAN</option>\r\n"
				+ "                                            <option value='SGN' style='color:#777a80'>SGN</option>\r\n"
				+ "                                        </select> </div>\r\n"
				+ "                                </div>\r\n"
				+ "                                <div class='row' >\r\n"
				+ "                                    <div class='col-sm-6' style='color:#10505b'> <input  type='date'  placeholder='mm/dd/yyyy' class='form-control datepicker'  style='font-family:Arial, FontAwesome; color:#10505b'> </div>\r\n"
				+ "                                    <div class='col-sm-6' style='color:#10505b'> <input type='date'  placeholder='mm/dd/yyyy' class='form-control datepicker'  style='font-family:Arial, FontAwesome; color:#10505b'> </div>\r\n"
				+ "                                </div>\r\n"
				+ "                                <div class='row mt-4'>\r\n"
				+ "                                    <div class='col-sm-6'> <select class='browser-default custom-select mb-4' id='select' style='color:#10505b'>\r\n"
				+ "                                            <option value='' disabled='' selected='' color:#777a80>Thời gian</option>\r\n"
				+ "                                            <option value='1' style='color:#10505b'>4:00 AM</option>\r\n"
				+ "                                            <option value='2'style='color:#10505b'>3:00 PM</option>\r\n"
				+ "                                            <option value='3' style='color:#10505b'>8:00 PM</option>\r\n"
				+ "                                        </select> </div>\r\n"
				+ "                                    <div class='col-sm-6'> <select class='browser-default custom-select mb-4' id='select' style='color:#10505b'>\r\n"
				+ "                                            <option value='' disabled='' selected='' color:#777a80>Thời gian</option>\r\n"
				+ "                                            <option value='1' style='color:#10505b'>4:00 AM</option>\r\n"
				+ "                                            <option value='2' style='color:#10505b'>4:00 PM</option>\r\n"
				+ "                                            <option value='3' style='color:#10505b'>10:00 PM</option>\r\n"
				+ "                                        </select> </div>\r\n"
				+ "                                </div>\r\n"
				+ "                                <div class='row'>\r\n"
				+ "                                    <div class='col-sm-4'> <select class='browser-default custom-select mb-4' id='select' style='color:#10505b'>\r\n"
				+ "                                            <option value='' disabled='' selected=''>Trẻ(0-14)</option>\r\n"
				+ "                                            <option value='1'>0</option>\r\n"
				+ "                                            <option value='2'>1</option>\r\n"
				+ "                                            <option value='3'>2</option>\r\n"
				+ "                                            <option value='3'>3</option>\r\n"
				+ "                                        </select> </div>\r\n"
				+ "                                    <div class='col-sm-4'> <select class='browser-default custom-select mb-4' id='select' style='color:#10505b'>\r\n"
				+ "                                            <option value='' disabled='' selected=''>Lớn(15-60)</option>\r\n"
				+ "                                            <option value='1'>0</option>\r\n"
				+ "                                            <option value='2'>1</option>\r\n"
				+ "                                            <option value='3'>2</option>\r\n"
				+ "                                            <option value='3'>3</option>\r\n"
				+ "                                        </select> </div>\r\n"
				+ "                                    <div class='col-sm-4'> <select class='browser-default custom-select mb-4' id='select' style='color:#10505b'>\r\n"
				+ "                                            <option value='' disabled='' selected=''>Già(>60)</option>\r\n"
				+ "                                            <option value='1'>0</option>\r\n"
				+ "                                            <option value='2'>1</option>\r\n"
				+ "                                            <option value='3'>2</option>\r\n"
				+ "                                            <option value='3'>3</option>\r\n"
				+ "                                        </select> </div>\r\n"
				+ "                                </div> <button   class='btn btn-primary float-bottom mt-5' onclick='myFunction1()' value='submit' style='margin-bottom: 5px;margin-top: -10px;'>Tìm kiếm</button>\r\n"
				+ "                            \r\n"
				+ "                            </div>\r\n"
				+ "                  \r\n"
				+ "               \r\n"
				+ "\r\n"
				+ "                    </form>\r\n"
				+ "   \r\n"
				+ "                \r\n"
				+ "                   \r\n"
				+ "  \r\n"
				+ "                \r\n"
				+ "            </nav>\r\n"
				+ "\r\n"
				+ "            <nav1>\r\n"
				+ "                <form action='#' >\r\n"
				+ "                    <div class='thanhtoan' id='thanhtoan'>\r\n"
				+ "                        <div class='container d-flex justify-content-center mt-5'>\r\n"
				+ "                            <div class='card'>\r\n"
				+ "                                <div>\r\n"
				+ "                                    <div class='d-flex pt-3 pl-3'>\r\n"
				+ "                                        <div type='margin-left:10px'><img src='anh/qr.png' width='100' height='100' style=' border-radius: 4px'/></div>\r\n"
				+ "                                        <div class='mt-3 pl-2'><span class='name' >"+ten+"</span>\r\n"
				+ "                                            <div><span class='cross'><div class='namett' ></div></span></div>\r\n"
				+ "												<input type='hidden' name='tttenks' id='tttenks'></input>"
				+ "                                        </div>\r\n"
				+ "                                    </div>\r\n"
				+ "                                    <div class='py-2 px-3'>\r\n"
				+ "                                        <div class='first pl-2 d-flex py-2'>\r\n"
				+ "                                            <div class='form-check'> <input type='radio' name='optradio' class='form-check-input mt-3 dot' checked> </div>\r\n"
				+ "                                            <div class='border-left pl-2'><span class='head'>Tổng tiền trả</span>\r\n"
				+ "                                                <div><span class='amount'> <div class='resulttt' ></div></span></div>\r\n"
				+"												<input type='hidden' name='giaks' id='giaks'></input>"
				+ "                                            </div>\r\n"
				+ "                                        </div>\r\n"
				+ "                                    </div>\r\n"
				+ "                                    <div class='py-2 px-3'>\r\n"
				+ "                                        <div class='second pl-2 d-flex py-2'>\r\n"
				+ "                                            <div class='form-check'> <input type='checkbox' name='optradio' class='form-check-input mt-3 dot'> </div>\r\n"
				+ "                                            <div class='border-left pl-2'><span class='head'>số cmnd</span>\r\n"
				+ "                                                <div class='d-flex'><span class='tien'>CMND</span><input name='cmnd' type='text'  class='form-control ml-1' placeholder='0'></div>\r\n"
				+ "                                            </div>\r\n"
				+ "                                        </div>\r\n"
				+ "                                    </div>\r\n"
				+ "                                    <div class='d-flex justify-content-between px-3 pt-4 pb-3'>\r\n"
				+ "                                        <div><span class='back' style='cursor: pointer;' id='thoattt'>Thoát</span></div> <button  class='btn btn-primary button'>Thanh toán</button>\r\n"
				+ "                                    </div>\r\n"
				+ "                                </div>\r\n"
				+ "                            </div>\r\n"
				+ "                        </div>\r\n"
				+ "\r\n"
				+ "                    </div>\r\n"
				+ "                </form>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "            </nav1>\r\n"
				+ "        </header>\r\n"
				+ "\r\n"
				+ "    \r\n"
				+ "            <main>\r\n"
+"                <section>\r\n"
+ "                    <div class='home'>   \r\n"
+ "                        \r\n"
+ "                        <div class='parallax home__parallax home__parallax-img2 may1' data-rellax-speed='-3' ></div>\r\n"
+ "                        <div class='parallax home__parallax home__parallax-img3 may2 ' data-rellax-speed='0.15'></div>\r\n"
+ "                       \r\n"
+ "                         <div class='tencty'>\r\n"
+ "\r\n"
+"<h1 class='parallax home__title headerx' data-rellax-speed='-2.2'  ><a style='background-color: rgba(195, 209, 71, 0.219);border-radius: 12px;'>Goool</a>loser </h1>\r\n"
+ "                      <span class=\"parallax home__subtitle\" data-rellax-speed=\"-2.1\">Khám phá với những</br> điều mới mẻ </span> "
+ "                                       \r\n"
+ "                         </div >\r\n"
+ "                </div>\r\n"
+ "                </section>"
				+"           <section class='container ' id='Booking' >\r\n"
				+ "                    <div style='padding-left: 30px;padding-top: 70px;'>\r\n"
				+ "                    <h3><a style='background-color: #29068b;padding: 5px;border-radius: 10px;cursor:pointer;color: #ffffff;'  onclick='myFunction2()'>Tìm kiếm</a> chuyến bay mà bạn muốn  "
				+ "\r\n"
				+ "                    </h3>\r\n"
				+ "                    <p>TÌM KIẾM NHỮNG CHUYẾN BAY VỚI NHỮNG MỨC GIÁ HẤP DẪN</p>\r\n"
				+ "                \r\n"
				+ "\r\n"
				+ "                </div>\r\n"
				+ "\r\n"
				+ "                </section>"
				
				+ "                                          <section class='container contact section header2' >\r\n"
		
				+ "                                        <div class='container bannery  banner1 ' id='banner_id1' >\r\n"
				+ "  \r\n"
				+ "                                            \r\n"
				+ "                                            <div class='quan'>\r\n"
				+ "                                            \r\n"
				+htmlBay
				+ "                                                \r\n"
				+ "                                                </div>\r\n"
				+ "                                                \r\n"
				+ "                    \r\n"
				+ "\r\n"
				+ "\r\n"
				+ "              \r\n"
				+ "\r\n"
				+ "                                        </section>\r\n"
				+ "\r\n"
				+ "        \r\n"
				+ "       \r\n"
				+ "     \r\n"
+"          <section class='container 'id ='yasuo' >\r\n"
+ "                <div style='padding-left: 30px;padding-top: 50px;'>\r\n"
+ "                <h3>Tìm hiểu thêm những gì là tốt nhất</h3>\r\n"
+ "                <p>CHÚNG TÔI ĐỒNG HÀNH CÙNG BẠN <a style='background-color: #29068b;padding: 5px;border-radius: 8px;cursor:pointer;color: #ffffff;text-decoration: none' href='homestay/summer.html#vungbien' >TÌM HIÊU THÊM </a><p>\r\n"
+ "            </div>\r\n"
+ "            </section>"
				+ "\r\n"
				+"      <section class='container   banner3 '  >\r\n"
				+ "                <div id='myCarousel' class='carousel slide carousel-fade' data-ride='carousel'>\r\n"
				+ "                    <div class='carousel-inner'>\r\n"
				+ "                        <div class='carousel-item active'>\r\n"
				+ "                            <div class='mask flex-center'  style='background-image:url(css/anime7.jpg);border-radius: 12px;'>\r\n"
				+ "                                <div class='container'>\r\n"
				+ "                                    <div class='row align-items-center'>\r\n"
				+ "                                        <div class='col-md-7 col-12 order-md-1 order-2'>\r\n"
				+ "             \r\n"
				+ "                                            <h4>Vùng biển</h4>\r\n"
				+ "                                            <p>Biển là sự lựa chọn hàng đầu nếu bạn thích hải sản và tắm nắng</p> <br> <a href='homestay/summer.html#vungbien' >TÌM HIỂU THÊM</a>\r\n"
				+ "                                        </div>\r\n"
				+ "                                        <div class='col-md-5 col-12 order-md-2 order-1'></div>\r\n"
				+ "                                    </div>\r\n"
				+ "                                </div>\r\n"
				+ "                            </div>\r\n"
				+ "                        </div>\r\n"
				+ htmlbn
				+ "                    </div> <a class='carousel-control-prev' href='#myCarousel' role='button' data-slide='prev'> <span class='carousel-control-prev-icon' aria-hidden='true'></span> <span class='sr-only'></span> </a> <a class='carousel-control-next' href='#myCarousel' role='button' data-slide='next'> <span class='carousel-control-next-icon' aria-hidden='true'></span> <span class='sr-only'></span> </a>\r\n"
				+ "                </div>\r\n"
				+ "            </section>"
				+ "            \r\n"
				+ "           \r\n"
				+ "         \r\n"
				+ "        \r\n"
				+"          <section class='container '  id ='bannerkhachsan' >\r\n"
				+ "                <div style='padding-left: 30px;padding-top: 50px;'>\r\n"
				+ "                <h3>Hãy nói cho chúng tôi</h3>\r\n"
				+ "                <p>NƠI BẠN SẮP ĐẾN VÀ CHÚNG TÔI SẼ GIÚP BẠN TÌM NƠI NGHỈ NGƠI<p>\r\n"
				+ "            </div>\r\n"
				+ "            </section>"
				
				+"            <section class='container  bannerx' >\r\n"
				+ "                <div class='container px-4  '>\r\n"
				+ "                    <div class='row gx-2 '>\r\n"


				+htmlks
				+ "                    </div>\r\n"
				+ "                    \r\n"
				+ "                  </div>\r\n"
				+ "                \r\n"
				+ "            </section>"
				
				+ "\r\n"
				+ "\r\n"
				+ "            <section class='yasuo1'  >\r\n"
				+ "\r\n"
				+ "                <div class='chungtoi' id='about'>\r\n"
				+ "                    <h2 class='about__subtitle'>We're Team Good Loser</h2>\r\n"
				+ "                    <span class='about__profession'>Best Web Design-2021</span>\r\n"
				+ "    \r\n"
				+ "                    <p class='about__text'>Sản phẩm được tạo ra bởi team Gloser Đại Học CNTT & TT Việt Hàn </p>\r\n"
				+ "                    <p class='about__text'> Tất cả hình ảnh trong bài làm đều được lấy ở pexel.com là một trang web hoàn toàn miễn phí sử dụng ảnh ảnh </p>\r\n"
				+ "                    <p class='about__text'>Các công nghệ sử dụng trong trang web bao gồm #rellax.js #bootstrap5 #scrollreveal.js #jQuery.js  trang web được thực hiện để người dùng dễ dàng đưa nội dung lên web</p>\r\n"
				+ "       \r\n"
				+ "                    <p class='about__text'>Hãy thử ấn    nút    tìm    kiếm    chuyến    bay    nếu    bạn    chưa    ấn   -   -   cảm    ơn    đã    xem    bài    mọi    thắc    mắt    xin    gửi    về    nvdu.20it6@vku.udn.vn'</p>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "                    <div class='about__social'>\r\n"
				+ "                        <a href='https://github.com/vietdu/nbanbi' class='about__social-icon' target='_blank'><i class='bx bxl-linkedin' ></i></a>\r\n"
				+ "                        <a href='https://github.com/vietdu/nbanbi' class='about__social-icon' target='_blank'><i class='bx bxl-facebook-circle'></i></a>\r\n"
				+ "                        <a href='https://github.com/vietdu/nbanbi' class='about__social-icon' target='_blank'><i class='bx bxl-github'></i></a>\r\n"
				+ "                    </div>\r\n"
				+ "                </div>\r\n"
				+ "\r\n"
				+ "            </section>\r\n"
				+ "\r\n"
				+ "    \r\n"
				+ "           \r\n"
				+ "    \r\n"
				+ "            <script src='https://cdnjs.cloudflare.com/ajax/libs/rellax/1.12.1/rellax.min.js'></script>\r\n"
				+ "    \r\n"
				+ "           \r\n"
				+ "    \r\n"
				+ "            <script src='https://unpkg.com/scrollreveal@4.0.9/dist/scrollreveal.min.js'></script>\r\n"
				+ "\r\n"
				+ "            <script >\r\n"
				+ "                \r\n"
				+ "const navMenu = document.getElementById('nav-menu'),\r\n"
				+ "\r\n"
				+ "toggleMenu = document.getElementById('nav-toggle'),\r\n"
				+ "\r\n"
				+ "dangnhapMenu = document.getElementById('dangnhap-menu'),\r\n"
				+ "dangnkyMenu = document.getElementById('dangky-menu'),\r\n"
				+ "hienthibay=document.getElementById('tkbay'),\r\n"
				+ "hienthithanhtoan=document.getElementById('thanhtoan'),\r\n"
				+ "\r\n"
				+ "closedangnhap=document.getElementById('dangnhap'),\r\n"
				+ "closedangnhap1=document.getElementById('dangnhap1'),\r\n"
				+ "closetkbay1=document.getElementById('outtkbay1'),\r\n"
				+ "closedangnhap2=document.getElementById('dangnhap2'),\r\n"
				+ "closedangnhap3=document.getElementById('dangnhap3')\r\n"
				+ jQtt1
				+jQtt2
				+jQbay1
				+jQbay2
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "thoattt=document.getElementById('thoattt')\r\n"

				+ "\r\n"
				+ "\r\n"
				+ "thoattt.addEventListener('click', ()=>{\r\n"
				+ "  hienthithanhtoan.classList.remove('thanhtoanshow')\r\n"
				+ "})\r\n"
				+ "\r\n"
				+ "\r\n"
				
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "toggleMenu.addEventListener('click', ()=>{\r\n"
				+ "navMenu.classList.toggle('show')\r\n"
				+ "})\r\n"
				+ "closedangnhap.addEventListener('click', ()=>{\r\n"
				+ "dangnhapMenu.classList.add('showdangnhap')\r\n"
				+ "\r\n"
				+ "})\r\n"
				+ "closedangnhap1.addEventListener('click', ()=>{\r\n"
				+ "\r\n"
				+ "dangnhapMenu.classList.remove('showdangnhap')\r\n"
				+ "})\r\n"
				+ "closedangnhap2.addEventListener('click', ()=>{\r\n"
				+ "dangnhapMenu.classList.toggle('andangnhap'),\r\n"
				+ "dangnkyMenu.classList.remove('dangky')\r\n"
				+ "})\r\n"
				+ "closedangnhap3.addEventListener('click', ()=>{\r\n"
				+ "dangnhapMenu.classList.toggle('andangnhap'),\r\n"
				+ "dangnkyMenu.classList.add('dangky'),\r\n"
				+ "dangnhapMenu.classList.remove('andangnhap')\r\n"
				+ "})\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "closetkbay1.addEventListener('click', ()=>{\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "hienthibay.classList.remove('dangky'),\r\n"
				+ "hienthibay.classList.remove('andangnhap'),\r\n"
				+ "dangnhapMenu.classList.add('showdangnhap')\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "})\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "var rellax = new Rellax('.parallax');\r\n"
				+ "const srr = ScrollReveal({\r\n"
				+ "origin: 'top',\r\n"
				+ "distance: '80px',\r\n"
				+ "duration: 2000,\r\n"
				+ "reset: true\r\n"
				+ "})\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "document.addEventListener('mousemove', move);\r\n"
				+ "function move(e){\r\n"
				+ "this.querySelectorAll('.vietdu').forEach(layer =>{\r\n"
				+ "\r\n"
				+ "    const speed =layer.getAttribute('data-speed')\r\n"
				+ "\r\n"
				+ "    const x = (-window.innerWidth  -e.pageX*speed)/240\r\n"
				+ "    const y = (-window.innerWidth  -e.pageY*speed)/120\r\n"
				+ "\r\n"
				+ "    layer.style.transform = `translateX(${x}px) translateY(${y}px)`\r\n"
				+ "})\r\n"
				+ "\r\n"
				+ "}\r\n"
				+ "const srr1 = ScrollReveal({\r\n"
				+ "origin: 'left',\r\n"
				+ "distance: '80px',\r\n"
				+ "duration: 2000,\r\n"
				+ "reset: this,\r\n"
				+ "})\r\n"
				+ "\r\n"
				+ "srr1.reveal('.form_bn2', {delay: 450})\r\n"
				+ "\r\n"
				+ "const srr2 = ScrollReveal({\r\n"
				+ "origin: 'right',\r\n"
				+ "distance: '80px',\r\n"
				+ "duration: 2000,\r\n"
				+ "reset: this,\r\n"
				+ "})\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "srr2.reveal('.form_bn3', {delay: 450})\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "srr.reveal('.about__img', {delay: 500})\r\n"
				+ "srr.reveal('.about__subtitle', {delay: 350})\r\n"
				+ "srr.reveal('.about__profession', {delay: 400})\r\n"
				+ "srr.reveal('.about__text', {delay: 500})\r\n"
				+ "srr.reveal('.about__social-icon', {delay: 600, interval: 200})\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "window.onscroll = function() {myFunction()};\r\n"
				+ "\r\n"
				+ "var header2 = document.getElementById(\"myheader2\");\r\n"
				+ "var sticky = header2.offsetTop;\r\n"
				+ "var w = window.innerWidth;\r\n"
				+ "\r\n"
				+ "var banner2 = document.getElementById(\"banner_id2\");\r\n"
				+ "var banner_zom2 = banner2.offsetTop;\r\n"
				+ "var banner3 = document.getElementById(\"banner_id3\");\r\n"
				+ "var banner_zom3 = banner3.offsetTop;\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "srr.reveal('.contact__subtitle', {})\r\n"
				+ "srr.reveal('.contact__text', {interval: 200})\r\n"
				+ "srr.reveal('.contact__input', {delay: 400})\r\n"
				+ "srr.reveal('.contact__button', {delay: 600})\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "gsap.from('.nav__logo', {opacity:0, duration: 3, delay: .7, y: 30, ease:'expo.out'});\r\n"
				+ "gsap.from('.nav__toggle', {opacity:0, duration: 3, delay: .7, y: 30, ease:'expo.out'});\r\n"
				+ "gsap.from('.nav__item', {opacity: 0, duration: 3, delay: .7, y: 35, ease:'expo.out', stagger: .2})\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "gsap.from('.home__subtitle', {opacity:0, duration: 3, delay: 1.1 , y: 35, ease:'expo.out'});\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "gsap.from('.home__scroll', {opacity:0, duration: 3, delay: 1.5, y: 25, ease:'expo.out'});\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "const sr = ScrollReveal({\r\n"
				+ "duration: 2500,\r\n"
				+ "reset: true\r\n"
				+ "});\r\n"
				+ "\r\n"
				+ "sr.reveal('.section__data',{origin: 'left',distance: '70px'}); \r\n"
				+ "\r\n"
				+ "sr.reveal('.section__img',{origin: 'left',distance: '90px',delay: 200}); \r\n"
				+ "\r\n"

				+ "function myFunction2() {\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "navMenu.classList.add('show')\r\n"
				+ "\r\n"
				+ "}\r\n"
				+ "function myFunction3() {\r\n"
				+ "\r\n"
				+ "location.href = \"#Booking\";\r\n"
				+ "}\r\n"
				+ "function myFunction4() {\r\n"
				+ "\r\n"
				+ "location.href = \"#bannerkhachsan\";\r\n"
				+ "}\r\n"
	
				+ "$(document).ready(function() {\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "if ($('.bbb_deals_slider').length) {\r\n"
				+ "var bbb_dealsSlider = $('.bbb_deals_slider');\r\n"
				+ "bbb_dealsSlider.owlCarousel({\r\n"
				+ "items: 1,\r\n"
				+ "loop: false,\r\n"
				+ "navClass: ['bbb_deals_slider_prev', 'bbb_deals_slider_next'],\r\n"
				+ "nav: false,\r\n"
				+ "dots: false,\r\n"
				+ "smartSpeed: 1200,\r\n"
				+ "margin: 30,\r\n"
				+ "autoplay: false,\r\n"
				+ "autoplayTimeout: 5000\r\n"
				+ "});\r\n"
				+ "\r\n"
				+ "if ($('.bbb_deals_slider_prev').length) {\r\n"
				+ "var prev = $('.bbb_deals_slider_prev');\r\n"
				+ "prev.on('click', function() {\r\n"
				+ "bbb_dealsSlider.trigger('prev.owl.carousel');\r\n"
				+ "});\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "if ($('.bbb_deals_slider_next').length) {\r\n"
				+ "var next = $('.bbb_deals_slider_next');\r\n"
				+ "next.on('click', function() {\r\n"
				+ "bbb_dealsSlider.trigger('next.owl.carousel');\r\n"
				+ "});\r\n"
				+ "}\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "if ($('.bbb_deals_timer_box').length) {\r\n"
				+ "var timers = $('.bbb_deals_timer_box');\r\n"
				+ "timers.each(function() {\r\n"
				+ "var timer = $(this);\r\n"
				+ "\r\n"
				+ "var targetTime;\r\n"
				+ "var target_date;\r\n"
				+ "\r\n"
				+ "if (timer.data('target-time') !== \"\") {\r\n"
				+ "targetTime = timer.data('target-time');\r\n"
				+ "target_date = new Date(targetTime).getTime();\r\n"
				+ "} else {\r\n"
				+ "var date = new Date();\r\n"
				+ "date.setDate(date.getDate() + 2);\r\n"
				+ "target_date = date.getTime();\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "var days, hours, minutes, seconds;\r\n"
				+ "\r\n"
				+ "var h = timer.find('.bbb_deals_timer_hr');\r\n"
				+ "var m = timer.find('.bbb_deals_timer_min');\r\n"
				+ "var s = timer.find('.bbb_deals_timer_sec');\r\n"
				+ "\r\n"
				+ "setInterval(function() {\r\n"
				+ "\r\n"
				+ "var current_date = new Date().getTime();\r\n"
				+ "var seconds_left = (target_date - current_date) / 1000;\r\n"
				+ "console.log(seconds_left);\r\n"
				+ "\r\n"
				+ "days = parseInt(seconds_left / 86400);\r\n"
				+ "seconds_left = seconds_left % 86400;\r\n"
				+ "\r\n"
				+ "hours = parseInt(seconds_left / 3600);\r\n"
				+ "hours = hours + days * 24;\r\n"
				+ "seconds_left = seconds_left % 3600;\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "minutes = parseInt(seconds_left / 60);\r\n"
				+ "seconds = parseInt(seconds_left % 60);\r\n"
				+ "\r\n"
				+ "if (hours.toString().length < 2) { hours=\"0\" + hours; } if (minutes.toString().length < 2) { minutes=\"0\" + minutes; } if (seconds.toString().length < 2) { seconds=\"0\" + seconds; } }); }); } });\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "            </script>\r\n"
				+ "\r\n"
				+ "            <script src='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js'></script>       \r\n"
				+ "   \r\n"
				+ "\r\n"
				+ "    </body>\r\n"
				+ "</html>";
		
	pw.println(html);
	System.out.println("-----------------------------------------------------------------------------------------");
	System.out.println(html);
			
	}

	
}