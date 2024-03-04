package com.rhttechcomp001.backend.mappers.impl;

import com.rhttechcomp001.backend.domain.entities.Avion;
import com.rhttechcomp001.backend.domain.dto.AvionDto;
import com.rhttechcomp001.backend.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AvionMapperImpl implements Mapper <Avion, AvionDto> {

    private ModelMapper modelMapper;

    public AvionMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public AvionDto mapTo(Avion avion){
      return modelMapper.map(avion, AvionDto.class);
    }

    @Override
    public Avion mapFrom(AvionDto avionDto) {
        return modelMapper.map(avionDto, Avion.class);
    }
}
