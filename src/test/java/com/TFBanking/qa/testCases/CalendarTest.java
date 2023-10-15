package com.TFBanking.qa.testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TFBanking.qa.base.TestBase;
import com.TFBanking.qa.pages.CalendarPage;
import com.TFBanking.qa.pages.DashboardPage;
import com.TFBanking.qa.pages.LoginPage;

public class CalendarTest extends TestBase {


LoginPage loginPage;
DashboardPage dashboardPage;
CalendarPage calendarPage;

	
public CalendarTest() {
	super();
}
	
	

@BeforeMethod
public void setUp() {
	init();
	
	dashboardPage = new DashboardPage();
	calendarPage = new CalendarPage();
	loginPage = new LoginPage();
}

@Test
public void calendarTest() {
	
	loginPage.enterUsername(prop.getProperty("username"));
	loginPage.enterPassword(prop.getProperty("password"));
	loginPage.clickLogin();
	dashboardPage.verifyDashboardPage();
	dashboardPage.clickCalendar();
	calendarPage.chooseCalendarDay();
	calendarPage.enterEventName("Test Run 5000");
	calendarPage.enterStartTime();
	
	
}




}
