package org.example.batching;

import org.example.sequential.SequentialPrimeCheck;

import java.text.NumberFormat;
import java.util.Locale;

public class UnfairBatching {

    //We will spawn as many threads as there are cores on the system, and not
    //more than that because we are not I/O bound here.

//    public static final int concurrency = Runtime.getRuntime().availableProcessors();
    public static final int concurrency = 10;
    public static final long max = SequentialPrimeCheck.max;

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        System.out.println("Unfair Batching");
        primeCalculator();
        long endTime = System.currentTimeMillis();

        NumberFormat nf = NumberFormat.getInstance(Locale.US);

        System.out.println("Number of primes less than " + nf.format(SequentialPrimeCheck.max) + ": " + CountPrimeTask.totalPrimeCount);

        System.out.println("Took total " + (endTime - startTime)/1000.0 + " seconds.");
        System.out.println();


    }
    public static void primeCalculator() {
        Thread arrThreads[] = new Thread[concurrency];

        long chunk = SequentialPrimeCheck.max / concurrency;
        long threadStart = 2;
        long threadEnd = threadStart + chunk;

        for (int i = 0; i < concurrency; i++) {
            Thread t = new Thread(new CountPrimeTask(threadStart, threadEnd), "Thread " + (i+1));
            t.start();
            arrThreads[i] = t;

            threadStart = threadEnd + 1;
            threadEnd = (threadEnd + chunk > SequentialPrimeCheck.max) ? SequentialPrimeCheck.max : threadEnd + chunk;
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
