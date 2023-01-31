package com.BookMyShow.TicketBooking.Repositories;

import com.BookMyShow.TicketBooking.Models.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieEntity,Integer> {

    MovieEntity findByMovieName(String name);
}
