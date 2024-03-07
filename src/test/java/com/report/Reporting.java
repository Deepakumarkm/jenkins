package com.report;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.base.BaseClass;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting extends BaseClass{
	public static void generatejvmfile(String jsonFile) throws FileNotFoundException, IOException {
		File file= new File(getprojectpath()+getpropertyfilevalue("jvmpath"));
		//create a object for configuration class
		Configuration configuration=new Configuration(file, "SST");
		// pass the version, browser k,v
		configuration.addClassifications("Browser Name", "Chrome");
		configuration.addClassifications("Browser Version", "114");
		configuration.addClassifications("Os", "win 11");
		configuration.addClassifications("Sprint", "2");
		
		//pass the json file to fetch results----> create the object for reportbuilder
		java.util.List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonFile);
		ReportBuilder builder= new ReportBuilder(jsonFiles, configuration);
		//construct jvm report
		builder.generateReports();

}}
