package com.example.villadihovo.repository.payment;

import com.example.villadihovo.model.payments.Online;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OnlineRepository extends JpaRepository<Online, Integer> {
}
