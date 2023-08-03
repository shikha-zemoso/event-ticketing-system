package com.zemoso.eventticketingsystem;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.aspectj.bridge.MessageUtil.fail;

@SpringBootTest
class EventticketingsystemApplicationTests {

	@Test
	public void testMainMethod() {
		try {
			EventticketingsystemApplication.main(new String[] {});
		} catch (Exception e) {
			fail("Does not throw any exception: " + e.getMessage());
		}
	}

}
