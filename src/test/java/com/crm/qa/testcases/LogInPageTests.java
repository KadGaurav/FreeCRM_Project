package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LogInPageTests extends TestBase{

	LoginPage loginPage;
	HomePage homePage;

	
	@BeforeMethod()
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
	}
	
	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void logInPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		Assert.assertEquals(title, "Free CRM software for customer relationship management, sales, and support.","LogIn Page Title not Matched");
	}
	
	@Test(priority=2)
	public void logInTest() {
		homePage = loginPage.logIn(prop.getProperty("username"), prop.getProperty("password"));
	}
	

}
