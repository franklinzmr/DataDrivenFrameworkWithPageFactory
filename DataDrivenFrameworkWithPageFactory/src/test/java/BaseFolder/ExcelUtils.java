package BaseFolder;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

    public static Object[][] getTableArray(String filePath, String sheetName) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet(sheetName);

        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getLastCellNum();
        System.out.println("colCount :"+colCount);

        // We subtract 1 to skip the header row
        Object[][] data = new Object[rowCount - 1][colCount];
        DataFormatter formatter = new DataFormatter();

        for (int i = 1; i < rowCount; i++) { // Start from 1 to skip header
            XSSFRow row = sheet.getRow(i);

            for (int j = 0; j < colCount; j++) {
                XSSFCell cell = row.getCell(j);
                // formatter.formatCellValue ensures data is read as a String regardless of type
                data[i - 1][j] = formatter.formatCellValue(cell);
            }
        }

        workbook.close();
        fileInputStream.close();
        return data;
    }
}