package com.it.bd.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import com.it.bd.basedrivers.PageDriver;
import com.it.bd.utilities.GetScreenShot;

public class OrderPage {
ExtentTest test;
	
	public OrderPage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(),this);
		this.test = test;
	}
	
	@FindBy(xpath="//input[@id='billing_first_name']")
	WebElement name;
		
	@FindBy(xpath="//input[@id='billing_phone']")
	WebElement Phoneno1;
	
	@FindBy(xpath="//input[@id='billing_alternative_phone']")
	WebElement Phoneno2;
	
	@FindBy(xpath=" //input[@id='billing_email']")
	WebElement email;
	
	@FindBy(xpath="//span[@id='select2-billing_state-container']")
	WebElement district;
	Select select =new Select(district);
	
	@FindBy(xpath="//select[@id='billing_area']")
	WebElement area;
	Select select1 =new Select(area);
	
	@FindBy(xpath="//textarea[@id='billing_address_1']")
	WebElement  address;
	
	@FindBy(xpath="//textarea[@id='order_comments']")
	WebElement order_comments;
	
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

	
	public void order() throws InterruptedException, IOException {
		try {
			test.info("Order Info");
			if(name.isDisplayed()) {
				name.clear();
				name.sendKeys("Fairuz Zahin Sneha");
				Thread.sleep(2000);
				Phoneno1.clear();
				Phoneno1.sendKeys("01829258800");
				Thread.sleep(2000);
				Phoneno2.clear();
				Phoneno2.sendKeys("01918055382");
				Thread.sleep(2000);
				email.clear();
				email.sendKeys("fairuz.zahin2018@gmail.com");
				Thread.sleep(2000);
				select.selectByVisibleText("Dhaka");
				Thread.sleep(2000);
				select1.selectByIndex(26);;
				Thread.sleep(2000);
				address.clear();
				address.sendKeys("G.P Cha-24,North Badda,Badda,Dhaka-1212");
				Thread.sleep(2000);
				order_comments.clear();
				order_comments.sendKeys("I want to order two books");
				Thread.sleep(4000);
				passCase("Entered orderpage");
				
			}
			
		}catch(Exception e) {
			failCase("order was not locateable. Please check the error message", "orderPagefail");
			
		}
		
		
	}

}
