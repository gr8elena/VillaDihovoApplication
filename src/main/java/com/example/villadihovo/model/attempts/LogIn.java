package com.example.villadihovo.model.attempts;

import com.example.villadihovo.model.users.UserTable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="log_in")
public class LogIn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int login_id;

    @Column(nullable = false)
    private String vreme_na_najava;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserTable user_id;
}