package com.slider_13;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class SliderDemo_1 {
	public static WebDriver driver;
	@BeforeTest
	public void openBrowser() {
		driver = new EdgeDriver();
		driver.get("https://emicalculator.net/#google_vignette");
		driver.manage().window().maximize();
	}

	@Test
	public void EmiCalculator() throws InterruptedException {
		WebElement loanSlider = driver.findElement(By.xpath("//div[@id='loanamountslider']//span"));
		WebElement interestSlider = driver.findElement(By.xpath("//div[@id='loaninterestslider']//span"));
		WebElement termSlider = driver.findElement(By.xpath("//div[@id='loantermslider']//span"));
		
		Actions action = new Actions(driver);
		action.dragAndDropBy(loanSlider, 88, 0).build().perform();
		Thread.sleep(1000);
		action.dragAndDropBy(interestSlider, 148, 0).build().perform();
		Thread.sleep(1000);
		action.dragAndDropBy(termSlider, -111, 0).build().perform();
		Thread.sleep(1000);
		
		String emiAmount = driver.findElement(By.xpath("//div[@id='emiamount']/p/span")).getText();
		Assert.assertEquals(emiAmount, "92,439");
		
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

}
