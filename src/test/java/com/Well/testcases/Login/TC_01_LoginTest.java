package com.Well.testcases.Login;

import java.io.IOException;

import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class TC_01_LoginTest extends BaseClass {
	@Test
	public void Login() throws IOException, InterruptedException
	{
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"WELL Login Functionality");
//		login.Login();
		try
		{
			login.Login();
		}
		catch(Throwable t){
			System.out.println("Something went wrong.....");
		}
	}
}
