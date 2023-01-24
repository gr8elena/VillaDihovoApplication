package com.example.villadihovo.model.offers;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="rooms")
public class Rooms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int room_id;

    @Column(nullable = false)
    private String room_type;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private boolean availability;

    @ManyToOne
    @JoinColumn(name = "villa_id", nullable = false)
    private Villa villa_id;
}
