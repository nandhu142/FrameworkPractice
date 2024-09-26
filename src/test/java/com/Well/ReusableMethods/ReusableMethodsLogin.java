package com.Well.ReusableMethods;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

public class ReusableMethodsLogin extends BaseClass {
	public void Login() throws IOException, InterruptedException
	{
		System.out.println("In reusable method");
		Properties OR = new Properties();
		FileInputStream fp = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/resources/ObjectLocator.properties");
		OR.load(fp);
		String Email="nandhakumaaran.s@sys-core.com";
		String Password="Init@2024";
		CommonMethod.sendKeys("EmailTextBox", Email);
		CommonMethod.sendKeys("PasswordBox", Password);
		Thread.sleep(4000);
		CommonMethod.RobustClick("SigninBtn");
		Thread.sleep(60000);		
		
	}
	
}
