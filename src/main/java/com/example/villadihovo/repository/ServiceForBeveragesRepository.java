package com.example.villadihovo.repository;

import com.example.villadihovo.dto.ServiceForBeveragesDto;
import com.example.villadihovo.model.reservations.ServiceForBeverages;
import com.example.villadihovo.model.reservations.ServiceForBeveragesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceForBeveragesRepository  extends JpaRepository<ServiceForBeverages, ServiceForBeveragesId> {
    @Query("SELECT new com.example.villadihovo.dto.ServiceForBeveragesDto(ut.full_name, s.service_type, b.beverage_type, b.price)" +
            "FROM ServiceForBeverages sfb " +
            "JOIN Service s ON sfb.service_id = s.service_id " +
            "JOIN Beverage b ON sfb.beverage_id = b.beverage_id \n" +
            "JOIN UserTable ut ON s.user_id.user_id  = ut.user_id ")
    List<ServiceForBeveragesDto> findAllServiceForBeveragesDto();
}
