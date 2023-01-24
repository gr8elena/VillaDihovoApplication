package com.example.villadihovo.service;

import com.example.villadihovo.model.offers.Villa;

import java.util.List;

public interface VillaService {
    List<Villa> listAllVillas();
    Villa getById(Integer id);
}
