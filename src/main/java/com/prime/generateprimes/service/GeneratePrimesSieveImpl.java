package com.prime.generateprimes.service;

import com.prime.generateprimes.domain.PrimeNumber;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class GeneratePrimesSieveImpl implements GeneratePrimes {
    @Override
    public PrimeNumber generatePrimes(int initial) {
        if (initial < 2) {
            return new PrimeNumber(initial, Collections.emptyList());
        } else {
            boolean[] primes = markAllComposites(initial);
            return new PrimeNumber(initial, retrieveAllPrimes(initial, primes));
        }
    }

    private List<Integer> retrieveAllPrimes(int initial, boolean[] primes) {
        return IntStream.rangeClosed(2, initial)
                .parallel()
                .filter(value -> primes[value])
                .boxed()
                .collect(Collectors.toList());
    }

    private boolean[] markAllComposites(int initial) {
        //Array of booleans with indexes till initial
        boolean[] primes = new boolean[initial + 1];
        //Mark all indexes as true initially
        Arrays.fill(primes, true);

        //Start marking the array indexes as false if divisible by the number in iteration, starting from 2
        IntStream.rangeClosed(2, (int) Math.sqrt(initial))
                .filter(num -> primes[num])
                .forEach(num -> {
                    //Mark multiples of num as false as this number will be composite.
                    //i.e. all the multiples of 2, 3, 4 and so on in the iteration will be marked false if not already marked
                    //All the indexes which are not marked at the end of loop will be primes
                    for (int i = num * 2; i <= initial; i += num) {
                        primes[i] = false;
                    }
                });
        return primes;
    }

}
