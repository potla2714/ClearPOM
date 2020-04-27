package com.guru.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.guru.base.TestBase;
import com.guru.pages.BankHomePage;
import com.guru.pages.ManagerHomePage;
import com.guru.util.CustomListener;
import com.guru.util.TestUtil;

@Listeners(CustomListener.class)
public class BankHomePageTest extends TestBase {
	BankHomePage bankHomePage;
	ManagerHomePage managerHomePage;
	TestUtil testUtil;
	String sheetName = "LoginTest";
	
	public BankHomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		bankHomePage = new BankHomePage();
		testUtil = new TestUtil();
	}
	
	@Test (priority = 1)
	public void verifyHomePageTitleTest() throws IOException {
		String guruPageTitle = bankHomePage.validateGuruPageTittle();
		Assert.assertEquals(guruPageTitle, "Guru99 Bank Home Page", "Home page title matched");
		//TestUtil.takeScreenshotAtEndOfTest();
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
		String managerPageTitle = managerHomePage.verifyGuruManagerTittle();
		Assert.assertEquals(managerPageTitle, "Guru99 Bank Manager HomePage", "Title Matched");
	}
	
	@DataProvider
	public Object[][] getLoginData() {
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test (dataProvider = "getLoginData")
	public void verifyLoginSectionwithIncorrectInfo(String UserName, String Password) {
		managerHomePage = bankHomePage.loginSection(UserName, Password);
		String alertText = testUtil.alertText();
		Assert.assertEquals(alertText, "User or Password is not valid");
		testUtil.alertAccept();
		String headerText = bankHomePage.validateGuruHeader();
		Assert.assertEquals(headerText, "Demo Site");
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
