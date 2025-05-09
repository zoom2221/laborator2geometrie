package ro.ulbs.laborator8;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class ExcelGenerator {

    public static void main(String[] args) {
        // 1. Datele
        Map<String, Object[]> data = new TreeMap<>();
        data.put("1", new Object[] {"Prenume", "Nume", "Nota1", "Nota2", "Nota3", "Nota4", "Max", "Medie"});
        data.put("2", new Object[] {"Amit", "Shukla", 9, 8, 7, 5});
        data.put("3", new Object[] {"Lokesh", "Gupta", 8, 9, 6, 7});
        data.put("4", new Object[] {"John", "Adwards", 8, 8, 7, 6});
        data.put("5", new Object[] {"Brian", "Schultz", 7, 6, 8, 9});

        // 2. Workbook + Sheet
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Rezultate");

        // 3. Stiluri
        XSSFFont boldFont = workbook.createFont();
        boldFont.setBold(true);

        XSSFCellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFont(boldFont);
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFCellStyle yellowStyle = workbook.createCellStyle();
        yellowStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        yellowStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        // 4. Scriere date + formule
        int rowNum = 0;
        for (Map.Entry<String, Object[]> entry : data.entrySet()) {
            Row row = sheet.createRow(rowNum);
            Object[] objArr = entry.getValue();
            int colNum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(colNum++);
                if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                } else if (obj instanceof Integer) {
                    cell.setCellValue((Integer) obj);
                }
                // Primul rând = header
                if (rowNum == 0) {
                    cell.setCellStyle(headerStyle);
                }
            }

            // Adăugare formule dacă nu e header
            if (rowNum > 0) {
                String maxFormula = String.format("MAX(D%d:G%d)", rowNum + 1, rowNum + 1);
                String avgFormula = String.format("AVERAGE(D%d:G%d)", rowNum + 1, rowNum + 1);

                Cell maxCell = row.createCell(6);
                maxCell.setCellFormula(maxFormula);
                maxCell.setCellStyle(yellowStyle);

                Cell avgCell = row.createCell(7);
                avgCell.setCellFormula(avgFormula);
                avgCell.setCellStyle(yellowStyle);
            }

            rowNum++;
        }

        // 5. Auto size
        for (int i = 0; i < 8; i++) {
            sheet.autoSizeColumn(i);
        }

        // 6. Salvare fisier
        try (FileOutputStream out = new FileOutputStream("output8.xlsx")) {
            workbook.write(out);
            workbook.close();
            System.out.println("Fisierul output8.xlsx a fost generat cu succes.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

