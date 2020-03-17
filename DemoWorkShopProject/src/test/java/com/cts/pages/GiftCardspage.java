package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class GiftCardspage {
	
	private By giftCardsLoc = By.xpath("(//a[contains(text(),'Gift Cards')])[1]");
	private By listLoc = By.id("products-viewmode");
	
	private WebDriver driver;
	public GiftCardspage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void clickOnGiftCards()
	{
		driver.findElement(giftCardsLoc).click();
	}
	
	public void selectClick(String list)
	{
		Select viewSelect = new Select(driver.findElement(listLoc));
		viewSelect.selectByVisibleText(list);
	}
	
	public String getGiftCardName()
	{
		return driver.findElement(By.linkText("$5 Virtual Gift Card")).getText();
	}

}
