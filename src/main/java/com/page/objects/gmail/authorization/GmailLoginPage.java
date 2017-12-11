package com.page.objects.gmail.authorization;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.wrapper.factory.BrowserFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class GmailLoginPage {
    private WebDriverWait wait;

    @FindBy(how = How.ID, using = "identifierId")
    private WebElement loginField;

    @FindBy(how = How.XPATH, using = "//div[@jsname='B34EJ']")
    private WebElement loginErrorLabel;

    @FindBy(how = How.ID, using = "identifierNext")
    private WebElement submitLoginButton;

    public void inputLogin(String login){
        loginField.click();
        loginField.sendKeys(login);
    }

    public void submitLogin(){
        submitLoginButton.click();
    }

    public boolean isLoginErrorLabelPresented(){
        try {
            wait = new WebDriverWait(BrowserFactory.getDriver(), 10);
            return wait.until(elem -> loginErrorLabel.isDisplayed());
        }
        catch (NoSuchElementException ex){
            return false;
        }
    }
}
