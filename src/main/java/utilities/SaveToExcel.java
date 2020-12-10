package utilities;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import objects.Project;
import objects.UserStory;

// plugins { // For gradle!!!
//     id 'java-library'
// }

// sourceCompatibility = 12
// targetCompatibility = 12

// repositories {
//     jcenter()
// }

// dependencies {
//     implementation 'org.apache.poi:poi-ooxml:4.1.1'
//     //required only for jdk 9 or above
//     implementation('com.fasterxml.jackson.core:jackson-databind:2.10.1')
// } 


// compile "org.apache.poi:poi-ooxml:4.1.1"	 // Maybe also for gradle!!

public class SaveToExcel {

    private static String[] columns = {"ID", "Points", "Description"};

    public static void saveToExcel(Project project) throws Exception {

        // Setup the basics
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet(" Burndown Chart ");
        XSSFRow headerRow = spreadsheet.createRow(0);

        for(int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
        
        }
        int rowNum = 1;
        for(UserStory story: project.projectPlanning.getBacklog()) {
            XSSFRow row = spreadsheet.createRow(rowNum++);

            row.createCell(0)
                    .setCellValue(story.getId());

            row.createCell(1)
                    .setCellValue(story.getPoints());

            row.createCell(2)
                    .setCellValue(story.getDescription());
        }

		// Resize all columns to fit the content size
        for(int i = 0; i < columns.length; i++) {
            spreadsheet.autoSizeColumn(i);
        }

        
        FileOutputStream out = new FileOutputStream(new File("src/main/java/Files/Writesheet.xlsx"));

        workbook.write(out);
        out.close();
        workbook.close();
        System.out.println("File written successfully");
    }
}