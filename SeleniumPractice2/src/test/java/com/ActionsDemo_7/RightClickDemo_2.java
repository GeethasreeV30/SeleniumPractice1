package com.ActionsDemo_7;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickDemo_2 {
	WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\g.venkataramana\\Downloads\\edgedriver_win64 (2)\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		
		Actions action = new Actions(driver);
		action.contextClick(driver.findElement(By.xpath("//span[contains(text(),'right click me')]"))).perform();
		driver.findElement(By.xpath("(//span[contains(text(),'Copy')])[2]")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		driver.close();
	}

}
