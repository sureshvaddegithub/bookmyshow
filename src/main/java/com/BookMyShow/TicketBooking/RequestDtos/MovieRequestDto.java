package com.BookMyShow.TicketBooking.RequestDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieRequestDto {

    private String name;
    private int duration;
    private Date releaseDate;
}
