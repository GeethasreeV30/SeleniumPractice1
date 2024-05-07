package com.ScreenShot_12;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;

public class BaseClass {
	public static WebDriver driver;
	public static String screenShotSubFolder;
	@BeforeMethod
	public void openBrowser() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() {
		//driver.close();
	}
	public void captureScreenShot(String fileName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("./Screenshots/"+fileName));
	}

}
