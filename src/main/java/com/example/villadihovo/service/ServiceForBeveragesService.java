package com.example.villadihovo.service;

import com.example.villadihovo.dto.ReservationForEventsDto;
import com.example.villadihovo.dto.ServiceForBeveragesDto;

import java.util.List;

public interface ServiceForBeveragesService {
    List<ServiceForBeveragesDto> findAllServiceForBeverages();
}
