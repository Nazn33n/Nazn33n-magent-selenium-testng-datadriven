package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class ReadExcel {
    public static Object[][] getExcelData(String filePath, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(sheetName);

        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();
        System.out.println(rowCount);
        System.out.println(colCount);

        Object[][] data = new Object[rowCount][colCount];
        System.out.println(Arrays.deepToString(data));

        DataFormatter formatter = new DataFormatter(); // To handle all types of cell data (string, numeric, etc.)

        for (int i = 1; i <= rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = formatter.formatCellValue(sheet.getRow(i).getCell(j)); // Store data in array
            }
            System.out.println(Arrays.deepToString(data));
        }

        workbook.close();
        fis.close();

        return data;
    }


}
