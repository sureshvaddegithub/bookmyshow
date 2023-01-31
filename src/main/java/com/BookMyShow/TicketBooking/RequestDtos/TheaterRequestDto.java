package com.BookMyShow.TicketBooking.RequestDtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TheaterRequestDto {
    private String name;
    private String city;
    private String address;
}
