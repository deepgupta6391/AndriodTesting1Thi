package rough;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadingMine {

	public String path;
	public FileInputStream fis = null;

	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;

	public ExcelReadingMine(String path) {
		this.path = path;

		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// returns row count in the sheet
	public int getRowCount(String sheetName) {

		int index = workbook.getSheetIndex(sheetName);
		if (index == -1) {
			return 0;
		} else {
			sheet = workbook.getSheetAt(index);
			int number = sheet.getLastRowNum() + 1;
			return number;
		}
	}

	// returns the data from the cell when col value is passed as string
	public String getCellData(String sheetName, String colName, int rowNum) {
		try {
			if (rowNum <= 0)
				return "";
			int index = workbook.getSheetIndex(sheetName);
			int col_Num = -1;
			if (index == -1)
				return "";

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(0);
			// Find col num
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
					col_Num = i;
			}

			if (col_Num == -1)
				return "";

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum - 1);

			if (row == null) {
				return "";
			}

			if (cell.getCellType() == CellType.STRING)
				return cell.getStringCellValue();
			else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA) {
				String cellText = String.valueOf(cell.getNumericCellValue());
				if (DateUtil.isCellDateFormatted(cell)) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
					cellText = dateFormat.format(cell.getDateCellValue());
				}
				return cellText;
			} else if (cell.getCellType() == CellType.BLANK) {
				return "";
			} else
				return String.valueOf(cell.getBooleanCellValue());

		} catch (Exception e) {
			e.printStackTrace();
			return "row " + rowNum + " or column " + colName + " does not exist in xls";
		}
	}

	// returns the data from the cell
	public String getCellData(String sheetName, int colNum, int rowNum) {
		try {
			if (rowNum <= 0)
				return "";

			int index = workbook.getSheetIndex(sheetName);

			if (index == -1)
				return "";

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				return "";

			cell = row.getCell(colNum);
			if (cell == null)
				return "";

			if (cell.getCellType() == CellType.STRING)
				return cell.getStringCellValue();
			else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA) {
				String cellText = String.valueOf(cell.getNumericCellValue());
				if (DateUtil.isCellDateFormatted(cell)) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
					cellText = dateFormat.format(cell.getDateCellValue());
				}
				return cellText;
			} else if (cell.getCellType() == CellType.BLANK) {
				return "";
			} else
				return String.valueOf(cell.getBooleanCellValue());
		} catch (Exception e) {
			e.printStackTrace();
			return "row " + rowNum + " or column " + colNum + " does not exist in xls";
		}

	}

}
