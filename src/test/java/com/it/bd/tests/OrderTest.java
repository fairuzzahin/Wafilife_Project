package com.it.bd.tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.it.bd.basedrivers.BaseDriver;
import com.it.bd.pages.OrderPage;
import com.it.bd.utilities.ExtentFactory;

public class OrderTest extends BaseDriver{
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	
	@BeforeClass
	public void start() throws InterruptedException {
		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>Wafilife OrderPage</b></p>").assignAuthor("QA TEAM").assignDevice("Windows");
	}

	@Test
	public void loginTest() throws InterruptedException, IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>OrderPage</b></p>");
		OrderPage orderPage = new OrderPage(childTest);
		orderPage.order();
	}
	
	@AfterClass
	public void report() {
		report.flush();
	}

}
