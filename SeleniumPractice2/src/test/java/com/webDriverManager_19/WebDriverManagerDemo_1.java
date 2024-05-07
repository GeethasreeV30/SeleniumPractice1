package com.webDriverManager_19;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerDemo_1 {
	WebDriver driver;

	@Test
	public void openBrowser() {
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	}
	
}
