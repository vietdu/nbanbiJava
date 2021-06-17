package user;

import java.util.List;


 
public class MainPro {
     
    public static void main(String args[]){
        try {
             
         
            String excelFilePath = "C:/Users/nbanbi94/Desktop/javapro/chuyenbay.xls";
             
            List<datphong> listBooks = new ReadFromExcelFile().readBooksFromExcelFile(excelFilePath);
            themdatphong bookDAO = new themdatphong();
            bookDAO.insertListBooks(listBooks);
             
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
     
}
