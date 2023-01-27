package com.example.villadihovo.repository.payment;

import com.example.villadihovo.model.payments.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
