package com.locatorsDemo_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class ClassLocatorDemo_3 {
	WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\g.venkataramana\\Downloads\\edgedriver_win64 (2)\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("nav-link-accountList")).click();
		//driver.findElement(By.className("a-input-text a-span12 auth-autofocus auth-required-field")).sendKeys("6302935810");
		driver.findElement(By.name("email")).sendKeys("6302935810");
		driver.findElement(By.id("continue")).click();
		//driver.findElement(By.className("a-button-input")).click();
		driver.findElement(By.name("password")).sendKeys("bt07sv");
		//driver.findElement(By.className("a-input-text a-span12 auth-autofocus auth-required-field")).sendKeys("bt07sv");
		driver.findElement(By.id("signInSubmit")).click();
		System.out.println(driver.getTitle());
		driver.close();

	}

}
