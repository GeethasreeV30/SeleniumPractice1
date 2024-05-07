package com.ScreenShot_12;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(ITestListenerClass_2.class)
public class AmazonScreenShot_2 {
	public static WebDriver driver;
	public static String screenShotSubFolder;
	@BeforeTest
	public void openBrowser() {
		driver = new EdgeDriver();
		driver.get("https://www.thewellnesscorner.com/");
		driver.manage().window().maximize();
	}
 
	@Test
	public void login() {
		SoftAssert softAssert = new SoftAssert();
		driver.findElement(By.xpath("//a[contains(text(),' GET STARTED')]")).click();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("g.venkataramana@accenture.com");
		driver.findElement(By.xpath("//div[contains(text(),'Continue')]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("vb");
		driver.findElement(By.xpath("//div[contains(text(),'Continue')]")).click();
		String actualResult = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div/div/div[3]/form/div/div/div/div/div/div/div[2]/div")).getText();
		//String expectedResult="Geethasree Venkataramana!";
		String expectedResult="Email and password do not match!";
		softAssert.assertNotEquals(expectedResult, actualResult);
		softAssert.assertAll();
	}
	@AfterTest
	public void closeBrowser() {
		//driver.close();
	}
	public void captureScreenShot(String fileName) throws IOException {
		if(screenShotSubFolder == null) {
			LocalDateTime myDateObj = LocalDateTime.now();
			
		    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");

		    screenShotSubFolder = myDateObj.format(myFormatObj);
		}
	    
		TakesScreenshot ts = (TakesScreenshot)driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("./Screenshots/"+screenShotSubFolder+"/"+fileName));
		System.out.println("screenshot saved");
	}
}
