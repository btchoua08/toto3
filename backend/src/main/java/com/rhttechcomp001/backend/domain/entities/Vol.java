package com.rhttechcomp001.backend.domain.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name="vol")
public class Vol {

    @Id
    @Column(length = 6)
    private String numvol;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "numpilote")
    private Pilote pilote;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "numavion")
    private Avion avion;
    @Column(length = 20)
    private String villedep;
    @Column(length = 20)
    private String villearr;
    @Column(length = 5)
    private String heuredep;
    @Column(length = 5)
    private String heurearr;
}
