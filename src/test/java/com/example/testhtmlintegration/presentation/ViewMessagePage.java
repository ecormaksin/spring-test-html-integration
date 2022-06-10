package com.example.testhtmlintegration.presentation;

import com.gargoylesoftware.css.parser.javacc.ParseException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ViewMessagePage extends AbstractPage {

    private WebElement id;
    private WebElement summary;
    private WebElement text;

    public ViewMessagePage(WebDriver driver) {
        super(driver);

        if (!"HtmlUnit Integration Example View".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the view page.");
        }
    }

    public Message getMessage() throws ParseException {
        Message message = new Message();
        message.setId(getId());
        message.setSummary(getSummary());
        message.setText(getText());
        return message;
    }

    private String getId() {
        return this.id.getAttribute("value");
    }

    private String getSummary() {
        return this.summary.getText();
    }

    private String getText() {
        return this.text.getText();
    }
}
