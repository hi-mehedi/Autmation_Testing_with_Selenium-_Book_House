package com.mehedi.hasan.pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
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

public class order extends commonMathod {
        
	ExtentTest test;
	
	public order(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test;
	}
	
	@FindBys({ @FindBy(xpath = "//*[@id=\"bottom-menu-toggle\"]/div/div[2]/div/nav/ul/li[1]/a")})
	WebElement bookoffer;
	
	@FindBys({@FindBy(xpath = "//div[8]//article[1]//figure[1]//div[1]//a[1]//img[1]")})
	WebElement bookdet2;
	
	@FindBys({@FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div[2]/div[11]/article/figure/div[2]/div[1]/h4/a")})
	WebElement bookdet1;
	
	@FindBys({@FindBy(xpath = "//*[@id=\"btn-add-to-cart\"]")})
	WebElement cart;
	
	@FindBys({@FindBy(xpath = "//div[@class='header_configure_area header_configure_four']//span[@class='cart_price'][contains(text(),'৳600')]")})
	WebElement checkcart;
	
	@FindBys({@FindBy(xpath = "//div[@class='header_configure_area header_configure_four']//a[normalize-space()='Checkout']")})
	WebElement checkout;
	
	@FindBys({@FindBy(xpath =  "/html/body/div[4]/div/div/div/form/div/div[1]/div/div/div[4]/div")})
	WebElement selectcity;
	
	@FindBys({@FindBy(xpath =  "/html/body/div[4]/div/div/div/form/div/div[1]/div/div/div[4]/div/ul/li[7]")})
	WebElement selectcity1;
	
	@FindBys({@FindBy(xpath =  "/html/body/div[4]/div/div/div/form/div/div[1]/div/div/div[5]/div")})
	WebElement area;
	
	@FindBys({@FindBy(xpath =  "/html/body/div[4]/div/div/div/form/div/div[1]/div/div/div[5]/div/ul/li[9]")})
	WebElement area1;
	
	@FindBys({@FindBy(xpath =  "/html/body/div[4]/div/div/div/form/div/div[1]/div/div/div[6]/input")})
	WebElement postoff;
	
	@FindBys({@FindBy(xpath =  "/html/body/div[4]/div/div/div/form/div/div[1]/div/div/div[7]/textarea")})
	WebElement address;
	
	@FindBys({@FindBy(xpath =  "//*[@id=\"order_note\"]")})
	WebElement note;
	
	@FindBys({@FindBy(xpath =  "//*[@id=\"gift_wrap\"]")})
	WebElement Gift;
	
	@FindBys({@FindBy(xpath =  "//*[@id=\"payment_condition\"]")})
	WebElement ReadAg;
	
	@FindBys({@FindBy(xpath =  "//*[@id=\"payment_defult\"]")})
	WebElement payment;
	
	
	
	
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
	
	public void oderpro() throws IOException {
		Actions action = new Actions(driver);
		 try {
			test.info("Click Booke House Offer");
			if(bookoffer.isDisplayed()) {
				bookoffer.click();
				timeout(3000);
				passCase("Successfully click");
				try {
					JavascriptExecutor js2 = (JavascriptExecutor) driver;
					js2.executeScript("arguments[0].scrollIntoView(true);", bookdet2);
					test.info("Click Selected Book");
					if(bookdet1.isDisplayed()) {
						bookdet1.click();
						timeout(2000);
						passCase("Successfully click");
						try {
							test.info("Click add to cart");
							if(cart.isDisplayed()) {
								cart.click();
								timeout(8000);
							    passCase("Successfully click the cart");
							    try {
									test.info("Click  cart for details");
									if(checkcart.isDisplayed()) {
										action.moveToElement(checkcart).perform();
										timeout(2000);
										passCase("Successfully Done");
										try {
											test.info("Click  checkout for details");
											if(checkout.isDisplayed()) {
												action.moveToElement(checkout).perform();
												checkout.click();
												timeout(3000);
												passCase("Successfully Done to  click checkout");
												try {
													test.info("Select  city and area");
													if(selectcity.isDisplayed()) {
														selectcity.click();
														timeout(2000);
														selectcity1.click();
														timeout(2000);
														area.click();
														timeout(2000);
														area1.click();
														timeout(2000);
														passCase("City and area Select Successful");
														try {
															test.info("Enter post office");
															if(postoff.isDisplayed()) {
																postoff.sendKeys("Rangpur Sadar");
																timeout(2000);
																passCase("Entered post office successfully");
																try {
																	test.info("Enter the address");
																	if(address.isDisplayed()) {
																		address.sendKeys("Rangpur");
																		timeout(2000);
																		passCase("Entered address successfully");
																		try {
																			js2.executeScript("arguments[0].scrollIntoView(true);", address);
																			test.info("Enter the note");
																			if(note.isDisplayed()) {
																				note.sendKeys("Happy Code");
																				timeout(2000);
																				passCase("Entered note successfully");
																				try {
																					js2.executeScript("window.scrollTo(0, 0)");
																					timeout(2000);
																					test.info("Click all check and Required Button");
																					Gift.click();
																					timeout(2000);
																					ReadAg.click();
																					timeout(2000);
																					payment.click();
																					timeout(5000);
																					passCaseWithSC("Done", "Done_all_check_Required");
																				} catch (Exception e) {
																					// TODO: handle exception
																					failCase("locator was not Found", "check_req_Fail");
																				}
																			}
																		} catch (Exception e) {
																			// TODO: handle exception
																			failCase("Note locator was not Found", "note_Fail");
																		}
																	}
																} catch (Exception e) {
																	// TODO: handle exception
																	failCase("Address locator was not Found", "address_Fail");
																}
															}
														} catch (Exception e) {
															// TODO: handle exception
															failCase("Post Office  locator was not Found", "postoff_Fail");
														}
													}
												} catch (Exception e) {
													// TODO: handle exception
													failCase("Select city  locator was not Found", "Select_city_Fail");
												}
											}
										} catch (Exception e) {
											// TODO: handle exception
											failCase("checkout  locator was not Found", "checkout_Fail");
										}
									}
								} catch (Exception e) {
									// TODO: handle exception
									failCase("Check Cart locator was not Found", "checkcart_Fail");
								}
							}
						} catch (Exception e) {
							// TODO: handle exception
							failCase("Cart locator was not Found", "cart_Fail");
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
					failCase("Selected Book Details locator was not Found", "Bookodet1_Fail");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			failCase("Book Offer locator was not Found", "Bookoffer_Fail");
		}

	}
}

