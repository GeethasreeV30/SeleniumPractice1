package com.popupHandle_5;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class ConfirmDemo_2 {
	WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\g.venkataramana\\Downloads\\edgedriver_win64 (3)\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		
		WebElement element = driver.findElement(By.id("confirmButton"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
		Alert confirm = driver.switchTo().alert();
		confirm.getText();
		confirm.accept();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement element1=driver.findElement(By.id("confirmButton"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", element1);
		Alert confirm1 = driver.switchTo().alert();
		confirm1.dismiss();
		
		//driver.close();
	}

}
