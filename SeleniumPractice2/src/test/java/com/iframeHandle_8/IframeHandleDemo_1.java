package com.iframeHandle_8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class IframeHandleDemo_1 {
	WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\g.venkataramana\\Downloads\\edgedriver_win64 (2)\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		
		//switch to frame
		WebElement childFrame = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(childFrame);
		
		WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement target = driver.findElement(By.xpath("//div[@id='droppable']"));
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).perform();
		
		//switch to main page
		driver.switchTo().defaultContent();
		String s = driver.findElement(By.xpath("//p[contains(text(),'Create targets for draggable elements.')]")).getText();
		System.out.println(s);
		//driver.close();
		
	}

}
