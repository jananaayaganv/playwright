package com.qa.testproject.pages;

import com.microsoft.playwright.Page;

public class LoginPageTP {

	private Page page;

	private String fullName = "//input[@id='name']";
	private String passWord = "//input[@id='password']";
	private String loginButton = "//button[@id='login']";
	private String logoutLink = "//button[@id='logout']";

	public LoginPageTP(Page page) {
		this.page = page;
	}

	public String getLoginPageTitle() {
		return page.title();
	}

	public boolean islogoutButtonExist() {
		return page.isVisible(logoutLink);
	}

	public boolean doLogin(String appUserName, String appPassword) {
		System.out.println("App creds: " + appUserName + ":" + appPassword);
		page.fill(fullName, appUserName);
		page.fill(passWord, appPassword);
		page.click(loginButton);
		page.locator(logoutLink).waitFor();
		if (page.locator(logoutLink).isVisible()) {
			System.out.println("user is logged in successfully....");
			return true;
		} else {
			System.out.println("user is not logged in successfully....");
			return false;
		}
	}
}
