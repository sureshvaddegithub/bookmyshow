package com.BookMyShow.TicketBooking.RequestDtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
public class ShowRequestDto {

    private LocalDate showDate;
    private LocalTime showTime;

    private String movieName;
    private int theaterId;
    private double multiplier;
}
