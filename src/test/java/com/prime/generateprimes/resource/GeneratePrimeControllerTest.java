package com.prime.generateprimes.resource;

import com.prime.generateprimes.service.GeneratePrimesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class GeneratePrimeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private GeneratePrimesService generatePrimesService;

    @Test
    public void shouldCallGeneratePrimesAndReturnDefaultOkResponseWhenInitialLessThanTwo() throws Exception {
        GeneratePrimeController generatePrimeController = new GeneratePrimeController(generatePrimesService);

        mockMvc.perform(MockMvcRequestBuilders.get("/primes/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().json("{\"initial\":1,\"primes\":[]}"));
    }

    @Test
    public void shouldCallGeneratePrimesAndReturnOkResponse() throws Exception {
        GeneratePrimeController generatePrimeController = new GeneratePrimeController(generatePrimesService);

        mockMvc.perform(MockMvcRequestBuilders.get("/primes/10"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().json("{\"initial\":10,\"primes\":[2,3,5,7]}"));
    }

}