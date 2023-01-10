package com.example.villadihovo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class activities{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int activity_id;

    @Column(nullable = false)
    private String activity_type;

    @Column(nullable = false)
    private float price;

    @Column(nullable = false)
    private int number_of_interested_guests;

    @Column(nullable = false)
    private String activity_location;
}