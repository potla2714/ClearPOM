package com.radioButton.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.guru.base.TestBase;
import com.guru.pages.BankHomePage;
import com.guru.util.TestUtil;

public class HandleDynamicRadioButton extends TestBase {
	
	
	public HandleDynamicRadioButton() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		driver.get(prop.getProperty("radioBtnUrl"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
