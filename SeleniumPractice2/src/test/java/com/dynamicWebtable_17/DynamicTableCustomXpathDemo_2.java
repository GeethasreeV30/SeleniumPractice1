package com.dynamicWebtable_17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DynamicTableCustomXpathDemo_2 {
	public static WebDriver driver;

	@BeforeTest
	public void openBrowser() {
		driver = new EdgeDriver();
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		driver.manage().window().maximize();
	}

	@Test
	public void dynamicTableMethod() {
		// using preceding sibling and parent for custom xpath without using any for loop
		String country = "India";
		driver.findElement(By.xpath("//strong[contains(text(),'"+country+"')]/parent::td/preceding-sibling::td//input[@class='hasVisited']")).click();
		
	}
}
