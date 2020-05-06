package com.ecomerce.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ecomerce.pages.MagentoHomePage;
import com.ecomerce.pages.ProductPage;
import com.ecomerce.util.CustomListener;
import com.guru.base.EcomTestBase;
import com.guru.pages.BankHomePage;
import com.guru.pages.ManagerHomePage;

@Listeners(CustomListener.class)
public class HomePageTest extends EcomTestBase{
	MagentoHomePage magentoHomePage;
	ProductPage productPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		magentoHomePage = new MagentoHomePage();
		productPage = new ProductPage();
	}
	
	@Test
	public void homePageTest() {
		String homeTitle = magentoHomePage.verifyMagentoPageTittle();
		Assert.assertEquals(homeTitle, "Home page", "Title Matched");
		magentoHomePage.clickOnMenu("Mobile");
		String productPageTitle = productPage.verifyProductPageTittle();
		Assert.assertEquals(productPageTitle, "Mobile", "Title matched");
		productPage.slectDropDown("Name");
		productPage.getAllProductsList();		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
