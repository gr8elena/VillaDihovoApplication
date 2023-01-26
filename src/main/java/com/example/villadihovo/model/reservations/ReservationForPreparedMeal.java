package com.example.villadihovo.model.reservations;

import com.example.villadihovo.model.offers.Meal;
import com.example.villadihovo.model.offers.PreparedMeal;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reservation_for_prepared_meal")
public class ReservationForPreparedMeal {

    @EmbeddedId
    private ReservationForPreparedMealId id;

    @Column(name = "quantity")
    @Min(value = 0, message = "Quantity must be greater than or equal to 0")
    private Integer quantity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reservation_id", referencedColumnName = "reservation_id", insertable = false, updatable = false)
    private Reservation reservation_id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "prepared_meal_id", referencedColumnName = "prepared_meal_id", insertable = false, updatable = false)
    })
    private PreparedMeal prepared_meal_id;

    @ManyToOne
    @JoinColumn(name = "meal_id", referencedColumnName = "meal_id", insertable = false, updatable = false)
    private Meal meal_id;

}
