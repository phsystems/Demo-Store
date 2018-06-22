package org.dbserver.evaluation.store.appobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomeAppObject {
	private WebDriver driver;

	public HomeAppObject(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getProductSearch() {
		return this.driver.findElement(By
				.id("search_input"));
	}

	public WebElement getProductSearchButton() {
		return this.driver.findElement(By
				.xpath("//*[@id=\"tygh_main_container\"]/div[2]/div/div[1]/div[3]/div/div[1]/div/div/form/button"));
	}

	public WebElement getSelectProduct() {
		return this.driver.findElement(By
				.cssSelector("#pagination_contents > div.grid-list > div:nth-child(1) > div > form > div.ty-grid-list__control"));
	}

	public WebElement getGoProduct() {
		return this.driver.findElement(By
				.cssSelector("#pagination_contents > div.grid-list > div:nth-child(1) > div > form > div.ty-grid-list__control > div > a"));
	}

	public WebElement getGoShoppingCart() {
		return this.driver.findElement(By
				.cssSelector("#sw_dropdown_8 > a > i"));
	}

	public WebElement getShoppingCart() { 
		return this.driver.findElement(By
				.cssSelector("#dropdown_8 > div > div.cm-cart-buttons.ty-cart-content__buttons.buttons-container.full-cart > div.ty-float-left > a"));
	}
	public WebElement getShoppingButton() {
		return this.driver.findElement(By
				.className("ty-btn__primary ty-btn__big ty-btn__add-to-cart cm-form-dialog-closer ty-btn"));
	}
	public By userProdutc = By
			.cssSelector("#tygh_main_container > div.tygh-header.clearfix > div > div:nth-child(1) > div.span3.top-logo-grid > div > div > a > img");
	
	public By userButton = By
			.cssSelector("#pagination_contents > div.grid-list > div:nth-child(1) > div > form > div.ty-grid-list__control > div > a");
	
	public By waitSearch = By
			.cssSelector("#tygh_main_container > div.tygh-content.clearfix > div > div:nth-child(2) > div > div > h1 > span.ty-mainbox-title__left");

	public By getProduct = By
			.cssSelector("#product_main_info_ajax > div > form > div.ty-product-block__left > h1 > a > bdi");
	
	public By userSelector = By
			.cssSelector("#sw_dropdown_8 > a > span > span.ty-block.ty-minicart-title__header.ty-uppercase");
	
	public By userResulte = By
			.className("ty-cart-content__product-title");

}
