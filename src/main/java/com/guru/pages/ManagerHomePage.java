package com.guru.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru.base.TestBase;

public class ManagerHomePage extends TestBase{
	
	@FindBy(xpath = "//marquee[@class = 'heading3']")
	WebElement marqueeText;
	
	@FindBy(xpath = "//td[contains(text(),'Manger Id : mngr257534')]")
	WebElement mangerId;
	
	public ManagerHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyGuruManagerTittle() {
		return driver.getTitle();
	}
	
	public String verifymarqeeText() {
		return marqueeText.getText();
	}
	
	public String verifyMangerIdText() {
		return mangerId.getText();
	}

}
