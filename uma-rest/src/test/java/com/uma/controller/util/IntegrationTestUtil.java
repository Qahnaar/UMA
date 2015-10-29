package com.uma.controller.util;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import com.fasterxml.jackson.core.JsonProcessingException;

public class IntegrationTestUtil {

	private MockMvc mockMvc;

	private MappingJackson2HttpMessageConverter jacksonMessageConverter;

	public IntegrationTestUtil(RequestMappingHandlerAdapter adapter, WebApplicationContext appContext) {
		mockMvc = MockMvcBuilders.webAppContextSetup(appContext).build();

		jacksonMessageConverter = (MappingJackson2HttpMessageConverter) adapter.getMessageConverters().stream()
				.filter(converter -> converter.getSupportedMediaTypes().stream()
						.anyMatch(type -> MediaType.APPLICATION_JSON.getType().equals(type.getType())
								&& MediaType.APPLICATION_JSON.getSubtype().equals(type.getSubtype())))
				.findFirst().get();
	}

	public String getObjectAsString(Object object) throws JsonProcessingException {
		return jacksonMessageConverter.getObjectMapper().writeValueAsString(object);
	}

	public MockMvc getMockMvc() {
		return mockMvc;
	}
}
