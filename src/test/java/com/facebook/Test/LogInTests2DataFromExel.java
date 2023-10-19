package com.facebook.Test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.facebook.Base.Base;
import com.facebook.Utilities.ExelData;
import com.facebook.Utilities.Screenshot;
import com.facebookPages.Login;

public class LogInTests2DataFromExel extends Base     // Extended base class and created referance variable of login Page
{
	
	
    
	//public static WebDriver driver;
	public static Login login;
	
	
	@Test(priority=1)
	public void loginWithInvalicredentials() throws Exception
	{
		XSSFSheet sheet = ExelData.data();    //Exel data is class // It support .xlsx extension
		                                                           // Workbookfactory supports all extension
		int rowCount= sheet.getPhysicalNumberOfRows();
		
		for(int i=1;i<rowCount ;i++)       //              from second row
		{
			XSSFRow row =sheet.getRow(i);
			
			driver=InializationBrowser("facebookurl");
			
			login =new Login(driver);
			
			
		login.enteremail(row.getCell(0).getStringCellValue());
		login.enterpassword(row.getCell(1).getStringCellValue());
		login.ClickOnLoginButton();
		
		killbrowser();
	}
	
	}
	
	
	
	

}
