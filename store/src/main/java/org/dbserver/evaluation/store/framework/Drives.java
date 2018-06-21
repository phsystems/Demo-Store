package org.dbserver.evaluation.store.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drives {
	public static WebDriver getFirefoxDriver() {
		WebDriverManager.firefoxdriver().setup();
		return new FirefoxDriver();
	}

	public static WebDriver getChomeDriver() {
		WebDriverManager.chromedriver().setup();
		return new ChromeDriver();
	}
}
