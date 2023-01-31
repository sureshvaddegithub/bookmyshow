package com.BookMyShow.TicketBooking.Services;

import com.BookMyShow.TicketBooking.Models.*;
import com.BookMyShow.TicketBooking.Repositories.ShowRepository;
import com.BookMyShow.TicketBooking.Repositories.ShowSeatRepository;
import com.BookMyShow.TicketBooking.Repositories.UserRepository;
import com.BookMyShow.TicketBooking.RequestDtos.BookTicketRequestDto;
import com.BookMyShow.TicketBooking.Repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    ShowRepository showRepository;

    @Autowired
    UserRepository userRepository;
    @Autowired
     ShowSeatRepository showSeatRepository;

    @Autowired
    TicketRepository ticketRepository;
    public String bookTicket(BookTicketRequestDto bookTicketRequestDto) throws Exception{

        List<String> requestedSeats = bookTicketRequestDto.getRequestedSeats();

        ShowEntity showEntity = showRepository.findById(bookTicketRequestDto.getShowId()).get();

        UserEntity userEntity = userRepository.findById(bookTicketRequestDto.getUserId()).get();

        List<ShowSeatEntity> bookedSeats = new ArrayList<>();

        for(ShowSeatEntity showSeat : showEntity.getListOfShowSeats()){

            if(!showSeat.isBooked() && requestedSeats.contains(showSeat.getSeatNo())){
                bookedSeats.add(showSeat);
            }
        }

        if(requestedSeats.size()!=bookedSeats.size()){
            throw new Exception("booked seats are not available");
        }

        TicketEntity ticketEntity = new TicketEntity();
        double amount = 0;
        double multiplier = showEntity.getMultiplier();
        String allocatedSeats = "";



        for(ShowSeatEntity showSeatEntity:bookedSeats){

            showSeatEntity.setBooked(true);
            showSeatEntity.setBookedAt(new Date());
            showSeatEntity.setShowEntity(showEntity);
            showSeatEntity.setTicketEntity(ticketEntity);

            amount = amount+multiplier*100;
            String seatNo = showSeatEntity.getSeatNo();
            allocatedSeats+=seatNo+",";
        }

        ticketEntity.setBooked_at(new Date());
        ticketEntity.setAmount((int) amount);
        ticketEntity.setShowEntity(showEntity);
        ticketEntity.setUserEntity(userEntity);
        ticketEntity.setAlloted_seats(allocatedSeats);
        ticketEntity.setListOfShowSeats(bookedSeats);

        userEntity.getListOfTickets().add(ticketEntity);
        userRepository.save(userEntity);
        return "booked sucessfully";
    }


    public String cancelTicket(int ticketId){

        //getting ticketentity using ticketId
        TicketEntity ticketEntity = ticketRepository.findById(ticketId).get();

        //getting list of showseatsentities
        List<ShowSeatEntity> listOfShowSeats = ticketEntity.getListOfShowSeats();

        for(ShowSeatEntity showseat:listOfShowSeats){


            //set ticketentity and booking date is null,
            //set booked is false,
            //remove the showSeatEntity from ticketEntity listofshowSeats

            showseat.setTicketEntity(null);
            showseat.setBookedAt(null);
            showseat.setBooked(false);
            showSeatRepository.save(showseat);

        }

        // set listofshowseats is null and update it to ticketEntity and save ticketEntity

        listOfShowSeats = null;
        ticketEntity.setListOfShowSeats(listOfShowSeats);
        ticketRepository.save(ticketEntity);

        //delete the ticket details in user
        UserEntity userEntity = ticketEntity.getUserEntity();
        List<TicketEntity> listOfTickets = userEntity.getListOfTickets();
        listOfTickets.remove(ticketEntity);
        userEntity.setListOfTickets(listOfTickets);

        //delete the ticket from database
        ticketRepository.deleteById(ticketId);
        userRepository.save(userEntity);
        return "cancelled successfully";

    }
}
