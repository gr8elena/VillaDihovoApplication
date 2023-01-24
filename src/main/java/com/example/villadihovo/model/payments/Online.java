package com.example.villadihovo.model.payments;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@PrimaryKeyJoinColumn(name = "payment_id")
@Table(name="online")
public class Online extends Payment {

    @Column(nullable = false, unique = true)
    private String card_number;

}
