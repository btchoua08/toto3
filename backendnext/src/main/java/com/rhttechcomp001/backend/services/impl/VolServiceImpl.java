package com.rhttechcomp001.backend.services.impl;

import com.rhttechcomp001.backend.domain.entities.Vol;
import com.rhttechcomp001.backend.repositories.VolRepository;
import com.rhttechcomp001.backend.services.VolService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class VolServiceImpl implements VolService {

    private VolRepository volRepository;

    public VolServiceImpl(VolRepository volRepository) {
        this.volRepository = volRepository;
    }

    @Override
    public Vol createVol(Vol vol) {
        return volRepository.save(vol);
    }

    @Override
    public List<Vol> findAll() {
        return StreamSupport
                .stream(
                        volRepository.findAll().spliterator(),
                        false)
                .collect(Collectors.toList());
    }
}
