package utils;

import com.github.javafaker.Faker;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Random;

public class WriteExcel {

    public static void writeExcelData(String filePath, String sheetName) throws IOException {
        Faker faker = new Faker();

        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(sheetName);

        int rowCount = 2;

        // create empty rows
        for (int i = 0; i <= rowCount; i++) {
            if (sheet.getRow(i) == null) {
                sheet.createRow(i);
            }
        }

        String[] headerRow = new String[]{"First Name", "Last Name", "Password", "Confirm Password", "Email"};
        int colCount = headerRow.length;
        for (int i = 0; i < colCount; i++) {
            sheet.getRow(0).createCell(i).setCellValue(headerRow[i]);
        }

        for (int i = 1; i <= rowCount; i++) {
            String password = getPassword(10);

            String[] bodyRow = new String[]{
                    faker.name().firstName(),
                    faker.name().lastName(),
                    password,
                    password,
                    RandomEmail.getEmail("Nazz#@yopmail.com")
            };
            for (int j = 0; j < colCount; j++) {
                sheet.getRow(i).createCell(j).setCellValue(bodyRow[j]);
            }
        }

        FileOutputStream fos = new FileOutputStream(filePath);
        workbook.write(fos);
        workbook.close();
        fos.close();
    }

    private static String getPassword(int length) {
        final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length - 2; i++) {
            int index = random.nextInt(CHARACTERS.length());
            password.append(CHARACTERS.charAt(index));
        }
        password.append('@');
        password.append('1');
        return password.toString();
    }
}

