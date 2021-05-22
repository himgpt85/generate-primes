package com.prime.generateprimes.service;

import com.prime.generateprimes.domain.PrimeNumber;

@FunctionalInterface
public interface GeneratePrimes {
    PrimeNumber generatePrimes(Integer initial);
}
