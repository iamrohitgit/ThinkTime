package com.ThinkTime.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.gson.annotations.Until;

public class TaskCreationPage extends CommonElementClass {
	
	WebDriverWait wait = new WebDriverWait(driver,30);
	public TaskCreationPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//a[contains(text(),'New Distributed Task')]")
	private WebElement newDistributedTaskLink;
	
	public void clickNewDistributedTaskLink()
	{
		wait.until(ExpectedConditions.titleContains("ThinkTime"));
		//new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='New Distributed Task']")));
		wait.until(ExpectedConditions.visibilityOf(newDistributedTaskLink));
		newDistributedTaskLink.click();
	}

}
