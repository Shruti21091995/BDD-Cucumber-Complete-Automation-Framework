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

public class ExcelUtilities 
{
	
	    private String filePath;
	    private Workbook workbook;
	    private Sheet sheet;
        private FileInputStream fis;
       
	    // 1. Constructor → Open the Excel file
	    public ExcelUtilities(String filePath) throws IOException 
	    {
	        this.filePath = filePath;
	        //open the excel file for reading
	        fis = new FileInputStream(filePath);
	      //load the file in workbook for reading
	        workbook=WorkbookFactory.create(fis);
	      }

	    // 2. Get number of rows in a sheet
	    public int getRowCount(String sheetName) 
	    {
	    	//load the sheet from the workbook
	        sheet = workbook.getSheet(sheetName);
	        return sheet.getLastRowNum() + 1;
	    }

	    // 3. Get number of columns in a sheet
	    public int getColumnCount(String sheetName) 
	    {
	    	//load the sheet from the workbook
	        sheet = workbook.getSheet(sheetName);
	        Row row = sheet.getRow(0);
	        return row.getLastCellNum();
	    }

	    // 4. Get data from a cell (row + column number)
	    public String getCellData(String sheetName, int rowNum, int colNum) 
	    {
	    	//load the sheet from the workbook
	        sheet = workbook.getSheet(sheetName);
	            Row row = sheet.getRow(rowNum);
               Cell cell = row.getCell(colNum);
               DataFormatter formatter = new DataFormatter();
	            return formatter.formatCellValue(cell);

	       
	    }

	    // 5. Write data to a cell
	    public boolean setCellData(String sheetName, int rowNum, int colNum, String value) throws IOException
	    {
	    	//load the sheet from the workbook
	            sheet = workbook.getSheet(sheetName);
	            Row row = sheet.getRow(rowNum);

	            if (row == null)
	                row = sheet.createRow(rowNum);

	            Cell cell = row.getCell(colNum);
	            if (cell == null)
	                cell = row.createCell(colNum);

	            cell.setCellValue(value);

	            FileOutputStream fos = new FileOutputStream(filePath);
	            workbook.write(fos);
	            fos.close();
	            return true;

	       
	    }

	    // 6. Close workbook
	    public void close() throws IOException 
	    {
	            workbook.close();
	            fis.close();
	        
	    }
	}


