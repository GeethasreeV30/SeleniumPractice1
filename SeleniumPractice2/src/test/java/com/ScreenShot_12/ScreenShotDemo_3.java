package com.ScreenShot_12;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
@Listeners(ITestListenerClass_2.class)
public class ScreenShotDemo_3 extends BaseClass{
	@Test
	public void google() {
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("youtube");
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[4]/div[2]/div[1]/div/ul/li[1]/div/div[2]/div[1]/div[1]/span")).click();
	}

	@Test
	public void amazon() {
		driver.get("https://www.thewellnesscorner.com/");
		SoftAssert softAssert = new SoftAssert();
		driver.findElement(By.xpath("//a[contains(text(),' GET STARTED')]")).click();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("g.venkataramana@accenture.com");
		driver.findElement(By.xpath("//div[contains(text(),'Continue')]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("vb");
		driver.findElement(By.xpath("//div[contains(text(),'Continue')]")).click();
		String actualResult = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div/div/div[3]/form/div/div/div/div/div/div/div[2]/div")).getText();
		//String expectedResult="Geethasree Venkataramana!";
		String expectedResult="Email and password does not match!";
		softAssert.assertEquals(expectedResult, actualResult);
		softAssert.assertAll();
	}
}
