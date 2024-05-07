package com.SortingPrice_16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SortAscending_1 {
	// 1. before filter capture the prices
	// 2. filter the price from the dropdown
	// 3. after filter capture the prices
	// 4. Compare the values/Assert the values
	public static WebDriver driver;
	List<String> beforeFilterPriceList = new ArrayList<String>();
	List<String> afterFilterPriceList = new ArrayList<String>();
	@BeforeTest
	public void openBrowser() {
		driver = new EdgeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	}
	@Test
	public void loginMethod() {
		driver.findElement(By.xpath("//a[@id=\"nav-link-accountList\"]")).click();
		driver.findElement(By.xpath("//input[@id='ap_email' and @name='email']")).sendKeys("6302935810");
		driver.findElement(By.xpath("//input[@class='a-button-input']")).click();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("bt07sv");
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
	}
	
	@Test
	public void searchProduct() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("smart");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#nav-flyout-searchAjax>div>div>div>div")).click();
		Thread.sleep(1000);
		//driver.findElement(By.cssSelector(".left-pane-results-container>div:nth-child(1)>div>div")).click();
	}
	
	/* 1. before filter capture the prices*/
	@Test
	public void beforeFilter() throws InterruptedException {
		List<WebElement> beforeFilterPrice = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		Thread.sleep(5000);
		//List<String> beforeFilterPriceList = new ArrayList<String>();
		for(WebElement price:beforeFilterPrice) {
			beforeFilterPriceList.add(price.getText());
		}
		beforeFilterPriceList.removeAll(Arrays.asList("", null));
		Thread.sleep(1000);
		for(String price: beforeFilterPriceList) {
			price = price.replace(",", "");
			System.out.println(price);
		}
	}
	
	/* 2. filter the price from the dropdown*/
	@Test
	public void selectSort() throws InterruptedException {
		Select sorting = new Select(driver.findElement(By.cssSelector("#s-result-sort-select")));
		sorting.selectByValue("price-asc-rank");
		Thread.sleep(1000);
	}
	
	/* 3. after filter capture the prices*/
	@Test
	public void afterFilter() throws InterruptedException {
		List<WebElement> afterFilterPrice = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		//List<String> afterFilterPriceList = new ArrayList<String>();
		for(WebElement price:afterFilterPrice) {
			afterFilterPriceList.add(price.getText());
		}
		afterFilterPriceList.removeAll(Arrays.asList("", null));
		Thread.sleep(1000);
		for(String price: afterFilterPriceList) {
			price = price.replace(",", "");
			System.out.println(price);
		}
	}
	
	/*4. Compare the values/Assert the values*/
	@Test
	public void comparePriceafterFiler() {
		Assert.assertNotEquals(afterFilterPriceList,beforeFilterPriceList);
	}
}
