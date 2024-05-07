package com.locatorsDemo_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class IdLocatorDemo_1 {
	WebDriver driver;
	
	public void idLocatorMethod() {
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
		System.out.println(driver.getTitle());
		driver.close();
	}

	public static void main(String[] args) {
		IdLocatorDemo_1 i = new IdLocatorDemo_1();
		i.idLocatorMethod();
	}

}
