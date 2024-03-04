package com.rhttechcomp001.backend.repositories;

import com.rhttechcomp001.backend.domain.entities.Avion;
import com.rhttechcomp001.backend.TestDataUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AvionRepositoryIntegrationsTest {

    private AvionRepository underTest;

    @Autowired
    public AvionRepositoryIntegrationsTest(AvionRepository underTest) {
        this.underTest = underTest;
    }

    @Test
    public void testThatAvionCanBeCreatedAndCanBeRecalled(){
        Avion avion = TestDataUtil.createTestAvion1();
        underTest.save(avion);
        Optional<Avion> result = underTest.findById(avion.getNumavion());
        assertThat(result).isPresent();
        assertThat(result.get().getNumavion()).isEqualTo(avion.getNumavion());
    }



    @Test
    public void testThatAvionCanBeUpdated(){
        Avion avion = TestDataUtil.createTestAvion1();
        underTest.save(avion);
        avion.setNomavion("Camerco");
        underTest.save(avion);

        Optional<Avion> result = underTest.findById(avion.getNumavion());
        assertThat(result).isPresent();
        assertThat(result.get().getNomavion()).isEqualTo(avion.getNomavion());
    }


}
