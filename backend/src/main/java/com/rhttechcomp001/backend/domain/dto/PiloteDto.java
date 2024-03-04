package com.rhttechcomp001.backend.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class PiloteDto {
    private Integer numpilote;
    private String nompilote;
    private String adresse;
}
