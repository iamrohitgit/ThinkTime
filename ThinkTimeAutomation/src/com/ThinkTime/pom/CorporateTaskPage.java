package com.ThinkTime.pom;

import org.apache.xalan.xsltc.dom.ExtendedSAX;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CorporateTaskPage extends CommonElementClass{

	WebDriverWait wait = new WebDriverWait(driver,30);
	public CorporateTaskPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//span[contains(text(),'for Review')]")
	private WebElement ReviewButton;
	
	@FindBy(xpath="//span[contains(text(),'MORE ')]")
	private WebElement moreButton;
	
	@FindBy(xpath="//ul[@id='actionModalLinksDraft']//a[contains(text(),'Edit')]")
	private WebElement editOption;
	
	@FindBy(xpath="//button[text()='Submit for Review']")
	private WebElement submitForReviewButton;
	
	@FindBy(xpath="//div[@class='rightPart']//button[contains(text(),'Ready')]")
	private WebElement rDistributeButton;
	
	@FindBy(xpath="//button[text()='Ready to Distribute']")
	private WebElement readyForDistribute;

	@FindBy(xpath="//div[@class='rightPart']/button[text()='Nevermind, Cancel']")
	private WebElement nevermindCancelButton;
	
	@FindBy(xpath="//div[@class='modalConfirmation']")
	private WebElement toolTip;
	
	public void editAndSubmitTask() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		moreButton.click();
		Actions action = new Actions(driver);
		action.moveToElement(editOption).click().perform();
		js.executeScript("scroll(250, 0)");
		wait.until(ExpectedConditions.visibilityOf(nevermindCancelButton));
		JavascriptExecutor jse = (JavascriptExecutor)driver;

		jse.executeScript("arguments[0].click()", nevermindCancelButton); 
		//nevermindCancelButton.click();
		// if the element is on bottom.
		js.executeScript("scroll(0, 250)");
		wait.until(ExpectedConditions.visibilityOf(ReviewButton));
		ReviewButton.click();
		wait.until(ExpectedConditions.visibilityOf(submitForReviewButton));
		System.out.println("click on submitfrreview");
		wait.until(ExpectedConditions.titleContains("ThinkTime"));
		js.executeScript("scroll(250,0)");
		submitForReviewButton.sendKeys(Keys.RETURN);
		wait.until(ExpectedConditions.titleContains("ThinkTime"));
		wait.until(ExpectedConditions.visibilityOf(rDistributeButton));
		rDistributeButton.sendKeys(Keys.RETURN);
		action.moveToElement(toolTip).perform();
		System.out.println(toolTip.getText());
		wait.until(ExpectedConditions.titleContains("ThinkTime"));
		wait.until(ExpectedConditions.visibilityOf(readyForDistribute));
		readyForDistribute.sendKeys(Keys.RETURN);
		action.moveToElement(toolTip).perform();
		System.out.println(toolTip.getText());
		Thread.sleep(4000);
		
	}
	
	
}
