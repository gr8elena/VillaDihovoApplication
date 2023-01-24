package com.example.villadihovo.model.offers;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="villa")
public class Villa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int villa_id;

    @Column(nullable = false)
    private String villa_location;

    @Column(nullable = false)
    private String name;

    private String villa_view_type;
}
