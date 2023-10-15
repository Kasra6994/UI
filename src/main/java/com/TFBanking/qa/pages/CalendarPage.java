package com.TFBanking.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.TFBanking.qa.base.TestBase;

public class CalendarPage extends TestBase {

	public CalendarPage() {
		PageFactory.initElements(driver, this);
	}

//Calendar	
	@FindBy(how = How.XPATH, using = "//span[@class='fc-icon fc-icon-right-single-arrow']")
	WebElement nextMonthButton;
	@FindBy(how = How.XPATH, using = "//button[normalize-space()='month']")
	WebElement monthButton;
	@FindBy(how = How.XPATH, using = "//button[normalize-space()='week']")
	WebElement weekButton;
	@FindBy(how = How.XPATH, using = "//button[normalize-space()='day']")
	WebElement dayButton;
	@FindBy(how = How.XPATH, using = "//div[@class='fc-toolbar']/div[3]")
	WebElement currentMonthElement;
	@FindBy(how = How.XPATH, using = "(//td)[48]")
	WebElement clickDayElement;

//Options After Choosing Date
	@FindBy(how = How.XPATH, using = "//input[@id='title']")
	WebElement eventNameField;
	@FindBy(how = How.XPATH, using = "(//div[normalize-space()='24'])[2]")
	WebElement miniCalendarDateButton;
	@FindBy(how = How.XPATH, using = "//button[normalize-space()='choose']")
	WebElement chooseButton;
	@FindBy(how = How.XPATH, using = "//textarea[@id='description']")
	WebElement descriptionField;
	@FindBy(how = How.XPATH, using = "//input[@id='start_time']")
	WebElement startTimeField;
	@FindBy(how = How.XPATH, using = "//input[@id='end_time']")
	WebElement endTimeField;
	@FindBy(how = How.XPATH, using = "//div[@class='clockpicker-tick'][normalize-space()='11']")
	WebElement clockChooser;
	@FindBy(how = How.XPATH, using = "//div[@class='clockpicker-dial clockpicker-minutes']//div[@class='clockpicker-tick'][normalize-space()='15']")
	WebElement secondHandClockChooser;

	public String getCurrentMonth() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currentMonthElement.getText();
	}

	public void clickDay() {
		clickDayElement.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public void enterEventName(String eventName) {

		eventNameField.sendKeys(eventName);
	}

	public void chooseCalendarDay() {
		while (!getCurrentMonth().equalsIgnoreCase("December 2023")) {
			nextMonthButton.click();
		}
		clickDayElement.click();
	}

	public void enterStartTime() {
		startTimeField.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		clockChooser.click();
		secondHandClockChooser.click();

	}
}
