package com.handleWindows_6;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class MultipleWindowHandleDemo_1 {
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

		driver.findElement(By.partialLinkText("(Titanium Black, 12GB, 512GB Storage)")).click();
		
		String mainWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			driver.switchTo().window(window);
		}
		driver.close();//closes child window
		driver.switchTo().window(mainWindow);
	}
}
