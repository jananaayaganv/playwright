package com.qa.opencart.base;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;
import com.qa.testproject.pages.HomePageTP;
import com.qa.testproject.pages.LoginPageTP;

public class BaseTest {
	
	PlaywrightFactory pf;
	Page page;
	protected Properties prop;

	protected HomePage homePage;
	protected LoginPage loginPage;
	
	protected HomePageTP homePageTP;
	protected LoginPageTP loginPageTP;
	
	@BeforeTest
	public void setup() {
		pf = new PlaywrightFactory();
		prop = pf.init_prop();
		page = pf.initBrowser(prop);
		homePage = new HomePage(page);
		homePageTP = new HomePageTP(page);
		loginPageTP = new LoginPageTP(page);
		
	}
	
	
	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}
	
	
	
	
	

}
