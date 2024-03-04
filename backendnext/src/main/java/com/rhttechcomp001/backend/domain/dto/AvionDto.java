package com.rhttechcomp001.backend.domain.dto;


public class AvionDto {

    private Integer numavion;
    private String nomavion;
    private Integer capacite;
    private String localisation;

    public Integer getNumavion() {
        return numavion;
    }

    public void setNumavion(Integer numavion) {
        this.numavion = numavion;
    }

    public String getNomavion() {
        return nomavion;
    }

    public void setNomavion(String nomavion) {
        this.nomavion = nomavion;
    }

    public Integer getCapacite() {
        return capacite;
    }

    public void setCapacite(Integer capacite) {
        this.capacite = capacite;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }
}
