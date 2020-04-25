package com.guru.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru.base.TestBase;
import com.guru.pages.BankHomePage;
import com.guru.pages.ManagerHomePage;

public class BankHomePageTest extends TestBase {
	BankHomePage bankHomePage;
	ManagerHomePage managerHomePage;
	
	public BankHomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		bankHomePage = new BankHomePage();
	}
	
	@Test (priority = 1)
	public void verifyHomePageTitleTest() {
		String guruPageTitle = bankHomePage.validateGuruPageTittle();
		Assert.assertEquals(guruPageTitle, "Guru99 Bank Home Page", "Home page title matched");
	}
	
	@Test (priority = 2)
	public void verifyGuruLogoTest() {
		Assert.assertTrue(bankHomePage.verifyGuruLogo(), "Guru Logo Present");
	}
	
	@Test (priority = 3)
	public void verifyGuruHeaderTest() {
		Assert.assertTrue(bankHomePage.verifyGuruHeader(), "Guru Header Present");
	}
	
	@Test (priority = 4)
	public void VerifyGuruHeaderText() {
		String headerText = bankHomePage.validateGuruHeader();
		Assert.assertEquals(headerText, "Demo Site");
	}
	
	@Test (priority = 5)
	public void verifyTheLoginSection() {
		managerHomePage = bankHomePage.loginSection(prop.getProperty("userId"), prop.getProperty("Password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
