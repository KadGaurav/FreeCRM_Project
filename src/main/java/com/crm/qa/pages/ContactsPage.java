package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(xpath="//select[@name='title']")
	WebElement titleDropDown;
	
	@FindBy(name="first_name")
	WebElement fName;
	
	@FindBy(name="surname")
	WebElement lName;
	
	@FindBy(name="client_lookup")
	WebElement compName;
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement saveBtn;
	
	
	public boolean verifyContactLabelDisplayed() {
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	public void createNewContact(String title,String firstName, String LastName ,String companyName) {
		Select select = new Select(titleDropDown);
		select.selectByVisibleText(title);
		
		fName.sendKeys(firstName);
		lName.sendKeys(LastName);
		compName.sendKeys(companyName);
		saveBtn.click();
	}

}
