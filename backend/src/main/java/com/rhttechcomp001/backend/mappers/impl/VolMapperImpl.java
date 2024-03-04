package com.rhttechcomp001.backend.mappers.impl;

import com.rhttechcomp001.backend.domain.dto.VolDto;
import com.rhttechcomp001.backend.domain.entities.Vol;
import com.rhttechcomp001.backend.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class VolMapperImpl implements Mapper<Vol , VolDto> {

    private ModelMapper modelMapper;

    public VolMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public VolDto mapTo(Vol vol) {

        return modelMapper.map(vol, VolDto.class);
    }

    @Override
    public Vol mapFrom(VolDto volDto) {

        return modelMapper.map(volDto, Vol.class);
    }
}
