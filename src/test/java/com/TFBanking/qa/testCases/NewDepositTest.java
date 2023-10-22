package com.TFBanking.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TFBanking.qa.base.TestBase;
import com.TFBanking.qa.pages.DashboardPage;
import com.TFBanking.qa.pages.LoginPage;
import com.TFBanking.qa.pages.NewDepositPage;
import com.TFBanking.qa.util.ExcelReader;

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

	@DataProvider(name = "New Deposit Data")
	public Object[][] newDepositTestData() {
		ExcelReader xl = new ExcelReader("src/main/java/com/TFBanking/qa/testdata/testData.xlsx");
		Object data[][] = xl.getExcelData("NewDepositData");
		System.out.println(data);
		return data;

	}

	@Test(dataProvider = "New Deposit Data")
	public void makeNewDepositTest(String account, String date, String description, String amount, String category,
			String tags1, String tags2, String payer, String method, String ref){
		loginPage.enterUsername(prop.getProperty("username"));
		loginPage.enterPassword(prop.getProperty("password"));
		loginPage.clickLogin();
		Assert.assertTrue(dashboardPage.verifyDashboardPage());
		dashboardPage.clickTransactions();
		dashboardPage.clickNewDeposit();
		Assert.assertTrue(newDepositPage.verifyNewDepositPage());
		newDepositPage.enterAccount(account);
		newDepositPage.enterDate(date);
		newDepositPage.attachFile();
		newDepositPage.enterDescription(description + randomNumGenerator(999999));
		newDepositPage.enterAmount(amount);
		newDepositPage.clickAdvanced();
		newDepositPage.selectCategory(category);
		newDepositPage.enterTags(tags1, tags2);
		newDepositPage.selectPayer(payer);
		newDepositPage.selectPaymentMethod(method);
		newDepositPage.enterRef(ref + randomNumGenerator(99999));
		newDepositPage.submit();
		Assert.assertTrue(newDepositPage.verifyDepositAdded());

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
