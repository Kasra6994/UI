package com.TFBanking.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.TFBanking.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(how=How.XPATH, using = "//input[@id='username']")
	WebElement usernameField;
	@FindBy(how=How.XPATH, using = "//input[@id='password']")
	WebElement passwordField;
	@FindBy(how=How.XPATH, using = "//button[@name='login']")
	WebElement loginButton;

	public LoginPage() {
		PageFactory.initElements(driver, this);

	}

	public void enterUsername(String username) {
		usernameField.sendKeys(username);

	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);

	}

	public void clickLogin() {
		loginButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}