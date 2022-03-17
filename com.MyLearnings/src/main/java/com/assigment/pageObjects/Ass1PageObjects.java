package com.assigment.pageObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Ass1PageObjects {
	public static WebDriver driver;

	public static final By mobile = By.xpath("//a[text()='Mobile']");
	public static final By select = By.xpath("(//select[@title='Sort By'])[1]");
	public static final By Selectname = By
			.xpath("(//select[@title='Sort By']/option[normalize-space(text())='Name'])[1]");

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

}
