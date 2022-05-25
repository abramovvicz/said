package com.saidproject.saidproject.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreateExcelFile {

    static final Logger logger = LoggerFactory.getLogger(CreateExcelFile.class);

    private static Workbook workbook;

    public static void writeFile(Object object, String fileName) throws IOException {
        workbook = new HSSFWorkbook();
        createSheet("someTitle");
        File file = new File(".");
        String filePath = file.getAbsolutePath();
        String fileLocation = filePath.substring(0, filePath.length() - 1) + fileName;
        FileOutputStream fileOutputStream = new FileOutputStream(fileLocation);
        try (fileOutputStream) {
            workbook.write(fileOutputStream);
            workbook.close();
            logger.info(String.format("Excel file created: %s, filePath is: %s ", fileName, filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static void createSheet(String title) {
        Sheet sheet = workbook.createSheet(title);
        sheet.setColumnWidth(0, 6000);
        sheet.setColumnWidth(1, 4000);
        Row header = sheet.createRow(0);
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        Cell headerCell = header.createCell(0);
        headerCell.setCellValue("Name");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(1);
        headerCell.setCellValue("Age");
        headerCell.setCellStyle(headerStyle);

        CellStyle style = workbook.createCellStyle();
        style.setWrapText(true);

        Row row = sheet.createRow(2);
        Cell cell = row.createCell(0);
        cell.setCellValue("John Smith");
        cell.setCellStyle(style);

        cell = row.createCell(1);
        cell.setCellValue(20);
        cell.setCellStyle(style);
    }

}
