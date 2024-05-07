package com.ActionsDemo_7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickDemo_3 {
	WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\g.venkataramana\\Downloads\\edgedriver_win64 (2)\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).perform();
		driver.findElement(By.xpath("(//span[contains(text(),'Sign in')])[1]")).click();
		driver.findElement(By.id("ap_email")).sendKeys("6302935810");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("bt07sv");
		driver.findElement(By.id("signInSubmit")).click();

		driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).sendKeys("samsung s24 ultra");
		action.doubleClick(driver.findElement(By.xpath("//input[@id=\"nav-search-submit-button\"]"))).perform();
	}

}
