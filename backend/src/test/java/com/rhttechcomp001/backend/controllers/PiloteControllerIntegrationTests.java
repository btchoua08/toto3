package com.rhttechcomp001.backend.controllers;

import com.rhttechcomp001.backend.TestDataUtil;
import com.rhttechcomp001.backend.domain.entities.Pilote;
import com.fasterxml.jackson.databind.ObjectMapper;
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
public class PiloteControllerIntegrationTests {

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;


    @Autowired
    public PiloteControllerIntegrationTests(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
        this.objectMapper=new ObjectMapper();
    }

    @Test
    public void testTharCreatePiloteSuccessfullyReturnsHttp201Created() throws Exception {

        Pilote testPilote = TestDataUtil.createTestPilote1();
        testPilote.setNumpilote(2);

        String piloteJson = objectMapper.writeValueAsString(testPilote);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/testtech/pilote")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(piloteJson)
        ).andExpect(
                MockMvcResultMatchers.status().isCreated()
        );

    }


}
