package org.dbserver.evaluation.store.appobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomeAppObject {
	private WebDriver driver;

	public HomeAppObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getProductSearch () {
		return this.driver.findElement(By.id("search_input")); 
	}
	public WebElement getProductSearchButton() {
		return this.driver.findElement(By.xpath(
				"//*[@id=\"tygh_main_container\"]/div[2]/div/div[1]/div[3]/div/div[1]/div/div/form/button")); 
	}
	public WebElement getSelectProduct() {
		return this.driver.findElement(By.cssSelector(
				"#pagination_contents > div.grid-list > div:nth-child(1) > div > form > div.ty-grid-list__control"));
	}
	public WebElement getGoProduct() {
		return this.driver.findElement(By.cssSelector(
			"#pagination_contents > div.grid-list > div:nth-child(1) > div > form > div.ty-grid-list__control > div > a"));
	}
	public WebElement getGoShoppingCart() {
		return this.driver.findElement(By.cssSelector("#sw_dropdown_8 > a > i"));
	}
	public WebElement getShoppingCart() { 
		return this.driver.findElement(By.cssSelector(".cm-cart-buttons > div:nth-child(1) > a:nth-child(1)"));
	}
	public WebElement getproduct() {
		return this.driver.findElement(By.cssSelector(".ty-cart-content > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2) > a:nth-child(1)"));
	}
} 
