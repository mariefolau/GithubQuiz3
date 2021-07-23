package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class GreetingControllerTest {
	
	@Autowired
	private MockMvc mvc;

	@Test
	 void test() throws Exception {
	  mvc.perform(MockMvcRequestBuilders.get("/greeting").accept(MediaType.APPLICATION_JSON))
	    .andExpect(status().isOk()).andExpect(content().json("{\"id\": 1, \"content\": \"Hello, World!\"}"));
	  mvc.perform(MockMvcRequestBuilders.get("/greeting").accept(MediaType.APPLICATION_JSON))
	    .andExpect(status().isOk()).andExpect(content().json("{\"id\": 2, \"content\": \"Hello, World!\"}"));
	 }
	 @Test
	 void testWithParameter() throws Exception {
	  mvc.perform(MockMvcRequestBuilders.get("/greeting").param("name", "Testerson").accept(MediaType.APPLICATION_JSON))
	    .andExpect(status().isOk()).andExpect(content().json("{\"content\": \"Hello, Testerson!\"}"));
	 }


}
