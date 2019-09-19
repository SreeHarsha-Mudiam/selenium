package com.WebObjects;

import java.applet.Applet;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Commanmethods.TestBaseCLass;
import com.Commanmethods.Webcommanmethods;

public class Pageobjectsfunctionality extends Webcommanmethods {

	@FindBy(id="menu_leave_viewLeaveModule")public static WebElement Leavetab;
	@FindBy(id="menu_leave_applyLeave")public static WebElement Apllytab;
	@FindBy(id="applyleave_txtLeaveType")public static  WebElement Leavetypedropdown;
	@FindBy(xpath="//option[contains(text(),'Annual Leave')]")public static  WebElement leavetypename;
	
	public static  void applyleave() {
		
		mouseover(Leavetab);	
		Apllytab.click();
		Leavetypedropdown.click();
		leavetypename.click();
		
	}
}
