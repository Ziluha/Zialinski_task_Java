package com.page.objects.gmail.mail;

import com.wrapper.factory.BrowserFactory;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailInboxPage {
    private WebDriverWait wait;

    @FindBy(how = How.XPATH, using = "//td[contains(@class, 'HE')]//span[contains(text(), 'Saved')]")
    private WebElement savedLabel;

    @FindBy(how = How.XPATH, using = "//div[@jscontroller='DUNnfe']//div[@role='button']")
    private WebElement composeButton;

    @FindBy(how = How.NAME, using = "subjectbox")
    private WebElement messageSubjectBox;

    @FindBy(how=How.XPATH, using = "//div[@role='navigation']//a[@href='https://mail.google.com/mail/#drafts']")
    private WebElement draftsLink;

    public void clickComposeButton(){
        composeButton.click();
    }

    public void inputMessageSubject(String messageSubject){
        messageSubjectBox.click();
        messageSubjectBox.sendKeys(messageSubject);
    }

    public boolean isLoginSucceed(){
        try{
            wait = new WebDriverWait(BrowserFactory.getDriver(), 10);
            return wait.until(elem -> composeButton.isDisplayed());
        }catch (NoSuchElementException ex){
            return false;
        }
    }

    public boolean isSavedLabelPresented(){
        try {
            wait = new WebDriverWait(BrowserFactory.getDriver(), 10);
            wait.until(ExpectedConditions.visibilityOf(savedLabel));
            return true;
        }catch (NoSuchElementException ex){
            return false;
        }
    }

    public void clickDraftsLink(){
        draftsLink.click();
    }
}
