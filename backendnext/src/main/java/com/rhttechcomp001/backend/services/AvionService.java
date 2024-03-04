package com.rhttechcomp001.backend.services;

import com.rhttechcomp001.backend.domain.entities.Avion;

import java.util.List;

public interface AvionService {
    Avion createAvion(Avion avion);

    List<Avion> findAll();
    Avion findById(Integer id);
}
