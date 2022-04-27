package com.example.testhtmlintegration.presentation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateMessagePage extends AbstractPage {

    private By idBy = By.name("id");
    private By summaryBy = By.name("summary");
    private By textBy = By.name("text");

    private WebElement id;
    private WebElement summary;
    private WebElement text;

    @FindBy(css = "input[type=submit]")
    private WebElement submit;

    public CreateMessagePage(WebDriver driver) {
        super(driver);
        driver.get("http://localhost:8080/messagges/form");

        String currentUrl = driver.getCurrentUrl(); 
        System.out.println(currentUrl);

        new WebDriverWait(driver, 20).until(ExpectedConditions.titleIs("HtmlUnit Integration Example Form"));

        id = driver.findElement(idBy);
        summary = driver.findElement(summaryBy);
        text = driver.findElement(textBy);
        submit = driver.findElement(By.cssSelector("input[type=submit]"));
    }

    // public ViewMessagePage post(String id, String summary, String text) {
    //     driver.findElement(idBy).sendKeys(id);
    //     driver.findElement(summaryBy).sendKeys(summary);
    //     driver.findElement(textBy).sendKeys(text);
    //     return new ViewMessagePage(driver);
    // }

    public <T> T createMessage(Class<T> resultPage, String id, String summary, String details) {

        // driver.findElement(idBy).sendKeys(id);
        // driver.findElement(summaryBy).sendKeys(summary);
        // driver.findElement(textBy).sendKeys(details);
        // driver.findElement(By.cssSelector("input[type=submit]")).click();

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
