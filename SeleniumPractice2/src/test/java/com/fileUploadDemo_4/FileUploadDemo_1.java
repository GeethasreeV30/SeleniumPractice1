package com.fileUploadDemo_4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class FileUploadDemo_1 {
	WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\g.venkataramana\\Downloads\\edgedriver_win64 (3)\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		driver.get("https://www.adobe.com/in/acrobat/online/pdf-editor.html");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement upload = driver.findElement(By.xpath("(//input[@id='fileInput'])[1]"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		upload.sendKeys("C:\\Users\\g.venkataramana\\Desktop\\Geethasree Venkataramana.pdf");
		
		//driver.close();
	}

}
