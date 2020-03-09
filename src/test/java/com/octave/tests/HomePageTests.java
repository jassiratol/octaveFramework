package com.octave.tests;

import org.testng.annotations.Test;

import com.octave.BaseTest;
import com.octave.pages.HomePage;
import com.octave.pages.JukeBoxPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class HomePageTests extends BaseTest{
	HomePage homePage;
	JukeBoxPage jukeBoxPage;
	
	  @BeforeClass
	  public void beforeClass( ) {  
	  }

	  @AfterClass
	  public void afterClass() {
	  }
	  
	  @BeforeMethod
	  public void beforeMethod(Method method) {
		  homePage = new HomePage();
		  System.out.println("\n"+ "Starthing method: "+ method.getName() +"\n");
	  }

	  @AfterMethod
	  public void afterMethod() {
	  }
	  
	  @Test
	  public void skipHomePage() {
		  jukeBoxPage= homePage.clickSkipButton();
		  String jukeBoxPageTitle = jukeBoxPage.getTitle();
		  String expectedTitle = "Title";
		  Assert.assertEquals(jukeBoxPageTitle, expectedTitle, "Arrived on JukeBox page");
	  }

}
