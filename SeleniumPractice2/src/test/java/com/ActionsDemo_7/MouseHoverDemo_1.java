package com.ActionsDemo_7;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class MouseHoverDemo_1 {
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

		Select dropDown = new Select(driver.findElement(By.id("searchDropdownBox")));
		dropDown.selectByVisibleText("Beauty");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		
		//driver.findElement(By.xpath("(//button[@class='sl-sobe-carousel-goto-nextpage' and contains(text(),'❯')])[1]")).click();
		driver.findElement(By.linkText("Skincare")).click();
		driver.findElement(By.linkText("Sunscreens")).click();
		
		driver.findElement(By.xpath("(//a[@title='Aqualogica Glow+ Dewy Sunscreen SPF 50 PA++++ | UVA/B &amp; Blue Light Protection for Men &amp; Women | Oily, Dry, Sensitive &amp; Combination Skin | Fragrance-Free | 50g'])[1]")).click();
		
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			driver.switchTo().window(window);
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Select quantityDropDown = new Select(driver.findElement(By.xpath("(//select[@id='quantity'])[1]")));
		quantityDropDown.selectByValue("2");
		driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[1]")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'Go to Cart')])[2]")).click();
		driver.findElement(By.xpath("(//input[@value='Delete'])[1]")).click();
		
		action.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).perform();
		driver.findElement(By.xpath("//span[contains(text(),'Sign Out')]")).click();
		driver.close();
	}
}
