package com.TFBanking.qa.testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TFBanking.qa.base.TestBase;
import com.TFBanking.qa.pages.DashboardPage;
import com.TFBanking.qa.pages.LoginPage;
import com.TFBanking.qa.pages.NewDepositPage;

public class NewDepositTest extends TestBase {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	NewDepositPage newDepositPage;

	public NewDepositTest() {
		super();
	}

	
	@BeforeMethod
	public void setUp() {

		init();
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		newDepositPage = new NewDepositPage();
	}

	@Test
	public void makeNewDepositTest() {
		loginPage.enterUsername(prop.getProperty("username"));
		loginPage.enterPassword(prop.getProperty("password"));
		loginPage.clickLogin();
		dashboardPage.verifyDashboardPage();
		dashboardPage.clickTransactions();
		dashboardPage.clickNewDeposit();
		newDepositPage.verifyNewDepositPage();
		newDepositPage.enterAccount("Ruby");
		//newDepositPage.enterDate();

	}
}
