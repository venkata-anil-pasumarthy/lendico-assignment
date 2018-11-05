package com.lendico.assignment;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * The Class AssignmentApplicationTests.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AssignmentApplicationTests {

	/** The main app. */
	@Mock
	AssignmentApplication mainApp;
	
	/** Set up mock */
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void contextLoads() {
		mainApp.main(new String[] {});
	}
}
