package org.dbserver.evaluation.store.framework;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.LogStatus;

public class ScreenShot {
	public static String capture(WebDriver driver) {
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = "./reports/screenshot/" + source.getName();
		return saveImageFile(source, path);
	}

	private static String saveImageFile(File source, String path) {
		try {
			FileUtils.copyFile(source, new File(path));
		} catch (IOException ex) {
			Reports.log(LogStatus.WARNING, "Capture error: " + ex.getMessage());
		}
		return path.replace("./reports/", "");
	}

}
