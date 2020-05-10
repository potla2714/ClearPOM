package com.javascriptExecutor;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.guru.base.TestBase;
import com.guru.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExcuterTest extends TestBase{
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {
		String projectPath =System.getProperty("user.dir");
		//System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/ChromeDriver/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/V4/");
		
		JavascriptExecutor js1 = ((JavascriptExecutor)driver);
		//Fetching the Domain Name of the site. Tostring() change object to name.		
		String siteName = js1.executeScript("return document.domain;").toString();
		System.out.println(siteName);
		//======================================================================
		//site url
		String siteUrl = js1.executeScript("return document.URL;").toString();			
		System.out.println("URL of the site = "+siteUrl);
		//======================================================================
		//Method document.title fetch the Title name of the site. Tostring() change object to name		
		String titleName = js1.executeScript("return document.title;").toString();			
		System.out.println("Title of the page = "+titleName);	
		//======================================================================
		driver.findElement(By.name("uid")).sendKeys("mngr257534");	
		//js1.executeScript("document.getElementById('some id').value='someValue';");
		//js1.executeScript("document.getElementByxpath('//div[@id = 'name']').value = 'Anil';");
		driver.findElement(By.name("password")).sendKeys("Ytytyne");
		WebElement btn =driver.findElement(By.name("btnLogin"));
		//======================================================================
		//Scroll-Down Until an Element Displayed
		js1.executeScript("arguments[0].scrollIntoView(true);",btn);
		//======================================================================
		//Highlight an Element
		js1.executeScript("arguments[0].style.border='3px dotted blue'", btn);
		//======================================================================
		//Add backgroud colour
		js1.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",btn);
		//======================================================================
		//Perform Click on LOGIN button using JavascriptExecutor
		js1.executeScript("arguments[0].click();", btn);	
		//======================================================================
		//To generate Alert window using JavascriptExecutor.
		js1.executeScript("alert('Welcome dude');");
		//======================================================================
		Alert alert = driver.switchTo().alert();
		alert.accept();	
		//======================================================================
		//Vertical scroll down by 600  pixels	
		js1.executeScript("window.scrollBy(0,600)");
		//======================================================================
		// for scrolling till the bottom of the page we can use the code like
		js1.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		//======================================================================
		//Navigate to new Page i.e to generate access page. (launch new url)		
		js1.executeScript("window.location = 'http://google.com/'");
		//======================================================================
		//To refresh the Page
		js1.executeScript("history.go(0)");
		//======================================================================
		// To get innertext of the entire webpage in Selenium
		String sText =  js1.executeScript("return document.documentElement.innerText;").toString();
		System.out.println(sText);
		//======================================================================
		//To click on a SubMenu which is only visible on mouse hover on Menu
		// js.executeScript("$('ul.menus.menu-secondary.sf-js-enabled.sub-menu li').hover()");
		//======================================================================
		//Size of Window
		Object height = js1.executeScript("return window.innerHeight;");
		Object width = js1.executeScript("return window.innerWidth;");
		System.out.println(width+ " and " +height);
		//======================================================================
		driver.quit();
	}




}
