package com.RegistrationForma_14;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class StudentRegistrationForm_1 {
	public static WebDriver driver;

	@BeforeTest
	public void openBrowser() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/automation-practice-form");
	}

	@Test
	public void registerForm() {
		//text boxes
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Ram");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Kumar");
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("ram40@gmail.com");
		
		//radio button
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label"))).click();
		
		//phone
		driver.findElement(By.xpath("//input[@id='userNumber']")).sendKeys("8678989834");
		
		//calender
		String day = "30";
		driver.findElement(By.xpath("//div//input[@id='dateOfBirthInput']")).clear();
		Select month = new Select(driver.findElement(By.className("react-datepicker__month-select")));
		month.selectByVisibleText("November");
		Select year = new Select(driver.findElement(By.className("react-datepicker__year-select")));
		year.selectByVisibleText("2000");
		driver.findElement(By.xpath("//div[contains(text(),"+day+")]")).click();//date
		
		//to perform Scroll on application using Selenium
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		
		//disappering elements after inspect enter ctrl+shift+p type emulate focus page and slect it. Now enter the subject which we want and inspect the element from list to get its locator
		driver.findElement(By.xpath("//input[@id='subjectsInput']")).sendKeys("c");
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Chemistry')]"))).click();
		driver.findElement(By.xpath("//input[@id='subjectsInput']")).sendKeys("p");
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Physics')]"))).click();
		driver.findElement(By.xpath("//input[@id='subjectsInput']")).sendKeys("m");
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Maths')]"))).click();
		//driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[6]/div[2]/div/div[2]/div/div[1]")).click();
		
		//check box
		new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[2]"))).click();
		new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[3]"))).click();
		
		//upload
		WebElement upload = driver.findElement(By.xpath("//input[@id='uploadPicture']"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		upload.sendKeys("C:\\Users\\g.venkataramana\\Desktop\\G.pdf");
		
		//address
		driver.findElement(By.xpath("//*[@id=\"currentAddress\"]")).sendKeys("erragadda");
		
		//scroll down
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,500)", "");
		
		//state
		driver.findElement(By.xpath("//input[@id='react-select-3-input']")).sendKeys("N");
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"react-select-3-option-0\"]"))).click();
		
		//city
		driver.findElement(By.xpath("//input[@id='react-select-4-input']")).sendKeys("D");
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"react-select-4-option-0\"]"))).click();
	}

	@AfterTest
	public void afterMethod() {
		driver.close();
	}
}
