package com.BookMyShow.TicketBooking.Controllers;

import com.BookMyShow.TicketBooking.RequestDtos.TheaterRequestDto;
import com.BookMyShow.TicketBooking.Services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("theater")
public class TheaterController {

    @Autowired
    TheaterService theaterService;

    @PostMapping("add-theater")
    public ResponseEntity<String> addTheater(@RequestBody()TheaterRequestDto theaterRequestDto){
        String result = theaterService.addTheater(theaterRequestDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("get-theater-by-city")
    public List<TheaterRequestDto> getTheaterByCityname(@RequestParam String cityname){
        return theaterService.getTheaterByCityname(cityname);
    }
}
