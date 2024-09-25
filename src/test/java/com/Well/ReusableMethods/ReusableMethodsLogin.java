package com.Well.ReusableMethods;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.Well.Engine.BaseClass;

public class ReusableMethodsLogin extends BaseClass {
	public void Login() throws IOException
	{
		System.out.println("In reusable method");
		Properties OR = new Properties();
		FileInputStream fp = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/resources/ObjectLocator.properties");
		OR.load(fp);
		
	}
	
}
