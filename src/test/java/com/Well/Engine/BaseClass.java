package com.Well.Engine;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.Well.ReusableMethods.ReusableMethodsLogin;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static String BrowserName;
	public static String Environment;
	public static String TestUrl;
	public static String TestNGTestName;
	public static String TestCaseName;
	public String envVar;
	public static ReusableMethodsLogin login = new ReusableMethodsLogin();

	@BeforeSuite
	@Parameters({"browserName", "environment"})
	public void setUp(String browserName,String environment) throws InterruptedException, IOException
	{
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        System.out.println(browserName);
        System.out.println(environment);
        
		Properties prop = new Properties();
		if ((System.getenv("browserName") != null && !System.getenv("browserName").isEmpty())
				&& System.getenv("environment") != null && !System.getenv("environment").isEmpty())
		{
			browserName = System.getenv("browserName");
			environment = System.getenv("environment");
			Environment = environment;
			BrowserName = browserName;
			System.out.println(browserName);
			System.out.println(environment);
		}
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/Environment.properties");
		prop.load(file); 
		TestUrl = prop.getProperty("ENV_TEST");
		driver.get(TestUrl);
		if (Environment.equalsIgnoreCase("TEST")) {
			do {
				envVar = "https://test-v2-api.wellcertified.com/api/";
				// CommonMethod.waitForPageLoaded(120);
			} while (driver.getPageSource().contains("Project Error"));
		}
	}
	
		
	public void StartTest(String TestcaseName, String Description) {
		System.out.println("Starting Test : " + TestNGTestName);
		System.out.println("Starting Test : " + TestCaseName);
	}
	

	@AfterSuite
	public void end()
	{
		System.out.println("End suite");
		driver.quit();
	}
	
	
}
