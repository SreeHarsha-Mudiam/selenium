package com.Commanmethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestBaseCLass {
	public static ExtentHtmlReporter extent;
	public static  ExtentReports report;
	public static ExtentTest logger;
	
	public static WebDriver driver;
	public static XSSFWorkbook xsw;
	public static void getbrowser(String Browser) {
		if(Browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\Desktop_bkp\\mail.interglobe.com\\chromedriver_win32 (5)\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("http://www.testingmasters.com/hrm/");
		}
		else if(Browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\TT089\\Downloads\\geckodriver-v0.24.0-win64 (1)\\geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("http://www.testingmasters.com/hrm/");
		}
		else if(Browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Users\\TT089\\Downloads\\IEDriverServer_x64_3.14.0 (2)\\IEDriverServer.exe");
			driver=new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("http://www.testingmasters.com/hrm/");
		}
		
		else
		{
			System.out.println("Browser is not opened");
		}
		
	}
	public static void userlogin(String Username,String password) {
		driver.findElement(By.id("txtUsername")).sendKeys(Username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		
		
		
		
	}
	public static String getscreenshots() {
		
		String Screenshotpath="E:\\Selenium_Harsh\\HRM\\Screenshots_"+getsystemdate()+".png";

		TakesScreenshot ts=(TakesScreenshot) driver;
		//String Screenshotpath=System.getProperty("user.dir") + "E:\\New folder\\Screenshots_"+getsystemdate()+".png";

	File location=ts.getScreenshotAs(OutputType.FILE);

	try {
		FileHandler.copy(location,new File(Screenshotpath));
	} catch (IOException e) {
		
		System.out.println("Screenshot is not taken : "+e.getMessage());
	}
	return Screenshotpath;
	
}


public static String getsystemdate() {
	DateFormat dateformet=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
	Date dte=new Date();
	return dateformet.format(dte);
	
}
public static void  Testdataread() {
	File filelocation=new File("E:\\Selenium_Harsh\\HRM\\TestData\\WebTestdata.xlsx");

	try {
		FileInputStream fis=new FileInputStream(filelocation);
		xsw=new XSSFWorkbook(fis);
		
	
	} catch (Exception e) {
		
		System.out.println("Data Not Reading:: "+e.getMessage());
	}
	
}
public String getstringvalue(String sheetname,int rownum,int columnum)
{
	Testdataread();
	System.out.println(xsw.getSheet(sheetname).getRow(rownum).getCell(columnum).getStringCellValue());
	return xsw.getSheet(sheetname).getRow(rownum).getCell(columnum).getStringCellValue();
	
	
}


@BeforeSuite
public static void initialstepexecution() {
	 extent=new ExtentHtmlReporter("E:\\Selenium_Harsh\\HRM\\Reports\\"+getsystemdate()+".html");
	  report=new ExtentReports();
	  report.attachReporter(extent);
	
}
@AfterMethod
public static void methodstatustoreport(ITestResult result) throws IOException {
	Reporter.log("Screenshot attached based on status");
	if(result.getStatus()==ITestResult.SUCCESS) {
		logger.pass("Success", MediaEntityBuilder.createScreenCaptureFromPath(getscreenshots()).build());
	Reporter.log("Successfully pass screesnshots attached");
	}
	
	else if(result.getStatus()==ITestResult.FAILURE){
		logger.fail("Failure", MediaEntityBuilder.createScreenCaptureFromPath(getscreenshots()).build());
		Reporter.log("Successfully failed screesnshots attached");	
	}
	else
	{
		System.out.println("Screenshots is not attached");
	}
	report.flush();
	Reporter.log("Html Reporter Is compleated",true);
	
	
}
}
