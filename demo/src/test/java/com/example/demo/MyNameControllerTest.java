package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RestController;


@SpringBootTest
@AutoConfigureMockMvc
@RestController
class MyNameControllerTest {	
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getMyNameReturnsOk() throws Exception {
		this.mockMvc.perform(get("/myname")).andDo(print())
		.andExpect(status().isOk());
 }
}
