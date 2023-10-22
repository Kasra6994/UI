package com.TFBanking.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.TFBanking.qa.base.TestBase;

public class NewBankAccountPage extends TestBase {

	public NewBankAccountPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//h5[normalize-space()='Add New Account']")
	WebElement addNewAccountHeader;
	@FindBy(how = How.XPATH, using = "//input[@id='account']")
	WebElement accountTitleField;
	@FindBy(how = How.XPATH, using = "//input[@id='description']")
	WebElement descriptionField;
	@FindBy(how = How.XPATH, using = "//input[@id='balance']")
	WebElement initialBalanceField;
	@FindBy(how = How.XPATH, using = "//input[@id='account_number']")
	WebElement accountNumberField;
	@FindBy(how = How.XPATH, using = "//input[@id='contact_person']")
	WebElement contactPersonField;
	@FindBy(how = How.XPATH, using = "//input[@id='contact_phone']")
	WebElement phoneField;
	@FindBy(how = How.XPATH, using = "//input[@id='ib_url']")
	WebElement urlfield;

	
	
	
	
	
	
	
}
