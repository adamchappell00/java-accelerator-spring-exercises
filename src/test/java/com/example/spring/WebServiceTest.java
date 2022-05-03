package com.example.spring;


import com.example.spring.controllers.RecordStoreController;
import com.example.spring.controllers.WebServiceController;
import com.example.spring.models.webservice.Quote;
import com.example.spring.models.webservice.Word;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RestController;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(WebServiceController.class)
public class WebServiceTest {

    // Wiring in the MockMvc object
    @Autowired
    private org.springframework.test.web.servlet.MockMvc mockMvc;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    // Sanity Check
    @Test
    public void contextLoads() {
        assertNotNull(mockMvc);
    }

    @Test
    public void testQuoteOfTheDay() throws Exception {
        // Arrange
        Quote expectedQuote = new Quote(1, "You miss 100% of the tacos you dont eat.", "Adam Chappell");
        String outputJson = mapper.writeValueAsString(expectedQuote);

        // Act
        mockMvc.perform(get("/quote"))
                .andExpect(status().isOk())                     // ASSERT (status code is 201)
                .andExpect(content().json(outputJson));         // ASSERT that what we're expecting is what we got back.

    }
    @Test
    public void testWordOfTheDay() throws Exception {
        // Arrange
        Word expectedWord = new Word(1, "Marine", "A person the ability to fail at finding a word he knows.");
        String outputJson = mapper.writeValueAsString(expectedWord);

        // Act
        mockMvc.perform(get("/word"))
                .andExpect(status().isOk())                     // ASSERT (status code is 201)
                .andExpect(content().json(outputJson));         // ASSERT that what we're expecting is what we got back.
    }
}