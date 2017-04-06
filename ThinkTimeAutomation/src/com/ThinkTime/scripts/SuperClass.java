package com.ThinkTime.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ThinkTime.pom.LoginPage;

public class SuperClass {
WebDriver driver;
@BeforeMethod
public void launch()
{
	System.setProperty("webdriver.gecko.driver", "E://Workspace3//ThinkTimeAutomation//exeFile//geckodriver.exe");
	//driver =new FirefoxDriver();
	System.setProperty("webdriver.chrome.driver", "E://Workspace3//ThinkTimeAutomation//exeFile//chromedriver_win32//chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.navigate().to("http://kendo.thinktimedev.com/");
	driver.manage().window().maximize();
	
}

@AfterMethod
public void quit()
{
	driver.quit();
}
}
