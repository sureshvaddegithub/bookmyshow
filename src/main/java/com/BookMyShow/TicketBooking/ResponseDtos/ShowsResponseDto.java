package com.BookMyShow.TicketBooking.ResponseDtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShowsResponseDto {

    private LocalTime time;
    private LocalDate date;
    private String movieName;
    private String theaterName;
    private String city;
    private String address;
}
