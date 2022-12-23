package com.qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();
	
	public WebDriver inItBrowser(String browser)
	{
		
		if(browser.equals("Chrome"))
		{
			tldriver.set(new ChromeDriver());
		}
		else if(browser.equals("Firefox"))
		{
			tldriver.set(new FirefoxDriver());
		}
		else
		{
			System.out.println("Please check the name of browser");
		}
		
		
		getdriver().manage().window().maximize();
		
		return getdriver();
		
	}
	
	public static synchronized WebDriver getdriver()
	{
		return tldriver.get();	
	}
}
