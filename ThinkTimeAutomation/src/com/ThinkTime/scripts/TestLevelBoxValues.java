package com.ThinkTime.scripts;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.ThinkTime.pom.AddCorporateTaskPage;
import com.ThinkTime.pom.CommonElementClass;
import com.ThinkTime.pom.LoginPage;
import com.ThinkTime.pom.TaskCreationPage;

public class TestLevelBoxValues extends SuperClass{
	@Test
	public void testLevelBoxValues() throws InterruptedException
	{
		LoginPage lPage = new LoginPage(driver);
		lPage.loginAction();
		CommonElementClass ceClass = new CommonElementClass(driver);
		ceClass.selectFromExecuteLink();
		TaskCreationPage tcPage = new TaskCreationPage(driver);
		tcPage.clickNewDistributedTaskLink();
		AddCorporateTaskPage actPage = new AddCorporateTaskPage(driver);
		List<String> levelBoxValues = actPage.getLevelList();
		System.out.println(levelBoxValues);
	
		}	
	}
