package com.example.testhtmlintegration.presentation;

import static org.assertj.core.api.Assertions.assertThat;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlHiddenInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextArea;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class MessageControllerMockMvcAndHtmlUnitTest {
   
    @Autowired
    WebClient webClient;


    @Test
    void test() throws Exception {

        HtmlPage createMsgFormPage = webClient.getPage("http://localhost/messages/form");

        HtmlForm form = createMsgFormPage.getHtmlElementById("messageForm");
        HtmlHiddenInput idInput = createMsgFormPage.getHtmlElementById("id");
        idInput.setValueAttribute("123");
        HtmlTextInput summaryInput = createMsgFormPage.getHtmlElementById("summary");
        summaryInput.setValueAttribute("Spring Rocks");
        HtmlTextArea textInput = createMsgFormPage.getHtmlElementById("text");
        textInput.setText("In case didn't know, Spring Rocks!");
        HtmlSubmitInput submit = form.getOneHtmlElementByAttribute("input", "type", "submit");
        HtmlPage newMessagePage = submit.click();

        assertThat(newMessagePage.getUrl().toString()).endsWith("/messages/123");
        String id = newMessagePage.getHtmlElementById("id").getAttribute("value");
        assertThat(id).isEqualTo("123");
        String summary = newMessagePage.getHtmlElementById("summary").getTextContent();
        assertThat(summary).isEqualTo("Spring Rocks");
        String text = newMessagePage.getHtmlElementById("text").getTextContent();
        assertThat(text).isEqualTo("In case you didn't know, Spring Rocks!");
    }
}

