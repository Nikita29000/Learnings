package com.utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

import com.assigment.pageObjects.Ass1PageObjects;

public class Screenshots extends Drivers{
	
	public void TakesScreenshots() throws IOException {
		
	
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File destFile=new File("./src/main/resources/Screenshot.png");
	FileUtils.copyFile(source, destFile);
	
	}

}
