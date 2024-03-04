package com.rhttechcomp001.backend.services.impl;

import com.rhttechcomp001.backend.domain.entities.Pilote;
import com.rhttechcomp001.backend.repositories.PiloteRepository;
import com.rhttechcomp001.backend.services.PiloteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PiloteServiceImpl implements PiloteService {

    private PiloteRepository piloteRepository;

    public PiloteServiceImpl(PiloteRepository piloteRepository) {
        this.piloteRepository = piloteRepository;
    }

    @Override
    public Pilote createPilote(Pilote pilote) {
        return piloteRepository.save(pilote);
    }

    @Override
    public Pilote findById(Integer id) {
        return piloteRepository.findById(id).get();
    }

    @Override
    public List<Pilote> findAll() {
        return StreamSupport
                .stream(
                        piloteRepository.findAll().spliterator(),
                        false)
                .collect(Collectors.toList());
    }
}
