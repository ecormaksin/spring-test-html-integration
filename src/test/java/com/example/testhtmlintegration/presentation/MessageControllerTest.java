package com.example.testhtmlintegration.presentation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class MessageControllerTest {
    
    @Autowired
    MockMvc mockMvc;

    @Test
    void testFirstPostExample() throws Exception {
        
        MockHttpServletRequestBuilder createMessage = post("/messages/")
            .param("summary", "Spring Rocks")
            .param("text", "In case you didn't know, Spring Rocks!");
        
        mockMvc.perform(createMessage)
            .andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("/messages/123"));
    }

    @Test
    void testSecondGetExample() throws Exception {

        mockMvc.perform(get("/messages/form"))
            .andExpect(xpath("//input[@name='summary']").exists())
            .andExpect(xpath("//textarea[@name='text']").exists());
    }

    @Test
    void testThird_mergeFirst_and_Second() throws Exception {

        String summaryParamName = "summary";
        String textParamName = "text";
        mockMvc.perform(get("/messages/form"))
            .andExpect(xpath("//input[@name='" + summaryParamName + "']").exists())
            .andExpect(xpath("//textarea[@name='" + textParamName + "']").exists());
        
        MockHttpServletRequestBuilder createMessage = post("/messages/")
            .param(summaryParamName, "Spring Rocks")
            .param(textParamName, "In case you didn't know, Spring Rocks!");
        
        mockMvc.perform(createMessage)
            .andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("/messages/123"));
    }
}
