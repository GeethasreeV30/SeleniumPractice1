package com.RobotClass_11;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;

public class FileUploadDemo_1 {
	WebDriver driver = new EdgeDriver();

	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\g.venkataramana\\Downloads\\edgedriver_win64 (3)\\msedgedriver.exe");
		driver.get("https://www.adobe.com/in/acrobat/online/pdf-editor.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	}

	@Test
	public void fileUpload() throws AWTException {
		Robot robot = new Robot();
		WebElement select = driver.findElement(By.xpath("//*[@id=\"CID\"]/div/div/div/div/div/div/div/div/div[2]/article/div[3]/div"));
		//driver.navigate().refresh();
		robot.setAutoDelay(5000);
		select.click();

		robot.setAutoDelay(5000);
		StringSelection stringSelect = new StringSelection("C:\\Users\\g.venkataramana\\Desktop\\G.pdf");
		robot.setAutoDelay(3000);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelect, null);
		robot.setAutoDelay(3000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.setAutoDelay(5000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.setAutoDelay(5000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.setAutoDelay(5000);
	}

	@AfterTest
	public void cloaseBrowser() {
	}

}
