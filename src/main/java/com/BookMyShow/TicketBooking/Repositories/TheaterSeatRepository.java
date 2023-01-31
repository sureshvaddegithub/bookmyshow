package com.BookMyShow.TicketBooking.Repositories;

import com.BookMyShow.TicketBooking.Models.TheaterSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterSeatRepository extends JpaRepository<TheaterSeatEntity,Integer> {
}
