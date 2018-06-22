package org.dbserver.evaluation.store.testcases;

import static org.testng.Assert.assertEquals;

import org.dbserver.evaluation.store.appobjects.HomeAppObject;
import org.dbserver.evaluation.store.framework.Reports;
import org.dbserver.evaluation.store.framework.ScreenShot;
import org.dbserver.evaluation.store.tasks.HomeTask;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BuyProductTestCase {
	@DataProvider(name = "ProductSearch")
	public static Object[][] credentials() {
		return new Object[][] {{ "Batman", "button_cart_ajax94" },{ "PS3","button_cart_ajax90" }};
	}

	private WebDriver driver;
	private HomeTask hometask;
	private HomeAppObject homeApp;

	@BeforeTest
	public void start() {
		WebDriverManager.firefoxdriver().setup();
		this.driver = new FirefoxDriver();
		this.homeApp = new HomeAppObject(this.driver);
		this.hometask = new HomeTask(this.driver);
		this.hometask.navigateToHomePage();
		Reports.startTest("Compra de Produto");
	}

	@Test(dataProvider = "ProductSearch") 
	public void testOne(String product, String id) throws InterruptedException {
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(homeApp.userProdutc));
		this.hometask.fillProdutc(product);
		Reports.log(LogStatus.INFO, "Inserção de Produto", ScreenShot.capture(driver));
		this.hometask.searchProduto();
		
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(homeApp.waitSearch));
		Reports.log(LogStatus.INFO, "Produtos Encontrados", ScreenShot.capture(driver));
		this.hometask.selectProdutc();
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(homeApp.userButton));
		this.hometask.goToProdutc();
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(homeApp.getProduct));
		Reports.log(LogStatus.INFO, "Confirmação Produto", ScreenShot.capture(driver));
		
		String userProduct = this.driver.findElement(homeApp.getProduct).getText().toString();
		this.driver.findElement(By.id(id)).click();
		Reports.log(LogStatus.INFO, "Produto adicionado carrinho", ScreenShot.capture(driver));
				
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(homeApp.userSelector));
		this.hometask.goShoppingCart();
		this.hometask.shoppingCart();
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(homeApp.userResulte));
		Reports.log(LogStatus.INFO, "Conferindo Carrinho", ScreenShot.capture(driver));
		String getProduct = this.driver.findElement(homeApp.userResulte).getText().toString();

		assertEquals(userProduct, getProduct); 
		Reports.log(LogStatus.PASS, "Produto Correto", ScreenShot.capture(driver));
	}
	  

	@AfterClass
	public void tearDown() {
		Reports.close();
		this.driver.quit();

	}

}
