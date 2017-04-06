package com.ThinkTime.scripts;

import org.testng.annotations.Test;

import com.ThinkTime.pom.LoginPage;

public class TestLoginPage extends SuperClass{
	@Test
	public void testLoginPage()
	{
		
		LoginPage lPage = new LoginPage(driver);
		lPage.loginAction();
		
	}

}
