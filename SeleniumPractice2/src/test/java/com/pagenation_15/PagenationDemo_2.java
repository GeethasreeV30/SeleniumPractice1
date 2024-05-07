package com.pagenation_15;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PagenationDemo_2 {
	// pagenation 1 2,...5,6 by clicking next button
	public static WebDriver driver;

	@BeforeTest
	public void openBrowser() {
		driver = new EdgeDriver();
		driver.get("https://datatables.net/examples/advanced_init/dt_events.html");
		driver.manage().window().maximize();
	}

	@Test
	public void pagenationMethod() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");

		//driver.findElement(By.xpath("//div[@class='dt-paging paging_full_numbers']//following::button[5]")).click();
		//first we capture name and click on next button when it come to last page the next button will be disabled 
		List<String> names = new ArrayList<String>();
		List<WebElement> nameElements = driver.findElements(By.cssSelector("#example>tbody>tr>td:nth-child(1)"));
		// getting text(name) from the name cloumn element and adding to names list
		for (WebElement nameElement : nameElements) {
			names.add(nameElement.getText());
		}
		
		//getting class name of next button
		String nextButtonClassName = driver.findElement(By.xpath("//button[@class='dt-paging-button next']")).getAttribute("class");
		
		//here for last page next button class contain disabled so we should click next button until we get disabled
		while(!nextButtonClassName.contains("disabled")) {
			
			//click next button
			driver.findElement(By.xpath("//*[@id=\"example_wrapper\"]/div[3]/div[2]/div/button[9]")).click();
			
			//finding name column elements and adding the name to names list
			nameElements = driver.findElements(By.cssSelector("#example>tbody>tr>td:nth-child(1)"));
			for (WebElement nameElement : nameElements) {
				names.add(nameElement.getText());
			}
			
			//iterating by using next button class name
			nextButtonClassName = driver.findElement(By.xpath("//*[@id=\"example_wrapper\"]/div[3]/div[2]/div/button[9]")).getAttribute("class");
			Thread.sleep(1000);
		}
		
		for(String name:names) {
			System.out.println(name);
		}
		int totalNames = names.size();
		System.out.println("total number of names: "+totalNames);
		// at end of table there is string like "Showing 1 to 10 of 57 entries" so
		// spliting this string and getting string "57"
		String displayCount = driver.findElement(By.xpath("//div[@id='example_info']")).getText().split(" ")[5];
		System.out.println("total number of displayed names oount: " + displayCount);
		Assert.assertEquals(displayCount, String.valueOf(totalNames));
		Thread.sleep(1000);

	}
}
