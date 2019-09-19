package com.Commanmethods;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Webcommanmethods extends TestBaseCLass{
	
	public static void mouseover(WebElement Element) {
	Actions act=new Actions(driver);
	act.moveToElement(Element).build().perform();
	}
	
	
	public static void selectelementondropdown() {
	
	}
	}
