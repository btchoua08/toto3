package com.rhttechcomp001.backend.repositories;

import com.rhttechcomp001.backend.TestDataUtil;
import com.rhttechcomp001.backend.domain.entities.Avion;
import com.rhttechcomp001.backend.domain.entities.Pilote;
import com.rhttechcomp001.backend.domain.entities.Vol;
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
public class VolRepositoryIntegrationTest {

    private VolRepository underTest;
    @Autowired
    public VolRepositoryIntegrationTest(VolRepository underTest) {
        this.underTest = underTest;
    }

    @Test
    public void testThatVolCanBeCreatedAndBeRecalled(){
        Pilote pilote = TestDataUtil.createTestPilote1();
        Avion avion= TestDataUtil.createTestAvion1();
        Vol vol =TestDataUtil.createTestVol1(avion,pilote);
        underTest.save(vol);
        Optional<Vol> result = underTest.findById(vol.getNumvol());
        assertThat(result).isPresent();
        assertThat(result.get().getNumvol()).isEqualTo(vol.getNumvol());

    }



}
