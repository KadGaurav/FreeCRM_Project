package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTests extends TestBase {
	
	public HomePageTests() {
		super();
	}

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactPage;
	
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		contactPage = new ContactsPage();
		
		homePage = loginPage.logIn(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void verifyHomePageTitle() {
		String homePageTitle = homePage.getHomePageTitle() ;
		Assert.assertEquals(homePageTitle, "CRMPRO");
	}
	
	@Test(priority=2)
	public void verifyUserName() {
		testUtil.switchToMainFrame();
		Assert.assertTrue(homePage.verifyUserName());
	}
	
	@Test(priority = 3)
	public void contactsLinkVerify() {
		testUtil.switchToMainFrame();
		contactPage = homePage.clickOnContact();
		
	}
	
	
	
}
