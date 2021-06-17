package Maybay;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
 


 
public class themdatphong {
     
    private Connection conn;
    private PreparedStatement ps;
     
    public void insertListBooks(List<datphong> listBooks) {
        try {

            conn.setAutoCommit(false);
             
            String sql = "INSERT INTO chuyenbay(tenhang, batdau, tendb, soluong, gia) VALUES (?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
             
            for (datphong book : listBooks) {
                ps.setString(1, book.getTenhang());
                ps.setString(2, book.getBatdau());
                ps.setString(3, book.getTendb());
                ps.setInt(4, book.getSoluong());
                ps.setString(5, book.getGia());
                ps.addBatch();
            }
             
            ps.executeBatch();
             
            // Gọi commit() để commit giao dịch với DB
            conn.commit();
             
            System.out.println("Record is inserted into BOOK table!");
             
        } catch (Exception e) {
             
            e.printStackTrace();

             
        } finally {
             
            try {
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
             
        }
    }
     
}
