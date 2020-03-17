package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DigitalDownloadsPage {
    
	private By digitalDownloadsLoc = By.xpath("(//a[contains(text(),'Digital downloads')])[1]");
	private By selectPriceLoc = By.id("products-orderby");
	private By firstPriceLoc = By.xpath("//span[text()='10.00']");
	private By secondPriceLoc = By.xpath("(//span[text()='3.00'])");
	private By thirdPriceLoc = By.xpath("(//span[text()='1.00'])");
	
	private WebDriver driver;
	public DigitalDownloadsPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public void clickOnDigitalDownloads()
	{
		 driver.findElement(digitalDownloadsLoc).click();
	}
	
	public void selectPrice(String sort)
	{
		Select sortSelect = new Select(driver.findElement(selectPriceLoc));
		sortSelect.selectByVisibleText(sort);

	}
	
	public String getFirstPrice()
	{
		return driver.findElement(firstPriceLoc).getText();	
	}
	
	public String getSecondprice()
	{
		return driver.findElement(secondPriceLoc).getText();
	}

	public String getThirdPrice()
	{
		return driver.findElement(thirdPriceLoc).getText();
	}
}
