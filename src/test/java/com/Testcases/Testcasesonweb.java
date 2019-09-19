package com.Testcases;

import org.openqa.selenium.support.PageFactory;

import com.WebObjects.Pageobjectsfunctionality;

public class Testcasesonweb extends Pageobjectsfunctionality{

	
	
	public static void testcase_01() {
		Pageobjectsfunctionality obj=PageFactory.initElements(driver, Pageobjectsfunctionality.class);
		obj.applyleave();
	}
	
}
