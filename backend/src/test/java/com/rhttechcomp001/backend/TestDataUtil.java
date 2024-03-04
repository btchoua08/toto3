package com.rhttechcomp001.backend;

import com.rhttechcomp001.backend.domain.entities.Avion;
import com.rhttechcomp001.backend.domain.entities.Pilote;
import com.rhttechcomp001.backend.domain.entities.Vol;
import com.rhttechcomp001.backend.domain.entities.enumeration.Capacite;

public final class TestDataUtil {


    public static Avion createTestAvion1(){
        return Avion.builder()
                .numavion(1)
                .nomavion("Airbus A300")
                .capacite(460)
                .localisation("Paris")
                .build();
    }

    public static Avion createTestAvion2(){
        return Avion.builder()
                .numavion(2)
                .nomavion("into avion values")
                .capacite(200)
                .localisation("Mulhouse")
                .build();
    }

    public static Pilote createTestPilote1(){
        return Pilote.builder()
                .numpilote(1)
                .nompilote("Ader Clément")
                .adresse("Paris")
                .build();
    }

    public static Pilote createTestPilote2(){
        return Pilote.builder()
                .numpilote(2)
                .nompilote("Lindbergh Charles")
                .adresse("New-York")
                .build();
    }

    public static Vol createTestVol1(final Avion avion , final  Pilote pilote){
        return Vol.builder()
                .numvol("AF001")
                .pilote(pilote)
                .avion(avion)
                .villedep("Paris")
                .villearr("Johannesbourg")
                .heuredep("06:00")
                .heurearr("13:31")
                .build();
    }



    public static Vol createTestVol2(final Avion avion , final  Pilote pilote){
        return Vol.builder()
                .numvol("AG0002")
                .pilote(pilote)
                .avion(avion)
                .villedep("Paris")
                .villearr("Alger")
                .heuredep("06:45")
                .heurearr("08:45")
                .build();
    }


}
