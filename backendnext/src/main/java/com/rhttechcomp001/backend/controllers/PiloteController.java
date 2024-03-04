package com.rhttechcomp001.backend.controllers;

import com.rhttechcomp001.backend.domain.dto.PiloteDto;
import com.rhttechcomp001.backend.domain.entities.Pilote;
import com.rhttechcomp001.backend.mappers.Mapper;
import com.rhttechcomp001.backend.mappers.NewAvionMapper;
import com.rhttechcomp001.backend.services.PiloteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class PiloteController {

    private PiloteService piloteService;

    private Mapper<Pilote, PiloteDto> piloteMapper;

    public PiloteController(PiloteService piloteService, Mapper<Pilote, PiloteDto> piloteMapper) {
        this.piloteService = piloteService;
        this.piloteMapper = piloteMapper;
    }

    @PostMapping(path ="/testtech/pilote")
    public ResponseEntity<PiloteDto> createPilote(@RequestBody PiloteDto piloteDto){
        Pilote  piloteEntity= piloteMapper.mapFrom(piloteDto);
        Pilote savePiloteEntity =piloteService.createPilote(piloteEntity);
        return new ResponseEntity<>(piloteMapper.mapTo(savePiloteEntity), HttpStatus.CREATED);
    }

    @GetMapping("/testtech/listpilote")
    public  List<PiloteDto>  listPilote(){
        List <Pilote>  piloteEntity =piloteService.findAll();
        return  piloteEntity.stream().map(piloteMapper::mapTo).collect(Collectors.toList());
    }
}
