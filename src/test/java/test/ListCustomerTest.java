package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.ListCustomerPage;
import page.LoginPage;
import util.BrowserFactory;

public class ListCustomerTest {
WebDriver driver;

	

	@Test
	@Parameters({"userName","password","dashboardHeader","FullName","CompanyName","Email","Phone","Address","City","State","Zip","Country","AddContactValidationText"})
	public void userShouldBeAbleToAddCustomer(String username,String password,String dashboardHeader,String fullname,String company,String email,String phone,String address,String city,String state,String zip,String country,String addCustomerHeader ) throws InterruptedException {

		driver = BrowserFactory.setup();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.InsertUserName(username);
		loginPage.InsertPassword(password);
		loginPage.clickSigninButton();

		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		Thread.sleep(1000);
		dashboardPage.verifyDashboardPage(dashboardHeader);
		dashboardPage.clickOnCustomerMenuButton();
		dashboardPage.clickOnListCustomerMenuButton();
		Thread.sleep(1000);
		
		ListCustomerPage listCustomerPage=PageFactory.initElements(driver, ListCustomerPage.class);
		listCustomerPage.validateListCustomerPage();
		listCustomerPage.clickonAddCustomeronListCustomer();

		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		Thread.sleep(1000);
		addCustomerPage.verifyAddCustomerPage(addCustomerHeader);
		addCustomerPage.insertFullName(fullname);
		addCustomerPage.insertCompany(company);
		addCustomerPage.insertEmail(email);
		addCustomerPage.insertPhone(phone);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertState(state);
		addCustomerPage.insertZip(zip);
        addCustomerPage.insertCountry(country);	
        addCustomerPage.clickOnSaveButton();
         
        dashboardPage.clickOnListCustomerMenuButton();
        Thread.sleep(1000);
        addCustomerPage.validateInsertedNameAndDelete();
        
        
	}

}

