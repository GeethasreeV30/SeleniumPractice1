package com.dynamicSearch_18;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AmazonDynamocSearch_2 {
	public static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driver = new EdgeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("sunscreen");
		//List<WebElement> list = driver.findElements(By.xpath("//div[@class='left-pane-results-container']//div//div[@class='s-suggestion s-suggestion-ellipsis-direction']"));
		List<WebElement> list = driver.findElements(By.xpath("//div[contains(text(),'sunscreen')]"));
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
