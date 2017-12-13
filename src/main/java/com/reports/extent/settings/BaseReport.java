package com.reports.extent.settings;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.io.File;

public class BaseReport {
    protected static ExtentReports extent;
    public static ExtentTest test;
    public static String testCaseName;
    private static ExtentHtmlReporter htmlReporter;

    public static void startReport(){
        int i = 1;
        String extentConfigName = "/extent-config.xml";
        String reportPath = System.getProperty("user.dir")+"/reports/Zialinski Task%o.html";
        File f = new File(reportPath);
        htmlReporter = new ExtentHtmlReporter(reportPath);
        while(f.exists() && !f.isDirectory()){
            String finalPath = String.format(reportPath, i);
            htmlReporter = new ExtentHtmlReporter(finalPath);
            f=new File(finalPath);
            ++i;
        }
        htmlReporter.loadConfig(System.getProperty("user.dir")+extentConfigName);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    public static void stopReport(){
        extent.flush();
        extent.removeTest(test);
    }
}
