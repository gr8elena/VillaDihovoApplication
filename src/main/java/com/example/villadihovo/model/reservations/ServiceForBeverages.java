package com.example.villadihovo.model.reservations;

import com.example.villadihovo.model.offers.Beverage;
import com.example.villadihovo.model.offers.Service;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(ServiceForBeveragesId.class)
@Table(name="service_for_beverages")
public class ServiceForBeverages {

    @Id
    @Column(name = "service_id")
    private Integer service_id;

    @Id
    @Column(name = "beverage_id")
    private Integer beverage_id;

    @Column(name = "quantity")
    @Min(value = 0, message = "Quantity must be greater than or equal to 0")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "service_id", insertable = false, updatable = false)
    private Service service;

    @ManyToOne
    @JoinColumn(name = "beverage_id", referencedColumnName = "beverage_id", insertable = false, updatable = false)
    private Beverage beverage;
}
