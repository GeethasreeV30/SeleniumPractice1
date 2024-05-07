package com.synchronization_9;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitDemo_2 {
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
		driver.findElement(By.xpath("//input[@placeholder='Search Amazon.in']")).sendKeys("rare rabbit");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();

		driver.findElement(By.linkText("Solid Hobo Shoulder Bag for Women/Girl's")).click();
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			driver.switchTo().window(window);
		}
		
		driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[1]")).click();
		WebElement goCart = driver.findElement(By.xpath("(//a[contains(text(),'Go to Cart')])[2]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.elementToBeClickable(goCart));
		goCart.click();
		driver.findElement(By.xpath("(//input[@value='Delete'])[1]")).click();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).perform();
		driver.findElement(By.xpath("//span[contains(text(),'Sign Out')]")).click();
		driver.quit();
	}

}
