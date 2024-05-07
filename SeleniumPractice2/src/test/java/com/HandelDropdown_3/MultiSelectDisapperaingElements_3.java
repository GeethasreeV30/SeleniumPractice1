package com.HandelDropdown_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class MultiSelectDisapperaingElements_3 {
	public static WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driver = new EdgeDriver();
		driver.get("https://demoqa.com/select-menu");
		driver.manage().window().maximize();

		//disappering elements after inspect enter ctrl+shift+p type emulate focused page and slect it. Now enter the subject which we want and inspect the element from list to get its locator
		driver.findElement(By.cssSelector("#react-select-4-input")).sendKeys(" ");
		driver.findElement(By.cssSelector("#react-select-4-option-0")).click();
		driver.findElement(By.cssSelector("#react-select-4-option-1")).click();
		driver.findElement(By.cssSelector("#react-select-4-option-2")).click();
		
		//cancelling the 1st selected option
		driver.findElement(By.className("css-xb97g8")).click();

	}

}
