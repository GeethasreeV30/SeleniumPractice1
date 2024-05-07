package com.SortingPrice_16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class SortDescendin_4 {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		driver = new EdgeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id=\"nav-link-accountList\"]")).click();
		driver.findElement(By.xpath("//input[@id='ap_email' and @name='email']")).sendKeys("6302935810");
		driver.findElement(By.xpath("//input[@class='a-button-input']")).click();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("bt07sv");
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("smart");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#nav-flyout-searchAjax>div>div>div>div")).click();
		Thread.sleep(1000);
		List<WebElement> beforeFilterPrice = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		Thread.sleep(5000);
		List<String> beforeFilterPriceList = new ArrayList<String>();
		for(WebElement price:beforeFilterPrice) {
			beforeFilterPriceList.add(price.getText());
		}
		beforeFilterPriceList.removeAll(Arrays.asList("", null));
		Thread.sleep(1000);
		for(String price: beforeFilterPriceList) {
			price = price.replace(",", "");
			System.out.println(price);
		}
		
		//click sort
		Select sorting = new Select(driver.findElement(By.cssSelector("#s-result-sort-select")));
		sorting.selectByValue("price-desc-rank");
		Thread.sleep(1000);
		
		//after sorting
		List<WebElement> afterFilterPrice = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		List<String> afterFilterPriceList = new ArrayList<String>();
		for(WebElement price:afterFilterPrice) {
			afterFilterPriceList.add(price.getText());
		}
		afterFilterPriceList.removeAll(Arrays.asList("", null));
		Thread.sleep(1000);
		for(String price: afterFilterPriceList) {
			price = price.replace(",", "");
			System.out.println(price);
		}
		
		//compare lists
		boolean priceCompareAfterSort = afterFilterPriceList.equals(beforeFilterPriceList);
		if(priceCompareAfterSort==false) {
			System.out.println("sorting is successful");
		}
		
	}

}
