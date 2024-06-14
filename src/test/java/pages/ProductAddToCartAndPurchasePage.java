package pages;

import java.awt.AWTException;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pom.ProductAddToCartAndPurchasePagePOM;
import utilities.LocalHelper;
import utilities.TestUtil;

public class ProductAddToCartAndPurchasePage extends ProductAddToCartAndPurchasePagePOM {
	 protected static final Logger logger = LoggerFactory.getLogger(ProductAddToCartAndPurchasePage.class);
	    
	    private final LocalHelper localHelper = new LocalHelper();

	    private final WebDriver driver;
	    
	    public ProductAddToCartAndPurchasePage(WebDriver driver) {
	        this.driver=driver;
	    }
	    public void clickIPhoneAddToCartButton() {
			try {
				localHelper.jsExecutorHighlight(iphoneAddToCartButton, driver);
				localHelper.clickElement(iphoneAddToCartButton, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(iphoneAddToCartButton, driver);
			}
			logger.info("Iphone Add to cart  button is clicked");
		}
	    public void clickAdidasShoeAddToCartButton() {
			try {
				localHelper.jsExecutorHighlight(adidasAddToCartButton, driver);
				localHelper.clickElement(adidasAddToCartButton, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(adidasAddToCartButton, driver);
			}
			logger.info("Iphone Add to cart  button is clicked");
		}
	    public String checkProductAddedSuccessMessage() {
			return localHelper.getText(productAddedToCartSuccessMsg, driver);
		}
	    public void clickAdidasProductViewButton() {
			try {
				localHelper.jsExecutorHighlight(adidasViewButton, driver);
				localHelper.clickElement(adidasViewButton, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(adidasViewButton, driver);
			}
			logger.info("Adidas product view button is clicked");
		}
	    public void clickAfterProductViewAddToCartButton() {
			try {
				localHelper.jsExecutorHighlight(afterViewAddToCartButton, driver);
				localHelper.clickElement(afterViewAddToCartButton, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(afterViewAddToCartButton, driver);
			}
			logger.info("After view poduct add to cart button is clicked");
		}
	    public void clickContinueShoppingButton() {
			try {
				localHelper.jsExecutorHighlight(continueShoppingButton, driver);
				localHelper.clickElement(continueShoppingButton, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(continueShoppingButton, driver);
			}
			logger.info("Continue shopping button is clicked");
		}
	    public void clickCartButton() {
			try {
				localHelper.jsExecutorHighlight(cartButton, driver);
				localHelper.clickElement(cartButton, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(cartButton, driver);
			}
			logger.info("Cart button is clicked");
		}
	    public void clickProductCheckoutButton() {
			try {
				localHelper.jsExecutorHighlight(productCheckoutButton, driver);
				localHelper.clickElement(productCheckoutButton, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(productCheckoutButton, driver);
			}
			logger.info("Product checkout button is clicked");
		}
	    public void clickCardExpiryDate() {
				localHelper.clickElement(expiryDateMonth, driver);
				localHelper.clickElement(expiryDateMonthOption, driver);
				localHelper.clickElement(expiryDateDay, driver);
				localHelper.clickElement(expiryDateOption, driver);
			
			logger.info("Product checkout button is clicked");
		}
	    public void enterCardCVV() {
			localHelper.jsExecutorHighlight(cvvInputBox, driver);
			localHelper.sendKeys(cvvInputBox,new TestUtil().init_Properties().getProperty("cvv"),driver);
			logger.info("CVV passed in the cvv input box");
		}
	    public void enterCardHolderName() {
			localHelper.jsExecutorHighlight(cardNameInputBox, driver);
			localHelper.sendKeys(cardNameInputBox,new TestUtil().init_Properties().getProperty("cardName"),driver);
			logger.info("Card name passed in the input box");
		}
	    public void sendCountryNameToSelectCountryBox() {
			localHelper.jsExecutorHighlight(selectCountry, driver);
	    	localHelper.jsExecutorClick(selectCountry, driver);
	    	localHelper.sendKeys(selectCountry, new TestUtil().init_Properties().getProperty("country"), driver);
	    	localHelper.clickElement(selectCountryOptionIndia, driver);
	    	
	    	logger.info("Text is passed in the TextBox");

		}
	    public void clickPlaceOrderButton() {
			try {
				localHelper.jsExecutorHighlight(placeOrderButton, driver);
				localHelper.clickElement(placeOrderButton, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(placeOrderButton, driver);
			}
			logger.info("Place order button is clicked");
		}
	    public String checkOrderPlacedSuccessMessage() {
			return localHelper.getText(orderPlacedSuccessMsg, driver);
		}
	    public void clickOrderDetailsExcelDownloadButton() throws AWTException, InterruptedException {
			try {
				localHelper.jsExecutorHighlight(orderDetailsExcelDownloadButton, driver);
				localHelper.clickElement(orderDetailsExcelDownloadButton, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(orderDetailsExcelDownloadButton, driver);
			}
			localHelper.clickEnterUsingRobot();
			logger.info("Order Details excel download button is clicked");
		}
	  
	    public void clickProductDeleteButton() {
			try {
				localHelper.jsExecutorHighlight(productDeleteFromCartButton, driver);
				localHelper.clickElement(productDeleteFromCartButton, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(productDeleteFromCartButton, driver);
			}
			logger.info("Product delete from Cart button is clicked");
		}
	    public void clickOrdersButton() {
			try {
				localHelper.jsExecutorHighlight(ordersButton, driver);
				localHelper.clickElement(ordersButton, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(ordersButton, driver);
			}
			logger.info("Orders button is clicked");
		}
	    public String getOrdersPageOrderID() {
	    	logger.info("Orders page Order ID Copied");
	    	localHelper.jsExecutorHighlight(ordersPageRecentOrderID, driver);
			return localHelper.getText(ordersPageRecentOrderID, driver);
		}
	    public void clickOrderViewButton() {
			try {
				localHelper.jsExecutorHighlight(ordersPageOrderViewButton, driver);
				localHelper.clickElement(ordersPageOrderViewButton, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(ordersPageOrderViewButton, driver);
			}
			logger.info("Orders view button is clicked");
		}
	    public String getOrderSummaryPageOrderID() {
	    	logger.info("Orders Summary page Order ID Copied");
	    	localHelper.jsExecutorHighlight(orderSummaryPageOrderID, driver);
			return localHelper.getText(orderSummaryPageOrderID, driver);
		}

}
