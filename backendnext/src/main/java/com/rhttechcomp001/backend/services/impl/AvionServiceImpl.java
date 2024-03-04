package com.rhttechcomp001.backend.services.impl;

import com.rhttechcomp001.backend.domain.entities.Avion;
import com.rhttechcomp001.backend.repositories.AvionRepository;
import com.rhttechcomp001.backend.services.AvionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AvionServiceImpl implements AvionService {

    private AvionRepository avionRepository;

    public AvionServiceImpl(AvionRepository avionRepository) {
        this.avionRepository = avionRepository;
    }

    @Override
    public Avion createAvion(Avion avion) {
        System.out.println(avion.toString());
       return avionRepository.save(avion);
    }

    @Override
    public List<Avion> findAll() {
        return StreamSupport
                .stream(
                        avionRepository.findAll().spliterator(),
                        false)
                .collect(Collectors.toList());
    }

    @Override
    public Avion findById(Integer id) {
        return avionRepository.findById(id).get();
    }
}
