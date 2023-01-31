package com.BookMyShow.TicketBooking.Repositories;

import com.BookMyShow.TicketBooking.Models.TheaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<TheaterEntity,Integer> {
}
