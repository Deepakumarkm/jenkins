package com.stepdefinition;

import java.io.FileNotFoundException;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.base.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

/**
 * 
 * @author Deepak
 * @date 08-06-2023
 * @see HooksClass to run before and after each scenario
 *
 */
public class HooksClass extends BaseClass {
	@Before
	public void beforescenario() throws FileNotFoundException, IOException {
		getdriver(getpropertyfilevalue("browser"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		geturl(getpropertyfilevalue("url"));
		maximize();
	}


	@After
	public void afterscenario(Scenario scenario) {
		Boolean b = scenario.isFailed();
		if (!b) {
			scenario.attach(ScreenShot(), "images/png", "SST Scenario");
		}
		quitwindow();
	}
}
