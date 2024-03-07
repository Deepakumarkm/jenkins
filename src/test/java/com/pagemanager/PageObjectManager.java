package com.pagemanager;

import com.page.Dashboard;
import com.page.LoginPage;

public class PageObjectManager {
	private LoginPage loginPage;
	private Dashboard dashboard;

	public LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage() : loginPage;
	}



	public Dashboard getDashboard() {
		return (dashboard == null) ? dashboard = new Dashboard() : dashboard;
	}


}
