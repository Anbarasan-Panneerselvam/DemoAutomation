package com.demoAutomationProject;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import baseClass.BaseClass;
import constants.Constants;
import pages.LoginPage;
import pages.ProductAddToCartAndPurchasePage;
import utilities.ScreenshotUtils;

public class ProductAddToCartAndPurchaseVerification extends BaseClass{
	private LoginPage loginPage;
	private ProductAddToCartAndPurchasePage productAddToCartAndPurchasePage;

	@Test(priority = 0,groups = {"Smoke" ,"Positive"},enabled = true)
	public void verifyLoginWithValidUserCredentials() throws InterruptedException, AWTException {
		logger.info("User login with valid credentials");
		loginPage=new LoginPage(driver);
		loginPage.enterUsername(Constants.username);
		loginPage.enterPassword(Constants.password);
		loginPage.clickLoginButton();
		productAddToCartAndPurchasePage=new ProductAddToCartAndPurchasePage(driver);
		productAddToCartAndPurchasePage.clickAdidasProductViewButton();
		productAddToCartAndPurchasePage.clickAfterProductViewAddToCartButton();
		logger.info("Checking Product added sucessfully or not ");
		Assert.assertEquals(productAddToCartAndPurchasePage.checkProductAddedSuccessMessage(),"Product Added To Cart","Assertion failure on verifying product purchase ");
		logger.info("Product Added succesfully");
		extentReportListener.test.log(Status.INFO, "Product added to cart successfully verified");
		productAddToCartAndPurchasePage.clickContinueShoppingButton();
		productAddToCartAndPurchasePage.clickIPhoneAddToCartButton();
		logger.info("Checking Product added sucessfully or not ");
		Assert.assertEquals(productAddToCartAndPurchasePage.checkProductAddedSuccessMessage(),"Product Added To Cart","Assertion failure on verifying product purchase ");
		logger.info("Product Added succesfully");
		productAddToCartAndPurchasePage.clickCartButton();
		productAddToCartAndPurchasePage.clickProductDeleteButton();
		productAddToCartAndPurchasePage.clickProductCheckoutButton();
		productAddToCartAndPurchasePage.clickCardExpiryDate();
		productAddToCartAndPurchasePage.enterCardCVV();
		productAddToCartAndPurchasePage.enterCardHolderName();
		productAddToCartAndPurchasePage.sendCountryNameToSelectCountryBox();
		productAddToCartAndPurchasePage.clickPlaceOrderButton();
		logger.info("Checking order placed sucessfully or not ");
		Assert.assertEquals(productAddToCartAndPurchasePage.checkOrderPlacedSuccessMessage(),"Order Placed Successfully","Assertion failure on verifying product purchase ");
		logger.info("Order placed succesfully");
		extentReportListener.test.log(Status.INFO, "Order placed sucessfully verified");
		productAddToCartAndPurchasePage.clickOrderDetailsExcelDownloadButton();
		productAddToCartAndPurchasePage.clickOrdersButton();
		String orderPageOrderID=productAddToCartAndPurchasePage.getOrdersPageOrderID();
		productAddToCartAndPurchasePage.clickOrderViewButton();
		ScreenshotUtils.captureScreenshotDirect();
		String orderSummaryPageOrderID=productAddToCartAndPurchasePage.getOrderSummaryPageOrderID();
		logger.info("Checking both order ID maching or not");
		Assert.assertEquals(orderPageOrderID,orderSummaryPageOrderID,"Assertion failure on verifying product purchase ");
		logger.info("Both Order id's matched");
		extentReportListener.test.log(Status.INFO, "Order page order id and Order summary page order id verified ");
		
		
		
		
	}
}
