package com.Well.Engine;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CommonMethod extends BaseClass{
	public static WebElement findElement(final String objectLocater) throws IOException {
		Properties p = new Properties();
		FileInputStream fp = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/resources/ObjectLocator.properties");
		p.load(fp);

		String objecttypeandvalues = p.getProperty(objectLocater);
		String[] splits = objecttypeandvalues.split("~");
		String objecttype = splits[0];
		objectvalue = splits[1];
		switch (objecttype) {

		case "id":
			return driver.findElement(By.id(objectvalue));

		case "xpath":

			return driver.findElement(By.xpath(objectvalue));

		case "name":

			return driver.findElement(By.name(objectvalue));

		case "class":

			return driver.findElement(By.className(objectvalue));

		case "tagname":

			return driver.findElement(By.tagName(objectvalue));

		case "css":

			return driver.findElement(By.cssSelector(objectvalue));

		case "linkText":

			return driver.findElement(By.linkText(objectvalue));
			
		default:
			
			return null;
		}

	}
	
	public static void sendKeys(String objectLocater, String value) throws IOException {
		findElement(objectLocater).sendKeys(value);
	}
	
	public static String getCurrentUrl() {
		System.out.println(driver.getCurrentUrl());
		String getCurrentUrl = driver.getCurrentUrl();
		return getCurrentUrl;
	}

	
	public static void RobustClick(String objectLocator) throws IOException
	{
		CommonMethod.findElement(objectLocator).click();	
	}
	
	public static void isEnabled(String objectLocator) throws IOException
	{
		Boolean b=findElement(objectLocator).isEnabled();
		if(b==true)
		{
			System.out.println("signin button is clickable");
		}
		else
		{
			System.out.println("signin button is not clickable");
		}
	}
	
	
	public static void isDisplayed(String objectLocator, int Timeout) throws IOException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Timeout));
		Boolean b=findElement(objectLocator).isDisplayed();
		System.out.println(b);
		if(b==true)
		{
			System.out.println("Login success!!!");
		}
		else
		{
			System.out.println("Login Failed...");
		}
	}
}
