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


public class signinPage extends commonMathod {

	/*
	 * Locators Methods
	 */

	ExtentTest test;
	
	public signinPage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test;
	}


	@FindBys({ @FindBy(xpath = "//div[@class='header_configure_area header_configure_four']//a[@id='navbarDropdown']") })
	WebElement signIn;
    
	@FindBys({ @FindBy(xpath = "//div[@class='header_configure_area header_configure_four']//a[@class='dropdown-item'][normalize-space()='Register']") })
	WebElement register; 
	
	@FindBys({ @FindBy(xpath = "/html/body/div[4]/div/div/div/div/div/form/p[1]/input") })
	WebElement name; 
	
	@FindBys({ @FindBy(xpath = "/html/body/div[4]/div/div/div/div/div/form/p[2]/input") })
	WebElement email; 
	
	@FindBys({ @FindBy(xpath = "/html/body/div[4]/div/div/div/div/div/form/p[3]/input") })
	WebElement mobile; 
	
	@FindBys({ @FindBy(xpath = "/html/body/div[4]/div/div/div/div/div/form/p[4]/input") })
	WebElement password; 
	
	@FindBys({ @FindBy(xpath = "/html/body/div[4]/div/div/div/div/div/form/p[5]/input") })
	WebElement cpassword; 
	
	@FindBys({ @FindBy(xpath = "/html/body/div[4]/div/div/div/div/div/form/div/button") })
	WebElement regbutton; 
	
	

	// Report
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

	public void signIN() throws InterruptedException, IOException {
		   Actions action = new Actions(driver);
		   try {
			   test.info("Enter SigIn Button");
			   if(signIn.isDisplayed()) {
				   action.moveToElement(signIn).perform();
				   timeout(3000);
				   passCase("Successfully Entered SignIn Button");
				   try {
					test.info("Enter Register Buuton");
					if(register.isDisplayed()) {
						action.moveToElement(register).perform();
						register.click();
						timeout(2000);
						passCase("Successfully Entered Register Button");
						try {
							test.info("Enter Name");
							if(name.isDisplayed()) {
								name.sendKeys("Mehedi Hasan soumik");
								timeout(2000);
								passCase("Successfully done");
								try {
									test.info("Enter email");
									if(email.isDisplayed()) {
										email.sendKeys("mehedihasan.mehedi607@gmail.com");
										timeout(2000);
										passCase("Successfully done");
										try {
											test.info("Enter Mobile Number");
											if(mobile.isDisplayed()) {
												mobile.sendKeys("01723547019");
												timeout(2000);
												passCase("Successfully done");
												try {
													test.info("Enter Password");
													if(password.isDisplayed()) {
														password.sendKeys("123456m##");
														timeout(2000);
														passCase("Successfully done");
														try {
															test.info("Enter Confrim Password");
															if(cpassword.isDisplayed()) {
																cpassword.sendKeys("123456m##");
																timeout(2000);
																passCase("Successfully done");
																try {
																	test.info("Enter Regsiter Button");
																	if(regbutton.isDisplayed()) {
																		regbutton.click();
																		timeout(2000);
																		passCase("Successfully done");
																		navigation_back();
																		timeout(2000);
																		navigation_back();
																		timeout(2000);
																	}
																} catch (Exception e) {
																	// TODO: handle exception
																	failCase("Register Button  locator was not found", "Regbutton_Fail");
																}
															}
														} catch (Exception e) {
															// TODO: handle exception
															failCase("Password  locator was not found", "CPassword_Fail");
														}
													}
												} catch (Exception e) {
													// TODO: handle exception
													failCase("Password  locator was not found", "Password_Fail");
												}
											}
										} catch (Exception e) {
											// TODO: handle exception
											failCase("Mobile no locator was not found", "Mobile_Fail");
										}
									}
								} catch (Exception e) {
									// TODO: handle exception
									failCase("Email locator was not found", "Email_Fail");
								}
							}
						} catch (Exception e) {
							// TODO: handle exception
							failCase("Name locator was not found", "Name_Fail");
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
					failCase("Register locator was not found", "Register_Fail");
				}
			   }
			
		} catch (Exception e) {
			// TODO: handle exception
			failCase("SigIn locator was not found", "SignIn_Fail");
		}

		

	}
	

	
}
   
	

