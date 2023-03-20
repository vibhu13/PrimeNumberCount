package org.example.sequential;

import java.text.NumberFormat;
import java.util.Locale;

public class SequentialPrimeCheck {
    public static final long max = 100_000_000;
    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();
        System.out.println("Sequential Processing");
        long num_primes = primeCalculator();
        final long endTime = System.currentTimeMillis();
        NumberFormat nf = NumberFormat.getInstance(Locale.US);

        System.out.println("Number of primes less than " + nf.format(max) + ": " + num_primes);
        System.out.println("Took total " + (endTime - startTime)/1000.0 + " seconds.");
        System.out.println();
    }

    public static long primeCalculator() {
        long num_primes = 0;
        for (long i = 2; i <= max; i++) {
            if (checkPrime(i))
                num_primes++;
        }
        return num_primes;
    }

    private static boolean checkPrime(long l) {
        long upper_bound = (long) Math.floor(Math.sqrt(l));
        for (long i = 2; i <= upper_bound; i++) {
            if (l % i == 0)
                return false;
        }
        return true;
    }
}