package com.BookMyShow.TicketBooking.Repositories;

import com.BookMyShow.TicketBooking.Models.ShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<ShowEntity,Integer> {

}
