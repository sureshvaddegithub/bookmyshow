package com.BookMyShow.TicketBooking;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class TicketBookingApplication {

	public static void main(String[] args) {

		SpringApplication.run(TicketBookingApplication.class, args);
	}

}
