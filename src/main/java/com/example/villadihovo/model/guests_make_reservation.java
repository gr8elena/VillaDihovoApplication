package com.example.villadihovo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(GuestMakeReservationId.class)
public class guests_make_reservation {

    @Id
    @Column(name = "user_id")
    private Integer user_id;

    @Id
    @Column(name = "reservation_id")
    private Integer reservation_id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private user_table user;

    @ManyToOne
    @JoinColumn(name = "reservation_id", referencedColumnName = "reservation_id", insertable = false, updatable = false)
    private reservation reservation;

}
