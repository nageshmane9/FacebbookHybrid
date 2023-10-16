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
import com.facebook.Utilities.FetchData;
import com.facebook.Utilities.Screenshot;
import com.facebookPages.Login;

public class LogInTests2Fetchdata extends Base     // Extended base class and created referance variable of login Page
{
	
	
	public static Login login;
	
	
	@BeforeMethod
	public void beforeMethod(Method m) throws Exception
	{
		driver=InializationBrowser("facebookurl");
		System.out.println("******Starting Test******"+m.getName()+"******");
		
	}
	
 
	@Test(dataProvider="data", dataProviderClass=FetchData.class)
	public void loginWithInvalidCredential(String email,String Password)
	{
		login =new Login(driver);
		login.enteremail(email);
		login.enterpassword(Password);
		login.ClickOnLoginButton();
		
	}
	
	
   @AfterMethod
   public void close()
   {
	   driver.quit();
   }
	
	
	
	

}
