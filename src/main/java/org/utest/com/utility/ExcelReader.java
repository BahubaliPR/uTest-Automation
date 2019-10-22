package org.utest.com.utility;

/*
 * Bahubali P R
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class ExcelReader {

	private FileOutputStream fileout = null;
	private FileInputStream fileIn;;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private XSSFRow row;
	private XSSFCell cell;
	private String path;

	public ExcelReader(String path) {
		this.path = path;
		try {
			fileIn = new FileInputStream(path);
			workbook = new XSSFWorkbook(fileIn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "Depreciated" })
	public String[][] getDataFromSheet(String sheetName, String excelName) {
		String dataSets[][] = null;

		try {
			// Get sheet from excel workbook
			sheet = workbook.getSheet(sheetName);

			// Count number of active rows
			int totalRow = sheet.getLastRowNum() + 1;

			// Count active columns in a row
			int totalColumn = sheet.getRow(0).getLastCellNum();

			// Create an array of row and column
			dataSets = new String[totalRow - 1][totalColumn];

			// Run for loop and store the data in 2D array
			// This for loop will run on rows
			for (int i = 1; i < totalRow; i++) {
				XSSFRow rows = sheet.getRow(i);

				// This for loop will run on columns of that row
				for (int j = 0; j < totalColumn; j++) {
					XSSFCell cell = rows.getCell(j);

					// If cell of type String, Then this if condition will work
					if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
						dataSets[i - 1][j] = cell.getStringCellValue();
					}

					// If cell of type number, then this if condition will work
					else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						String cellText = String.valueOf(cell.getNumericCellValue());
						dataSets[i - 1][j] = cellText;
					}

					else {
						// if cell of type boolean, then this if condition will
						// work
						dataSets[i - 1][j] = String.valueOf(cell.getBooleanCellValue());
					}
				}
			}
		}

		catch (Exception e) {
			System.out.println("Exception in reading Xlxs file" + e.getMessage());
			e.printStackTrace();
		}
		return dataSets;
	}

	@SuppressWarnings("Depreciated")
	public String getCellDataFromSheet(String sheetName, String colName, int rowNum) {
		try {
			int col_Num = 0;
			int index = workbook.getSheetIndex(sheetName);
			sheet = workbook.getSheetAt(index);
			XSSFRow row = sheet.getRow(0);

			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().equals(colName)) {
					col_Num = i;
					break;
				}
			}
			row = sheet.getRow(rowNum - 1);
			XSSFCell cell = row.getCell(col_Num);
			if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
				return cell.getStringCellValue();
			}

			else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
				return "";
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
