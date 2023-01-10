package com.example.villadihovo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@PrimaryKeyJoinColumn(name = "payment_id")
public class on_site extends payment{

    @Column(nullable = false)
    private String currency;

    @Column(nullable = false)
    private String payment_type;

    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne
    private user_table user_id;
}