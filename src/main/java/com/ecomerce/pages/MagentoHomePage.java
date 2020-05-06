package com.ecomerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru.base.EcomTestBase;

public class MagentoHomePage extends EcomTestBase {

	//Page Factory
	@FindBy(xpath = "//ol//li//a[contains(text(), 'Mobile')]")
	WebElement clickOnMenu;


	public MagentoHomePage() {
		PageFactory.initElements(driver, this);
	}

	//Initilizing page objects
	public String verifyMagentoPageTittle() {
		return driver.getTitle();
	}
	
	public ProductPage clickOnMenu(String menuItem) {
		driver.findElement(By.xpath("//ol//li//a[contains(text(), '"+menuItem+"')]")).click();
		return new ProductPage();
	}

}
