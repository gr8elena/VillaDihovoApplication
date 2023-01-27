package com.example.villadihovo.service.impl.reservationImpl;

import com.example.villadihovo.dto.ServiceForBeveragesDto;
import com.example.villadihovo.repository.reservation.ServiceForBeveragesRepository;
import com.example.villadihovo.service.reservation.ServiceForBeveragesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceForBeverageServiceImpl implements ServiceForBeveragesService{

    @Autowired
    private ServiceForBeveragesRepository serviceForBeveragesRepository;

    @Override
    public List<ServiceForBeveragesDto> findAllServiceForBeverages() {
        return serviceForBeveragesRepository.findAllServiceForBeveragesDto();
    }
}
