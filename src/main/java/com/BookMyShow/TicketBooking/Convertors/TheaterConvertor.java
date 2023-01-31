package com.BookMyShow.TicketBooking.Convertors;

import com.BookMyShow.TicketBooking.Models.TheaterEntity;
import com.BookMyShow.TicketBooking.RequestDtos.TheaterRequestDto;

public class TheaterConvertor {

    public static TheaterEntity convertToTheaterEntity(TheaterRequestDto theaterRequestDto){
        TheaterEntity theaterEntity = TheaterEntity.builder()
                .name(theaterRequestDto.getName()).city(theaterRequestDto.getCity())
                .address(theaterRequestDto.getAddress()).build();
        return theaterEntity;
    }
}
