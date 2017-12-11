package com.zialinski.webdriver;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest {
    @Test
    public void test(){
        System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://gmail.com");
        Assert.assertTrue(driver.findElement(By.id("identifierNext")).isDisplayed());
        driver.close();
    }

}
