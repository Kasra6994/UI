package com.TFBanking.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.TFBanking.qa.base.TestBase;

public class NewDepositPage extends TestBase {

	public NewDepositPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//h5[normalize-space()='Add Deposit']")
	WebElement addDepositHeader;
	@FindBy(how = How.XPATH, using = "//span[@id='select2-account-container']")
	WebElement chooseAccountButton;
	@FindBy(how = How.XPATH, using = "//input[@id='date']")
	WebElement dateField;
	@FindBy(how = How.XPATH, using = "//input[@id='description']")
	WebElement descriptionField;
	@FindBy(how = How.XPATH, using = "//form[@id='upload_container']")
	WebElement attachFile;
	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Attach File']")
	WebElement attachFileButton;
	@FindBy(how = How.XPATH, using = "//input[@id='amount']")
	WebElement amountField;
//@FindBy(how=How.XPATH,using="")
//WebElement 
//@FindBy(how=How.XPATH,using="")
//WebElement 

	public void verifyNewDepositPage() {
		Assert.assertEquals(addDepositHeader.getText(), "Add Deposit");
	}

	public void enterAccount(String accountName) {

		chooseAccountButton.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		String xPathBefore = "//li[text()='";
		String xPathAfter = "']";
		String newXpath = xPathBefore + accountName + xPathAfter;
		driver.findElement(By.xpath(newXpath)).click();

	}

	public void enterDate(String month, int day) {

		String xPath = "//li[text()='5']";
		dateField.click();
		String currentMonth = driver.findElement(By.xpath("//li[@data-type='month current']")).getText();
		System.out.println(currentMonth);
		while (!currentMonth.equalsIgnoreCase("Dec 2023")) {
			driver.findElement(By.xpath("//li[@data-type='month next']")).click();
		}
		driver.findElement(By.xpath(xPath)).click();

	}

	public void attachFile() {

		attachFileButton.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		attachFile.sendKeys("/Users/kasrayeganeh/Downloads/Kasra%20_Yeganeh_Job_Profile.docx");

	}

}
