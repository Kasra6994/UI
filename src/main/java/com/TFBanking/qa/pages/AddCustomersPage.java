package com.TFBanking.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.TFBanking.qa.base.TestBase;

public class AddCustomersPage extends TestBase {

	public AddCustomersPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//h5[text()='Add Contact']")
	WebElement addContactHeaderElement;
	@FindBy(how = How.XPATH, using = "//input[@id='account']")
	WebElement fullNameElement;
	@FindBy(how = How.XPATH, using = "//select[@id='cid']")
	WebElement companyDropdownElement;
	@FindBy(how = How.XPATH, using = "//input[@id='email']")
	WebElement emailElement;
	@FindBy(how = How.XPATH, using = "//input[@id='phone']")
	WebElement phoneNumberElement;
	@FindBy(how = How.XPATH, using = "//input[@id='address']")
	WebElement addressElement;
	@FindBy(how = How.XPATH, using = "//input[@id='city']")
	WebElement cityElement;
	@FindBy(how = How.XPATH, using = "//input[@id='state']")
	WebElement stateElement;
	@FindBy(how = How.XPATH, using = "//input[@id='zip']")
	WebElement zipElement;
	@FindBy(how = How.XPATH, using = "//select[@id='country']")
	WebElement countryDropDownElement;

	@FindBy(how = How.XPATH, using = "//select[@id='currency']")
	WebElement currencyElement;
	@FindBy(how = How.XPATH, using = "//select[@id='group']")
	WebElement groupElement;
	@FindBy(how = How.XPATH, using = "//input[@id='password']")
	WebElement passwordElement;
	@FindBy(how = How.XPATH, using = "//input[@id='cpassword']")
	WebElement confirmPasswordElement;
	@FindBy(how = How.XPATH, using = "//button[@id='submit']")
	WebElement saveButton;

	

	public void validateAddContactsPage(String expectedText) {

		Assert.assertEquals(addContactHeaderElement.getText(), "Add Contact", "Error page not found!");

	}

	static String insertedName;

	public void enterFullName(String fullName) {
		insertedName = fullName + randomNumGenerator(999);
		fullNameElement.sendKeys(insertedName);

	}

	public void enterCompanyDropDown(String visibleText) {

		selectFromDropdown(companyDropdownElement, visibleText);

	}

	public void enterEmail(String email) {
		emailElement.sendKeys(randomNumGenerator(9999) + email);
	}

	public void enterPhoneNumber(String phoneNumber) {

		phoneNumberElement.sendKeys(phoneNumber + randomNumGenerator(9999));

	}

	public void enterAddress(String address) {
		addressElement.sendKeys(randomNumGenerator(9999) + " " + address);
	}

	public void enterCity(String city) {
		cityElement.sendKeys(city);

	}

	public void enterState(String state) {
		stateElement.sendKeys(state);
	}

	public void enterZip(String zip) {
		zipElement.sendKeys(zip + randomNumGenerator(99));
	}

	public void selectCountry(String visibleText) {
		selectFromDropdown(countryDropDownElement, visibleText);
	}

	public void addTags(String tag) {

	}

	public void selectCurrency(String visibleText) {

		selectFromDropdown(currencyElement, visibleText);

	}

	public void selectGroup(String visibleText) {

		selectFromDropdown(groupElement, visibleText);
	}

	public void enterPassword(String password) {
		passwordElement.sendKeys(password);
	}

	public void confirmPassword(String password) {
		confirmPasswordElement.sendKeys(password);
	}

	public void submitContact() {
		saveButton.click();
	}

}
 