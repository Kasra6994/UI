package com.TFBanking.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver.SystemProperty;

import com.TFBanking.qa.base.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIME_OUT = 20;
	public static long IMPLICIT_WAIT_TIME = 10;

	public static String getScreenshot(String testCaseName) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";

	}


		
		
		
	
	
	
	

//	public static ExtentReports getExtentReport() {
//
//		String path = System.getProperty("user.dir") + "//reports//index.html";
//		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
//		reporter.config().setDocumentTitle("Test Results");
//		reporter.config().setReportName("Automation Results");
//
//		ExtentReports extent = new ExtentReports();
//		extent.attachReporter(reporter);
//		extent.setSystemInfo("Tester", "Kasra Yeganeh");
//		extent.createTest(path);
//		return extent;
//	}

}