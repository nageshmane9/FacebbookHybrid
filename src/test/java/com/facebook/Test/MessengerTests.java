package com.facebook.Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.facebook.Base.Base;
import com.facebook.Utilities.Screenshot;

public class MessengerTests extends Base
{
  
	public static WebDriver driver;
	
	@Test
	public void openurl() throws Exception
	{
		
		driver=InializationBrowser("amazonurl");
		
		Screenshot.getAshot();
		
	}
	
	
}
