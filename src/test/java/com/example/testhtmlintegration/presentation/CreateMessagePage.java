package com.example.testhtmlintegration.presentation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class CreateMessagePage {

    @Autowired
    private WebDriver driver;

    private WebElement id;
    private WebElement summary;
    private WebElement text;

    @FindBy(css = "input[type=submit]")
    private WebElement submit;

    public <T> T createMessage(Class<T> resultPage, String id, String summary, String details) {
        this.id.sendKeys(id);
        this.summary.sendKeys(summary);
        this.text.sendKeys(details);
        this.submit.click();
        return PageFactory.initElements(driver, resultPage);
    }

    public static CreateMessagePage to(WebDriver driver) {
        driver.get("http://localhost:9990/messagges/form");
        return PageFactory.initElements(driver, CreateMessagePage.class);
    }
}
