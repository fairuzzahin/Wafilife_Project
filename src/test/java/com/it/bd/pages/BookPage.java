package com.it.bd.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.it.bd.basedrivers.PageDriver;
import com.it.bd.utilities.GetScreenShot;

public class BookPage {
ExtentTest test;
	
	public BookPage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(),this);
		this.test = test;
	}
	
	@FindBy(xpath="//body/div[2]/div[3]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[1]/div[1]/div[2]/div[3]/ul[1]/li[1]/div[1]/div[1]/a[1]")
	WebElement book;
	
	@FindBys({
		
	@FindBy(xpath="//body/div[1]/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[2]/button[2]"),
	@FindBy(xpath="//button[@type='submit' and contains(text(),' অর্ডার করুন ' ) ]")
	
	 })
	WebElement order;
	@FindBy(xpath=" //span[contains(text(),'অর্ডার সম্পন্ন করুন')]")
	WebElement orderComplete;
	


	
	@SuppressWarnings("unused")
	public void failCase(String message, String scName) throws IOException {
		test.fail(
				"<p style=\"color:#FF5353; font-size:13px\"><b>"+message+"</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), ""+scName+"");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + ""+scName+".png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		PageDriver.getCurrentDriver().quit();
	}
	
	public void passCase(String message) {
		test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>"+message+"</b></p>");
	}
	
	@SuppressWarnings("unused")
	public void passCaseWithSC(String message, String scName) throws IOException {
		test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>"+message+"</b></p>");
		String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), ""+scName+"");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + ""+scName+".png";
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
	}

	
	public void book() throws InterruptedException, IOException {
		try {
			test.info("Click on Book");
			if(book.isDisplayed()) {
				book.click();
				Thread.sleep(4000);
                order.click();       
				Thread.sleep(5000);
				orderComplete.click();
				Thread.sleep(5000);
				passCase("Entered Bookpage");
				
			}
		}catch(Exception e) {
			failCase("Book was not locateable. Please check the error message", "bookPagefail");
			
		}
		
		
	}
	

}
