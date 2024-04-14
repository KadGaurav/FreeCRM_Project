package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	public LoginPage()  {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement SignUpBtn;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement LogInBtn;
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage logIn(String user,String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		LogInBtn.click();
		
		return new HomePage();
	}

}
