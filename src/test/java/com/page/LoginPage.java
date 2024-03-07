package com.page;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;



public class LoginPage extends BaseClass {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	

	@FindBy(xpath = "//input[@id='Input_Email']")
	private WebElement txtUserNa;

	@FindBy(xpath = "//input[@id='Input_Password']")
	private WebElement txtPass;

	@FindBy(xpath = "//button[@id='login-submit']")
	private WebElement btnLogin;
	
	@FindBy(xpath = "//*[@id=\"kt_login_signin_form\"]/div[6]/div/ul/li")
	private WebElement invalidAttempt;

	@FindBy(xpath = "//div[@class='fv-row mb-8']/span/span")
	private WebElement emailCridentials;
	
	@FindBy(xpath = "//div[@class='fv-row mb-3']/span/span")
	private WebElement passwordCridentials;
	
	//span[@id="Input_Email-error"]
	
	@FindBy(xpath = "//span[@id='Input_Email-error']")
	private WebElement emailWrongCridentials;
	
	@FindBy(xpath = "/html/body/div/section/div/div/div/div[1]/div[2]/div[2]/div/div/div[2]/a")
	private WebElement orgbtb;
	
	
	public WebElement getOrgbtb() {
		return orgbtb;
	}

	public void setOrgbtb(WebElement orgbtb) {
		this.orgbtb = orgbtb;
	}

	public WebElement getEmailWrongCridentials() {
		return emailWrongCridentials;
	}

	public void setEmailWrongCridentials(WebElement emailWrongCridentials) {
		this.emailWrongCridentials = emailWrongCridentials;
	}

	public WebElement getEmailCridentials() {
		return emailCridentials;
	}

	public void setEmailCridentials(WebElement emailCridentials) {
		this.emailCridentials = emailCridentials;
	}

	public WebElement getPasswordCridentials() {
		return passwordCridentials;
	}

	public void setPasswordCridentials(WebElement passwordCridentials) {
		this.passwordCridentials = passwordCridentials;
	}

	public WebElement getTxtUserNa() {
		return txtUserNa;
	}

	public void setTxtUserNa(WebElement txtUserNa) {
		this.txtUserNa = txtUserNa;
	}

	public WebElement getTxtPass() {
		return txtPass;
	}

	public void setTxtPass(WebElement txtPass) {
		this.txtPass = txtPass;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public WebElement getInvalidAttempt() {
		return invalidAttempt;
	}

	public void setInvalidAttempt(WebElement invalidAttempt) {
		this.invalidAttempt = invalidAttempt;
	}

	public void setBtnLogin(WebElement btnLogin) {
		this.btnLogin = btnLogin;
	}

	public void login(String username, String password) {
		sendkeys(getTxtUserNa(), username);
		sendkeys(getTxtPass(), password);
		click(btnLogin);
	}

	public void loginByEnter(String username, String password) throws AWTException {
		sendkeys(getTxtUserNa(), username);
		sendkeys(getTxtPass(), password);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void withoutCridentials() {
		click(btnLogin);

	}
	public void withCridentials(String username) {
		sendkeys(getTxtUserNa(), username);
		click(btnLogin);
	}
	
	public void sorting() {
		List<WebElement> name = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		String[] before_sort = new String[name.size()];
		for (int i = 0; i < name.size(); i++) {
			before_sort[i] = name.get(i).getText().trim();

		}
		System.out.println("*****before_sort******");
		Print(before_sort);

//		Arrays.sort(before_sort, String.CASE_INSENSITIVE_ORDER);
//
//		System.out.println("*****after sort******");
//		Print(before_sort);
//		String[] After_sort = new String[name.size()];
//
//		for (int i = 0; i < name.size(); i++) {
//			After_sort[i] = name.get(i).getText().trim();
//
//		}


	}
}
