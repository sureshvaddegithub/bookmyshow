package com.BookMyShow.TicketBooking.Models;


import javax.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tickets_table")
@Data
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String alloted_seats;
    private int amount;
    private Date booked_at;

    @ManyToOne
    @JoinColumn
    private ShowEntity showEntity;

    @OneToMany(mappedBy = "ticketEntity",cascade = CascadeType.ALL)
    private List<ShowSeatEntity> listOfShowSeats;

    @ManyToOne
    @JoinColumn
    private UserEntity userEntity;

}
