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
public class villa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int villa_id;

    @Column(nullable = false)
    private String villa_location;

    @Column(nullable = false)
    private String name;

    private String villa_view_type;
}
