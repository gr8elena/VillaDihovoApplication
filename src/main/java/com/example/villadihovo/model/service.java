package com.example.villadihovo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int service_id;

    @Column(nullable = false)
    private String service_type;

    @Column(nullable = false)
    private float price;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private user_table user_id;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private rooms room_id;
}
