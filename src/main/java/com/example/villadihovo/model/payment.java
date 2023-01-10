package com.example.villadihovo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int payment_id;

    @Column(nullable = false)
    private float total_payment;

    @Column(nullable = false)
    private LocalDate pay_date;

    @Column(nullable = false)
    private String rec_id;

    @Column(nullable = false)
    private String customer_id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private user_table user_id;
}
