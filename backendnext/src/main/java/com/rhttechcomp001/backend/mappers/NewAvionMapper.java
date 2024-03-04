package com.rhttechcomp001.backend.mappers;

import com.rhttechcomp001.backend.domain.dto.AvionDto;
import com.rhttechcomp001.backend.domain.entities.Avion;
import com.rhttechcomp001.backend.domain.entities.enumeration.Capacite;
import com.rhttechcomp001.backend.exceptions.CapaciteConversionException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class NewAvionMapper {
    @Mapping(target = "capacite",expression = "java(mapCapacite(avionDto))")
    public abstract Avion fromDtoToAvion(AvionDto avionDto);
   // @Mapping(target = "capacite",expression = "java(mapCapaciteToString(avion.getCapacite()))")
    public abstract AvionDto fromAvionToAvionDto(Avion avion);

  /*  protected String  mapCapaciteToString(Capacite capacite){
        return capacite.getValue().toString();
    }*/

    protected Integer mapCapacite(AvionDto avionDto){
            Integer capacite =avionDto.getCapacite();
            validaCapacite(capacite);
            return capacite;
    }
    private static void validaCapacite(Integer str) {
        for (Capacite cap : Capacite.values()) {
            if (cap.getValue().equals(str)) {
                return;
            }
        }
        throw new CapaciteConversionException("La capaciter saisie n'est pas valide");
    }
}
