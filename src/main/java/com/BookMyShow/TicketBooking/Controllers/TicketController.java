package com.BookMyShow.TicketBooking.Controllers;

import com.BookMyShow.TicketBooking.RequestDtos.BookTicketRequestDto;
import com.BookMyShow.TicketBooking.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tickets")
public class TicketController {

    @Autowired
    TicketService ticketService;
    @PostMapping("book-ticket")
    public String bookTicket(@RequestBody()BookTicketRequestDto bookTicketRequestDto){
        try{
            return ticketService.bookTicket(bookTicketRequestDto);
        }
        catch (Exception e){
            return e.getMessage();
        }

    }

    @PostMapping("cancel-ticket")
    public String cancelTicket(@RequestParam() int ticketId){
    return ticketService.cancelTicket(ticketId);
    }
}
