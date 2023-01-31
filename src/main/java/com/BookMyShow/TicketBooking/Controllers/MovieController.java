package com.BookMyShow.TicketBooking.Controllers;

import com.BookMyShow.TicketBooking.RequestDtos.MovieRequestDto;
import com.BookMyShow.TicketBooking.ResponseDtos.MovieResponseDto;
import com.BookMyShow.TicketBooking.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movie")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("add-movie")
    public ResponseEntity<String> addMovie(@RequestBody()MovieRequestDto movieRequestDto){
        String result = movieService.addMovieToDb(movieRequestDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("get-movie")
    public ResponseEntity<MovieResponseDto> getMovie(@RequestParam String name){
        MovieResponseDto movieResponseDto = movieService.getMovieFromDb(name);
        return new ResponseEntity<>(movieResponseDto,HttpStatus.CREATED);
    }

    @GetMapping("get-list-of-movies")
    public ResponseEntity<List<MovieResponseDto>> getAllMovies(){
        List<MovieResponseDto> movieResponseDtos = movieService.getAllMovies();
        return new ResponseEntity<>(movieResponseDtos,HttpStatus.CREATED);
    }
}
