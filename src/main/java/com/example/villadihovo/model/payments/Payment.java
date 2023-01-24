package com.example.villadihovo.model.payments;

import com.example.villadihovo.model.users.UserTable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="payment")
public class Payment {

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
    private UserTable user_id;
}
