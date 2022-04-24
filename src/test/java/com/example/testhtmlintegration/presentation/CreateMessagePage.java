package com.example.testhtmlintegration.presentation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateMessagePage extends AbstractPage {

    // private WebElement id;
    // private WebElement summary;
    // private WebElement text;

    // @FindBy(css = "input[type=submit]")
    // private WebElement submit;

    public CreateMessagePage(WebDriver driver) {
        super(driver);
    }

    private By idBy = By.id("id");
    private By summaryBy = By.id("summary");
    private By textBy = By.id("text");

    public ViewMessagePage post(String id, String summary, String text) {
        driver.findElement(idBy).sendKeys(id);
        driver.findElement(summaryBy).sendKeys(summary);
        driver.findElement(textBy).sendKeys(text);
        return new ViewMessagePage(driver);
    }

    // public <T> T createMessage(Class<T> resultPage, String id, String summary, String details) {
    //     this.id.sendKeys(id);
    //     this.summary.sendKeys(summary);
    //     this.text.sendKeys(details);
    //     this.submit.click();
    //     return PageFactory.initElements(driver, resultPage);
    // }

    // public static CreateMessagePage to(WebDriver driver) {
    //     driver.get("http://localhost:9990/messagges/form");
    //     return PageFactory.initElements(driver, CreateMessagePage.class);
    // }
}
