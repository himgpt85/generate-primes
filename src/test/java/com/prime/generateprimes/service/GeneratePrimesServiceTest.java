package com.prime.generateprimes.service;

import com.prime.generateprimes.domain.PrimeNumber;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GeneratePrimesServiceTest {

    GeneratePrimesService generatePrimesService = new GeneratePrimesService();

    @Test
    public void shouldReturnTrueIfNumberIsPrime() {
        assertTrue(generatePrimesService.isPrime(23));
    }

    @Test
    public void shouldReturnFalseIfNumberIsComposite() {
        assertFalse(generatePrimesService.isPrime(8));
    }

    @Test
    public void shouldGeneratePrimeNumbersWhenInitialGreaterThan1() {
        Integer[] arr = new Integer[]{2, 3, 5, 7, 11, 13, 17, 19};
        List<Integer> expectedListOfPrime = Arrays.asList(arr);
        PrimeNumber primeNumber = generatePrimesService.generatePrimes(20);
        assertEquals(20, primeNumber.getInitial());
        assertEquals(expectedListOfPrime, primeNumber.getPrimes());
    }

    @Test
    public void shouldGenerateEmptyListOfPrimeNumbersWhenInitialEqualTo1() {
        PrimeNumber primeNumber = generatePrimesService.generatePrimes(1);
        assertEquals(1, primeNumber.getInitial());
        assertEquals(Collections.emptyList(), primeNumber.getPrimes());
    }
}