package com.example.villadihovo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class events {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int event_id;

    @Column(nullable = false)
    private String event_type;

    @Column(nullable = false)
    private float price;

    @Column(nullable = false)
    private int number_of_interested_guests;

}
