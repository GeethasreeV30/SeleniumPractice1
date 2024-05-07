package com.webdriverDemo_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverLaunchDemo_1 {
	WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\g.venkataramana\\Downloads\\edgedriver_win64 (2)\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id=\"nav-link-accountList\"]")).click();
		driver.findElement(By.xpath("//input[@id=\"ap_email\"]")).sendKeys("6302935810");
		driver.findElement(By.xpath("//input[@id=\"continue\"]")).click();
		driver.findElement(By.xpath("//input[@id=\"ap_password\"]")).sendKeys("bt07sv");
		driver.findElement(By.xpath("//input[@id=\"signInSubmit\"]")).click();
		System.out.println(driver.getTitle());
		driver.close();


	}

}
