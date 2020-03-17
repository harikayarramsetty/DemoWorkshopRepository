package com.cts.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LauchWebBrowser {
	public static WebDriver driver;
	
	public static void start()
	{
		System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://demowebshop.tricentis.com/");
	    
	}

}
