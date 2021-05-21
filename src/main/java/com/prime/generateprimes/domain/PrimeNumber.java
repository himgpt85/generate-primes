package com.prime.generateprimes.domain;

import java.util.List;

public class PrimeNumber {
    private Integer initial;
    private List<Integer> primes;

    public Integer getInitial() {
        return initial;
    }

    public List<Integer> getPrimes() {
        return primes;
    }

    public void setInitial(Integer initial) {
        this.initial = initial;
    }

    public void setPrimes(List<Integer> primes) {
        this.primes = primes;
    }

    public PrimeNumber(Integer initial, List<Integer> primes) {
        this.initial = initial;
        this.primes = primes;
    }
}
