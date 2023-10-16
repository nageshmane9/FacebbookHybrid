package com.facebook.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base 
{
	
	public static WebDriver driver;
	public static Properties prop;

	
	public WebDriver InializationBrowser(String url)throws Exception
	{
		 prop = new Properties();
			
			FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Properties\\config.properties");
			
			prop.load(fis);
			
			 String a= prop.getProperty("Browsername");
		
		if(a.equals("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); 
		}
		
		else if(a.equals("FireFox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(); 
		}
		else if(a.equals("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(); 
		}
		
	//	driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(prop.getProperty(url));
		
		return driver;
	}
	
	
	public void WaitForVisibility( WebElement e)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		  wait.until(ExpectedConditions.visibilityOf(e));
	}
	
	public void WaitUntilIsClickable( WebElement e)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		  wait.until(ExpectedConditions.elementToBeClickable(e));
	}
	
	public void Click(WebElement e)
	{
		WaitForVisibility(e);
		e.click();
	}
	
	public void SendKeys (WebElement email,String text)
	{
		WaitForVisibility(email);
		email.sendKeys(text);
	}
	
	public void ClearText(WebElement e)
	{
		WaitForVisibility(e);
		e.clear();
	}
	
	public String getText(WebElement e)
	{
		WaitForVisibility(e);
		return e.getText();
	}
	
	public void navigateBack()
	{
		driver.navigate().back();
		
	}
	
	public void acceptAlert()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		System.out.println("Alert-"+driver.switchTo().alert().getText());
		alert.accept();
	}
	
	public void dismissAlert()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		System.out.println("Alert-"+driver.switchTo().alert().getText());
		alert.dismiss();
		
	}

	public void scrollIntoView(WebElement e)
	{
	        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoViewIfNeeded()",e);
	}

	public void scrollIntoView(WebElement e,int up,int down)
	{
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy("+up+","+down+")");
		
	}
	
	public void switchtoNextWindow(int e)
	{
		
		Set<String> windowpopup= driver.getWindowHandles();
		Iterator <String> iterate = windowpopup.iterator();
		  
		ArrayList<String> windowIndex = new ArrayList(); // upcasting
		
		while(iterate.hasNext())  // hasNext (If there is )
		{
			windowIndex.add(iterate.next());	//store that new window address
		}
		
		driver.switchTo().window(windowIndex.get(e));
		driver.manage().window().maximize();
		System.out.println("Switched to window");
		
		System.out.println("Window title="+driver.getTitle());  
	}
	
	public String getCurrentTime()
	{
	   DateFormat dateformat = new SimpleDateFormat("hh:mm a");
	   Date time= new Date();
	    
	  String time1= dateformat.format(time);
	  
	  return time1;  	
	}
	
	public String getCurrentDate()
	{
	   DateFormat dateformat = new SimpleDateFormat("dd/mm/yyyy");
	   Date date= new Date();
	    
	  String date1= dateformat.format(date);
	  
	  return date1;  	
	}
	
	public void killbrowser()
	{
		driver.quit();
	}
	
	
	
	
	
	

}
