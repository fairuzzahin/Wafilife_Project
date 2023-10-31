package com.it.bd.tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.it.bd.basedrivers.BaseDriver;
import com.it.bd.pages.WriterPage;
import com.it.bd.utilities.ExtentFactory;

public class WriterTest extends BaseDriver {
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	
	@BeforeClass
	public void start() throws InterruptedException {
		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>Wafilife WriterPage</b></p>").assignAuthor("QA TEAM").assignDevice("Windows");
	}

	@Test
	public void loginTest() throws InterruptedException, IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>WriterPage</b></p>");
		WriterPage writerPage = new WriterPage(childTest);
		writerPage.writer();
	}
	
	@AfterClass
	public void report() {
		report.flush();
	}


}
