package com.prime.generateprimes.service;

import com.prime.generateprimes.domain.PrimeNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GeneratePrimesBasicImplTest {
    GeneratePrimesBasicImpl generatePrimesBasic = new GeneratePrimesBasicImpl();

    @Test
    public void shouldReturnTrueIfNumberIsPrime() {
        assertTrue(generatePrimesBasic.isPrime(997));
    }

    @Test
    public void shouldReturnFalseIfNumberIsComposite() {
        assertFalse(generatePrimesBasic.isPrime(1000));
    }

    @Test
    public void shouldGeneratePrimeNumbersWhenInitialGreaterThan1() {
        List<Integer> expectedListOfPrime = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19);
        PrimeNumber primeNumber = generatePrimesBasic.generatePrimes(20);
        assertEquals(20, primeNumber.getInitial());
        assertEquals(expectedListOfPrime, primeNumber.getPrimes());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 0, -1})
    public void shouldGenerateEmptyListOfPrimeNumbersWhenInitialEqualTo1(int lessThanOne) {
        PrimeNumber primeNumber = generatePrimesBasic.generatePrimes(lessThanOne);
        assertEquals(lessThanOne, primeNumber.getInitial());
        assertEquals(Collections.emptyList(), primeNumber.getPrimes());
    }
}