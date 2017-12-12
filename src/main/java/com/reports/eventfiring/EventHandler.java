package com.reports.eventfiring;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class EventHandler implements WebDriverEventListener{
    public void beforeAlertAccept(WebDriver webDriver) {

    }

    public void afterAlertAccept(WebDriver webDriver) {

    }

    public void afterAlertDismiss(WebDriver webDriver) {

    }

    public void beforeAlertDismiss(WebDriver webDriver) {

    }

    public void beforeNavigateTo(String s, WebDriver webDriver) {
        System.out.println("Navigating to " + s);
    }

    public void afterNavigateTo(String s, WebDriver webDriver) {
        System.out.println("Navigated to " + s);
    }

    public void beforeNavigateBack(WebDriver webDriver) {
        System.out.println("Before beforeNavigateBack " + webDriver.getCurrentUrl());
    }

    public void afterNavigateBack(WebDriver webDriver) {
        System.out.println("After navigateback to " + webDriver.getCurrentUrl());
    }

    public void beforeNavigateForward(WebDriver webDriver) {
        System.out.println("Before beforeNavigateForward " + webDriver.getCurrentUrl());
    }

    public void afterNavigateForward(WebDriver webDriver) {
        System.out.println("AfterNavigateForward to " + webDriver.getCurrentUrl());
    }

    public void beforeNavigateRefresh(WebDriver webDriver) {

    }

    public void afterNavigateRefresh(WebDriver webDriver) {

    }

    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        System.out.println("Finding element by " + by.toString());
    }

    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        System.out.println("Find happened using method " + by.toString());
    }

    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        System.out.println("About to click on the " + webElement.toString());
    }

    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        System.out.println("Clicked on " + webElement.toString());
    }

    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        System.out.println("Before changing of value");
    }

    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        System.out.println("Value changed " + webElement.toString());
    }

    public void beforeScript(String s, WebDriver webDriver) {
        System.out.println("Before beforeScript " + s);
    }

    public void afterScript(String s, WebDriver webDriver) {
        System.out.println("AfterScript, Script is " + s);
    }

    public void onException(Throwable throwable, WebDriver webDriver) {
        System.out.println("Exception occured at " + throwable.getMessage());
    }
}
