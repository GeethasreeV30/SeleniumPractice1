package com.locatorsDemo_2;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LinkTextLocatorDemo_5 {
	WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\g.venkataramana\\Downloads\\edgedriver_win64 (2)\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.findElement(By.id("nav-link-accountList")).click();
		driver.findElement(By.id("ap_email")).sendKeys("6302935810");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("bt07sv");
		driver.findElement(By.id("signInSubmit")).click();

		// search
		driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).sendKeys("samsung s24 ultra");
		driver.findElement(By.xpath("//input[@id=\"nav-search-submit-button\"]")).click();

		driver.findElement(By.linkText("Samsung Galaxy S24 Ultra 5G AI Smartphone (Titanium Black, 12GB, 512GB Storage)")).click();
		
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			driver.switchTo().window(window);
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//driver.findElement(By.xpath("//input[@id=\"add-to-cart-button\" and @title=\"Add to Shopping Cart\" and @type=\"button\" and@value=\"Add to Cart\"]")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div[5]/div[3]/div[1]/div[3]/div/div[1]/div/div[1]/div/div/div[2]/div/div[2]/div/form/div/div/div[36]/div[1]/span/span/span/input")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.navigate().to("https://www.amazon.in/ref=nav_logo");
	}
}