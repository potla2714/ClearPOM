package com.guru.util;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.guru.base.TestBase;

public class CustomListener extends TestUtil implements ITestListener{
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Failed");
		takeScreenshotAtEndOfTestFailed(result.getMethod().getMethodName());
		
	}
	
}