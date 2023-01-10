package com.example.villadihovo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class log_in{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int login_id;

    @Column(nullable = false)
    private String vreme_na_najava;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private user_table user_id;
}