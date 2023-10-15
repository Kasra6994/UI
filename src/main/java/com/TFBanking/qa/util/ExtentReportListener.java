package com.TFBanking.qa.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.util.Date;

public class ExtentReportListener implements ITestListener {
	private ExtentReports extent;
	private ExtentTest test;
	private String suiteName;

	public void onStart(ITestContext context) {
		suiteName = context.getSuite().getName();
		String reportPath = "test-output/" + suiteName + "_ExtentReport.html";
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
		sparkReporter.config().setReportName(suiteName + " Test Automation Report");
		sparkReporter.config().setDocumentTitle(suiteName + " Test Report");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
	}

	public void onTestStart(ITestResult result) {

		test = extent.createTest(result.getName());
		test.assignCategory(suiteName + " Tests");
		test.assignAuthor("Tester: Kasra Yeganeh");
		test.assignDevice(getSystemInfo());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - Passed", ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Failed", ExtentColor.RED));
		test.fail(result.getThrowable());
	    try {
	        
	        String screenshotPath = TestUtil.getScreenshot(result.getName());
	        test.addScreenCaptureFromPath(screenshotPath, "Failed Test Screenshot");
	    } catch (IOException e) {
	        
	        e.printStackTrace();
	    }
	
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Skipped", ExtentColor.ORANGE));
		test.skip(result.getThrowable());
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

	private String getSystemInfo() {
		// Retrieve system or environment information
		String osName = System.getProperty("os.name");
		String osVersion = System.getProperty("os.version");
		String osArch = System.getProperty("os.arch");

		return osName + " " + osVersion + " (" + osArch + ")";
	}
}
