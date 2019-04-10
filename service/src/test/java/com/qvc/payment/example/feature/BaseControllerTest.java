package com.qvc.payment.example.feature;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(SpringExtension.class)
@Tag("unit")
public abstract class BaseControllerTest {

  protected MockMvc mvc;

  @BeforeEach
  public void setUp() throws Exception {
    mvc =
        MockMvcBuilders.standaloneSetup(getController())
            .setControllerAdvice(new ErrorHandler())
            .build();
  }

  protected abstract Object getController();
}
