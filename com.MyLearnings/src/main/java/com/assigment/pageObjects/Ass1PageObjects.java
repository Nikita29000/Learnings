package com.assigment.pageObjects;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.utility.Drivers;

public class Ass1PageObjects extends Drivers {
//	public static WebDriver driver;

	public static final By mobile = By.xpath("//a[text()='Mobile']");
	public static final By select = By.xpath("(//select[@title='Sort By'])[1]");
	public static final By Selectname = By
			.xpath("(//select[@title='Sort By']/option[normalize-space(text())='Name'])[1]");

	public static final By sonyPrice = By.xpath("//span[text()='$100.00']");
	public static final By sonyXperia = By.xpath("//h2//a[@title='Sony Xperia']");
	public static final By addToCart = By.xpath("//a[@title='Xperia']//following::button[@title='Add to Cart']");
	public static final By quantity = By.xpath("//input[@title='Qty']");
	public static final By updatebtn = By.xpath("//button[@title='Update']");
	public static final By Errormsg = By.xpath("//p[normalize-space(text())='* The maximum quantity allowed for purchase is 500.']");
	public static final By Emptycart= By.id("empty_cart_button");
	public static final By EmptyCartmsg= By.xpath("//h1//following::p[text()='You have no items in your shopping cart.']");
	public static final By iphoneAddCompare= By.xpath("(//a[@title='IPhone']//following::a[text()='Add to Compare'])[1]");
	public static final By sonyAddCompare= By.xpath("(//a[@title='Sony Xperia']//following::a[text()='Add to Compare'])[1]");
	public static final By Compare= By.xpath("//button[@title='Compare']");
	public static final By iphone = By.xpath("//h2//a[@title='IPhone']");

	

	
	public void verifyPagetitle() {
		String actual = driver.getTitle();
		String expected = "Home page";
		if (expected.equalsIgnoreCase(actual)) {
			System.out.println(driver.getTitle() + " Title is displayed");

		} else {
			System.out.println("Correct Title is not displayed");

		}

	}

	public void clickOnMobile() throws Exception {
		driver.findElement(mobile).click();

		String actual = driver.getTitle();
		String expected = "Mobile";
		if (actual.equalsIgnoreCase(expected)) {
			System.out.println(driver.getTitle() + " Title is displayed");

		} else {
			System.out.println("Correct Title is not displayed");

		}

		driver.findElement(select).click();
		Thread.sleep(2000);
		driver.findElement(Selectname).click();

	}

	public void sortByName() {
		ArrayList<String> notSorted = new ArrayList<String>();

		List<WebElement> allElements = driver.findElements(By.xpath("//h2//a"));

		for (int i = 0; i <= allElements.size() - 1; i++) {
			System.out.println(allElements.size());
			notSorted.add(allElements.get(i).getText());

			System.out.println("All Elements are " + notSorted);
		}
		ArrayList<String> sorted = new ArrayList<String>();
		for (String sortedList : notSorted) {
			sorted.add(sortedList);

		}
		Collections.sort(sorted);
		System.out.println("Sorted list is displayed" + sorted);

	}
	
	
	public void verifyPrices() throws Exception {
        Thread.sleep(1000);

		String menuPagePrice = driver.findElement(sonyPrice).getText();
		
		driver.findElement(sonyXperia).click();
		
		String detailPagePrice = driver.findElement(sonyPrice).getText();
        Thread.sleep(1000);

		Assert.assertEquals(menuPagePrice, detailPagePrice);
		System.out.println("Actual and expected values are displayed as expected");

		
	}
	
	
	public void verifyQuantityError() throws Exception {
		
		driver.findElement(addToCart).click();
		Thread.sleep(1000);

		driver.findElement(quantity).clear();
		driver.findElement(quantity).sendKeys("1000");

		Thread.sleep(1000);

		driver.findElement(updatebtn).click();
		Thread.sleep(1000);

		
		if(driver.findElement(Errormsg).isDisplayed()== true) {
			System.out.println("Quantity Error message is displayed");
		}else {
			System.out.println("Quantity Error message is not displayed");
		}
	}
	
	
	public void VerifyEmptyCart() throws Exception {
		
		driver.findElement(Emptycart).click();
		Thread.sleep(1000);
		if(driver.findElement(EmptyCartmsg).isDisplayed()== true) {
			System.out.println("Cart is Empty message is displayed");
		}else {
			System.out.println("Cart is not Empty ");
		}
	}
	
	
	public void AddToCompare() throws Exception {
		
		driver.findElement(iphoneAddCompare).click();
		Thread.sleep(1000);

		driver.findElement(sonyAddCompare).click();
		Thread.sleep(1000);

	}
	
	public void VerifyProducts() throws Exception {
		
		String parent = driver.getWindowHandle();
		driver.findElement(Compare).click();
		Thread.sleep(1000);
		
		Set <String> allWindows = driver.getWindowHandles();
		
		int count= allWindows.size();
		System.out.println(count);
		Thread.sleep(1000);

		for(String child: allWindows) {
			
			if(!parent.equalsIgnoreCase(child)) {
				Thread.sleep(1000);

				driver.switchTo().window(child);
				Thread.sleep(1000);

				driver.findElement(sonyXperia).isDisplayed();
				assertTrue(true, "Sony Xperia validated");
				Thread.sleep(1000);

				driver.findElement(iphone).isDisplayed();
				assertTrue(true, "Iphone validated");
				Thread.sleep(1000);

				driver.close();

				
			}
			
			driver.switchTo().window(parent);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
