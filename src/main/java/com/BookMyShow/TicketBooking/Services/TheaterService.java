package com.BookMyShow.TicketBooking.Services;

import com.BookMyShow.TicketBooking.Convertors.TheaterConvertor;
import com.BookMyShow.TicketBooking.Enums.SeatType;
import com.BookMyShow.TicketBooking.Models.TheaterEntity;
import com.BookMyShow.TicketBooking.Models.TheaterSeatEntity;
import com.BookMyShow.TicketBooking.Repositories.TheaterRepository;
import com.BookMyShow.TicketBooking.Repositories.TheaterSeatRepository;
import com.BookMyShow.TicketBooking.RequestDtos.TheaterRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {

    @Autowired
    TheaterRepository theaterRepository;
    @Autowired
    TheaterSeatRepository theaterSeatRepository;

    public String addTheater(TheaterRequestDto theaterRequestDto){
        TheaterEntity theaterEntity = TheaterConvertor.convertToTheaterEntity(theaterRequestDto);
        List<TheaterSeatEntity> listOfTheaterSeats = creationOfTheaterSeats();
        for(TheaterSeatEntity t :listOfTheaterSeats){
            t.setTheaterEntity(theaterEntity);
        }
        theaterEntity.setListOfTheaterSeats(listOfTheaterSeats);
        theaterRepository.save(theaterEntity);
        return "added successfully";
    }
    public List<TheaterSeatEntity> creationOfTheaterSeats(){
        List<TheaterSeatEntity> listOfTheaterSeats = new ArrayList<>();
        TheaterSeatEntity seat1 = new TheaterSeatEntity("1A", SeatType.GOLD,100);
        TheaterSeatEntity seat2 = new TheaterSeatEntity("1B", SeatType.GOLD,100);
        TheaterSeatEntity seat3 = new TheaterSeatEntity("1C", SeatType.GOLD,100);
        TheaterSeatEntity seat4 = new TheaterSeatEntity("1D", SeatType.GOLD,100);
        TheaterSeatEntity seat5 = new TheaterSeatEntity("1E", SeatType.GOLD,100);
        TheaterSeatEntity seat6 = new TheaterSeatEntity("1F", SeatType.GOLD,100);
        listOfTheaterSeats.add(seat1);
        listOfTheaterSeats.add(seat2);
        listOfTheaterSeats.add(seat3);
        listOfTheaterSeats.add(seat4);
        listOfTheaterSeats.add(seat5);
        listOfTheaterSeats.add(seat6);

        return listOfTheaterSeats;
    }

    public List<TheaterRequestDto> getTheaterByCityname(String cityname){

        List<TheaterEntity> theaterEntities = theaterRepository.findByCity(cityname);

        List<TheaterRequestDto> theaterRequestDtos = new ArrayList<>();
        for(TheaterEntity theaterEntity:theaterEntities){
            TheaterRequestDto theaterRequestDto =TheaterRequestDto.builder().name(theaterEntity.getName())
                    .address(theaterEntity.getAddress()).city(theaterEntity.getCity()).build();
            theaterRequestDtos.add(theaterRequestDto);
        }
        return theaterRequestDtos;
    }
}
