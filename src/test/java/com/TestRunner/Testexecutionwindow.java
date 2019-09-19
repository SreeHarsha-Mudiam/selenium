package com.TestRunner;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Commanmethods.TestBaseCLass;
import com.Testcases.Testcasesonweb;
import com.WebObjects.Pageobjectsfunctionality;

public class Testexecutionwindow extends Testcasesonweb{
	public static TestBaseCLass tbc=new TestBaseCLass();
	@Test
	public static void execution() {
		logger=report.createTest("Hrm Login");
		logger.info("Launching the Browser");
		
		Testexecutionwindow.getbrowser("Chrome");
		
		logger.info("User Login");
		
		String userid=tbc.getstringvalue("Testvalues", 1, 1);
	
		String userpsw=tbc.getstringvalue("Testvalues", 1, 2);
		Testexecutionwindow.userlogin(userid, userpsw);
		logger.info("Apply Leave");
		Testexecutionwindow.testcase_01();
		
		
	}

}
