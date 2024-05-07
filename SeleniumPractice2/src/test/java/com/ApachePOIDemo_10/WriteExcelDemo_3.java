package com.ApachePOIDemo_10;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class WriteExcelDemo_3 {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\g.venkataramana\\Desktop\\Selenium practice\\logincred.xls");
		FileInputStream input = new FileInputStream(file);
		HSSFWorkbook workbook = new HSSFWorkbook(input);
		HSSFSheet sheet = workbook.getSheetAt(0);

		// fetching all values in sheet
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		for (int i = 1; i <= rowCount; i++) {
			int cellcount = sheet.getRow(i).getLastCellNum();
			System.out.println("Row" + i + " data is :");

			for (int j = 0; j < cellcount; j++) {
				System.out.print(sheet.getRow(i).getCell(j).getStringCellValue() + ",");
			}
			System.out.println();
		}
		
		//create new cell for each row
		sheet.getRow(0).createCell(2).setCellValue("Status");
		sheet.getRow(1).createCell(2).setCellValue("Pass");
		sheet.getRow(2).createCell(2).setCellValue("Fail");
		sheet.getRow(3).createCell(2).setCellValue("Pass");
		System.out.println("saved changes");
		FileOutputStream out = new FileOutputStream("C:\\Users\\g.venkataramana\\Desktop\\Selenium practice\\LoginCredResult.xls");
		workbook.write(out);
		out.close();
		
		//create new row and add cell values for that row
		HSSFRow row1 = sheet.createRow(rowCount+1);
		row1.createCell(0).setCellValue("pqr123");
		row1.createCell(1).setCellValue("pqr123");
		row1.createCell(2).setCellValue("Pass");
		System.out.println("saved changes");
		FileOutputStream out1 = new FileOutputStream("C:\\Users\\g.venkataramana\\Desktop\\Selenium practice\\LoginCredResultNewRow.xls");
		workbook.write(out1);
		out1.close();
	}

}
