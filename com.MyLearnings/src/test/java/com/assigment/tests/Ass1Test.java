package com.assigment.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.assigment.pageObjects.Ass1PageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ass1Test extends Ass1PageObjects {
	Ass1PageObjects obj = new Ass1PageObjects();


	
	@BeforeMethod
	public void setProperty() {
	//	WebDriverManager.chromedriver().setup();
	}
	

	@BeforeTest
	public void launchUrl() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Driver\\chromedriver.exe"); 
		driver = new ChromeDriver();
		driver.get("http://live.techpanda.org/index.php/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void Guru99() throws Exception {
		
		String actual= driver.getTitle();
		String expected="Home page" ;
		if(expected.equalsIgnoreCase(actual)) {
			System.out.println(driver.getTitle()+" Title is displayed");
			
		}else {
			System.out.println("Correct Title is not displayed");

		}
		
		obj.clickOnMobile();
		obj.sortByName();
	}
	
	
	@AfterTest
	public void closeBrowser() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}
}
