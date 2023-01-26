package com.example.villadihovo.model.reservations;

import com.example.villadihovo.model.offers.Activities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(ReservationForActivityId.class)
@Table(name = "reservation_for_activity")
public class ReservationForActivity {

    @Id
    @Column(name = "reservation_id")
    private Integer reservation_id;

    @Id
    @Column(name = "activity_id")
    private Integer activity_id;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reservation_id", referencedColumnName = "reservation_id", insertable = false, updatable = false)
    private Reservation reservation;

    @ManyToOne
    @JoinColumn(name = "activity_id", referencedColumnName = "activity_id", insertable = false, updatable = false)
    private Activities activity;

}
