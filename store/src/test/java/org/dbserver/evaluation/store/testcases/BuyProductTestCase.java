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
		return new Object[][] { { "Batman", "Resultados da pesquisa","button_cart_ajax94", "det_img_1860791280"}, { "PS3", "Resultados da pesquisa", "button_cart_ajax90","det_img_1770303465" }};
	}
	private WebDriver driver;
	private HomeTask hometask;
	@BeforeTest
	public void start() {
		WebDriverManager.firefoxdriver().setup();
		this.driver = new FirefoxDriver();
		new HomeAppObject(this.driver);
		this.hometask = new HomeTask(this.driver);
		this.hometask.navigateToHomePage();
		Reports.startTest("Compra de Produto");
	}
	 @Test(dataProvider = "ProductSearch")
	 public void testOne(String product, String result, String id, String idPro) throws InterruptedException {
		 Thread.sleep(5000);
		 this.hometask.fillProdutc(product);
		 Reports.log(LogStatus.INFO, "Inserção de Produto", ScreenShot.capture(driver));
		 Thread.sleep(5000);
		 this.hometask.searchProduto();	
		 
		 By userSelector = By.cssSelector("#tygh_main_container > div.tygh-content.clearfix > div > div:nth-child(2) > div > div > h1 > span.ty-mainbox-title__left");
		 new WebDriverWait(driver, 10)	
		 .until(ExpectedConditions.visibilityOfElementLocated(userSelector));
		  String imprime = this.driver.findElement(userSelector).getText().toString();
		  System.out.println(imprime);
		  		assertEquals(result, driver.findElement(userSelector).getText());
		  		Thread.sleep(2000);
		  Reports.log(LogStatus.INFO, "Produtos Encontrados", ScreenShot.capture(driver));
		  this.hometask.selectProdutc(); 
		  this.hometask.goToProdutc();
		  Thread.sleep(2000);
		  
		  By userProdutcSelector = By.id(id);
		  new WebDriverWait(driver, 10)
			.until(ExpectedConditions.visibilityOfElementLocated(userProdutcSelector));
		  String imprime2 = this.driver.findElement(userProdutcSelector).getText().toString();
		  System.out.println(imprime2);
		  Thread.sleep(2000);
		  Reports.log(LogStatus.INFO, "Confirmação Produto", ScreenShot.capture(driver));
		  this.driver.findElement(By.id(id)).click();
		  String test = this.driver.findElement(By.id("sw_dropdown_8")).getText().toString();
		  System.out.println(test);
		  Thread.sleep(2000);
		  Reports.log(LogStatus.INFO, "Produto adicionado carrinho", ScreenShot.capture(driver));
		  Thread.sleep(5000);
		 
	 }
	@Test(dataProvider = "ProductSearch")
	 public void testTwo(String product, String result, String id, String idPro)throws InterruptedException {
		 Thread.sleep(5000);
		 this.hometask.goShoppingCart();
		 Thread.sleep(5000); 
		 this.hometask.shoppingCart();
		 Thread.sleep(5000);
		 By test = By.id(idPro);
		 System.out.println(test);
		 new WebDriverWait(driver, 10) 
			.until(ExpectedConditions.visibilityOfElementLocated(test));
		  String imprime3 = this.driver.findElement(By.id(idPro)).getText().toString();  
		  System.out.println(imprime3);
		 assertEquals(product, driver.findElement(test).getText());
		 
		 
	 }
	 
	@AfterClass
		public void tearDown() { 
		Reports.close();
	 	this.driver.quit();

		}
	
	
	

}
