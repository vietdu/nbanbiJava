package capnhat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
 
import capnhat.Book;
import capnhat.MySQLConnectionUtils;

 
public class BookDAO {
     
    private Connection conn;
    private PreparedStatement ps;
     
    public void insertListBooks(List<Book> listBooks) {
        try {
            conn = MySQLConnectionUtils.connect();
            // Sét tự động commit false, để chủ động điều khiển
            conn.setAutoCommit(false);
             
            String sql = "INSERT INTO chuyenbay(id, tenhang, batdau, tendb,soluong, gia) VALUES (?, ?,?, ?, ?, ?)";
            String desql="delete from chuyenbay";
            Connection con = MySQLConnectionUtils.connect();
            PreparedStatement deps = con.prepareStatement(desql);
            int rows = deps.executeUpdate();
            ps = conn.prepareStatement(sql);
             
            for (Book book : listBooks) {
                ps.setDouble(1, book.getId());
                ps.setString(2, book.getTenhang());
                ps.setString(3, book.getBatdau());
                ps.setString(4, book.getTendb());
                ps.setDouble(5, book.getSoluong());
                ps.setString(6, book.getGia());
          
                ps.addBatch();
            }
            
            ps.executeBatch();
             
            conn.commit();
            
            System.out.println("Thay doi thanh cong :vv!");
             
        } catch (Exception e) {
             
            e.printStackTrace();
            MySQLConnectionUtils.rollbackQuietly(conn);
             
        } finally {
             
            try {
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
             
            MySQLConnectionUtils.disconnect(conn);
        }
    }
     
}