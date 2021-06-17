package capnhat;

public class Book {
    
    private double id;
    private String tenhang;
    private String batdau;
    private String tendb;
    private double soluong;
    private String gia;
     
    public Book() {
         
    }
     
    public Book( double id, String tenhang, String batdau, String tendb,double soluong ,String gia) {
        this.id = id;
        this.tenhang = tenhang;
        this.batdau=batdau;
        this.tendb = tendb;
        this.soluong = soluong;
        this.gia = gia;
    }
   
 
    public double getId() {
        return id;
    }
 
    public void setId(double id) {
        this.id = id;
    }
 
    public String getTenhang() {
        return tenhang;
    }
 
    public void setTenhang(String tenhang) {
        this.tenhang = tenhang;
    }
    
    public String getBatdau() {
    	return batdau;
    }
    public void setBatdau(String batdau) {
    	this.batdau = batdau;
    }
    public String getTendb() {
    	return tendb;
    }
    public void setTendb(String tendb) {
    	this.tendb=tendb;
    }
    public void setSoluong( double  soluong) {
    	this.soluong=soluong;
    }
    public double getSoluong() {
    	return soluong;
    }
  
    public String getGia() {
    	return gia;
    }
    public void setGia( String gia) {
    	this.gia=gia;
    }
     
}