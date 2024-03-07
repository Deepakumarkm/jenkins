package com.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class Dashboard extends BaseClass {
	public Dashboard() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"main-head\"]/div[2]/h2")
	public WebElement dashboardSucces;

	public WebElement getDashboardSucces() {
		return dashboardSucces;
	}

	public void setDashboardSucces(WebElement dashboardSucces) {
		this.dashboardSucces = dashboardSucces;
	}

	public void success() {
		String gettext = gettext(getDashboardSucces());
	}
}
