package com.dynamicWebtable_17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DynamicWebtableDemo_1 {
	public static WebDriver driver;
	@BeforeTest
	public void openBrowser() {
		driver = new EdgeDriver();
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		driver.manage().window().maximize();
	}
	@Test
	public void dynamicTableMethod() {
		//printing countries (2nd column excluding country heading
		for(int i = 2;i<=197;i++) {
			String country = driver.findElement(By.cssSelector("#countries>tbody>tr:nth-child("+i+")>td:nth-child(2)")).getText();
			System.out.println(country);
			//check box india
			if(country.contains("India")) {
				driver.findElement(By.cssSelector("#countries>tbody>tr:nth-child("+i+")>td:nth-child(1)>input")).click();
			}
		}
	}
}
