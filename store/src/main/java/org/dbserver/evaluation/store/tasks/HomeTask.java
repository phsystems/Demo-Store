package org.dbserver.evaluation.store.tasks;

import org.dbserver.evaluation.store.appobjects.HomeAppObject;
import org.openqa.selenium.WebDriver;

public class HomeTask {
	private HomeAppObject home;
	private WebDriver driver;

	
	public static final String Home_URL ="http://demo.cs-cart.com/";
	
	public HomeTask (WebDriver driver) {
		this.home = new HomeAppObject(driver);
		this.driver = driver; 
	}
	public void fillProdutc(String product) { 
		this.home.getProductSearch().click();
		this.home.getProductSearch().clear();
		this.home.getProductSearch().sendKeys(product); 
	}
	public void searchProduto() {
		home.getProductSearchButton().click();
	}
	public void selectProdutc() {
		home.getSelectProduct().click();
	}
	public void goToProdutc() {
		home.getGoProduct().click(); 
	}
	public void goShoppingCart() {
		home.getGoShoppingCart().click();
	}
	public void shoppingCart() {
		home.getShoppingCart().click();
	}
	public void continueButton() {
		home.getContinueButton().click();
	}
	public void navigateToHomePage() {
		this.driver.get(Home_URL);
	}
	
}
