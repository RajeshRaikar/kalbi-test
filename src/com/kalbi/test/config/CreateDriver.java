package com.kalbi.test.config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.kalbi.lib.util.DataHandlers;

public class CreateDriver {
	
	public static WebDriver getDriverInstance()
	{
		WebDriver driver = null;
		String browser = DataHandlers.getDataFromProerties("configuration", "browser");
		String url =  DataHandlers.getDataFromProerties("configuration", "env");
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./browser-servers/chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./browser-servers/geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		else
		{
			System.err.println("invalid browser option please"+"check configuration.properties file");
			return driver;
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		if(url.equalsIgnoreCase("test"))
		{
			driver.get("https://demo.actitime.com");
			
		}
		else
		{
			driver.get("https://localhost/demo.actitime.com");	
		}
		return driver;
	}

}
