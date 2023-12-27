package com.ecommerce.Ecommerce;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EcommerceApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	void addTwoNumbers() {
		//given
		//when invoke method
		//then expected answer is 
		int num = 10;
		int expected = 100;
		int result = num * num ;
		assertThat(result).isEqualTo(expected);
	}

}
