package com.utility;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
	Screenshots screenshot = new Screenshots();

	@Override
	 public void onTestStart(ITestResult result) {
		
		 
		  }

	@Override
	 public void onTestSuccess(ITestResult result) {
		  }

	@Override
	 public void onTestFailure(ITestResult result) {
	   System.out.println(result.getMethod().getMethodName());  
	   try {
		screenshot.TakesScreenshots();
	} catch (IOException e) {
		e.printStackTrace();
	}
		  }

	@Override
	 public void onTestSkipped(ITestResult result) {
		  }



















}

