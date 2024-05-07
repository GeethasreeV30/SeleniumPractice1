package com.HandelDropdown_3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultipleDropDown_2 {
	public static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driver = new EdgeDriver();
		driver.get("https://demoqa.com/select-menu");
		driver.manage().window().maximize();

		Select select = new Select(driver.findElement(By.cssSelector("#cars")));
		if (select.isMultiple()) {
			select.selectByValue("volvo");
			select.selectByVisibleText("Opel");
			select.selectByIndex(1);
		}
		
		List<WebElement> options = select.getAllSelectedOptions();
		for(WebElement option:options) {
			System.out.println(option.getText());
		}
	}

}
