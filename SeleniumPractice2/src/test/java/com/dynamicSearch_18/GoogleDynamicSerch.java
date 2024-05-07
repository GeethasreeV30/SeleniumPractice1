package com.dynamicSearch_18;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleDynamicSerch {
	public static WebDriver driver;

	@BeforeTest
	public void openBrowser() {
		driver = new EdgeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void googleSearch() {
		//driver.findElement(By.className("gLFyf")).sendKeys("selenium");
		/*List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='wM6W7d']"));
		//List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='lnnVSe']"));
		//List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@class='pcTkSc']"));
		WebDriverWait listWait = new WebDriverWait(driver,Duration.ofSeconds(20));
		listWait.until(ExpectedConditions.visibilityOfAllElements(list));
		System.out.println("total number of suggestions shown: "+list.size());
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getText());
			
			//clcik on "selenium testing
			if(list.get(i).getText().contains("selenium testing")) {
				list.get(i).click();
				break;//used after the click is success comes out of loop
			}
		}*/
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("sunscreen");
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='left-pane-results-container']//div/descendant::div[contains(text(),'sunscreen')]"));
		
		System.out.println("total number of suggestions shown: "+list.size());
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getText());
			
			//clcik on "selenium testing
			if(list.get(i).getText().contains("sunscreen for women")) {
				list.get(i).click();
				break;//used after the click is success comes out of loop
			}
		}
	}
}
