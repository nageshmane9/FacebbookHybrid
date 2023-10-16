package com.facebook.Utilities;

import org.testng.annotations.DataProvider;

public class FetchData 
{

	@DataProvider(name="data")
	public static Object[][] GetData()
	{
		
		Object data[][] = new Object[3][2];    //3 row and 2 column
		
		//1st set
		
		data[0][0]= "CAjiton@gmail.com";
		data[0][1]= "Abcd@123";
		
		//2nd Set
		
		data[1][0]="rcajitonrais@gmail.com";
		data[1][1]= "xyz@123";
		
		//3rd Set
		
		data[2][0]="8605654166";
		data[2][1]="Cajiton@123";
		
		return data;
	}
	
}
