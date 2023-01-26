package com.example.villadihovo.model.reservations;

import com.example.villadihovo.model.payments.Payment;
import com.example.villadihovo.model.offers.Rooms;
import com.example.villadihovo.model.offers.Villa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservation_id;

    @Column(nullable = false)
    private LocalDate start_date;

    @Column(nullable = false)
    private LocalDate end_date;

    @Column(nullable = false)
    private int number_guests;

    @Column(nullable = false)
    private int adults;

    @Column(nullable = true)
    private int children;

    @ManyToOne
    @JoinColumn(name = "villa_id", nullable = false)
    private Villa villa_id;

    @ManyToOne
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment payment_id;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Rooms room_id;
}