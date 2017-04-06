package com.ThinkTime.scripts;

import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.ThinkTime.pom.AddCorporateTaskPage;
import com.ThinkTime.pom.CommonElementClass;
import com.ThinkTime.pom.CorporateTaskPage;
import com.ThinkTime.pom.GenericExcel;
import com.ThinkTime.pom.LoginPage;
import com.ThinkTime.pom.TaskCreationPage;

public class TestAddCorporateTaskPage extends SuperClass{
@Test
public void testEnabledFields() throws InvalidFormatException, IOException, InterruptedException
{
	LoginPage lPage = new LoginPage(driver);
	lPage.loginAction();
	CommonElementClass ceClass = new CommonElementClass(driver);
	ceClass.selectFromExecuteLink();
	TaskCreationPage tcPage = new TaskCreationPage(driver);
	tcPage.clickNewDistributedTaskLink();
	AddCorporateTaskPage actPage = new AddCorporateTaskPage(driver);
	actPage.selectLevelBoxValue("Region");
	actPage.isWebElementPresent();
}

@Test
public void testRequiredFields() throws InvalidFormatException, IOException, InterruptedException
{
	LoginPage lPage = new LoginPage(driver);
	lPage.loginAction();
	CommonElementClass ceClass = new CommonElementClass(driver);
	ceClass.selectFromExecuteLink();
	TaskCreationPage tcPage = new TaskCreationPage(driver);
	tcPage.clickNewDistributedTaskLink();
	AddCorporateTaskPage actPage = new AddCorporateTaskPage(driver);
	actPage.selectLevelBoxValue("Region");
	actPage.clickSaveButton();
	actPage.requiredFields();
	
}
	
@Test
public void testACTPage() throws InvalidFormatException, IOException, InterruptedException
{
	try {
		LoginPage lPage = new LoginPage(driver);
		lPage.loginAction();
		CommonElementClass ceClass = new CommonElementClass(driver);
		ceClass.selectFromExecuteLink();
		TaskCreationPage tcPage = new TaskCreationPage(driver);
		tcPage.clickNewDistributedTaskLink();
		AddCorporateTaskPage actPage = new AddCorporateTaskPage(driver);
		actPage.selectLevelBoxValue("Region");
		actPage.enterRequiredFields("Bamji1", "3/8/2017", "3/24/2017");
		//actPage.ownerBoxValue("001_sergey_test 123");
		actPage.typeBoxValue("_test sync_");
		actPage.roleBoxValue("Country Manager");
		Thread.sleep(5000);
		actPage.clickSaveButton();
		Thread.sleep(6000);
		
		CorporateTaskPage ctPage = new CorporateTaskPage(driver);
		ctPage.editAndSubmitTask();
		System.out.println("dusted");
	} catch (Exception e) {
		AddCorporateTaskPage actPage = new AddCorporateTaskPage(driver);
		actPage.handleErrorMessage();
		// TODO: handle exception
	}
	
	}
}
