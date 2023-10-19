package com.TFBanking.qa.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TFBanking.qa.base.TestBase;
import com.TFBanking.qa.pages.DashboardPage;
import com.TFBanking.qa.pages.LoginPage;
import com.TFBanking.qa.util.ExcelReader;

public class LoginTest extends TestBase {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	
	public LoginTest() {
		super();

	}

	
	@DataProvider
	public void loginData() {
		
		
		
	}
	
	
	
	@BeforeMethod
	public void setUp() {

		init();
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
	}

	@Test
	public void loginTest(){
		ExcelReader xl = new ExcelReader("src/main/java/com/TFBanking/qa/testdata/testData.xlsx");
		loginPage.enterUsername(xl.getCellData("LoginData", "Login Username", 2));
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
