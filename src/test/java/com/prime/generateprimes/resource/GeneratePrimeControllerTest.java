package com.prime.generateprimes.resource;

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

    private static final String response =
            "{\"Initial\":100,\"Primes\":[2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97]}";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldCallGeneratePrimesAndReturnDefaultOkResponseWhenInitialLessThanTwo() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/primes/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().json("{\"Initial\":1,\"Primes\":[]}"));
    }

    @Test
    public void shouldCallGeneratePrimesAndReturnOkResponse() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/primes/100"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().json(response));
    }

    @Test
    public void shouldCallGeneratePrimesWithBasicAlgorithmAndReturnOkResponse() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/primes/100?algorithm=1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().json(response));
    }

    @Test
    public void shouldCallGeneratePrimesWithSquareRootAlgorithmAndReturnOkResponse() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/primes/100?algorithm=2"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().json(response));
    }

    @Test
    public void shouldCallGeneratePrimesWithSieveAlgorithmAndReturnOkResponse() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/primes/100?algorithm=3"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().json(response));
    }
}