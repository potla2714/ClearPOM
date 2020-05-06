package com.ecomerce.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ecomerce.util.EcomTestUtil;
import com.guru.base.EcomTestBase;

public class ProductPage extends EcomTestBase{
	@FindBy(xpath = "//div//select[@title = 'Sort By']")
	WebElement dropDown;	
	
	@FindBy(xpath = "//h2[@class = 'product-name']//a")
	List<WebElement> listProductNames;
	
	public ProductPage() {
		PageFactory.initElements(driver, this);
	}

	//Initilizing page objects
	public String verifyProductPageTittle() {
		return driver.getTitle();
	}
	
	public void slectDropDown(String selectByText) {
		Select select = new Select(dropDown);
		select.selectByVisibleText(selectByText);		
	}
	
	public void getAllProductsList() {
		for (WebElement productNames : listProductNames) {
			String eachProductName = productNames.getText();
			System.out.println(eachProductName);
		}
	}

}
