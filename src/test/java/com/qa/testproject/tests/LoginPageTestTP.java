package com.qa.testproject.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class LoginPageTestTP extends BaseTest {

	@Test(priority = 1)
	public void loginPageNavigationTest() {
		//loginPageTP = homePageTP.navigateToLoginPage();
		String actLoginPageTitle = loginPageTP.getLoginPageTitle();
		System.out.println("page act title: " + actLoginPageTitle);
		Assert.assertEquals(actLoginPageTitle, AppConstants.TP_LOGIN_PAGE_TITLE);
	}

//	@Test(priority = 2)
//	public void forgotPwdLinkExistTest() {
//		Assert.assertTrue(loginPageTP.isForgotPwdLinkExist());
//	}

	@Test(priority = 3)
	public void appLoginTest() {
		Assert.assertTrue(loginPageTP.doLogin(prop.getProperty("tpusername").trim(), prop.getProperty("tppassword").trim()));
	}

}
