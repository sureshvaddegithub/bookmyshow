package com.BookMyShow.TicketBooking.Controllers;

import com.BookMyShow.TicketBooking.Models.ShowEntity;
import com.BookMyShow.TicketBooking.RequestDtos.GetAllShowsRequestDto;
import com.BookMyShow.TicketBooking.RequestDtos.ShowRequestDto;
import com.BookMyShow.TicketBooking.ResponseDtos.ShowsResponseDto;
import com.BookMyShow.TicketBooking.Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@RestController
@RequestMapping("show")
public class ShowController {

    @Autowired
    ShowService showService;
    @PostMapping("add-show")
    public ResponseEntity<String> addShow(@RequestBody()ShowRequestDto showRequestDto){
        String result = showService.addShow(showRequestDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("get-all-shows")
    public List<ShowsResponseDto> getAllShows(@RequestParam LocalDate fromDate, @RequestParam LocalDate toDate, @RequestParam LocalTime fromTime,@RequestParam LocalTime toTime){
        return showService.getAllShows(fromDate,toDate,fromTime,toTime);
    }
}
