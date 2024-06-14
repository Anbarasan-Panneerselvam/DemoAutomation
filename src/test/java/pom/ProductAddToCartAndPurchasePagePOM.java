package pom;

import org.openqa.selenium.By;

public class ProductAddToCartAndPurchasePagePOM {
	public By zaraCoatAddToCartButton=By.xpath("(//div[@class='card-body']//button)[2]");
	public By adidasAddToCartButton=By.xpath("(//div[@class='card-body']//button)[4]");
	public By iphoneAddToCartButton=By.xpath("//b[text()='IPHONE 13 PRO']//following::button[text()=' Add To Cart']");
	public By cartButton=By.xpath("//button[text()='  Cart ']");
	public By ordersButton=By.xpath("//button[text()='  ORDERS']");
	public By homeButton=By.xpath("//button[text()=' HOME ']");
	public By signOutButton=By.xpath("//button[text()=' Sign Out ']");
	public By zaraCoatViewButton=By.xpath("(//button[text()=' View'])[1]");
	public By adidasViewButton=By.xpath("(//button[text()=' View'])[2]");
	public By iphoneViewButton=By.xpath("(//button[text()=' View'])[3]");
	public By afterViewAddToCartButton=By.xpath("//button[text()='Add to Cart']");
	public By continueShoppingButton=By.xpath("//a[text()='Continue Shopping']");
	public By productAddedToCartSuccessMsg=By.xpath("//div[text()=' Product Added To Cart ']");
	public By productDeleteFromCartButton=By.xpath("//button[@class='btn btn-danger']");
	public By productCheckoutButton=By.xpath("//button[text()='Checkout']");
	public By productBuyNowButton=By.xpath("//button[text()='Buy Now']");
	public By cartContinueShoppingButton=By.xpath("//button[text()='Continue Shopping']");
	public By cvvInputBox=By.xpath("//div[text()='CVV Code ']//following-sibling::input");
	public By expiryDateMonth=By.xpath("(//div//following::select[@class='input ddl'])[1]");
	public By expiryDateDay=By.xpath("//select[@class='input ddl']/following-sibling::select[1]");
	public By expiryDateMonthOption=By.xpath("(//option[text()='01'])[1]");
	public By expiryDateOption=By.xpath("(//option[text()='12'])[2]");
	public By cardNameInputBox=By.xpath("//div[text()='Name on Card ']//following-sibling::input");
	public By selectCountry=By.xpath("//input[@placeholder='Select Country']");
	public By selectCountryOptionIndia=By.xpath("//span[text()=' India']");
	public By placeOrderButton=By.xpath("//a[text()='Place Order ']");
	public By orderPlacedSuccessMsg=By.xpath("//div[text()=' Order Placed Successfully ']");
	public By orderDetailsExcelDownloadButton=By.xpath("//button[text()='Click To Download Order Details in Excel']");
	public By logoutSuccessMsg=By.xpath("//div[text()=' Logout Successfully ']");
	public By ordersPageRecentOrderID=By.xpath("//tr[@class='ng-star-inserted']//th[1]");
	public By ordersPageOrderViewButton=By.xpath("(//button[text()='View'])[1]");
	public By orderSummaryPageOrderID=By.xpath("//small[text()='Order Id']/following-sibling::div");
	
}
