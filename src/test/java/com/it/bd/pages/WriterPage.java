package com.it.bd.pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import com.it.bd.basedrivers.PageDriver;
import com.it.bd.utilities.GetScreenShot;



public class WriterPage {
ExtentTest test;
private JavascriptExecutor driver;


	public WriterPage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(),this);
		this.test = test;
	}
	
	@FindBy(xpath="//span[contains(text(),'লেখক')]")
	WebElement writer;

	JavascriptExecutor js=(JavascriptExecutor) driver;	
	@FindBy(xpath="//h3[contains(text(),'Md. Al-Amin (Choton)')]")
	WebElement writername;
	

	
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

	
	public void writer() throws InterruptedException, IOException {
		
		try {
			test.info("Click on Writer");
			if(writer.isDisplayed()) {
				writer.click();
				Thread.sleep(6000);
				js.executeScript("arguments[0].scrollIntoView(true);",writername);
                writername.click();
				Thread.sleep(5000);
				passCase("Entered Writerpage");
				
			}
		}catch(Exception e) {
			failCase("Writer was not locateable. Please check the error message", "writerPagefail");
			
		}
		
		
	}
	

}
