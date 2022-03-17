package com.assigment.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.assigment.pageObjects.Ass1PageObjects;
import com.utility.Screenshots;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ass1Test extends Ass1PageObjects {
	Ass1PageObjects obj = new Ass1PageObjects();
	Screenshots screenshot = new Screenshots();

	@BeforeMethod
	public void setProperty() {
		driver.manage().deleteAllCookies();

	}

	@BeforeTest
	public void launchUrl() {
		WebDriverManager.chromedriver().setup();

//		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Driver\\chromedriver.exe"); 
		driver = new ChromeDriver();
		driver.get("http://live.techpanda.org/index.php/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void SelectName() throws Exception {
        Thread.sleep(1000);
		obj.verifyPagetitle();
		obj.clickOnMobile();
//		screenshot.TakesScreenshots();
		obj.sortByName();
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();

	}

}
