package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ApparelAndShoesPage {

	private By apparelLoc = By.xpath("(//a[contains(text(),'Apparel & Shoes')])[1]");
	private By blueAndGreenSneakerLoc = By.linkText("Blue and green Sneaker");
	private By quantityLoc = By.id("addtocart_28_EnteredQuantity");
	private By addTocartLoc = By.id("add-to-cart-button-28");
	private By shoppingLoc = By.xpath("//span[text()='Shopping cart']");
	private By shoppingQuantityLoc = By.xpath("//input[contains(@name,'itemquantity')]");
	
	private WebDriver driver;
	public ApparelAndShoesPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void clickOnApparelAndShoes()
	{
		driver.findElement(apparelLoc).click();
	}
	
	public void clickOnBlueAndGreenSneaker()
	{
		
		driver.findElement(blueAndGreenSneakerLoc).click();
	}
	
	public void clearQuantity()
	{
		driver.findElement(quantityLoc).clear();
	}
	
	public void enterQuantity(String qty)
	{
		driver.findElement(quantityLoc).sendKeys(qty);
	}
	
	public void clickOnAddtoCart()
	{
		driver.findElement(addTocartLoc).click();
	}
	
	public void clickOnShoppingCart()
	{
		driver.findElement(shoppingLoc).click();
	}
	
	public String quantityAssertion()
	{
		WebElement quantity = driver.findElement(shoppingQuantityLoc);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return  js.executeScript("return arguments[0].value;", quantity).toString();


	}
}
