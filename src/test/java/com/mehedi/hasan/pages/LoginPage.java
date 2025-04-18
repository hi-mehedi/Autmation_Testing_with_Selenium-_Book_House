package com.mehedi.hasan.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.mehedi.hasan.drivers.PageDriver;
import com.mehedi.hasan.utilities.GetScreenshot;
import com.mehedi.hasan.utilities.commonMathod;

public class LoginPage extends commonMathod {
        
	ExtentTest test;
	
	public LoginPage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test;
	}
	
	@FindBys({ @FindBy(xpath = "//div[@class='header_configure_area header_configure_four']//a[@id='navbarDropdown']") })
	WebElement signIn;
	
	@FindBys({@FindBy(xpath = "//div[@class='header_configure_area header_configure_four']//a[@class='dropdown-item'][normalize-space()='Login..']")})
	WebElement LoginB;
	
	@FindBys({@FindBy(xpath = "//*[@id=\"email\"]")})
	WebElement email;
	
	@FindBys({@FindBy(xpath = "//*[@id=\"c-password\"]")})
	WebElement password;
	
	@FindBys({@FindBy(xpath = "//*[@id=\"remember\"]")})
	WebElement remember;
	
	@FindBys({@FindBy(xpath = "/html/body/div[4]/div/div/div/div/div/form/div/button")})
	WebElement loginButton;

	//Report
	public void passCase(String message) {
		test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>" + message + "</b></p>");
	}

	@SuppressWarnings("unused")
	public void passCaseWithSC(String message, String scName) throws IOException {
		test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>" + message + "</b></p>");
		String screenShotPath = GetScreenshot.capture(PageDriver.getCurrentDriver(), "" + scName + "");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + "" + scName + ".png";
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
	}

	// Fail
	@SuppressWarnings("unused")
	public void failCase(String message, String scName) throws IOException {
		test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>" + message + "</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		String screenShotPath = GetScreenshot.capture(PageDriver.getCurrentDriver(), "" + scName + "");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + "" + scName + ".png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		PageDriver.getCurrentDriver().quit();
	}
	
	public void LogIn() throws IOException {
		 Actions action = new Actions(driver);
		 try {
			 test.info("Enter SigIn Button");
			 if(signIn.isDisplayed()) {
				 action.moveToElement(signIn).perform();
				   timeout(3000);
				   passCase("Successfully Entered SignIn Button");
				   try {
						 test.info("Enter Login Button");
						 if(LoginB.isDisplayed()) {
							 action.moveToElement(LoginB).perform();
							 LoginB.click();
							   timeout(2000);
							   passCase("Successfully Entered Login Button");
							   try {
									 test.info("Enter Your Name");
									 if(email.isDisplayed()) {
										 email.sendKeys("mehedihasan.mehedi607@gmail.com");
										   timeout(2000);
										   passCase("Successfully Done");
										   try {
												 test.info("Enter Your Password");
												 if(password.isDisplayed()) {
													 password.sendKeys("123456m##");
													   timeout(2000);
													   passCase("Successfully Done");
													   try {
															 test.info("Click Remember Button");
															 if(remember.isDisplayed()) {
																 remember.click();
																   timeout(2000);
																   passCase("Successfully Enter Remember Me");
																   try {
																		 test.info("Click Remember Button");
																		 if(loginButton.isDisplayed()) {
																			 loginButton.click();
																			   timeout(2000);
																			   passCaseWithSC("Successfully Enter Login Button", "Pass_Login");
																		 }
																} catch (Exception e) {
																	// TODO: handle exception
																	failCase("Login Button locator was not  found", "LogButton2_Fail");
																}
															 }
													} catch (Exception e) {
														// TODO: handle exception
														failCase("Remember locator was not  found", "Remember_Fail");
													}
												 }

										} catch (Exception e) {
											// TODO: handle exception
											failCase("Password locator was not  found", "LogPass_Fail");
										}
									 }

							} catch (Exception e) {
								// TODO: handle exception
								failCase("Email locator was not  found", "LogEmail_Fail");
							}
						 }
				} catch (Exception e) {
					// TODO: handle exception
					failCase("LogIn locator was not  found", "Login_Fail");
				}
			 }
			
		} catch (Exception e) {
			// TODO: handle exception
			failCase("SignIn locator was not  found", "Signin_Fail");
		}

	}
}
