package com.ThinkTime.pom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class AddCorporateTaskPage extends CommonElementClass{

	public AddCorporateTaskPage(WebDriver driver) {
		super(driver);
		
	}
	
	WebDriverWait wait = new WebDriverWait(driver,30);
   

	@FindBy(xpath="//span[text()='Select a task location level']")
	private WebElement levelBox;
	
	@FindBy(xpath="//div[@class='k-animation-container']/div/span/input[@class='k-textbox']")
	private WebElement levelBoxField;
		
	@FindBy(xpath="(//ul[@class='k-list k-reset'])[1]/li")
	private List<WebElement> levelBoxOptions;
	
	@FindBy(xpath="//input[@name='Title<']")
	private WebElement titleField;
	
	@FindBy(xpath="//a[text()='+ New Subtask']")
	private WebElement newSubTaskLink;
	
	@FindBy(xpath="(//div[@class='taskDetailsForm']/div//span[@class='k-icon k-i-arrow-n'])[1]")
	private WebElement increaseValueKey_hours;
	
	@FindBy(xpath="(//div[@class='taskDetailsForm']/div//span[@class='k-icon k-i-arrow-n'])[2]")
	private WebElement increaseValueKey_mins;
	
	@FindBy(xpath="(//div[@class='taskDetailsForm']/div//span[@title='Decrease value'])[1]")
	private WebElement decreaseValueKey_hours;
	
	@FindBy(xpath="(//div[@class='taskDetailsForm']/div//span[@title='Decrease value'])[2]")
	private WebElement decreaseValueKey_min;
	
	@FindBy(xpath="(//input[@class='k-formatted-value k-numerictextbox inputEst k-input k-valid'])[1]")
	private WebElement estWorkEffortField_hours;
	
	@FindBy(xpath="(//input[@class='k-formatted-value k-numerictextbox inputEst k-input k-valid'])[2]")
	private WebElement estWorkEffortField_mins;
	
	@FindBy(xpath="//div[@class='taskDetailsForm']/div[2]//span[text()='select']")
	private WebElement startDateCalendarButton;
	
	@FindBy(xpath="//input[@name='startDate']")
	private WebElement startDateCalendarField;
	
	@FindBy(xpath="//input[@name='endDate']")
	private WebElement dueDateCalendarField;
	
	@FindBy(xpath="//div[@class='taskDetailsForm']/div[4]//span[contains(text(),'Natasha')]")
	private WebElement ownerBox;
	
	@FindBy(xpath="(//ul[@class='k-list k-reset'])[11]/li")
	private List<WebElement> ownerBoxOptions;
	
	@FindBy(xpath="//div[@class='taskDetailsForm']/div[6]//span[text()='Select One']")
	private WebElement typeBox;
	
	@FindBy(xpath="(//ul[@class='k-list k-reset'])[13]/li")
	private List<WebElement> typeBoxOptions; 
	
	@FindBy(xpath="(//span[contains(text(),'Select a Role')])[3]")
	private WebElement roleBox;
	
	@FindBy(xpath="(//ul[@class='k-list k-reset'])[6]/li")
	private List<WebElement> roleBoxOptions;

	@FindBy(xpath="//button[text()='Save Changes']")
	private WebElement saveChangesButton;
	
	@FindBy(xpath="//div[@class='rightPart']/button[text()='Nevermind, Cancel']")
	private WebElement nevermindCancelButton;
	
	@FindBy(xpath="//h2[text()='Help Ticket Integration']")
	private WebElement helpTicketField;
	
	@FindBy(xpath="//a[text()='+ Add Requirement']")
	private WebElement addRequirement;
	
	@FindBy(xpath="//label[text()='Content']")
	private WebElement contentSection;
	
	@FindBy(xpath="//span[@class='k-widget k-tooltip k-tooltip-validation k-invalid-msg']")
	private List<WebElement> requiredFields;
	
	@FindBy(xpath="//div[@class='notificationMessage']")
	private WebElement errorMessage;
	
	public void handleErrorMessage()
	{
		
		String actualError = errorMessage.getText();
		if (actualError.isEmpty()) {
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed due to application error: "+actualError);
			Assert.fail();
		}
		
		
	}
	
	public void isWebElementPresent()
	{
		if(levelBox!= null){
			System.out.println("Level Box is Present");
			}else{
			System.out.println("Level Box is Absent");
			}
		if(titleField.isEnabled()){
			System.out.println("Title field is Enable");
			}else{
			System.out.println("Title field is Disabled");
			
			}
		if(newSubTaskLink.isDisplayed()){
			System.out.println("new subtask link is displayed");
			}else{
			System.out.println("new subtask link is not displayed");
			}
		if(saveChangesButton.isEnabled()){
			System.out.println("Save Changes button is Enable");
			}else{
			System.out.println("Save Changes button is Disabled");
			}
		if(nevermindCancelButton!= null){
			System.out.println("nevermindCancelButton is Present");
			}else{
			System.out.println("nevermindCancelButton is Absent");
			}
		if(startDateCalendarField.isEnabled()){
			System.out.println("Start date calendar field is Enable");
			}else{
			System.out.println("Start date calendar field is Disabled");
			}
		if(dueDateCalendarField.isEnabled()){
			System.out.println("Due date calendar field is Enable");
			}else{
			System.out.println("Due date calendar field is Disabled");
			}
		if(ownerBox.isSelected()){
			System.out.println("Owner drop down is Enable");
			}else{
			System.out.println("Owner drop down is Disabled");
			}
		if(typeBox.isSelected()){
			System.out.println("Type drop down is Enable");
			}else{
			System.out.println("Type drop down is Disabled");
			}
		if(roleBox.isSelected()){
			System.out.println("Role drop down is Enable");
			}else{
			System.out.println("Role drop down is Disabled");
			}		
	}
	
	
	public List<String> getLevelList()
	{
		List<String> levelOptions = new ArrayList<String>();
			wait.until(ExpectedConditions.titleContains("ThinkTime"));
			for (WebElement lbOption : levelBoxOptions)
			{
				levelOptions.add(lbOption.getAttribute("textContent"));
			}
			return levelOptions;
	}	
	
	public void selectLevelBoxValue(String value) throws InvalidFormatException, IOException, InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("scroll(250, 0)");
		wait.until(ExpectedConditions.titleContains("ThinkTime"));
		wait.until(ExpectedConditions.invisibilityOfAllElements(levelBoxOptions));
		levelBox.click();
	for(WebElement opt : levelBoxOptions)
		{
			
			if(opt.getAttribute("textContent").contains(value))
			{
				System.out.println("before");
				
				executor.executeScript("arguments[0].click();", opt);
				
				
			}
		}
	}
	
	public void enterRequiredFields(String titleValue, String startDateValue, String dueDateValue)
	{
	
		titleField.sendKeys(titleValue);
	    increaseValueKey_hours.click();
	    increaseValueKey_mins.click();
		startDateCalendarField.sendKeys(startDateValue);
		dueDateCalendarField.sendKeys(dueDateValue);
		
	}
	
	public void ownerBoxValue(String ownerValues) 
	{
		ownerBox.click();
		for(WebElement opt : ownerBoxOptions)
		{
			if(opt.getAttribute("textContent").contains(ownerValues))
			{
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", opt);
			}
		}
	}
	
	public void typeBoxValue(String typeValues) 
	{
		typeBox.click();
		for(WebElement opt : typeBoxOptions)
		{
			if(opt.getAttribute("textContent").contains(typeValues))
			{
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", opt);
			}
		}
	}
	
	public void roleBoxValue(String roleValues) 
	{
		roleBox.click();
		for(WebElement opt : roleBoxOptions)
		{
			if(opt.getAttribute("textContent").contains(roleValues))
			{
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", opt);
			}
		}
	}
	
	public void clickSaveButton()
	{
		saveChangesButton.click();
	}
	
	public void requiredFields()
	{
		for(WebElement requiredF : requiredFields)
		{
			
			{
				System.out.println("following are required - "+requiredF.getAttribute("data-for"));
				
			}
		}
		
	}
	
	
	
}
