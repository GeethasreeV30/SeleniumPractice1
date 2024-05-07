package com.ScreenShot_12;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScreenShotDemo_1 {
	WebDriver driver = new EdgeDriver();
	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\g.venkataramana\\Downloads\\edgedriver_win64 (2)\\msedgedriver.exe");
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	}

	@Test
	public void loginMethod() throws IOException {
		driver.findElement(By.xpath("//a[@id=\"nav-link-accountList\"]")).click();
		driver.findElement(By.xpath("//input[@id='ap_email' and @name='email']")).sendKeys("6302935810");
		driver.findElement(By.xpath("//input[@class='a-button-input']")).click();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("bt07sv");
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		TakesScreenshot ts = (TakesScreenshot)driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("./Screenshots/homePage.png"));
	}
	@Test
	public void logoutMethod() {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).perform();
		driver.findElement(By.xpath("//span[contains(text(),'Sign Out')]")).click();
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

}
