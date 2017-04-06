package com.ThinkTime.scripts;

import java.io.IOException;
import java.util.List;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;
import com.ThinkTime.pom.DashboardsPage;
import com.ThinkTime.pom.GenericExcel;
import com.ThinkTime.pom.LoginPage;

import org.testng.Assert;

public class TestDashboards extends SuperClass {
@Test
public void testDashboards() throws InvalidFormatException, IOException
{
	LoginPage lPage = new LoginPage(driver);
	lPage.loginAction();
	DashboardsPage dashPage= new DashboardsPage(driver);
	List<String> dashs = dashPage.getDashboardNames();
	GenericExcel gExcel = new GenericExcel();
	for(int i=0;i<dashs.size();i++)
	{
		gExcel.writeToExcel("Dashboards", i, 0, dashs.get(i));
	}
	System.out.println(dashs);
	List<String> widgets = dashPage.getWidgetsNames();
	for(int i=0;i<widgets.size();i++)
	{
		gExcel.writeToExcel("Widgets", i, 0, widgets.get(i));
	}
	System.out.println(widgets);
	List<String> widgetsToTest = gExcel.getExcelData("WidgetsToTestContent");
	System.out.println(widgetsToTest+" ->From Excel sheet");
	List<String> expectedData = new java.util.LinkedList<>();
	List<String> contents = new java.util.LinkedList<>();
	List<String> expectedDashs = gExcel.getExcelData("Dashboards");
	System.out.println(expectedDashs+" -> From excel");
	List<String> expectedWidgets = gExcel.getExcelData("Widgets");
	System.out.println(expectedWidgets+" -> From Excel");
	for (String widget : widgetsToTest){
		contents = dashPage.getWidgetDataByName(widget);
		expectedData = gExcel.getExcelData(widget);
		try {
			Assert.assertEquals(contents, expectedData);
			System.out.println("Current Ticket Status (Agent)& My Tasks (Task Receiver) data matches");
			
		} catch (Exception e) {
			
		}
		
		
	}
	try {
		Assert.assertEquals(dashs, expectedDashs);
		System.out.println("Dashboard contents matches with Excel's contents");
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	
	try {
		Assert.assertEquals(widgets, expectedWidgets);
		System.out.println("Widget contents matches with Excel's contents");
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	
}
}
