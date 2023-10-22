package com.TFBanking.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
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
	@FindBy(how = How.XPATH, using = "//input[@type='file']")
	WebElement attachFile;
	@FindBy(how = How.XPATH, using = "//input[@id='amount']")
	WebElement amountField;
	@FindBy(how = How.XPATH, using = "//a[@id='a_toggle']")
	WebElement advancedOptions;
	@FindBy(how = How.XPATH, using = "//select[@id='cats']")
	WebElement categoryDropdown;
	@FindBy(how = How.XPATH, using = "//input[@class='select2-search__field']")
	WebElement tagsField;
	@FindBy(how = How.XPATH, using = "//select[@id='payer']")
	WebElement payerDropdown;
	@FindBy(how = How.XPATH, using = "//select[@id='pmethod']")
	WebElement pmMethodDropdown;
	@FindBy(how = How.XPATH, using = "//input[@id='ref']")
	WebElement refField;
	@FindBy(how = How.XPATH, using = "//button[@id='submit']")
	WebElement submitButton;
	@FindBy(how = How.XPATH, using = "//div[@class='alert alert-success fade in']")
	WebElement verifyDepositAdded;

	public boolean verifyNewDepositPage() {
		try {
			Assert.assertEquals(addDepositHeader.getText(), "Add Deposit");
			return true;

		} catch (AssertionError e) {
			e.printStackTrace();
			return false;
		}
	}

	public void enterAccount(String accountName) {

		chooseAccountButton.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		String xPath = "//li[contains(text(), '" + accountName + "')]";
		driver.findElement(By.xpath(xPath)).click();

	}

	public void enterDate(String date) {
		dateField.clear();
		dateField.sendKeys(date);
		driver.findElement(By.xpath("//li[@data-type='day selected']")).click();
	}

	public void enterDescription(String description) {

		descriptionField.sendKeys(description);
		
	}

	public void attachFile() {

		String relativeFilePath = "/src/main/java/com/TFBanking/qa/testdata/TestFile.pdf";
		String filePath = System.getProperty("user.dir") + relativeFilePath;
		attachFile.sendKeys(filePath);
		WebElement fileUploadedMsg = driver.findElement(By.xpath("//div[@class='toast-message']"));
		Assert.assertTrue(fileUploadedMsg.isDisplayed());
	}

	public void enterAmount(String amount) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		amountField.sendKeys(amount);
	}

	public void clickAdvanced() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		advancedOptions.click();
	}

	public void selectCategory(String category) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selectFromDropdown(categoryDropdown, category);
	}

	public void enterTags(String tags1, String tag2) {
		tagsField.sendKeys(tags1);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.RETURN).perform();
		tagsField.sendKeys(tag2);
		actions.sendKeys(Keys.RETURN).perform();
	}

	public void selectPayer(String payer) {
		selectFromDropdown(payerDropdown, payer);
	}

	public void selectPaymentMethod(String method) {
		selectFromDropdown(pmMethodDropdown, method);
	}

	public void enterRef(String ref) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		refField.sendKeys(ref);
	}

	public void submit() {
		submitButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean verifyDepositAdded() {
		try {
			Thread.sleep(1000);
			String actualText = verifyDepositAdded.getText();
			actualText = actualText.replace("×", "").trim();
			System.out.println(actualText);
			Assert.assertEquals(actualText, "Transaction Added Successfully");
			return true;

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (AssertionError e) {
			e.printStackTrace();
			return false;
		}

	}
}
