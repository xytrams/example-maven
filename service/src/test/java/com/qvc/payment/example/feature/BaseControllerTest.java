package com.qvc.payment.example.feature;

import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
public abstract class BaseControllerTest {

	protected MockMvc mvc;

	@BeforeEach
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(getController()).setControllerAdvice(new ErrorHandler()).build();
	}

	protected abstract Object getController();

}