package com.Unocoin_Web.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter
{
public ExtentHtmlReporter htmlReporter;
public ExtentReports extent;
public ExtentTest logger;

public void onStart(ITestContext testcontext)
{
	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
	String repName="Test-Report-"+timeStamp+".html";
	htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName);
	htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
	
	extent=new ExtentReports();
	extent.attachReporter(htmlReporter);
	extent.setSystemInfo("Host name","localhost");
	extent.setSystemInfo("Environment","QA");
	extent.setSystemInfo("user","Gaurav");
	
	htmlReporter.config().setDocumentTitle("Unocoin Web Test Report");//title of report
	htmlReporter.config().setReportName("Unocoin Functional Test Report");//name of the report
	htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);//location of the chart
	htmlReporter.config().setTheme(Theme.DARK);
	}

public void onTestSuccess(ITestResult tr)
{
	logger=extent.createTest(tr.getName());// create new entry of the report
	logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));//send the passed information
}
public void onTestFailure(ITestResult tr)
{
	logger=extent.createTest(tr.getName());// create new entry of the report
	logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
	String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
	File f = new File(screenshotPath);
	
	if(f.exists())
	{
		try {
			logger.fail("Screenshot is below:"+ logger.addScreenCaptureFromPath(screenshotPath));
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
public void onTestSkipped(ITestResult tr)
{
	logger=extent.createTest(tr.getName());// create new entry of the report
	logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));	
}
public void onFinish(ITestContext testContext)
{
	extent.flush();
}
}
