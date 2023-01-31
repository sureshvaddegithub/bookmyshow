package com.BookMyShow.TicketBooking.Services;

import com.BookMyShow.TicketBooking.Models.*;
import com.BookMyShow.TicketBooking.Repositories.MovieRepository;
import com.BookMyShow.TicketBooking.Repositories.ShowRepository;
import com.BookMyShow.TicketBooking.Repositories.ShowSeatRepository;
import com.BookMyShow.TicketBooking.Repositories.TheaterRepository;
import com.BookMyShow.TicketBooking.RequestDtos.GetAllShowsRequestDto;
import com.BookMyShow.TicketBooking.RequestDtos.ShowRequestDto;
import com.BookMyShow.TicketBooking.ResponseDtos.ShowsResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    MovieRepository movieRepository;


    @Autowired
    ShowRepository showRepository;

    @Autowired
    ShowSeatRepository showSeatRepository;

    public String addShow(ShowRequestDto showRequestDto){

        //creating showEntity
        ShowEntity showEntity = ShowEntity.builder().showDate(showRequestDto.getShowDate())
                .showTime(showRequestDto.getShowTime()).multiplier(showRequestDto.getMultiplier()).build();


        //getting theaterEntity from theaterId
        TheaterEntity theaterEntity = theaterRepository.findById(showRequestDto.getTheaterId()).get();

        //getting movieEntity using moviename
        MovieEntity movieEntity = movieRepository.findByMovieName(showRequestDto.getMovieName());


        //adding movie and theater to show
        showEntity.setMovieEntity(movieEntity);
        showEntity.setTheaterEntity(theaterEntity);
//        movieEntity.getListOfShows().add(showEntity);
//        theaterEntity.getListOfShow().add(showEntity);

        List<ShowSeatEntity> showSeatEntities = creationOfShowSeatEntity(theaterEntity.getListOfTheaterSeats());

        showEntity.setListOfShowSeats(showSeatEntities);
        for(ShowSeatEntity showSeatEntity:showSeatEntities){
            showSeatEntity.setShowEntity(showEntity);
        }


//        movieRepository.save(movieEntity);
//        theaterRepository.save(theaterEntity);
        showRepository.save(showEntity);
        return "add successfully";
    }

    public List<ShowSeatEntity> creationOfShowSeatEntity(List<TheaterSeatEntity> theaterSeatEntities){
        List<ShowSeatEntity> showSeatEntities = new ArrayList<>();
        for(TheaterSeatEntity theaterSeatEntity:theaterSeatEntities){
            ShowSeatEntity showSeatEntity = ShowSeatEntity.builder().seatNo(theaterSeatEntity.getSeatNo())
                    .seatType(theaterSeatEntity.getSeatType()).build();
            showSeatEntities.add(showSeatEntity);
        }
        return showSeatEntities;
    }


    public List<ShowsResponseDto> getAllShows( LocalDate fromDate ,LocalDate toDate,LocalTime  fromTime,LocalTime toTime){

        List<ShowEntity> showEntities = showRepository.findAll();

        List<ShowsResponseDto> ansList = new ArrayList<>();

        for(ShowEntity showEntity:showEntities){

            LocalDate date = showEntity.getShowDate();
            LocalTime time = showEntity.getShowTime();

            if(date.compareTo(fromDate)>=0 && date.compareTo(toDate)<=0 && time.compareTo(fromTime)>=0 && time.compareTo(toTime)<=0){

                ShowsResponseDto showsResponseDto = ShowsResponseDto.builder().time(showEntity.getShowTime())
                        .date(showEntity.getShowDate()).city(showEntity.getTheaterEntity().getCity())
                        .theaterName(showEntity.getTheaterEntity().getName())
                        .address(showEntity.getTheaterEntity().getAddress()).movieName(showEntity.getMovieEntity().getMovieName()).build();
                ansList.add(showsResponseDto);
            }

        }
        return ansList;
    }
}
