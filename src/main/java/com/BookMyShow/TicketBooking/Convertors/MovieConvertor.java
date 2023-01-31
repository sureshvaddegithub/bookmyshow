package com.BookMyShow.TicketBooking.Convertors;

import com.BookMyShow.TicketBooking.Models.MovieEntity;
import com.BookMyShow.TicketBooking.RequestDtos.MovieRequestDto;

public class MovieConvertor {

    public static MovieEntity convertToMovieEntity(MovieRequestDto movieRequestDto){
        MovieEntity movieEntity = MovieEntity.builder().movieName(movieRequestDto.getName())
                .duration(movieRequestDto.getDuration()).releaseDate(movieRequestDto.getReleaseDate()).build();
        return movieEntity;
    }
}
