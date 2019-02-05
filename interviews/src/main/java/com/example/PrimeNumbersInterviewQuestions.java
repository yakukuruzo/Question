package com.example;

import java.util.Arrays;

/**
 * Created by levin on 4/16/17.
 */

public class PrimeNumbersInterviewQuestions {


    //checks whether an int is prime or not.
    public static boolean isPrime(int n) {
        //check if n is a multiple of 2
        if (n % 2 == 0) return false;
        //if not, then just check the odds
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    //set up the primesieve
    public static void fillSieve(boolean[] primes) {
        Arrays.fill(primes, true);        // assume all integers are prime.
        primes[0] = primes[1] = false;       // we know 0 and 1 are not prime.
        for (int i = 2; i < primes.length; i++) {
            //if the number is prime,
            //then go through all its multiples and make their values false.
            if (primes[i]) {
                for (int j = 2; i * j < primes.length; j++) {
                    primes[i * j] = false;
                }
            }
        }
    }

    public boolean[] isPrimeSieve(int n) {
        boolean[] primes = new boolean[n];
        fillSieve(primes);
        return primes;
    }

}
