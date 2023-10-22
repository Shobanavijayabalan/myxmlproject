package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

//import page.AddCustomerPage;
//import page.DashboardPage;
//import page.LoginPage;
//import util.BrowserFactory;

public class LoginTest {
  WebDriver driver;  
  
  
//  String addcontact="Add Contact";
//  String fullName="selenium";
//  String company="Amazon";
//  String email="fdfdf";
@Test
@Parameters({"userName","password","dashboardHeader"})
public void validUserShouldBeAbleToLogin(String username,String password,String dashboardHeader) throws InterruptedException {
	driver=BrowserFactory.setup();
    
	LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
    loginPage.InsertUserName(username);
    loginPage.InsertPassword(password);
    loginPage.clickSigninButton();
    
    DashboardPage dashboardPage= PageFactory.initElements(driver, DashboardPage.class);
    dashboardPage.verifyDashboardPage(dashboardHeader);
    BrowserFactory.tearDown();
}
	
}
 