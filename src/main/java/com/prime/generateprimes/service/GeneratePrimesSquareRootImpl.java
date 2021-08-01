package com.prime.generateprimes.service;

import com.prime.generateprimes.domain.PrimeNumber;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class GeneratePrimesSquareRootImpl implements GeneratePrimes {
    @Override
    public PrimeNumber generatePrimes(int initial) {
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
            If the number is composite then it can have 2 factors e.g. number = f1 * f2
            If f1 and f2 are greater than square root of the number then f1*f2 would be greater than the number
            That means at least one of the factors must be less than equal to the square root of the number
            That is why we are creating a range from 2 to square root of a number to be checked for prime
         */
        return number > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .allMatch(factor -> number % factor != 0);
    }
}
