package com.ApachePOIDemo_10;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ReadDataDemo_2 {
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\g.venkataramana\\Desktop\\Selenium practice\\logincred.xls");
		FileInputStream input = new FileInputStream(file);
		HSSFWorkbook workbook = new HSSFWorkbook(input);
		HSSFSheet sheet = workbook.getSheetAt(0);

		// fetching only single value
		HSSFRow row = sheet.getRow(1);
		HSSFCell cell = row.getCell(1);
		String password = cell.getStringCellValue();
		System.out.println(password);

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
	}
}
