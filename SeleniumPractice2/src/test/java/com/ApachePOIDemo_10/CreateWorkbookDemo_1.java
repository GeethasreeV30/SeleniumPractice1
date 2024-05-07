package com.ApachePOIDemo_10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class CreateWorkbookDemo_1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Sheet01");
		String filePath = "C:\\Users\\g.venkataramana\\Desktop\\Selenium practice\\PracticeDemo.xls";
		
		FileOutputStream out = new FileOutputStream(filePath);
		workbook.write(out);
		out.close();
	}
}
