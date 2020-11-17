package Config1;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	public static String data=null;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row = null;
	public static XSSFCell cell = null;
	public static String[][] excelData = null;
	public static int colCount=0;
	public static int rowCount=0;
	public static int lastRow ;
	public static int maxCell;
	public static String[][] readdata;
	//Reading Excel File and get the data
	public static String[][] excel_Files(String sheetname) throws Exception {
		try {
			String FilePath ="src\\test\\resources\\ReadExcelData.xlsx";
			FileInputStream finputStream = new FileInputStream(new File(FilePath));

			workbook = new XSSFWorkbook(finputStream);
			sheet = workbook.getSheet(sheetname);
			colCount = sheet.getRow(0).getPhysicalNumberOfCells();

			//System.out.println("Columns"+ colCount);

			rowCount = sheet.getPhysicalNumberOfRows();

			//System.out.println("Rows"+ rowCount);

			maxCell=  colCount;
			excelData = new String[rowCount][colCount];

			for(int Nrow = 0; Nrow<rowCount; Nrow++) {
				row = sheet.getRow(Nrow);
				for(int Ncolumn =0; Ncolumn<colCount ; Ncolumn++) {
					cell = sheet.getRow(Nrow).getCell(Ncolumn);
					DataFormatter df = new DataFormatter();
					excelData[Nrow][Ncolumn] = df.formatCellValue(cell);
				}
			}
		}catch(Exception e) {
          System.out.println(e.getMessage());
		}

		return excelData;
	}

	
		

	}


