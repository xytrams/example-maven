package com.qvc.payment.example.feature;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.junit4.SpringRunner;

import com.qvc.payment.example.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "app.baseUrl=http://localhost:8080", webEnvironment = WebEnvironment.NONE, classes = Application.class)
@AutoConfigureWireMock(port = 0)
public class CurrentDateFeature {

	@Test
	@DisplayName("Verifying controller is invoked")
	public void checkLoadContext() {
		String expected = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE);
		stubFor(get(urlEqualTo("/resource"))
				.willReturn(aResponse()
							.withHeader("Content-Type", "application/json;charset=UTF-8")
							.withBody(expected)));

	}
}
