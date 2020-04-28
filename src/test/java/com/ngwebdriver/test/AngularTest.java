package com.ngwebdriver.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AngularTest {
	public static WebDriver driver;
	public static NgWebDriver ngDriver;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://hello-angularjs.appspot.com/sorttablecolumn");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Creating an instance of NgWebDriver
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);	
		ngDriver.waitForAngularRequestsToFinish();
	}
	
	@Test
	public void angularTest() {
		driver.findElement(ByAngular.model("name")).sendKeys("QA");
		driver.findElement(ByAngular.model("employees")).sendKeys("514");	
		driver.findElement(ByAngular.model("headoffice")).sendKeys("Hyderabd");
		driver.findElement(ByAngular.buttonText("Submit")).click();
		String txt = driver.findElement(ByAngular.repeater("company in companies").row(4).column("name")).getText();
		System.out.println(txt + " Added.");
		
		if(txt.equalsIgnoreCase("QA")) {
			System.out.println("New Company Added. Now remove it");
			driver.findElement(ByAngular.repeater("company in companies").row(4)).findElement(ByAngular.buttonText("Remove")).click();
			System.out.println("Removed Sucessfully");
		
		}
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
