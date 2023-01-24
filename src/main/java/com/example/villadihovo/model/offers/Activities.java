package com.example.villadihovo.model.offers;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="activities")
public class Activities {

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