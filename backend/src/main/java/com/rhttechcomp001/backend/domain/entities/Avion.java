package com.rhttechcomp001.backend.domain.entities;

import com.rhttechcomp001.backend.domain.entities.enumeration.Capacite;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="avion")
public class Avion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numavion;
    @Column(length = 20)
    private String nomavion;
    private Integer capacite;
    @Column(length = 20, nullable = false, columnDefinition = "VARCHAR(20) DEFAULT 'Paris'")
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
