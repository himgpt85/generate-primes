package com.prime.generateprimes.resource;

import com.prime.generateprimes.domain.PrimeNumber;
import com.prime.generateprimes.service.GeneratePrimesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneratePrimeController {

    Logger log = LoggerFactory.getLogger(GeneratePrimeController.class);

    @Autowired
    private GeneratePrimesService generatePrimesService;

    private final Integer[] defaultPrimes = new Integer[]{2, 3, 5, 7};

    public GeneratePrimeController(GeneratePrimesService generatePrimesService) {
        this.generatePrimesService = generatePrimesService;
    }

    /**
     * API that returns a list of prime numbers from 2 to the upperBound
     *
     * @param initial upper bound to limit the size of the returned primes
     * @return initial and list of prime numbers from 2 to initial
     */
    @GetMapping("/primes/{initial}")
    public PrimeNumber generatePrimes(@PathVariable("initial") Integer initial) {
        log.info("Generating prime numbers with initial " + initial);
        return generatePrimesService.generatePrimes(initial);
    }
}