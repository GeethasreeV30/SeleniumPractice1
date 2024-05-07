package com.popupHandle_5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class PromptDemo_3 {
	WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\g.venkataramana\\Downloads\\edgedriver_win64 (3)\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		WebElement element = driver.findElement(By.id("promtButton"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
		Alert promptAlert = driver.switchTo().alert();
		String alertText = promptAlert.getText();
		System.out.println("Alert text is " + alertText);
		
		promptAlert.sendKeys("User");
		promptAlert.accept();
	}

}
