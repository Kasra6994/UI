package com.TFBanking.qa.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TFBanking.qa.base.TestBase;
import com.TFBanking.qa.pages.DashboardPage;
import com.TFBanking.qa.pages.LoginPage;

public class LoginTest extends TestBase {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	
	public LoginTest() {
		super();

	}

	
	
	@BeforeMethod
	public void setUp() {

		init();
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
	}

	@Test
	public void loginTest(){

		loginPage.enterUsername(prop.getProperty("username"));
		loginPage.enterPassword(prop.getProperty("password"));
		loginPage.clickLogin();
		dashboardPage.verifyDashboardPage();
		
	}

	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
