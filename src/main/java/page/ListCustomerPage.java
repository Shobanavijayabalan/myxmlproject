package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class ListCustomerPage {
	WebDriver driver;

	public ListCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[1]/a[1]") WebElement ADD_CUSTOMER_ON_LIST_CUSTOMER_HEADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"foo_filter\"]") WebElement SEARCH_BAR_OF_LIST_CUSTOMER_ELEMENT;
	
	public void validateListCustomerPage() throws InterruptedException {
		Thread.sleep(1000);
		Assert.assertTrue(ADD_CUSTOMER_ON_LIST_CUSTOMER_HEADER_ELEMENT.isDisplayed(), "List Customer Page is not available");
	}
    public void clickonAddCustomeronListCustomer() {
    	ADD_CUSTOMER_ON_LIST_CUSTOMER_HEADER_ELEMENT.click();
    	 }
}
