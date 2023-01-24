package com.example.villadihovo.model.offers;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="events")
public class Events {

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
