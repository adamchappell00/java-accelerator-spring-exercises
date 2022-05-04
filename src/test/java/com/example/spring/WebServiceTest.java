package com.example.spring;


import com.example.spring.controllers.RecordStoreController;
import com.example.spring.controllers.WebServiceController;
import com.example.spring.models.Record;
import com.example.spring.models.webservice.Answer;
import com.example.spring.models.webservice.Quote;
import com.example.spring.models.webservice.Word;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RestController;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
        // Act
        mockMvc.perform(get("/quote"))
                .andDo(print())
                .andExpect(status().isOk())                                 // ASSERT (status code is 201)
                .andExpect(jsonPath("$.body").isNotEmpty())         // ASSERT there is a non-empty body field
                .andExpect(jsonPath("$.author").isNotEmpty())       // ASSERT there is a non-empty author field
                .andExpect(jsonPath("$.id").isNotEmpty());          // ASSERT there is a non-empty id field

    }
    @Test
    public void testWordOfTheDay() throws Exception {
        // Act
        mockMvc.perform(get("/word"))
                .andDo(print())
                .andExpect(status().isOk())                            // ASSERT (status code is 201)
                .andExpect(jsonPath("$.word").isNotEmpty())             // ASSERT there is a non-empty word field
                .andExpect(jsonPath("$.definition").isNotEmpty())       // ASSERT there is a non-empty definition field
                .andExpect(jsonPath("$.id").isNotEmpty());              // ASSERT there is a non-empty id field

    }

    @Test
    public void testMagic8Ball() throws Exception {
        // Arrange
        Answer inputAnswer = new Answer("Should I do the thing?");
        String inputJson = mapper.writeValueAsString(inputAnswer);

        // Act
        mockMvc.perform(post("/magic")
                        .content(inputJson)                           // Set the request body.
                        .contentType(MediaType.APPLICATION_JSON) )
                .andDo(print())
                .andExpect(status().isOk())                            // ASSERT (status code is 201)
                .andExpect(jsonPath("$.answer").isNotEmpty())       // ASSERT there is a non-empty answer field
                .andExpect(jsonPath("$.question").isNotEmpty())     // ASSERT there is a non-empty question field
                .andExpect(jsonPath("$.id").isNotEmpty());          // ASSERT there is a non-empty id field

    }
}