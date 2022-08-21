package com.qa.testproject.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class HomePageTestTP extends BaseTest {
	@Test(priority = 3)

	public void homePageTitleTest() {
		String actualTitle = homePageTP.getHomePageTitle();
		Assert.assertEquals(actualTitle, AppConstants.TP_HOME_PAGE_TITLE);
	}
	@Test(priority = 1)
	
	public void homePageURLTest() {
		String actualURL = homePageTP.getHomePageURL();
		Assert.assertEquals(actualURL, prop.getProperty("tpURL"));
	}
	
	@Test(priority = 2)
	public void appLoginTest() {
		Assert.assertTrue(loginPageTP.doLogin(prop.getProperty("tpusername").trim(), prop.getProperty("tppassword").trim()));
	}

	
	@Test(priority = 4)
	public void doFormFilling() {
		Assert.assertTrue(homePageTP.doFormFilling(prop.getProperty("address").trim(), prop.getProperty("email").trim(), prop.getProperty("phoneNumber").trim()));
	}
	
	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] {
				{ "Macbook" }, 
				{ "iMac" }, 
				{ "Samsung" }
		};
	}

//	@Test(dataProvider = "getProductData")
//	public void searchTest(String productName) {
//		String actualSearchHeader = homePage.doSearch(productName);
//		Assert.assertEquals(actualSearchHeader, "Search - " + productName);
//	}

}
