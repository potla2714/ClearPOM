package com.guru.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru.base.TestBase;

public class BankHomePage extends TestBase{
	
	//Page Factory
	@FindBy(xpath = "//div[@id='site-name']")
	WebElement guruHeader;
	
	@FindBy(xpath = "//img[contains(@alt,'Guru99')]")
	WebElement guruLogo;
	
	@FindBy(xpath = "//input[@name = 'uid']")
	WebElement loginUserId;
	
	@FindBy(xpath ="//input[@name = 'password']")
	WebElement loginPassword;
	
	@FindBy(xpath = "//input[@name = 'btnLogin']")
	WebElement loginBtn;
	
	public BankHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Initilizing page objects
	public boolean verifyGuruHeader() {
		return guruHeader.isDisplayed();
	}
	
	public String validateGuruHeader() {
		return guruHeader.getText();
	}
	
	public String validateGuruPageTittle() {
		return driver.getTitle();
	}
	
	public boolean verifyGuruLogo() {
		return guruLogo.isDisplayed();
	}
	
	public ManagerHomePage loginSection(String userId, String userPassword) {
		loginUserId.sendKeys(userId);
		loginPassword.sendKeys(userPassword);
		loginBtn.click();
		return new ManagerHomePage();
	}

}
