package Maybay;

public class datphong {
    
    private int id;
    private String tenhang;
    private String batdau;
    private String tendb;
    private int soluong;
    private String gia;
     
    public datphong() {
         
    }
     
    public datphong(String tenhang, String batdau, String tendb, int soluong, String gia) {
        this.tenhang =tenhang;
        this.batdau = batdau;
        this.tendb = tendb;
        this.soluong = soluong;
        this.gia = gia;
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
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
  
    public String getGia() {
        return gia;
    }
    public void setTendb(String tendb) {
        this.tendb = tendb;
    }
  
    public String getTendb() {
        return tendb;
    }
    public void setGia(String gia) {
        this.gia = gia;
    }
 
    public int getSoluong() {
        return soluong;
    }
 
    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
     
}