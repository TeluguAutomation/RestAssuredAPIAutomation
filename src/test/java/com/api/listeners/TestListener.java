package com.api.listeners;

import org.apache.logging.log4j.LogManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListener implements ITestListener{

	private static final org.apache.logging.log4j.Logger Logger = LogManager.getLogger(TestListener.class);

   
    public void onStart(ITestContext context) {
        Logger.info("========== Test Suite Started: " + context.getName() + " ==========");
    }

   
    public void onFinish(ITestContext context) {
        Logger.info("========== Test Suite Completed: " + context.getName() + " ==========");
    }

   
    public void onTestStart(ITestResult result) {
       // result.setAttribute("startTime", System.currentTimeMillis()); // Store start time
        Logger.info("---------- Test Started: " + result.getMethod().getMethodName() + " ----------");
    }

   
    public void onTestSuccess(ITestResult result) {
        Logger.info("PASSED: " + result.getMethod().getMethodName());
        Logger.info("Description: " + result.getMethod().getDescription());
    }

   
    public void onTestFailure(ITestResult result) {
        Logger.error("FAILED: " + result.getMethod().getMethodName());
        Logger.error("Description: " + result.getMethod().getDescription());
        Logger.error("Error Details: ", result.getThrowable());

     
    }

   
    public void onTestSkipped(ITestResult result) {
        Logger.warn("SKIPPED: " + result.getMethod().getMethodName());
        if (result.getThrowable() != null) {
            Logger.warn("Skip Reason: " + result.getThrowable().getMessage());
        }
    }
}
