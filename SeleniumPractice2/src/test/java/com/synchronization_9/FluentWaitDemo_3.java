package com.synchronization_9;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class FluentWaitDemo_3 {
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
		driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[2]")).click();
		/*FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(Duration.ofSeconds(30))
			       .pollingEvery(Duration.ofSeconds(5))
			       .ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						WebElement element = driver.findElement(By.xpath("//div[@id='attachDisplayAddBaseAlert']"));
						String getTextOnPage = element.getText();
						if(getTextOnPage.equals("Added to Cart")){
							System.out.println(getTextOnPage);
							WebElement cartbutton = driver.findElement(By.xpath("(//input[@class='a-button-input'])[37]"));
							return cartbutton;
						}else{
							System.out.println("FluentWait Failed");
							return null;
						}
					}
				});
		element.click();*/
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement cartbutton = driver.findElement(By.xpath("(//input[@class='a-button-input'])[37]"));
		cartbutton.click();
	}
}
