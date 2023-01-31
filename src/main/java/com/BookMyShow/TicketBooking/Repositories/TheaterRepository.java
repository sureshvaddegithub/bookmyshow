package com.BookMyShow.TicketBooking.Repositories;

import com.BookMyShow.TicketBooking.Models.TheaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TheaterRepository extends JpaRepository<TheaterEntity,Integer> {
    List<TheaterEntity> findByCity(String cityname);
}
