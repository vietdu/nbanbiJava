package user;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 

 
public class ReadFromExcelFile {
     
    public List<datphong> readBooksFromExcelFile(String excelFilePath) throws IOException {
        List<datphong> listBooks = new ArrayList<datphong>();
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
         
        Workbook workBook = getWorkbook(inputStream, excelFilePath);
        Sheet firstSheet = workBook.getSheetAt(0);
        Iterator<Row> rows = firstSheet.iterator();
         
        while (rows.hasNext()) {
            Row row = rows.next();
            Iterator<Cell> cells = row.cellIterator();
            datphong book = new datphong();
             
            while (cells.hasNext()) {
                Cell cell = cells.next();
                int columnIndex = cell.getColumnIndex();
                 
                switch (columnIndex) {
                    case 0:
                        book.setTenhang((String) getCellValue(cell));
                        break;
                    case 1:
                        book.setBatdau((String) getCellValue(cell));
                        break;
                    case 2:
                        book.setTendb((String) getCellValue(cell));
                        break;
                    case 3:
                    	book.setSoluong((int) getCellValue(cell));
                    	break;
                     case 4:
                        book.setGia((String) getCellValue(cell));
                         break;
                }
            }
            listBooks.add(book);
        }
         
        workBook.close();
        inputStream.close();
         
        return listBooks;
    }
     
    private Object getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
      
            case BOOLEAN:
                return cell.getBooleanCellValue();
      
            case NUMERIC:
                return cell.getNumericCellValue();
        }
      
        return null;
    }
     
    private Workbook getWorkbook(FileInputStream inputStream, String excelFilePath) throws IOException {
        Workbook workbook = null;
      
        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }
      
        return workbook;
    }
     
}
