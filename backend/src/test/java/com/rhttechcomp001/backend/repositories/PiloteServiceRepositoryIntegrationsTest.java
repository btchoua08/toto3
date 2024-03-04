package com.rhttechcomp001.backend.repositories;

import com.rhttechcomp001.backend.domain.entities.Pilote;
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
public class PiloteServiceRepositoryIntegrationsTest {
    private PiloteRepository underTest;

    @Autowired
    public PiloteServiceRepositoryIntegrationsTest(PiloteRepository underTest) {
        this.underTest = underTest;
    }

    @Test
    public void testThatPiloteCanBeCreatedAndRecalled(){
        Pilote pilote = TestDataUtil.createTestPilote1();
        underTest.save(pilote);

        Optional<Pilote> result = underTest.findById(pilote.getNumpilote());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(pilote);

    }


    @Test
    public void testThatAvionCanBeUpdated(){
        Pilote pilote1 =TestDataUtil.createTestPilote1();
        underTest.save(pilote1);
        pilote1.setNompilote("TCHOUA TCHATOUO");
        underTest.save(pilote1);

        Optional<Pilote> result = underTest.findById(pilote1.getNumpilote());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(pilote1);
    }

}
