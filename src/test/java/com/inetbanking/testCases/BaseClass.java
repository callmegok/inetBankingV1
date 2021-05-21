package com.inetbanking.testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.log4j.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.inetbanking.utilities.ReadConfig;

public class BaseClass {
	
	
	/*	User ID :	mngr323191
		Password :	ygErupU
	*/
	ReadConfig readconfig= new ReadConfig();
	public String baseURL= readconfig.geturl();
	public String 	username=readconfig.getusername();
	public String 	password= readconfig.getpassword();
	public static WebDriver driver;
	public ExtentReports extent;
	public static Logger logger;
	

	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		
		logger= Logger.getLogger("BaseClass");
		//DOMConfigurator.configure("Log4j.xml");----> used for XML Log4j
		PropertyConfigurator.configure("Log4j.properties");
		logger.info("This is Log");
	    //extent report and extent spark reporter
		
		String path =System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Edocketing results");
		reporter.config().setDocumentTitle("Passport results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Gokul");
		
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getchromepath());
			driver=new ChromeDriver();
		}
		
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",readconfig.getfirefoxpath());
			driver=new FirefoxDriver();
		}
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver",readconfig.getiepath());
			driver=new InternetExplorerDriver();
		}
		driver.get(baseURL);
	}

	@AfterClass()
	public void tearDown()
	{
		
		driver.quit();
	}
}
