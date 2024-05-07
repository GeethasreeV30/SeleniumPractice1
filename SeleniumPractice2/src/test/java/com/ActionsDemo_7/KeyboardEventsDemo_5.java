package com.ActionsDemo_7;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardEventsDemo_5 {
	WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\g.venkataramana\\Downloads\\edgedriver_win64 (2)\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		driver.get("https://quillbot.com/grammar-check");
		driver.manage().window().maximize();

		Actions action = new Actions(driver);
		// typing text
		action.sendKeys(driver.findElement(By.xpath("//div[@id='GRAMMAR_EDITOR_MAIN']")), "Today is your")
				.keyDown(Keys.SHIFT).sendKeys("birthday").keyUp(Keys.SHIFT).build().perform();
		// select all text
		action.keyDown(driver.findElement(By.xpath("//div[@id='GRAMMAR_EDITOR_MAIN']")), Keys.CONTROL).sendKeys("a")
				.keyUp(Keys.CONTROL).build().perform();
		// copy text
		action.keyDown(driver.findElement(By.xpath("//div[@id='GRAMMAR_EDITOR_MAIN']")), Keys.CONTROL).sendKeys("c")
				.keyUp(Keys.CONTROL).build().perform();

		action.keyDown(driver.findElement(By.xpath("//div[@id='GRAMMAR_EDITOR_MAIN']")), Keys.CONTROL).sendKeys("v")
				.keyUp(Keys.CONTROL).build().perform();
	}

}
