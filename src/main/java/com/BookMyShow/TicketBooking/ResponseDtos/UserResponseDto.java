package com.BookMyShow.TicketBooking.ResponseDtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor

public class UserResponseDto {
    private int id;
    private String name;
    private String mobileNo;
}
