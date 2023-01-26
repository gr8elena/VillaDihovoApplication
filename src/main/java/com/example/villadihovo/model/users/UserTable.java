package com.example.villadihovo.model.users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="user_table")
public class UserTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;

    @Column(nullable = false, unique = true)
    private String embg;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String full_name;

    @Column(nullable = false)
    private String phone_number;

    public UserTable(String embg, String address, String email, String password, String username, String full_name, String phone_number) {
        this.embg = embg;
        this.address = address;
        this.email = email;
        this.password = password;
        this.username = username;
        this.full_name = full_name;
        this.phone_number = phone_number;
    }
}
