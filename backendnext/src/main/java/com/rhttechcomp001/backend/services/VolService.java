package com.rhttechcomp001.backend.services;

import com.rhttechcomp001.backend.domain.entities.Vol;

import java.util.List;

public interface VolService {
    Vol createVol(Vol vol);
    List<Vol> findAll();
}
