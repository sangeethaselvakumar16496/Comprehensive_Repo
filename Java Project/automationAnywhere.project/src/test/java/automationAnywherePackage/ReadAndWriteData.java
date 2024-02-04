package automationAnywherePackage;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

class ExcelConfig {

	private File file;
	private FileInputStream fis;
	private XSSFWorkbook excelWorkbook;
	private XSSFSheet excelSheet;
	private String fileName;

	public ExcelConfig(String fileName) {
		this.fileName = fileName;
		String filePath = System.getProperty("user.dir") + "\\Excel\\";
		file = new File(filePath + fileName);
		try {
			fis = new FileInputStream(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getXlSheet(String sheetName) {
		try {
			excelWorkbook = new XSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		excelSheet = excelWorkbook.getSheet(sheetName);
	}

	public int getRowNum() {
		int rowNum = excelSheet.getLastRowNum();
		return rowNum;
	}

	public int getColumnNum() {
		int colNum = excelSheet.getRow(0).getLastCellNum();
		return colNum;
	}

	public String getCellData(String colName, int rowIndex) {
		String colHeaderName = null;
		String cellData = null;
		try {
			column: for (int i = 0; i <= getColumnNum(); i++) {
				colHeaderName = excelSheet.getRow(0).getCell(i).getStringCellValue();
				if (colName.equals(colHeaderName)) {
					row: for (int j = rowIndex; j <= getRowNum(); j++) {
						cellData = excelSheet.getRow(j).getCell(i).getStringCellValue();
						break row;
					}
					break column;
				}
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			closeXl();
		}
		return cellData;
	}

	public void closeXl() {
		try {
			excelWorkbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

public class ReadAndWriteData {

	private final String excelFileName = "CourseDetails.xlsx";
	private String excelSheetName = "Course Data";
	ExcelConfig xl;

	public List<String> readDataFromExcel(String columnName) {
		xl = new ExcelConfig(excelFileName);
		xl.getXlSheet(excelSheetName);
		int rowCount = xl.getRowNum();
		List<String> columnList = new ArrayList<String>();
		for (int i = 1; i <= rowCount; i++) {
			columnList.add(xl.getCellData(columnName, i));
		}
		return columnList;
	}

	@Test
	public void displayExcelDataRowWise() {
		xl = new ExcelConfig(excelFileName);
		xl.getXlSheet(excelSheetName);
		int rowCount = xl.getRowNum();
		int columnCount = xl.getColumnNum();
		System.out.println("No of rows in excel: " + rowCount);
		System.out.println("No of columns in excel: " + columnCount);
		String column1 = "Name";
		String column2 = "Courses";
		String column3 = "Fee";
		List<String> columnList1 = readDataFromExcel(column1);
		List<String> columnList2 = readDataFromExcel(column2);
		List<String> columnList3 = readDataFromExcel(column3);
		if ((columnList1.size() == columnList2.size()) && (columnList2.size() == columnList3.size())
				&& (columnList3.size() == columnList1.size())) {
			System.out.println();
			for (int i = 0; i < columnList1.size(); i++) {
				System.out.print(columnList1.get(i) + "\t|" + columnList2.get(i) + "\t|" + columnList3.get(i) + "\n");
			}
		}
	}

}