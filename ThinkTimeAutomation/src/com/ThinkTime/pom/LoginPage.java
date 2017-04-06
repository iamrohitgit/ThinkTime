package com.ThinkTime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends CommonElementClass{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	WebDriverWait wait = new WebDriverWait(driver,30);
	
	@FindBy(id="username")
	private WebElement usernameField;
	
	@FindBy(id="password")
	private WebElement passwordField;
	
	@FindBy(xpath="//button[@class='submitButton']")
	private WebElement loginField;
	
	public void loginAction()
	{
		usernameField.sendKeys("natasha.ciancio@mailinator.com");
		passwordField.sendKeys("1");
		loginField.click();
	}

}
