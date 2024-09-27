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
		String Username=null;
		String Password=null;
		Username = data.getCellData("Login", "AdminUserName", 3);
		Password = data.getCellData("Login", "Password", 3);
		System.out.println(Username);
		System.out.println(Password);
		CommonMethod.sendKeys("EmailTextBox", Username);
		CommonMethod.sendKeys("PasswordBox", Password);
		CommonMethod.getCurrentUrl();
		CommonMethod.isEnabled("SigninBtn");
		CommonMethod.RobustClick("SigninBtn");
		Thread.sleep(10000);		
		CommonMethod.isDisplayed("DashboardVisible",20);
//		CommonMethod.getCurrentUrl();
		System.out.println("Url after login :"+ CommonMethod.getCurrentUrl());
		Thread.sleep(4000);
	}
	
	
	
}
