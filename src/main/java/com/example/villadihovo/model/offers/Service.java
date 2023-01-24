package com.example.villadihovo.model.offers;

import com.example.villadihovo.model.users.UserTable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="service")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int service_id;

    @Column(nullable = false)
    private String service_type;

    @Column(nullable = false)
    private float price;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserTable user_id;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Rooms room_id;
}
