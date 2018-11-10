package com.kalbi.lib.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public WebElement getUserNameTextbox()
	{
		WebElement element = driver.findElement(By.name("Username"));
		return element;
	}
	public WebElement getPasswordTextbox()
	{
		return driver.findElement(By.xpath("//input[@type='submit]"));
	}
	public WebElement getLoginErrMsg()
	{
		return driver.findElement(By.xpath("//span[contains(text(),'Username or password')]"));
		
	}
	public void waitForLoginPageToLoad()
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("Loginform"))));
	}
}
