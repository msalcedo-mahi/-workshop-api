package com.workshop;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FirstControllerTest {
	protected MockMvc mockMvc;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Autowired
	protected WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testWithoutAnyHeader() throws Exception {
		try{
			mockMvc.perform(get("/api/first"))
					.andExpect(status().isBadRequest());

		}catch (Exception e){
			assertEquals("The header Content-Type does not exist!", e.getCause().getMessage());
		}
	}

	@Test
	public void testWithContentTypeNoJson() throws Exception {
		try{
			mockMvc.perform(get("/api/first").contentType(MediaType.APPLICATION_ATOM_XML))
					.andExpect(status().isBadRequest());

		}catch (Exception e){
			assertEquals("The content-type is not application/json", e.getCause().getMessage());
		}
	}


	@Test
	public void testWithoutAuthAndWithContentTypeHeaders() throws Exception {
		try{
			mockMvc.perform(get("/api/first").contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isBadRequest());

		}catch (Exception e){
			assertEquals("The header Authorization does not exist!", e.getCause().getMessage());
		}
	}

	@Test
	public void testWithBadAuthHeader() throws Exception {
		try{
			HttpHeaders authHeader = new HttpHeaders();
			authHeader.set("Authorization", "Anything ==token==");
			mockMvc.perform(get("/api/first").contentType(MediaType.APPLICATION_JSON).headers(authHeader))
					.andExpect(status().isBadRequest());

		}catch (Exception e){
			assertEquals("Authorization does not contain Basic or Bearer token", e.getCause().getMessage());
		}
	}

	@Test
	public void testWithAuthAndContentTypeHeaders() throws Exception {
		HttpHeaders authHeader = new HttpHeaders();
		authHeader.set("Authorization", "Basic ==token==");
		mockMvc.perform(get("/api/first").contentType(MediaType.APPLICATION_JSON).headers(authHeader))
				.andExpect(status().isOk());
	}



}
