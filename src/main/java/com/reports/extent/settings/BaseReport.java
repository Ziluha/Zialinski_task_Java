package com.reports.extent.settings;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import junit.framework.TestResult;

public class BaseReport {
    protected static ExtentReports extent;
    protected static ExtentTest test;
    public static String testCaseName;
    private static ExtentHtmlReporter htmlReporter;

    public static void startReport(String testSuiteName){
        String extentConfigName = "/extent-config.xml";
        String reportPath = System.getProperty("user.dir")+"/reports/"+testSuiteName+".html";
        htmlReporter = new ExtentHtmlReporter(reportPath);
        htmlReporter.loadConfig(System.getProperty("user.dir")+extentConfigName);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    public void getResult(){
        TestResult result = new TestResult();
        if(result.failureCount()>0){
            test.fail(result.errors().toString());
        }
    }

    public static void stopReport(){
        extent.flush();
        extent.removeTest(test);
    }
}
