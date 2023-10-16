package com.facebook.Test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.facebook.Base.Base;
import com.facebook.Utilities.Screenshot;
import com.facebookPages.Login;

public class LogInTests extends Base     // Extended base class and created referance variable of login Page
{
	
	
	public static Login login;
	
	
	
	@BeforeMethod
	public void beforeMethod(Method m) throws Exception
	{
		driver=InializationBrowser("facebookurl");
		System.out.println("******Starting Test******"+m.getName()+"******");
		
	}
	
	@Test(priority=1)
	public void loginWithValidCredentials() throws IOException
	{
		login = new Login(driver);
		login.enteremail("8605654166");
		login.enterpassword("98819072@N");
		login.ClickOnLoginButton();
		String Actual= driver.getTitle();
		System.out.println(Actual);
		String Expected=prop.getProperty("HomePageTitle");
		System.out.println(Expected);
		Assert.assertEquals(Actual,Expected);
		
	}
	
	@Test(priority=2,enabled=false)
	public void loginWithInvalidEmail()
	{
		login =new Login(driver);
		login.enteremail("86056541");
		login.enterpassword("98819072@N");
		login.ClickOnLoginButton();
		
		String actual = driver.getTitle();
		String Expected =prop.getProperty("LoginTitle");
		Assert.assertEquals(actual,Expected);
	
	}
	
	@Test(priority=3,enabled=false)
	public void loginWithInvalidPass()
	{
		login =new Login(driver);
		login.enteremail("8605654166");
		login.enterpassword("98819072");
		login.ClickOnLoginButton();
		
		String actual = driver.getTitle();
		
		String Expected =prop.getProperty("LoginTitle");
		Assert.assertEquals(actual,Expected);
	}
	
	
	
   @AfterMethod
   public void close()
   {
	   driver.quit();
   }
	
	
	
	

}
