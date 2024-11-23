package sample;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.*;
import java.util.*;

public class FileCompare {

    @Test
    public static void compare() throws Exception {
        // Input file paths (from resources folder)
        String filePath1 = "src/test/resources/file1.txt";
        String filePath2 = "src/test/resources/file2.txt";
        String outputExcelPath = "src/test/resources/results.xlsx";

        // Batch size for processing lines
        int batchSize = 100;

        // Run the comparison
        compareFiles(filePath1, filePath2, outputExcelPath, batchSize);
        System.out.println("Comparison completed. Results saved in " + outputExcelPath);
    }

    public static void compareFiles(String filePath1, String filePath2, String outputExcelPath, int batchSize)
            throws Exception {
        try (BufferedReader reader1 = new BufferedReader(new FileReader(filePath1));
             BufferedReader reader2 = new BufferedReader(new FileReader(filePath2))) {

            Map<Integer, String[]> mismatches = new LinkedHashMap<>();

            List<String> batch1 = new ArrayList<>();
            List<String> batch2 = new ArrayList<>();
            int globalLineCount = 0;

            String line1, line2;
            while ((line1 = reader1.readLine()) != null && (line2 = reader2.readLine()) != null) {
                batch1.add(line1);
                batch2.add(line2);
                globalLineCount++;

                // Process the batch if it reaches the specified batch size
                if (batch1.size() == batchSize) {
                    processBatch(batch1, batch2, mismatches, globalLineCount - batchSize + 1);
                    batch1.clear();
                    batch2.clear();
                }
            }

            // Process any remaining lines
            if (!batch1.isEmpty()) {
                processBatch(batch1, batch2, mismatches, globalLineCount - batch1.size() + 1);
            }

            // Write mismatches to Excel
            writeMismatchesToExcel(mismatches, outputExcelPath);
        }
    }

    private static void processBatch(List<String> batch1, List<String> batch2, Map<Integer, String[]> mismatches,
                                     int startLineNumber) {
        for (int i = 0; i < batch1.size(); i++) {
            if (!batch1.get(i).equals(batch2.get(i))) {
                int globalLineNumber = startLineNumber + i;
                mismatches.put(globalLineNumber, new String[]{batch1.get(i), batch2.get(i)});
            }
        }
        System.out.println("Processed batch starting at line " + startLineNumber);
    }

    private static void writeMismatchesToExcel(Map<Integer, String[]> mismatches, String outputExcelPath)
            throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Mismatches");

        // Header row
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Line Number");
        header.createCell(1).setCellValue("File 1 Content");
        header.createCell(2).setCellValue("File 2 Content");

        // Populate mismatches
        int rowNum = 1;
        for (Map.Entry<Integer, String[]> entry : mismatches.entrySet()) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(entry.getKey());
            row.createCell(1).setCellValue(entry.getValue()[0]);
            row.createCell(2).setCellValue(entry.getValue()[1]);
        }

        // Save to file
        try (FileOutputStream fos = new FileOutputStream(outputExcelPath)) {
            workbook.write(fos);
        }
        workbook.close();
    }
}
