package com.example.testhtmlintegration.presentation;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class MessageControllerMockMvcAndWebDriverTest {

    WebDriver driver;

    @BeforeEach
    void setup() {
        
    }

    @Test
    void test() throws Exception {

        // CreateMessagePage page = new CreateMessagePage(driver);
        CreateMessagePage page = CreateMessagePage.to(driver);

        String expectedId = "123";
        String expectedSummary = "Spring Rocks";
        String expectedText = "In case you didn't know, Spring Rocks!";

        Message expectedMessage = new Message(expectedId, expectedSummary, expectedText);

        ViewMessagePage viewMessagePage = 
            page.createMessage(ViewMessagePage.class, expectedId, expectedSummary, expectedText);
        
        assertThat(viewMessagePage.getMessage()).isEqualTo(expectedMessage);
    }
}
