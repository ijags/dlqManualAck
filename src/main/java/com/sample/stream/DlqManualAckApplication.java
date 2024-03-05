package com.sample.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DlqManualAckApplication {

	public static void main(String[] args) {
		SpringApplication.run(DlqManualAckApplication.class, args);
	}

}
