package com.example.villadihovo.service;

import com.example.villadihovo.model.villa;

import java.util.List;

public interface VillaService {
    List<villa> listAllVillas();
    villa getById(Integer id);
}
