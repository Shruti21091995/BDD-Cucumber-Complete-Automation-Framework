package Utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

public class ExcelReaderUtils 
{
 WebDriver driver;
  public static Workbook wb;
  public static FileInputStream fis;
  public static Sheet sheet;
  public static FileOutputStream fos;
  
  public void SetExcelFilePath(String path,String sheetName) throws IOException 
  {
	  //load the excel file 
	  fis=new FileInputStream(path);
	  //load the excel file in workbook
	  wb=WorkbookFactory.create(fis);
	  //load the sheet from workbook
	  sheet=wb.getSheet(sheetName);
  }
   
    public int GetNoOfRows()
   {
	 int rowNum=sheet.getLastRowNum()+1;
	 return rowNum;
   }
  
    public int GetNoOfColumns()
   {
	  int ColNum=sheet.getRow(0).getLastCellNum();
	  return ColNum;
   }
     public String GetData(int rowNum,int colNum)
    {
	  Row row=sheet.getRow(rowNum);
	  Cell cell=row.getCell(colNum);
	  DataFormatter formatter= new DataFormatter();
	  String value=formatter.formatCellValue(cell);
	  return value;
	
     }
     public Boolean SetExcelData(int SheetName,int rowNum,int colNum,String Value,String path) throws IOException
     {
    	Row row=sheet.getRow(rowNum);
    	if(row==null)
    	{
    		row=sheet.createRow(rowNum);
    	}
    	
    	Cell cell=row.getCell(colNum);
    	if(cell==null)
    	{
    		 cell=row.createCell(colNum);
    	}
    	cell.setCellValue(Value);
    	fos = new FileOutputStream(path);
    	wb.write(fos);
    	fos.close();
		return true;
    	 
     }
     
     
     public void close() throws IOException
     {
    	 wb.close();
    	 fis.close();
     }
}










