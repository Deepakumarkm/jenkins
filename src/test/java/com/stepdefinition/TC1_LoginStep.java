package com.stepdefinition;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class TC1_LoginStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	

	@Given("User is on the SST login Page")
	public void user_is_on_the_sst_login_page() {
		
	}
	@When("User Should Perform Login {string},{string}")
	public void user_should_perform_login(String string, String string2) {
		pom.getLoginPage().login(string, string2);
	}
	
	@Then("User Should Verify After Login Success Message {string}")
	public void user_should_verify_after_login_success_message(String string) {
		WebElement dashboardSucces = pom.getDashboard().getDashboardSucces();
		String text = dashboardSucces.getText();
		org.testng.Assert.assertEquals(text, string, text);
		Assert.assertEquals("Dashboard", text);
	    Assert.assertEquals("Dashbosssard", text);
		
		
	}

	@When("User Should Perform Login {string},{string} With Enter Key")
	public void user_should_perform_login_with_enter_key(String string, String string2) throws AWTException {
		pom.getLoginPage().loginByEnter(string, string2);
	}
	

	@SuppressWarnings("deprecation")
	@Then("User Should Verify After Login With Invalid Credentials Error Message Contains {string}")
	public void user_should_verify_after_login_with_invalid_credentials_error_message_contains(String string) {
		WebElement invalidAttempt = pom.getLoginPage().getInvalidAttempt();
		String text = invalidAttempt.getText();
		Assert.assertEquals("Invalid login attempt.", text);
		
	}

	@When("User should perform Login Without Credintials")
	public void user_should_perform_login_without_credintials() {
		pom.getLoginPage().withoutCridentials();
	   
	}

	@Then("User should verify After Login With field is required Credentials Error Message as {string} and {string}")
	public void user_should_verify_after_login_with_field_is_required_credentials_error_message_as_and(String string, String string2) {
	  WebElement emailCridentials = pom.getLoginPage().getEmailCridentials();
	  WebElement passwordCridentials = pom.getLoginPage().getPasswordCridentials();
	  String email = emailCridentials.getText();
	  String password = passwordCridentials.getText();
	  Assert.assertEquals("The Email field is required.", email);
	  Assert.assertEquals("The Password field is required.", password);
	}

	

	@When("User should perform Login With wrong Credintials {string}")
	public void user_should_perform_login_with_wrong_credintials(String string) {
		pom.getLoginPage().withCridentials(string);
	}
	@Then("User should verify After Login With field is required Credentials Error Message as {string}")
	public void user_should_verify_after_login_with_field_is_required_credentials_error_message_as(String string) {
		WebElement emailWrongCridentials = pom.getLoginPage().getEmailWrongCridentials();
		String text = emailWrongCridentials.getText();
		Assert.assertEquals("The Email field is not a valid e-mail address.", text);
		
	}





	
	@When("user should click organization")
	public void user_should_click_organization() throws InterruptedException {
		Thread.sleep(5000);
	   pom.getLoginPage().getOrgbtb().click();
	}
	@When("user should get data for sort")
	public void user_should_get_data_for_sort() throws InterruptedException {
		Thread.sleep(5000);
	  pom.getLoginPage().sorting();
	}






}
