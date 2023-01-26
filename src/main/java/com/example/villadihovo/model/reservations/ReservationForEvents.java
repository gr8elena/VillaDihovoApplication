package com.example.villadihovo.model.reservations;

import com.example.villadihovo.model.offers.Events;
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
@IdClass(ReservationForEventsId.class)
@Table(name = "reservation_for_events")
public class ReservationForEvents {
    @Id
    @Column(name = "reservation_id")
    private Integer reservation_id;

    @Id
    @Column(name = "event_id")
    private Integer event_id;

    @ManyToOne
    @JoinColumn(name = "reservation_id", referencedColumnName = "reservation_id", insertable = false, updatable = false)
    private Reservation reservation;

    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "event_id", insertable = false, updatable = false)
    private Events event;
}
