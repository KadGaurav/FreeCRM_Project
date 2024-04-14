package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTests extends TestBase {

	public ContactPageTests() {
		super();
	}

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactPage;
	
	String sheetName = prop.getProperty("SheetName");

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		contactPage = new ContactsPage();

		homePage = loginPage.logIn(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToMainFrame();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	
	  @Test(priority = 1) public void verifyContactsPage() {
		  homePage.clickOnContact();
	  Assert.assertTrue(contactPage.verifyContactLabelDisplayed(),
	  "Contact Label is Missing"); }
	  
	  @Test(priority = 2) public void selectContacts() {
		  homePage.clickOnContact();
	  contactPage.selectContactsByName("Xyz Robert");
	  contactPage.selectContactsByName("pqr Robert"); }
	 

	@Test(priority = 3 , dataProvider="getCRMTestData" )
	public void createNewContact(String title,String firstName, String LastName ,String companyName) {
		homePage.clickOnNewContact();
		contactPage.createNewContact(title,firstName, LastName,companyName);
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object[][] data = TestUtil.getTestData(sheetName) ;
		return data;
		
	}

}
