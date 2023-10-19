package com.facebookPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebook.Base.Base;

public class Login extends Base
{
	
	public Login(WebDriver rdriver)
	{
		driver=rdriver;
		PageFactory.initElements(rdriver,this);	
	}
	
	@FindBy (id="email") private WebElement email;
	@FindBy (id="pass") private WebElement password;
	@FindBy (xpath="//Button[@name='login']") private WebElement LoginButton;
	@FindBy (xpath="//a[text()='Forgotten password?']") private WebElement forgotpasswordlink;
	@FindBy (id="u_0_0_Sl") private WebElement CreateAccountButton;
	
	
	public Login enteremail(String text)
	{
		SendKeys(email,text);
		System.out.println("Enterd email address");
		return this;
	}
	
	public Login enterpassword(String text)
	{
		SendKeys(password,text);
		System.out.println("Enterd password");
		return this;
	}
	
	public Login ClickOnLoginButton()
	{
		Click(LoginButton);
		System.out.println("Clicked on Login button");
		return this;
	}
	
	public Login ClickOnForgotAccount()
	{
		Click(forgotpasswordlink);
		System.out.println("Clicked on forgot Account Link");
		return this;
	}
	
	public Login ClickOnSignUpForFacebook()
	{
		Click(CreateAccountButton);
		System.out.println("Clicked on Sign Up for Facebook link");
		return this;
	}
	
	
	
	
	
	
	
	
	
	

}
