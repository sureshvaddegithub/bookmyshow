package com.BookMyShow.TicketBooking.Services;

import com.BookMyShow.TicketBooking.Convertors.MovieConvertor;
import com.BookMyShow.TicketBooking.Models.MovieEntity;
import com.BookMyShow.TicketBooking.Repositories.MovieRepository;
import com.BookMyShow.TicketBooking.RequestDtos.MovieRequestDto;
import com.BookMyShow.TicketBooking.ResponseDtos.MovieResponseDto;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public String addMovieToDb(MovieRequestDto movieRequestDto){
        MovieEntity movieEntity = MovieConvertor.convertToMovieEntity(movieRequestDto);
        movieRepository.save(movieEntity);
        return "movie add successfully";
    }

    public MovieResponseDto getMovieFromDb(String name){
        MovieEntity movieEntity = movieRepository.findByMovieName(name);
        MovieResponseDto movieResponseDto = MovieResponseDto.builder().id(movieEntity.getId())
                .name(movieEntity.getMovieName()).duration(movieEntity.getDuration())
                .releaseDate(movieEntity.getReleaseDate()).build();
        return movieResponseDto;
    }
}
