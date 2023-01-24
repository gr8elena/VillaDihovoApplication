package com.example.villadihovo.service.impl;

import com.example.villadihovo.model.offers.Villa;
import com.example.villadihovo.repository.VillaRepository;
import com.example.villadihovo.service.VillaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VillaServiceImpl implements VillaService {

    @Autowired
    private VillaRepository villaRepository;

    @Override
    public List<Villa> listAllVillas() {
        List<Villa> villaList;
        villaList = villaRepository.findAll();
        return villaList;
    }

    @Override
    public Villa getById(Integer id) {
        return this.villaRepository.getById(id);
    }
}
