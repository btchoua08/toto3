package com.rhttechcomp001.backend.controllers;

import com.rhttechcomp001.backend.domain.entities.Avion;
import com.rhttechcomp001.backend.TestDataUtil;
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
public class AvionControllerIntegrationTests {

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @Autowired
    public AvionControllerIntegrationTests(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
        this.objectMapper = new ObjectMapper();
    }

    @Test
    public void testTharCreateAvionSuccessfullyReturnsHttp201Created() throws Exception {

        Avion testAvion1 = TestDataUtil.createTestAvion1();
        testAvion1.setNumavion(4);

        String avionJson = objectMapper.writeValueAsString(testAvion1);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/testtech/avion")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(avionJson)
        ).andExpect(
                MockMvcResultMatchers.status().isCreated()
        );

    }

    @Test
    public void testTharCreateAvionSuccessfullyReturnsSavedAvion() throws Exception {

        Avion testAvion = TestDataUtil.createTestAvion2();
        testAvion.setNumavion(5);
        String avionJson = objectMapper.writeValueAsString(testAvion);
        mockMvc.perform(
                MockMvcRequestBuilders.post("/testtech/avion")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(avionJson)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.numavion").isNumber()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.nomavion").value("into avion values")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.capacite").value(200)
        );

    }
}
