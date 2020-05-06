package com.javascriptExecutor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExcuterTest2 {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		String projectPath =System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://ui.cogmento.com/");
		driver.findElement(By.name("email")).sendKeys("potla2714@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Anil@514");		 
		//driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();
		// driver.close();	

		WebElement btn = driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']"));
		//flash(btn, driver);
		//alertMsg("Warning");

		//Simple Code  lines
		JavascriptExecutor js1 = ((JavascriptExecutor)driver); 
		js1.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",btn);
		Thread.sleep(2000);
		//js1.executeScript("arguments[0].click();", btn);
		//js1.executeScript("history.go(0)");
		String title = js1.executeScript("return document.title;").toString();
		System.out.println(title);
		String text = js1.executeScript("return document.documentElement.innerText;").toString();
		System.out.println(text);
		js1.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		js1.executeScript("window.scrollBy(0,600)");
		js1.executeScript("arguments[0].scrollIntoView(true);", btn);
		//driver.close();
		//js1.executeScript("alert('Warning')");
		
	}

	public static void flash(WebElement element, WebDriver driver) {
		String bgColour = element.getCssValue("backgroundColor");
		for(int i=0; i<10; i++) {
			changeColour("rgb(0,200,0)", element, driver);
			changeColour(bgColour, element, driver);
		}		
	}

	public static void changeColour(String colour, WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.backgroundColor = '"+colour+"'", element);
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {

		}
	}

	public static void alertMsg(String msg) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("alert('"+msg+"')");

	}

}
