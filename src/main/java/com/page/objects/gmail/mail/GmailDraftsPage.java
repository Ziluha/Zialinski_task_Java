package com.page.objects.gmail.mail;

import com.wrapper.factory.BrowserFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import javax.annotation.Nullable;
import java.util.List;
import java.util.NoSuchElementException;

public class GmailDraftsPage {
    private WebDriverWait wait;
    private String draftsTitle = "Drafts";

    @FindBy(how = How.XPATH, using = "(//div[@role='button']//span[@class='ts'])[last()]")
    private WebElement countOfDrafts;

    @FindBy(how = How.XPATH, using = "//div[@role='main']//span[@class='bog']")
    private List<WebElement> draftsSubjectsList;

    @FindBy(how= How.XPATH, using = "//div[@role='main']//div[@role='checkbox']/div")
    private List<WebElement> draftCheckboxesList;

    @FindBy(how = How.XPATH, using = "//div[@role='button' and @act='16']/div")
    private WebElement discardDraftsButton;

    public boolean isDraftAdded(String messageSubject){
        return draftsSubjectsList.get(0).getText().equals(messageSubject);
    }

    public boolean isDraftPageOpened(){
        try{
            wait = new WebDriverWait(BrowserFactory.getDriver(), 10);
            return wait.until(elem -> BrowserFactory.getDriver().getTitle().contains(draftsTitle));
        }catch (NoSuchElementException ex){
            return false;
        }
    }

    public void chooseFirstDraft(){
        draftCheckboxesList.get(0).click();
    }

    public void clickDiscardDraftButton(){
        discardDraftsButton.click();
    }

    public int getCountOfDrafts(){
        return Integer.parseInt(countOfDrafts.getText());
    }
}
