package com.cts.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.cts.base.LauchWebBrowser;
import com.cts.pages.ApparelAndShoesPage;
import com.cts.pages.DigitalDownloadsPage;
import com.cts.pages.ElectronicsPage;
import com.cts.pages.GiftCardspage;
import com.cts.pages.Jewellrypage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	
	WebDriver driver;
	
	@Given("I have a browser with demoworkshop page")
	public void i_have_a_browser_with_demoworkshop_page() {
		
		LauchWebBrowser.start();
		this.driver= LauchWebBrowser.driver;
		
	}

	//1st scenario
	
	@When("I enter username as {string} and password as {string} and I go to electronics and click on phone and get the details of the product")
	public void i_enter_username_as_and_password_as_and_I_go_to_electronics_and_click_on_phone_and_get_the_details_of_the_product(String username, String password) {
	    
		ElectronicsPage electronics = new ElectronicsPage(driver);
		electronics.clickOnLogin();
		electronics.enterUsername(username);
		electronics.enterPassword(password);
		electronics.clickOnLoginButton();
		
		electronics.clickOnElectronics();
		electronics.clickOnCellPhones();
		electronics.clickOnSmartphones();
		electronics.getDetails("p");
		
	}
	
	@Then("I should get the details of phone")
	public void i_should_get_the_details_of_phone() {
		
		ElectronicsPage electronics = new ElectronicsPage(driver);
		String actText = electronics.electronicsAssertion();
		Assert.assertEquals("Ideal for everyday use.", actText);
	
	}

	//2nd scenario
	
	@When("I  go to apparel and shoes and click on any product and change the quantity to {string}")
	public void i_go_to_apparel_and_shoes_and_click_on_any_product_and_change_the_quantity_to(String qty) {
	    
	
		ApparelAndShoesPage apparel = new ApparelAndShoesPage(driver);
		apparel.clickOnApparelAndShoes();
		apparel.clickOnBlueAndGreenSneaker();
		apparel.clearQuantity();
		apparel.enterQuantity(qty);
		apparel.clickOnAddtoCart();
		apparel.clickOnShoppingCart();
		
	}

	@Then("The quantity of the product should be changed to {string}")
	public void the_quantity_of_the_product_should_be_changed_to(String expQty) {
	   
		ApparelAndShoesPage apparel = new ApparelAndShoesPage(driver);
		String actQty = apparel.quantityAssertion();
		System.out.println(actQty);
		Assert.assertEquals(expQty, actQty);

	}

		//3rd scenario
	
	@When("I enter username as {string} and password as {string} and I go to digital downloads and change the sort by to {string}")
	public void i_enter_username_as_and_password_as_and_I_go_to_digital_downloads_and_change_the_sort_by_to(String username, String password, String sort) {
	    
		
		ElectronicsPage electronics = new ElectronicsPage(driver);
		electronics.clickOnLogin();
		electronics.enterUsername(username);
		electronics.enterPassword(password);
		electronics.clickOnLoginButton();
		
		DigitalDownloadsPage digital = new DigitalDownloadsPage(driver);
		digital.clickOnDigitalDownloads();

		digital.selectPrice(sort);
	}

	
	@Then("It should be sorted to high to low")
	public void it_should_be_sorted_to_high_to_low() {
		
		DigitalDownloadsPage digital = new DigitalDownloadsPage(driver);
		String ele1 = digital.getFirstPrice();
		String ele2 = digital.getSecondprice();
	  	String ele3 = digital.getThirdPrice();
	  	
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
	    
		ElectronicsPage electronics = new ElectronicsPage(driver);
		electronics.clickOnLogin();
		electronics.enterUsername(username);
		electronics.enterPassword(password);
		electronics.clickOnLoginButton();
		
		
		Jewellrypage jewelry = new Jewellrypage(driver);
		jewelry.clickOnJewelry();
		jewelry.clickOnPrice();
	}
	
	@Then("It should be change to {int}-{int} filter")
	public void it_should_be_change_to_filter(Integer value1, Integer value2) {
		
		Jewellrypage jewelry = new Jewellrypage(driver);
		String valueText = jewelry.getPrice();
		valueText = valueText.replace(".00", "");
		int value = Integer.parseInt(valueText);

		if (value > value1 && value < value2) {
			System.out.println("filterd by price");
		} else {
			Assert.fail("Do not filtered by value");
		}
		
	 }


	//5th scenario

	@When("I enter username as {string} and password as {string} and I go to gift cards change the view as to {string}")
	public void i_enter_username_as_and_password_as_and_I_go_to_gift_cards_change_the_view_as_to(String username, String password, String list) {
		ElectronicsPage electronics = new ElectronicsPage(driver);
		electronics.clickOnLogin();
		electronics.enterUsername(username);
		electronics.enterPassword(password);
		electronics.clickOnLoginButton();
		
		GiftCardspage giftCard = new GiftCardspage(driver);
		giftCard.clickOnGiftCards();
		giftCard.selectClick(list);
		
	}

	@Then("It should be changed to list")
	public void it_should_be_changed_to_list() {
	  
		GiftCardspage giftCard = new GiftCardspage(driver);
		String actItem = giftCard.getGiftCardName();
		Assert.assertEquals("$5 Virtual Gift Card", actItem);
		
	}
	
}
