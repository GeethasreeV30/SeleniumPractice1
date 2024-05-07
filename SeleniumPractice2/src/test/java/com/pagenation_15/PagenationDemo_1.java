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

public class PagenationDemo_1 {
	//pagenation 1 2,3,4,5,6 using for loop without clicking next button(clicking on number button)
	public static WebDriver driver;
	@BeforeTest
	public void openBrowser() {
		driver = new EdgeDriver();
		driver.get("https://datatables.net/examples/advanced_init/dt_events.html");
		driver.manage().window().maximize();
	}
	@Test
	public void pagenationMethod() throws InterruptedException {
		List<WebElement> pages =  driver.findElements(By.xpath("//div[@class='dt-paging paging_full_numbers']//following::button"));
		int pagnationSize = pages.size();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		
		driver.findElement(By.xpath("//div[@class='dt-paging paging_full_numbers']//following::button[5]")).click();
		List<String> names = new ArrayList<String>();
		for(int i = 2;i<=pagnationSize-2;i++) {
			//clciking in pagenation 1 2,3,4,5,6
			driver.findElement(By.xpath("//div[@class='dt-paging paging_full_numbers']//following::button["+i+"]")).click();
			//storing the element of names column
			List<WebElement> nameElements = driver.findElements(By.cssSelector("#example>tbody>tr>td:nth-child(1)"));
			
			//getting text(name) from the name cloumn element and adding to names list
			for(WebElement nameElement:nameElements) {
				names.add(nameElement.getText());
			}
			Thread.sleep(1000);
		}
		for(String name:names) {
			System.out.println(name);
		}
		int totalNames = names.size();
		System.out.println("total number of names: "+totalNames);
		//at end of table there is string like "Showing 1 to 10 of 57 entries" so spliting this string and getting string "57"
		String displayCount = driver.findElement(By.xpath("//div[@id='example_info']")).getText().split(" ")[5];
		System.out.println("total number of displayed names oount: "+displayCount);
		Assert.assertEquals(displayCount ,String.valueOf(totalNames));
		Thread.sleep(1000);
		
	}
}
