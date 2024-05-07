package com.BrokenLink_20;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinkDemo_1 {
	// 1. Collect all the links in the web page based on "a" and "img" tags.
	// 2. Send HTTP request for the link and read HTTP response code.
	// 3. Find out whether the link is valid or broken based on HTTP response code.
	// 4. Repeat this for all the links captured.
	WebDriver driver;

	@BeforeTest
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	}

	@Test
	public void brokenLinkVerify() throws IOException {
		// 1. Collect all the links in the web page based on "a" and "img" tags.
		List<WebElement> links = driver.findElements(By.tagName("a"));
		links.addAll(driver.findElements(By.tagName("img")));
		System.out.println("total count of links and images: "+links.size());
		
		//2. iterate linksist : exclude all the links/images - doesnt have any href attribute and also exclude links with javascript
		List<WebElement> activeLinks = new ArrayList<WebElement>();
		for(int i =0;i<links.size();i++) {
			if(links.get(i).getAttribute("href") != null && (! links.get(i).getAttribute("href").contains("javascript"))) {
				activeLinks.add(links.get(i));
			}
		}
		System.out.println("total count of active links and images: "+activeLinks.size());
		
		//3. check href URL with httpurlconnection
		for(int i = 0;i<activeLinks.size();i++) {
			HttpURLConnection connection = (HttpURLConnection)new URL(activeLinks.get(i).getAttribute("href")).openConnection();
			connection.connect();
			String response = connection.getResponseMessage();
			connection.disconnect();
			System.out.println(activeLinks.get(i).getAttribute("href")+"--->"+response);
		}
	}
}

