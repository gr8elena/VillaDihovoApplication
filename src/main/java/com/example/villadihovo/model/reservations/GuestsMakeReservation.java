package com.example.villadihovo.model.reservations;

import com.example.villadihovo.model.users.UserTable;
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
@IdClass(GuestMakeReservationId.class)
@Table(name = "guests_make_reservation")
public class GuestsMakeReservation {

    @Id
    @Column(name = "user_id")
    private Integer user_id;

    @Id
    @Column(name = "reservation_id")
    private Integer reservation_id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private UserTable user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reservation_id", referencedColumnName = "reservation_id", insertable = false, updatable = false)
    private Reservation reservation;

}
