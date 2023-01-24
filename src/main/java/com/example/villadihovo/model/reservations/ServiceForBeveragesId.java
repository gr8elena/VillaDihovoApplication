package com.example.villadihovo.model.reservations;

import lombok.Data;

import java.io.Serializable;

@Data
public class ServiceForBeveragesId implements Serializable {
    private int service_id;
    private int beverage_id;
}
