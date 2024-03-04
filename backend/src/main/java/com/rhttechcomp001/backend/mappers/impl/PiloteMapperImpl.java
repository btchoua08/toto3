package com.rhttechcomp001.backend.mappers.impl;

import com.rhttechcomp001.backend.domain.dto.PiloteDto;
import com.rhttechcomp001.backend.domain.entities.Pilote;
import com.rhttechcomp001.backend.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PiloteMapperImpl implements Mapper<Pilote, PiloteDto> {

    private ModelMapper modelMapper;

    public PiloteMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public PiloteDto mapTo(Pilote pilote) {
        return modelMapper.map(pilote, PiloteDto.class);
    }

    @Override
    public Pilote mapFrom(PiloteDto piloteDto) {
        return modelMapper.map(piloteDto, Pilote.class);
    }
}
