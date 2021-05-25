package com.prime.generateprimes.resource;

import com.prime.generateprimes.domain.PrimeNumber;
import com.prime.generateprimes.service.GeneratePrimesBasicImpl;
import com.prime.generateprimes.service.GeneratePrimesSieveImpl;
import com.prime.generateprimes.service.GeneratePrimesSquareRootImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneratePrimeController {

    Logger log = LoggerFactory.getLogger(GeneratePrimeController.class);

    @Autowired
    private final GeneratePrimesBasicImpl generatePrimesBasic;

    @Autowired
    private final GeneratePrimesSquareRootImpl generatePrimesSquareRoot;

    @Autowired
    private final GeneratePrimesSieveImpl generatePrimesSieve;


    public GeneratePrimeController(GeneratePrimesBasicImpl generatePrimesBasic,
                                   GeneratePrimesSquareRootImpl generatePrimesSquareRoot,
                                   GeneratePrimesSieveImpl generatePrimesSieve) {
        this.generatePrimesBasic = generatePrimesBasic;
        this.generatePrimesSquareRoot = generatePrimesSquareRoot;
        this.generatePrimesSieve = generatePrimesSieve;
    }

    /**
     * API that returns a list of prime numbers from 2 to the upperBound
     *
     * @param initial   upper bound to limit the size of the returned primes
     * @param algorithm Algorithm to use to find primes, default to 3 (Sieve of Eratosthenes)
     * @return initial and list of prime numbers from 2 to initial
     */
    @GetMapping("/primes/{initial}")
    public PrimeNumber generatePrimes(@PathVariable("initial") Integer initial,
                                      @RequestParam(value = "algorithm", defaultValue = "3") int algorithm) {
        switch (algorithm) {
            case 1:
                log.info("Generating prime numbers with basic algorithm and initial " + initial);
                return generatePrimesBasic.generatePrimes(initial);
            case 2:
                log.info("Generating prime numbers with square root algorithm and initial " + initial);
                return generatePrimesSquareRoot.generatePrimes(initial);
            default:
                log.info("Generating prime numbers with sieve algorithm and initial " + initial);
                return generatePrimesSieve.generatePrimes(initial);
        }
    }
}