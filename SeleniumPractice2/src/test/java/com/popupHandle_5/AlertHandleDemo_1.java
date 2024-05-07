package com.popupHandle_5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AlertHandleDemo_1 {
WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\g.venkataramana\\Downloads\\edgedriver_win64 (3)\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("alertButton")).click();
		
		Alert simpleAlert = driver.switchTo().alert();
		simpleAlert.accept();
		
	}
}
