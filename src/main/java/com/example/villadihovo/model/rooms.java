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
public class rooms {

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
    private villa villa_id;
}
