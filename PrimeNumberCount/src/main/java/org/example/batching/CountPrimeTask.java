package org.example.batching;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class CountPrimeTask implements Runnable {
    private long start;
    private long end;

    public static AtomicLong totalPrimeCount = new AtomicLong();

    public CountPrimeTask(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        batchCheck();
        long endTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + " " + (endTime - startTime) + " ms" + " " + (endTime - startTime)/1000.0 + " seconds");
    }

    private void batchCheck(){
        long primeCount = 0;
        for (long i = start; i <= end; i++) {
            if (checkPrime(i)) {
                primeCount++;
            }
        }
      totalPrimeCount.set(totalPrimeCount.get()+primeCount);
    }

    private boolean checkPrime(long x){
        for(long i=2; i<=Math.sqrt(x); i++){
            if(x%i == 0)
                return false;
        }
        return true;
    }
}
