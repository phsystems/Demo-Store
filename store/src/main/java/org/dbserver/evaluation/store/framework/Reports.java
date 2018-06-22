package org.dbserver.evaluation.store.framework;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reports {
	private static final String DEFAULT_DESCRIPTION = "Demo Store";
	private static ExtentReports extent;
	private static ExtentTest logger;
	private static final String REPORT_FILE_PATH = "/test-output/STMExtentReport_" + System.currentTimeMillis()	+ ".html";
	public static void create(String title, String description) {
		extent = new ExtentReports(System.getProperty("user.dir") + REPORT_FILE_PATH, false);
		extent.addSystemInfo("Host Name", "http://demo.cs-cart.com");
		extent.addSystemInfo("Project", "evaluation");
		extent.addSystemInfo("User Name", "Pedro Henrique");
		extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));
	}
	public static void startTest(String testDescription) {
		if (extent == null) {
			create(DEFAULT_DESCRIPTION, testDescription);
		} logger = extent.startTest(testDescription);
	}
	public static void log(LogStatus logStatus, String message, String imagePath) {
		if (logger == null) {
			startTest(DEFAULT_DESCRIPTION);
		}logger.log(logStatus, message, logger.addScreenCapture(imagePath).concat(imagePath));
	}
	public static void log(LogStatus logStatus, String message) {
		if (logger == null) {
			startTest(DEFAULT_DESCRIPTION);
		} logger.log(logStatus, message);
	}

	public static void close() {
		if (extent != null) {
			extent.flush();
		} else {
			startTest("O TestCase passou!");
			log(LogStatus.INFO, "O teste encerrou.");
			close();
		}
	}

	public static void TearDown() {
		extent.flush();
		extent.close();
	}
}
