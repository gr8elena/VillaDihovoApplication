package com.example.villadihovo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class reservation {

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
    private villa villa_id;

    @ManyToOne
    @JoinColumn(name = "payment_id", nullable = false)
    private payment payment_id;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private rooms room_id;
}