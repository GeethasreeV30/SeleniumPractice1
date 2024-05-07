package com.webdriverDemo_1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class WebElementSearchDemo_2 {
	WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\g.venkataramana\\Downloads\\edgedriver_win64 (2)\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[@id=\"nav-link-accountList\"]")).click();
		List<WebElement> inputs = driver.findElements(By.tagName("input"));
		System.out.println("number of input tags: " + inputs.size());

	}

}
