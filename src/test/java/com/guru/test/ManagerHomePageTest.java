package com.guru.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.guru.base.TestBase;
import com.guru.pages.BankHomePage;
import com.guru.pages.ManagerHomePage;

public class ManagerHomePageTest extends TestBase {
	BankHomePage bankHomePage;
	ManagerHomePage managerHomePage;
	
	public ManagerHomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		bankHomePage = new BankHomePage();
		managerHomePage = new ManagerHomePage();
		managerHomePage = bankHomePage.loginSection(prop.getProperty("userId"), prop.getProperty("Password"));
	}
	
	@Test
	public void verifyManagerHomePageTitle() {
		String managerPageTitle = managerHomePage.verifyGuruManagerTittle();
		Assert.assertEquals(managerPageTitle, "Guru99 Bank Manager HomePage", "Title Matched");
	}
	
	@Test (dependsOnMethods = {"verifyManagerHomePageTitle"})
	public void verifyMarqeeText() {
		String marqeeText = managerHomePage.verifymarqeeText();
		Assert.assertEquals(marqeeText, "Welcome To Manager's Page of Guru99 Bank");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
