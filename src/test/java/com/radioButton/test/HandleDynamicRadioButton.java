package com.radioButton.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.guru.base.TestBase;
import com.guru.pages.BankHomePage;
import com.guru.util.CustomListener;
import com.guru.util.TestUtil;

@Listeners(CustomListener.class)
public class HandleDynamicRadioButton extends TestBase {


	public HandleDynamicRadioButton() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		driver.get(prop.getProperty("radioBtnUrl"));
	}

	@Test
	public void radioBtnTest() {
		driver.getTitle();
		List<WebElement> listOfRadioBtns = driver.findElements(By.xpath("//input[@name = 'lang' and @type = 'radio']"));
		for(int i =0; i<listOfRadioBtns.size(); i++) {
			if (listOfRadioBtns.get(i).getAttribute("value").trim()
					.equalsIgnoreCase("Python")) {
				// Show the Checkbox count with value.
				System.out.println("CheckBox = " + i + " "
						+ listOfRadioBtns.get(i).getAttribute("value").trim());
				if (!(listOfRadioBtns.get(i).isSelected())) {
					listOfRadioBtns.get(i).click();
				} else {
					// De-select the check boxes.
					listOfRadioBtns.get(i).click();
				}
			}else if(listOfRadioBtns.get(i).getAttribute("type").trim()
					.equalsIgnoreCase("C#")) {

				// Show the size of radio buttons.
				System.out.println("Radio  = " + i + " "
						+ listOfRadioBtns.get(i).getAttribute("value").trim());

				// Select the radio button if not already selected.
				if (!(listOfRadioBtns.get(i).isSelected())) {
					listOfRadioBtns.get(i).click();
				}

			}

		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
