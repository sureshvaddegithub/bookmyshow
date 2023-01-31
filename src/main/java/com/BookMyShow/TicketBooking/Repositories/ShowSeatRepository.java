package com.BookMyShow.TicketBooking.Repositories;

import com.BookMyShow.TicketBooking.Models.ShowSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowSeatRepository extends JpaRepository<ShowSeatEntity,Integer> {
}
