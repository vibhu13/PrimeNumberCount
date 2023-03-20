package org.example.fair;

import org.example.sequential.SequentialPrimeCheck;

import java.util.concurrent.atomic.AtomicLong;

public class CountPrimeTaskV2 implements Runnable {

    public static AtomicLong totalPrimeCount = new AtomicLong(0);
    public static AtomicLong currentNumber = new AtomicLong(2);


    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        doCheckAndIncrement();
        long endTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + " " + (endTime - startTime) + " ms" + " " + (endTime - startTime)/1000.0 + " seconds");
    }

    // This checks the number prime or not and add it to total
    private void doCheckAndIncrement(){
        while(true){
            long x  = currentNumber.getAndIncrement();
            if(x > SequentialPrimeCheck.max)
                break;
            else if(checkPrime(x))
            {
                totalPrimeCount.getAndIncrement();
            }
        }
    }

    private boolean checkPrime(long x){
        for(long i=2; i<=Math.sqrt(x); i++){
            if(x%i == 0)
                return false;
        }
        return true;
    }
}
