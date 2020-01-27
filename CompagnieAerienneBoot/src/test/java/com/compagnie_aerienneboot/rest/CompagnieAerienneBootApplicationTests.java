package com.compagnie_aerienneboot.rest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CompagnieAerienneBootApplicationTests {

	@Test
	void contextLoads() {
		Long l =5L;
		char c=(char)l.longValue();
		System.out.println(c);
	}

}
