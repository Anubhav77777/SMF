package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readXslxdata {

    private static Workbook workbook;
    private static Sheet sheet;
    private static String excelPath = System.getProperty("user.dir") + "/src/test/resources/testdata/smf.xlsx";

    // Open the Excel file and sheet
    public static void openSheet(String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(new File(excelPath));
        workbook = WorkbookFactory.create(fis);
        sheet = workbook.getSheet(sheetName);
        fis.close();
    }

    // Save and close the Excel
    public static void saveAndClose() throws IOException {
        FileOutputStream fos = new FileOutputStream(new File(excelPath));
        workbook.write(fos);
        workbook.close();
        fos.close();
    }

    // Just printing the row/column count
    public static void getData(String sheetName) throws IOException {
        openSheet(sheetName);

        int totalRows = sheet.getLastRowNum();
        System.out.println("Total Rows: " + totalRows);

        Row rowCells = sheet.getRow(0);
        int totalCols = rowCells.getLastCellNum();
        System.out.println("Total Columns: " + totalCols);

        workbook.close();
    }

    // Write a new username and password into the Excel
    public static void writeNewUser(String sheetName, String username, String password) throws IOException {
        openSheet(sheetName);

        int lastRowNum = sheet.getLastRowNum();
        Row newRow = sheet.createRow(lastRowNum + 1);

        newRow.createCell(0).setCellValue(username);  // Username
        newRow.createCell(1).setCellValue(password);  // Password
        newRow.createCell(2).setCellValue("unused");  // Status

        saveAndClose();
    }

    // Fetch first unused user credentials and mark it as used
    public static String[] getFirstUnusedUser(String sheetName) throws IOException {
        openSheet(sheetName);

        for (Row row : sheet) {
            Cell statusCell = row.getCell(2);
            if (statusCell != null && statusCell.getStringCellValue().equalsIgnoreCase("unused")) {
                String username = row.getCell(0).getStringCellValue();
                String password = row.getCell(1).getStringCellValue();

                // Mark as used
                statusCell.setCellValue("used");
                saveAndClose();

                return new String[]{ username, password };
            }
        }
        workbook.close();
        return null;
    }
}












//package utilities;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//
//public class readXslxdata {
//
//	public static void main(String[] args) {
//		
//
//	}
//     public void getData(String excelSheetName) throws IOException {
//     
//     File f = new File(System.getProperty("user.dir")+"src\\test\\resources\\testdata\\smf.xlsx");
//     FileInputStream fis = new FileInputStream(f);     
//     Workbook wb =  WorkbookFactory.create(fis);
//     Sheet sheetname = wb.getSheet(excelSheetName);
//     
//     int totalRows = sheetname.getLastRowNum();
//     System.out.println(totalRows);
//     Row rowCells = sheetname.getRow(0);
//     int  totalCols = rowCells.getLastCellNum();
//     System.out.println(totalCols);
//     
//     }
//}
