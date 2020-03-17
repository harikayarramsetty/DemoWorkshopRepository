package com.cts.stepdefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	
	WebDriver driver;
	
	@Given("I have a browser with demoworkshop page")
	public void i_have_a_browser_with_demoworkshop_page() {
		
		System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://demowebshop.tricentis.com/");
	    
	}

	//1st scenario
	
	@When("I enter username as {string} and password as {string} and I go to electronics and click on phone and get the details of the product")
	public void i_enter_username_as_and_password_as_and_I_go_to_electronics_and_click_on_phone_and_get_the_details_of_the_product(String username, String password) {
	    
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
		driver.findElement(By.xpath("(//a[contains(text(),'Electronics')])[1]")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'Cell phones')])[4]")).click();
		driver.findElement(By.xpath("(//a[text()='Smartphone'])[2]")).click();
		
		WebElement detailsBox = driver.findElement(By.xpath("//div[@itemprop='description']"));
		List<WebElement> allDetails = detailsBox.findElements(By.tagName("p"));
		for(WebElement detail : allDetails)
		{
			
			System.out.println(detail.getText());
		}
	
	}
	
	@Then("I should get the details of phone")
	public void i_should_get_the_details_of_phone() {
		
		
		String actText = driver.findElement(By.xpath("//p[text()='Ideal for everyday use.']")).getText();
		Assert.assertEquals("Ideal for everyday use.", actText);
	
	}

	//2nd scenario
	
	
	@When("I enter username as {string} and password as {string} and I  go to apparel and shoes and click on any product and change the quantity to {string}")
	public void i_enter_username_as_and_password_as_and_I_go_to_apparel_and_shoes_and_click_on_any_product_and_change_the_quantity_to(String username, String password, String qty) {
	   
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
	
		driver.findElement(By.xpath("(//a[contains(text(),'Apparel & Shoes')])[1]")).click();
		driver.findElement(By.linkText("Blue and green Sneaker")).click();
		driver.findElement(By.id("addtocart_28_EnteredQuantity")).clear();
		driver.findElement(By.id("addtocart_28_EnteredQuantity")).sendKeys(qty);
		driver.findElement(By.id("add-to-cart-button-28")).click();
		driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
	
	
	
	}


	@Then("The quantity of the product should be changed to {int}")
	public void the_quantity_of_the_product_should_be_changed_to(Integer expQty) {
	    
		 WebElement quantity =  driver.findElement(By.xpath("//input[contains(@name,'itemquantity')]"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			//String actQty = js.executeScript("return document.getElementsByClassName('qty-input')[0].value;").toString();
			String actQty =js.executeScript("return arguments[0].value;", quantity).toString();
			
			System.out.println(actQty);
			Assert.assertEquals(expQty, actQty);
	}

	//3rd scenario
	
	@When("I enter username as {string} and password as {string} and I go to digital downloads and change the sort by to {string}")
	public void i_enter_username_as_and_password_as_and_I_go_to_digital_downloads_and_change_the_sort_by_to(String username, String password, String sort) {
	    
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
        driver.findElement(By.xpath("(//a[contains(text(),'Digital downloads')])[1]")).click();
		
		Select sortSelect = new Select(driver.findElement(By.id("products-orderby")));
		sortSelect.selectByVisibleText(sort);
	
	}

	
	@Then("It should be sorted to high to low")
	public void it_should_be_sorted_to_high_to_low() {
		
	  	String ele1 = driver.findElement(By.xpath("(//span[text()='10.00'])[2]")).getText();
	  	String ele2 = driver.findElement(By.xpath("(//span[text()='3.00'])")).getText();
	  	String ele3 = driver.findElement(By.xpath("(//span[text()='1.00'])")).getText();
	  	
	  	ele1 = ele1.replace(".00", "");
	  	ele2 = ele2.replace(".00", "");
	  	ele3 = ele3.replace(".00", "");
	  	System.out.println(ele1);
	  	
	  	int firstEle = Integer.parseInt(ele1);
	  	int secondEle = Integer.parseInt(ele2);
	  	int thirdEle = Integer.parseInt(ele3);
	  	
	  	if(firstEle > secondEle && secondEle > thirdEle)
	  	{
	  		System.out.println("sorted");
	  	}
	  	else
	  	{
	  		Assert.fail("not sorted");
	  	}
	    
	}


	//4th scenario
	
	@When("I enter username as {string} and password as {string} and I go to jewelry change the filter by price")
	public void i_enter_username_as_and_password_as_and_I_go_to_jewelry_change_the_filter_by_price(String username, String password) {
	    
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
		driver.findElement(By.xpath("(//a[contains(text(),'Jewelry')])[1]")).click();
		driver.findElement(By.xpath("//span[text()='3000.00']")).click();
		
		
	}
	
	@Then("It should be change to {int}-{int} filter")
	public void it_should_be_change_to_filter(Integer value1, Integer value2) {
		
		String valueText =  driver.findElement(By.xpath("//span[text()='2100.00']")).getText();
		valueText = valueText.replace(".00", "");
		int value = Integer.parseInt(valueText);
		
		if(value > value1 &&value < value2)
		{
			System.out.println("filterd by price");
		}
		else
		{
			Assert.fail("Do not filtered by value");
		}
	 }


	//5th scenario

	@When("I enter username as {string} and password as {string} and I go to gift cards change the view as to {string}")
	public void i_enter_username_as_and_password_as_and_I_go_to_gift_cards_change_the_view_as_to(String username, String password, String list) {
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
		driver.findElement(By.xpath("(//a[contains(text(),'Gift Cards')])[1]")).click();
		Select viewSelect = new Select(driver.findElement(By.id("products-viewmode")));
		viewSelect.selectByVisibleText(list);
		
	}

	@Then("It should be changed to list")
	public void it_should_be_changed_to_list() {
	  
		
		
	}
	
}
