package exelChuyenbay;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
 
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
 
public class ReadExcelDemo {
 
   public static void main(String[] args) throws IOException {
  
    
       FileInputStream inputStream = new FileInputStream(new File("C:/demo/employee.xls"));

       HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
 
  
 
       HSSFSheet sheet = workbook.getSheetAt(0);
 
  
       Iterator<Row> rowIterator = sheet.iterator();
 
       while (rowIterator.hasNext()) {
           Row row = rowIterator.next();
 
           Iterator<Cell> cellIterator = row.cellIterator();
 
           while (cellIterator.hasNext()) {
               Cell cell = cellIterator.next();
  
    
               CellType cellType = cell.getCellTypeEnum();
 
               switch (cellType) {
               case _NONE:
                   System.out.print("");
                   System.out.print("\t");
                   break;
               case BOOLEAN:
                   System.out.print(cell.getBooleanCellValue());
                   System.out.print("\t");
                   break;
               case BLANK:
                   System.out.print("");
                   System.out.print("\t");
                   break;
               case FORMULA:
       
      
                   System.out.print(cell.getCellFormula());
                   System.out.print("\t");
                    
                   FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
         
           
                   System.out.print(evaluator.evaluate(cell).getNumberValue());
                   break;
               case NUMERIC:
                   System.out.print(cell.getNumericCellValue());
                   System.out.print("\t");
                   break;
               case STRING:
                   System.out.print(cell.getStringCellValue());
                   System.out.print("\t");
                   break;
               case ERROR:
                   System.out.print("!");
                   System.out.print("\t");
                   break;
               }
 
           }
           System.out.println("");
       }
   }
 
}