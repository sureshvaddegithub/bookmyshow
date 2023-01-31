package com.BookMyShow.TicketBooking.Models;

import com.BookMyShow.TicketBooking.Enums.SeatType;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name ="show_seats")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShowSeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String seatNo;
    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private boolean booked;
    private Date bookedAt;

    @ManyToOne
    @JoinColumn
    private ShowEntity showEntity;
    @ManyToOne
    @JoinColumn
    private TicketEntity ticketEntity;


}
