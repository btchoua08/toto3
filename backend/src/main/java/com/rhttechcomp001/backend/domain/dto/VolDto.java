package com.rhttechcomp001.backend.domain.dto;

import com.rhttechcomp001.backend.domain.entities.Avion;
import com.rhttechcomp001.backend.domain.entities.Pilote;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class VolDto {

    private String numvol;
    private Pilote pilote;
    private Avion avion;
    private String villedep;
    private String villearr;
    private String heuredep;
    private String heurearr;
}
