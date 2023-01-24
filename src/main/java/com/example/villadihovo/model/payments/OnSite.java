package com.example.villadihovo.model.payments;

import com.example.villadihovo.model.users.UserTable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@PrimaryKeyJoinColumn(name = "payment_id")
@Table(name="on_site")
public class OnSite extends Payment {

    @Column(nullable = false)
    private String currency;

    @Column(nullable = false)
    private String payment_type;

    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne
    private UserTable user_id;
}