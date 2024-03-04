package com.rhttechcomp001.backend.services;

import com.rhttechcomp001.backend.domain.entities.Pilote;

import java.util.List;

public interface PiloteService {

    Pilote createPilote(Pilote pilote);
    Pilote findById(Integer id);
    List<Pilote> findAll();
}
