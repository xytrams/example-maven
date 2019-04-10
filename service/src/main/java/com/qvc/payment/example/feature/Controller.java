package com.qvc.payment.example.feature;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/currentDate", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Slf4j
public class Controller {

  @GetMapping
  public ResponseEntity<String> currentDate() {
    log.info("Requesting current date");
    return ResponseEntity.ok(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE));
  }
}
