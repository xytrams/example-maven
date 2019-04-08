package com.qvc.payment.example.feature;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ControllerTest extends BaseControllerTest {

	@Override
	protected Object getController() {
		return new Controller();
	}

	@BeforeEach
	void beforeEachTest(TestInfo testInfo) {
		log.info(String.format("About to execute [%s]", testInfo.getDisplayName()));
	}

	@AfterEach
	void afterEachTest(TestInfo testInfo) {
		log.info(String.format("Finished executing [%s]", testInfo.getDisplayName()));
	}
	
	@Test
	@DisplayName("Return current date and HTTP 200")
	public void request_findAll_accepted() throws Exception {
		String expected = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE);
		RequestBuilder builder = MockMvcRequestBuilders.get("/currentDate");
		mvc.perform(builder).andExpect(status().isOk())
							.andExpect(content().string(expected))
							.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}
	
}
