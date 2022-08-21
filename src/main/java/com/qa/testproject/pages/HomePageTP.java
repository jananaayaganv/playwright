package com.qa.testproject.pages;

import com.microsoft.playwright.Page;

public class HomePageTP {

	private Page page;
	
	private String countryDD = "//select[@id='country']";
	private String addressTB = "//input[@id='address']";
	private String emailTB = "//input[@id='email']";
	private String phoneNumberTB ="//input[@id='phone']";
	private String saveButton ="//button[@id='save']";
	private String savedText="//span[@class='tp-saved']";
	
	
	
	public HomePageTP(Page page) {
		this.page = page;
	}

	// 3. page actions/methods:
	public String getHomePageTitle() {
		String title =  page.title();
		System.out.println("page title: " + title);
		return title;
	}

	public String getHomePageURL() {
		String url =  page.url();
		System.out.println("page url : " + url);
		return url;
	}
	
	public boolean doFormFilling(String address, String email, String phoneNumber) {
		//System.out.println("App creds: " + appUserName + ":" + appPassword);
		page.locator(countryDD).selectOption("India");
		page.fill(addressTB, address);
		page.fill(emailTB, email);
		page.fill(phoneNumberTB, phoneNumber);
		page.click(saveButton);
		page.locator(savedText).waitFor();
		if (page.locator(savedText).isVisible()) {
			System.out.println("user enters data  saved successfully....");
			return true;
		} else {
			System.out.println("user enters data is wrong....");
			return false;
		}
	}
	

}
