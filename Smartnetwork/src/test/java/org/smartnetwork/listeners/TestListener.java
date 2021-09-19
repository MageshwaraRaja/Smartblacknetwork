package org.smartnetwork.listeners;

import static org.smartnetwork.extentreport.ExtentTestManager.getTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.smartnetwork.execution.BaseClass;
import org.smartnetwork.extentreport.ExtentManager;
import org.smartnetwork.logs.Log;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import java.util.Objects;

public class TestListener extends BaseClass implements ITestListener {
	    private static String getTestMethodName(ITestResult iTestResult) {
	        return iTestResult.getMethod().getConstructorOrMethod().getName();
	    }

	    @Override
	    public void onStart(ITestContext iTestContext) {
	        Log.info("I am in onStart method " + iTestContext.getName());
	        iTestContext.setAttribute("WebDriver", this.driver);
	    }

	    @Override
	    public void onFinish(ITestContext iTestContext) {
	        Log.info("I am in onFinish method " + iTestContext.getName());
	        ExtentManager.extentReports.flush();
	    }

	    @Override
	    public void onTestStart(ITestResult iTestResult) {
	        Log.info(getTestMethodName(iTestResult) + " test is starting.");
	    }

	    @Override
	    public void onTestSuccess(ITestResult iTestResult) {
	        Log.info(getTestMethodName(iTestResult) + " test is succeed.");
	        getTest().log(Status.PASS, "Test passed");
	    }

	    @Override
	    public void onTestFailure(ITestResult iTestResult) {
	        Log.info(getTestMethodName(iTestResult) + " test is failed.");

	        Object testClass = iTestResult.getInstance();
	        WebDriver driver = ((BaseClass) testClass).getDriver();

	        String base64Screenshot =
	            "data:image/png;base64," + ((TakesScreenshot) Objects.requireNonNull(driver)).getScreenshotAs(OutputType.BASE64);
	        getTest().log(Status.FAIL, "Test Failed",
	            getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0));
	    }

	    @Override
	    public void onTestSkipped(ITestResult iTestResult) {
	        Log.info(getTestMethodName(iTestResult) + " test is skipped.");
	        getTest().log(Status.SKIP, "Test Skipped");
	    }

	    @Override
	    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
	        Log.info("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
	    }
}
