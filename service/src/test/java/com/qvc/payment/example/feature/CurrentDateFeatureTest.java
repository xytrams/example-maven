package com.qvc.payment.example.feature;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
    webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 0)
@Tag("integration")
public class CurrentDateFeatureTest {

  @Test
  @DisplayName("Verifying controller is invoked")
  public void checkLoadContext() {
    String expected = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE);
    stubFor(
        get(urlEqualTo("/currentDate"))
            .willReturn(
                aResponse()
                    .withHeader("Content-Type", "application/json;charset=UTF-8")
                    .withBody(expected)));
  }
}
