package com.runner;

import java.io.FileNotFoundException;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.BaseClass;
import com.report.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(dryRun = false, tags = ("  "), plugin = {
		"json:target\\output.json" }, features = "src\\test\\resources", glue = "com.stepdefinition")

public class TestRunnerClass extends BaseClass {
	@AfterClass
	public static void afterClass() throws FileNotFoundException, IOException {
		// to generate jvm report--->input pass a json file report ---->call reporting
		// class --->generatre jvm report
		Reporting.generatejvmfile(getprojectpath() + getpropertyfilevalue("jsonpath"));

	}

}
