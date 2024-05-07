package com.locatorsDemo_2;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class XpathLocatorDemo_8 {
	WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\g.venkataramana\\Downloads\\edgedriver_win64 (2)\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id=\"nav-link-accountList\"]")).click();
		driver.findElement(By.xpath("//input[@id='ap_email' and @name='email']")).sendKeys("6302935810");
		driver.findElement(By.xpath("//input[@class='a-button-input']")).click();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("bt07sv");
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		
		// search
		driver.findElement(By.xpath("//input[@placeholder='Search Amazon.in']")).sendKeys("samsung s24 ultra");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();

		driver.findElement(By.xpath("//span[contains(text(),'Samsung Galaxy S24 Ultra 5G AI Smartphone (Titanium Gray, 12GB, 512GB Storage)')]")).click();

		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			driver.switchTo().window(window);
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//in webpage there are two elements with same element so Index[2] is used to get only 2nd element
		driver.findElement(By.xpath("(//span[@id='submit.add-to-cart'])[2]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//driver.navigate().to("https://www.amazon.in/ref=nav_logo");
	}
}
