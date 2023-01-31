package com.BookMyShow.TicketBooking.RequestDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookTicketRequestDto {
    private List<String> requestedSeats;
    private int userId;
    private int showId;
}
