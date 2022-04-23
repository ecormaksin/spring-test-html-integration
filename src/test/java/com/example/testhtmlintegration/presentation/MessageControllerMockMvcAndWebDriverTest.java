package com.example.testhtmlintegration.presentation;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class MessageControllerMockMvcAndWebDriverTest {

    @Autowired
    WebDriver driver;

    @Test
    void test() throws Exception {

        CreateMessagePage page = CreateMessagePage.to(driver);
    }
}
