package com.ApachePOIDemo_10;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DataTestingDemo_4 {
	WebDriver driver;
	public static DataFormatter formatter = new DataFormatter();

	public Object[][] dataExcel() throws IOException {
		File file = new File("C:\\Users\\g.venkataramana\\Desktop\\Selenium practice\\amazoncred.xls");
		FileInputStream input = new FileInputStream(file);
		HSSFWorkbook workbook = new HSSFWorkbook(input);
		HSSFSheet sheet = workbook.getSheetAt(0);
		ArrayList<String> cred = new ArrayList<String>();

		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getLastCellNum();
		Object[][] testData = new Object[rowCount - 1][colCount];
		for (int i = 0; i < rowCount - 1; i++) {
			HSSFRow row = sheet.getRow(i + 1);
			for (int j = 0; j < colCount; j++) {
				HSSFCell col = row.getCell(j);
				if (col == null)
					testData[i][j] = " ";
				else
					testData[i][j] = formatter.formatCellValue(col);
			}
		}
		workbook.close();
		return testData;
	}

	public static void main(String[] args) throws IOException {
		DataTestingDemo_4 d = new DataTestingDemo_4();
		Object[][] data = d.dataExcel();
		String uname, password;
		for (int i = 0; i < data.length; i++) {
			uname = (String) data[i][0];
			password = (String) data[i][1];
			System.out.println(uname);
			System.out.println(password);
			System.setProperty("webdriver.edge.driver","C:\\Users\\g.venkataramana\\Downloads\\edgedriver_win64 (2)\\msedgedriver.exe");

			WebDriver driver = new EdgeDriver();
			driver.get("https://www.amazon.in/");
			driver.manage().window().maximize();
			driver.findElement(By.id("nav-link-accountList")).click();
			driver.findElement(By.id("ap_email")).sendKeys(uname);
			driver.findElement(By.id("continue")).click();
			driver.findElement(By.id("ap_password")).sendKeys(password);
			driver.findElement(By.id("signInSubmit")).click();
			//String incorrectPhone = driver.findElement(By.xpath("//h4[contains(text(),'Incorrect phone number')]")).getText();
			/*if(incorrectPhone.equalsIgnoreCase("Incorrect phone number")){
				continue;
			}else{
				driver.findElement(By.id("ap_password")).sendKeys(password);
				String incorrectPassword = driver.findElement(By.xpath("//span[contains(text(),'Your password is incorrect')]")).getText();
				if(incorrectPassword.equalsIgnoreCase("Your password is incorrect")) {
					continue;
				}else {
					driver.findElement(By.id("signInSubmit")).click();
				}
			}*/
			driver.close();
		
		}
	}

}
