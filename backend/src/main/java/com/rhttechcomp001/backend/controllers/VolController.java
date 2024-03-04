package com.rhttechcomp001.backend.controllers;

import com.rhttechcomp001.backend.domain.dto.PiloteDto;
import com.rhttechcomp001.backend.domain.dto.VolDto;
import com.rhttechcomp001.backend.domain.entities.Avion;
import com.rhttechcomp001.backend.domain.entities.Pilote;
import com.rhttechcomp001.backend.domain.entities.Vol;
import com.rhttechcomp001.backend.mappers.Mapper;
import com.rhttechcomp001.backend.services.AvionService;
import com.rhttechcomp001.backend.services.PiloteService;
import com.rhttechcomp001.backend.services.VolService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class VolController {

    private VolService volService;
    private PiloteService piloteService;
    private AvionService avionService;
    private Mapper<Vol, VolDto> volMapper;

    public VolController(VolService volService, PiloteService piloteService, AvionService avionService, Mapper<Vol, VolDto> volMapper) {
        this.volService = volService;
        this.piloteService = piloteService;
        this.avionService = avionService;
        this.volMapper = volMapper;
    }

    @PostMapping("/testtech/{numpilote}/{numavion}/createvol")
    public ResponseEntity<VolDto> createVol(
            @PathVariable("numpilote") Integer numpilote,
            @PathVariable("numavion") Integer numavion ,
            @RequestBody VolDto volDto){
        Pilote pilote =piloteService.findById(numpilote);
        Avion avion  =avionService.findById(numavion);
        volDto.setAvion(avion);
        volDto.setPilote(pilote);
        Vol volEntity =volMapper.mapFrom(volDto);
        Vol saveVolEntity = volService.createVol(volEntity);
        return new ResponseEntity<>(volMapper.mapTo(saveVolEntity), HttpStatus.CREATED);
    }

    @GetMapping("/testtech/listvol")
    public List<VolDto> listVol(){
        List <Vol>  volEntity =volService.findAll();
        return  volEntity.stream().map(volMapper::mapTo).collect(Collectors.toList());
    }
}
