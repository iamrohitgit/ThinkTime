
package com.ThinkTime.pom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.collections.CollectionUtils;

public class CommonElementClass {
	WebDriver driver;
	public CommonElementClass(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//table[@class='widgetTable']")
	private WebElement MyTasksTable;
	
	@FindBy(xpath="//table[@class='widgetTable']/tbody/tr")
	private List<WebElement> rowNames;

	@FindBy(xpath="//table[@class='widgetTable']/thead/tr/th")
	private List<WebElement> columnNames;
	
	@FindBy(xpath="(//tbody)[1]/tr/td")
	private List<WebElement> cellNames; 
	
	@FindBy(id="eLabel2")
	private WebElement executeLink;
	
	@FindBy(xpath="//div[@class='dropdown open']//a[text()='Task Creation']")
	private WebElement taskCreationLink;
	
	public void selectFromExecuteLink()
	{	executeLink.sendKeys(Keys.RETURN);
		Actions action = new Actions(driver);
		action.moveToElement(taskCreationLink).click().perform();
		
	}
	
	public void getDataMyTasksTable() throws InvalidFormatException, IOException
	{
		int rowCount = rowNames.size();
		//System.out.println(rowCount);
		int cellCount=cellNames.size();
		//System.out.println(cellCount);
		int columnCount = columnNames.size();
		List<String> contents = new LinkedList();
		int contentsSize = contents.size();
		for(int cellNum=0;cellNum<cellCount;cellNum++)
		{
			String content = cellNames.get(cellNum).getText();
			contents.add(content);
			System.out.println(content);
											
		}
			GenericExcel gExcel = new GenericExcel();
			int excelRowCount = gExcel.getRowCount("Sheet1");
		System.out.println("==================================================");
				List<String> edata=gExcel.getExcelData("Sheet1");
				
			    List<Integer> comparingList = new ArrayList<Integer>();
			    System.out.println("contents "+contents.size());
			    System.out.println("edata "+edata.size());
			    for (String a : contents)
			    {
			        for (String b : edata)
			        {
			            if (a.equals(b))
			            {
			                System.out.println("Equals " + a);
			                break;
			            }
			        }
			    }

	}	 

}
