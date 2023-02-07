package com.example.villadihovo.model.statistics;

import com.example.villadihovo.model.reservations.GuestMakeReservationId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "activity_statistics")
public class StatisticsForActivity {

    @Id
    @Column(name = "years")
    private BigDecimal years;

    @Column(name = "num_activities")
    private Integer num_activities;

    @Column(name = "total_guests")
    private Integer total_guests;

    @Column(name = "avg_price")
    private float avg_price;

    @Column(name = "sales")
    private float sales;
}
