package com.BookMyShow.TicketBooking.Repositories;

import com.BookMyShow.TicketBooking.Models.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketEntity,Integer> {
}
