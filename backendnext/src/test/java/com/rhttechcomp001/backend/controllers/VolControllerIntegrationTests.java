package com.rhttechcomp001.backend.controllers;
import com.rhttechcomp001.backend.TestDataUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rhttechcomp001.backend.domain.entities.Avion;
import com.rhttechcomp001.backend.domain.entities.Pilote;
import com.rhttechcomp001.backend.domain.entities.Vol;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class VolControllerIntegrationTests {

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;


    @Autowired
    public VolControllerIntegrationTests(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
        this.objectMapper=new ObjectMapper();
    }

    @Test
    public void testTharCreateVolSuccessfullyReturnsHttp201Created() throws Exception {

        Pilote pilote =TestDataUtil.createTestPilote1();
        Avion avion=TestDataUtil.createTestAvion1();
        Vol testVol = TestDataUtil.createTestVol1(avion,pilote);
        testVol.setNumvol("GR5681");

        String volJson = objectMapper.writeValueAsString(testVol);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/testtech/1/1/createvol")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(volJson)
        ).andExpect(
                MockMvcResultMatchers.status().isCreated()
        );

    }


}
