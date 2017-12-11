package com.zialinski.webdriver;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest {
    @Test
    public void test(){
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("https://gmail.com");
        Assert.assertTrue(driver.findElement(By.id("identifierNext")).isDisplayed());
        driver.close();
    }

}
