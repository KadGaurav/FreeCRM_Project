package com.crm.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventsListner;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	static EventFiringWebDriver e_driver;
	static WebEventsListner eventListner;

	public TestBase() {
		FileInputStream filePath = null;
		try {
			prop = new Properties();
			filePath = new FileInputStream(
					"F:\\Selenium\\FreeCRM\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(filePath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

			// HeadLess Mode On ---->
			// ChromeOptions options = new ChromeOptions();
			// WebDriverManager.chromedriver().setup();
			// options.addArguments("headless");
			// driver = new ChromeDriver(options);
			// <------------

		} else if (browserName.equalsIgnoreCase("firefox")) {

		} else if (browserName.equalsIgnoreCase("edge")) {

		}

		e_driver = new EventFiringWebDriver(driver);
		eventListner = new WebEventsListner();
		e_driver.register(eventListner);
		driver = e_driver;

		driver.manage().deleteAllCookies();

		driver.get(prop.getProperty("url"));

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

	}

}
