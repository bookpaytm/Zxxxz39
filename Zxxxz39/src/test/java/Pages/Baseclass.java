package Pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Utilities.Browserfactory;
import Utilities.Configuredataprovider;
import Utilities.Exceldataprovider;
import Utilities.Helper;

public class Baseclass {
	
public WebDriver driver;
public Exceldataprovider excel;
public Configuredataprovider config;
public ExtentReports report;
public ExtentTest logger;

@BeforeSuite
public void Suite(){
excel=new Exceldataprovider();
config=new Configuredataprovider();
report=new ExtentReports();
ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"./Reports/salman"+Helper.CurrentFormatDateTime()+".html"));
report.attachReporter(extent);
}

@BeforeClass
public void setup(){
driver=Browserfactory.startapplication(driver, config.getBrowser(), config.getappurl());

}
@AfterClass
public void shutdown(){
Browserfactory.quitbrowser(driver);
}
@AfterMethod
public void CapturedScreenshot(ITestResult result) throws IOException{
if(result.getStatus()==ITestResult.SUCCESS){
logger.pass("Test case is passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.CapturedScreenshots(driver)).build());
	Helper.CapturedScreenshots(driver);
}
else if(result.getStatus()==ITestResult.FAILURE){
logger.fail("Test case is failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.CapturedScreenshots(driver)).build());
}
report.flush();
}

}
