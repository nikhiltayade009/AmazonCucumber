package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LoginPage {

	
	private WebDriver driver;
	
	 
	private By hoveraccount =By.xpath("//*[@id='nav-link-accountList']");
	
	private By hoversignin = By.xpath("//*[@id='nav-flyout-ya-signin']//*[@class='nav-action-inner']");
	
	private By username = By.xpath("//*[@id='ap_email']");
	
	private By continuebutton = By.xpath("//*[@type='submit']");
	
	private By password = By.xpath("//*[@id='ap_password']");
	
	private By signinbutton = By.xpath("//*[@id='signInSubmit']");
	
	private By orderslink = By.xpath("//*[@id='nav-orders']");
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
				
	}
	
	public String getLoginPageTitle()
	{
	 return driver.getTitle();
	}
	
	public boolean isOrderDisplayed()
	{
		WebElement OrderElement = driver.findElement(orderslink);
		
		return OrderElement.isDisplayed();	
	}
	
	
	public void enterusername()
	{
		Actions act = new Actions(driver);
		
		act.moveToElement(driver.findElement(hoveraccount)).perform();
		
		driver.findElement(hoversignin).click();
		
		driver.findElement(username).sendKeys("8668321787");
		
		driver.findElement(continuebutton).click();
	}
	
	
	public void enterpassword()
	{
		driver.findElement(password).sendKeys("123456");
	}
	
	public void finalsignin()
	{
		driver.findElement(signinbutton).click();
	}
	
	
	public SearchProduct doLogin(String un ,String pwd)
	{
		//entering username
         Actions act = new Actions(driver);
		
		act.moveToElement(driver.findElement(hoveraccount)).perform();
		
		driver.findElement(hoversignin).click();
		
		driver.findElement(username).sendKeys(un);
		
		driver.findElement(continuebutton).click();
		
		
		//entering password
		driver.findElement(password).sendKeys(pwd);
		
		//Signin 
		driver.findElement(signinbutton).click();;
		
		return new SearchProduct(driver); 
		
	}
	
	
	
}
