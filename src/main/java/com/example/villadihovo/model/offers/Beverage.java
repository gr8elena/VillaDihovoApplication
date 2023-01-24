package com.example.villadihovo.model.offers;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="beverage")
public class Beverage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int beverage_id;

    @Column(nullable = false)
    private String beverage_type;

    @Column(nullable = false)
    private float price;
}
