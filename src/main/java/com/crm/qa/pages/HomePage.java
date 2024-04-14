package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class HomePage extends TestBase {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	TestUtil testUtil = new TestUtil();
	
	@FindBy(xpath="(//td[@class='headertext'])[1]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[text()='Contacts']")
	WebElement contactLinks;
	
	@FindBy(xpath="//a[@title='New Contact']")
	WebElement newContactBtn;
	
	@FindBy(xpath="//a[@title='Tasks']")
	WebElement tasksLinks;
	
	@FindBy(xpath="//a[@title='Deals']")
	WebElement dealsLinks;
	
	
	public String getHomePageTitle() {
		return driver.getTitle();
	}

	public boolean verifyUserName() {
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContact() {
		contactLinks.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDeals() {
		dealsLinks.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasks() {
		tasksLinks.click();
		return new TasksPage();
	}
	
	public void clickOnNewContact() {
		Actions action = new Actions(driver);
		action.moveToElement(contactLinks);
		//testUtil.waitForWebElementToAppear(newContactBtn);
		action.click(newContactBtn).build().perform();
	}

}
