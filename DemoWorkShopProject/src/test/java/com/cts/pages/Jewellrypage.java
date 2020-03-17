package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Jewellrypage {
	
	
	private By jewelryLoc = By.xpath("(//a[contains(text(),'Jewelry')])[1]");
	private By selectPriceLoc = By.xpath("//span[text()='3000.00']");
    private By priceLoc = By.xpath("//span[text()='2100.00']");
	
	private WebDriver driver;
	public Jewellrypage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public void clickOnJewelry()
	{
		driver.findElement(jewelryLoc).click();
	}
	
	public void clickOnPrice()
	{
		driver.findElement(selectPriceLoc).click();
	}
	
	public String getPrice()
	{
		return driver.findElement(priceLoc).getText();
		
	}

}
