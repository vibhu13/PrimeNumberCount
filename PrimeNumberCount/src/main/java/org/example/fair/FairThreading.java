package org.example.fair;

import org.example.sequential.SequentialPrimeCheck;

import java.text.NumberFormat;
import java.util.Locale;

public class FairThreading {


    //public static final int concurrency = Runtime.getRuntime().availableProcessors();
    public static final int concurrency = 10;
    public static final long max = SequentialPrimeCheck.max;

    public static void main(String[] args) {
        System.out.println("Using Fair Thread Policy.");
        long startTime = System.currentTimeMillis();
        primeCalculator();
        long endTime = System.currentTimeMillis();

        NumberFormat nf = NumberFormat.getInstance(Locale.US);

        System.out.println("Number of primes less than " + nf.format(SequentialPrimeCheck.max) + ": " + CountPrimeTaskV2.totalPrimeCount.get());

        System.out.println("Took total " + (endTime - startTime)/1000.0 + " seconds.");
        System.out.println();


    }
    public static void primeCalculator() {
        Thread arrThreads[] = new Thread[concurrency];


        for (int i = 0; i < concurrency; i++) {
            Thread t = new Thread(new CountPrimeTaskV2(), "Thread " + (i+1));
            t.start();
            arrThreads[i] = t;
        }

        for (int i = 0; i < concurrency; i++) {
            try {
                arrThreads[i].join();
            } catch (InterruptedException e) {
                System.out.println("Was interrupted.");
                return;
            }
        }
    }
}