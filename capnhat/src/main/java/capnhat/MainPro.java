package capnhat;

import java.util.List;

import capnhat.BookDAO;
import capnhat.Book;
import capnhat.ReadFromExcelFile;
 
public class MainPro {
     
    public static void main(String[] args) {
    	while(true) {
    
        try {
        	Thread.sleep(10000);
            String excelFilePath = "C:/Users/nbanbi94/Desktop/javapro/danhsachchuyenbay.xls";
            System.out.println(0);
             
            List<Book> listBooks = new ReadFromExcelFile().readBooksFromExcelFile(excelFilePath);
            System.out.println(1);
            BookDAO bookDAO = new BookDAO();
            System.out.println(2);
            bookDAO.insertListBooks(listBooks);
             
        } catch (Exception e) {
            System.out.println("biloi: " + e.getMessage());
        }
    	}
    }
    
     
}