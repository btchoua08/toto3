package com.rhttechcomp001.backend.controllers;

import com.rhttechcomp001.backend.domain.dto.PiloteDto;
import com.rhttechcomp001.backend.domain.entities.Avion;
import com.rhttechcomp001.backend.domain.entities.Pilote;
import com.rhttechcomp001.backend.exceptions.CapaciteConversionException;
import com.rhttechcomp001.backend.domain.dto.AvionDto;
import com.rhttechcomp001.backend.mappers.Mapper;
import com.rhttechcomp001.backend.mappers.NewAvionMapper;
import com.rhttechcomp001.backend.services.AvionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class AvionController {

    private AvionService avionService;

    private NewAvionMapper newAvionMapper;
    private Mapper<Avion, AvionDto> avionMapper;

    public AvionController(AvionService avionService, NewAvionMapper newAvionMapper, Mapper<Avion, AvionDto> avionMapper) {
        this.avionService = avionService;
        this.newAvionMapper = newAvionMapper;
        this.avionMapper = avionMapper;
    }

    @PostMapping(path ="/testtech/avion")
    public ResponseEntity<AvionDto> createAvion(@RequestBody AvionDto avion){


       try {
           Avion avionEntity= newAvionMapper.fromDtoToAvion(avion);
           Avion saveAvionEntity =avionService.createAvion(avionEntity);
           return new ResponseEntity<>(newAvionMapper.fromAvionToAvionDto(saveAvionEntity), HttpStatus.CREATED);
       }catch (CapaciteConversionException exception){
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }


    }

    @GetMapping("/testtech/listavion")
    public  List<AvionDto> getAvions(){
        List<Avion> avionEntity = avionService.findAll();
        return  avionEntity.stream().map(avionMapper::mapTo).collect(Collectors.toList());
    }
}
