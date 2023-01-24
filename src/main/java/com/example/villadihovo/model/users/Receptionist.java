package com.example.villadihovo.model.users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
@Table(name="receptionist")
public class Receptionist extends UserTable
{
    @Column(nullable = false)
    private int shift;

    @Column(nullable = false)
    private float salary;
}

