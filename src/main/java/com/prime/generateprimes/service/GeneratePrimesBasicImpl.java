package com.prime.generateprimes.service;

import com.prime.generateprimes.domain.PrimeNumber;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class GeneratePrimesBasicImpl implements GeneratePrimes {
    @Override
    public PrimeNumber generatePrimes(Integer initial) {
        if (initial < 2) {
            return new PrimeNumber(initial, Collections.emptyList());
        } else {
            List<Integer> listOfPrimes = IntStream.rangeClosed(2, initial)
                    .parallel()
                    .filter(this::isPrime)
                    .boxed()
                    .collect(Collectors.toList());
            return new PrimeNumber(initial, listOfPrimes);
        }
    }

    public boolean isPrime(int number) {
        /*
            Loop from 2 to number-1 and check if any factor returns remainder as 0
         */
        return number > 1 && IntStream.range(2, number)
                .allMatch(factor -> number % factor != 0);
    }
}
