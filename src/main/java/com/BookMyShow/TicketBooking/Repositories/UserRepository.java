package com.BookMyShow.TicketBooking.Repositories;

import com.BookMyShow.TicketBooking.Models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {

     UserEntity findByName(String name);
}
