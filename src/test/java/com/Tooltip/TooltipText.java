package com.Tooltip;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TooltipText {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://seleniumpractise.blogspot.com/2019/09/bootstrap-tooltip-in-selenium.html#");
		Actions act = new Actions(driver);   //Actions is a class
		act.moveToElement(driver.findElement(By.xpath("//a[text() = 'Hover over me']"))).perform();
		//to find tooltip, click on F8 or function F8 from keyboard after mouse hover 
		String toolTipText = driver.findElement(By.xpath("//div[@class = 'tooltip fade top in']")).getText();
		System.out.println(toolTipText);
		Assert.assertEquals(toolTipText, "Hooray!");
		driver.quit();
  
	}

}
