package com.ThinkTime.pom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardsPage extends CommonElementClass{

	public DashboardsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//ul[@class='k-tabstrip-items k-reset']/li")
	public List<WebElement> Dashboards;
	
	@FindBy(xpath="//ul[@class='k-tabstrip-items k-reset']")
	private WebElement DashboardsMenu;
	
	@FindBy(xpath="//h2[@class='titleWidget ng-binding']")
	public List<WebElement> Widgets;
	
	public List<String> getWidgetsNames()
	{
		List<String> widgetsNames = new ArrayList<String>();
		
		for (WebElement widget : Widgets)
		{
			widgetsNames.add(widget.getAttribute("textContent"));
		}		
		return widgetsNames;
	}
	
	public List<String> getDashboardNames()
	{
		List<String> dashNames = new ArrayList<String>();
		
		for (WebElement dash : Dashboards)
		{
			dashNames.add(dash.getAttribute("textContent"));
		}		
		return dashNames;
	}
	
	public List<String> getWidgetDataByName(String widgetName) throws InvalidFormatException
	{
		WebElement widgetTable = driver.findElement(By.xpath("//div[@class='listItem ng-scope widgetContainer']/div/h2[contains(text(),'"+widgetName+"')]/../div/div/table/tbody"));
		List<WebElement> cells = widgetTable.findElements(By.xpath("./tr/td"));
		List<String> contents = new LinkedList<String>();
		System.out.println("=============="+widgetName+"============");
		for(WebElement cell : cells){
			contents.add(cell.getText());
			for(int i=0;i<contents.size();i++)
			{
				GenericExcel gExcel=new GenericExcel();
				gExcel.writeToExcel(widgetName, i, 0, contents.get(i));
			}
			System.out.println(cell.getText());
		}
		return contents;
	}
}
