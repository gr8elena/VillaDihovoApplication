package com.example.villadihovo.model.reservations;

import com.example.villadihovo.model.offers.Service;
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
@IdClass(ReservationForServiceId.class)
@Table(name="reservation_for_service")
public class ReservationForService {
    @Id
    @Column(name = "reservation_id")
    private Integer reservation_id;

    @Id
    @Column(name = "service_id")
    private Integer service_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reservation_id", referencedColumnName = "reservation_id", insertable = false, updatable = false)
    private Reservation reservation;

    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "service_id", insertable = false, updatable = false)
    private Service service;
}
