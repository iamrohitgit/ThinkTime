package com.ThinkTime.scripts;

import org.testng.annotations.Test;

import com.ThinkTime.pom.AddCorporateTaskPage;
import com.ThinkTime.pom.CommonElementClass;
import com.ThinkTime.pom.LoginPage;
import com.ThinkTime.pom.TaskCreationPage;

public class TestPresenceOfElements extends SuperClass{
	@Test
	public void presenceOfElement()
	{
		LoginPage lPage = new LoginPage(driver);
		lPage.loginAction();
		CommonElementClass ceClass = new CommonElementClass(driver);
		ceClass.selectFromExecuteLink();
		TaskCreationPage tcPage = new TaskCreationPage(driver);
		tcPage.clickNewDistributedTaskLink();
		AddCorporateTaskPage actPage = new AddCorporateTaskPage(driver);
		actPage.isWebElementPresent();
	}

}
