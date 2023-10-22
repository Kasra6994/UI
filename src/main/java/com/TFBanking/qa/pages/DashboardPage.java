package com.TFBanking.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.TFBanking.qa.base.TestBase;

public class DashboardPage extends TestBase {

	public DashboardPage() {

		PageFactory.initElements(driver, this);

	}

//Customers Elements
	@FindBy(how = How.XPATH, using = "//h2[normalize-space()='Dashboard']")
	WebElement dashBoardHeaderElement;
	@FindBy(how = How.XPATH, using = "//span[normalize-space()='Customers']")
	WebElement customersButton;
	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Add Customer']")
	WebElement addCustomerButton;
	@FindBy(how = How.XPATH, using = "//a[normalize-space()='List Customers']")
	WebElement listCustomersButton;
	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Groups']")
	WebElement groupsButton;

//Companies Elements
	@FindBy(how = How.XPATH, using = "//span[normalize-space()='Companies']")
	WebElement companiesButton;

//Transactions Elements
	@FindBy(how = How.XPATH, using = "//span[normalize-space()='Transactions']")
	WebElement transactionsButton;
	@FindBy(how = How.XPATH, using = "//a[normalize-space()='New Deposit']")
	WebElement newDepositButton;
	@FindBy(how = How.XPATH, using = "//a[normalize-space()='New Expense']")
	WebElement newExpenseButton;
	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Transfer']")
	WebElement transferButton;
	@FindBy(how = How.XPATH, using = "//a[normalize-space()='View Transactions']")
	WebElement viewTransactionsButton;
	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Balance Sheet']")
	WebElement balanceSheetButton;

//Sales Elements
	@FindBy(how = How.XPATH, using = "//span[normalize-space()='Sales']")
	WebElement salesButton;

//Calendar Element
	@FindBy(how = How.XPATH, using = "//span[normalize-space()='Calendar']")
	WebElement calendarButton;

	public boolean verifyDashboardPage() {
		try {
			Assert.assertEquals(dashBoardHeaderElement.getText(), "Dashboard");
			return true; // Return true if the assertion passes
		} catch (AssertionError e) {
			return false; // Return false if the assertion fails
		}
	}
	
	 
	
	public void clickCalendar() {
		calendarButton.click();
	}

	public void clickTransactions() {
		transactionsButton.click();
	}

	public void clickNewDeposit() {
		newDepositButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
