package com.TFBanking.qa.testCases;

import org.testng.Assert;
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

	@BeforeMethod
	public void setUp() {

		init();
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
	}

	@DataProvider(name = "Login Data")
	public Object[][] loginTestData() {

		ExcelReader xl = new ExcelReader("src/main/java/com/TFBanking/qa/testdata/testData.xlsx");
		Object data[][] = xl.getExcelData("LoginData");
		return data;

	}

	@Test(dataProvider = "Login Data")
	public void loginTest(String username, String password, String exp) {
		
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		if (exp.equalsIgnoreCase("invalid")) {
			if (loginPage.invalidLoginisDisplayed()) {
				Assert.assertTrue(loginPage.invalidLoginisDisplayed());
			}else if(dashboardPage.verifyDashboardPage()){
				 Assert.fail("Error! Login Succesful with invalid login!!");
			}
		}
		else if(exp.equalsIgnoreCase("valid")) {
			Assert.assertTrue(dashboardPage.verifyDashboardPage());
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
