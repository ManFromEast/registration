package com.prime;

import java.util.concurrent.CountDownLatch;

public class SumPrime {
// simple approach to get the summary of prime which less than 10
    // if process amount of prime, we can choose ForkJoin to get the summary
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(1);
        final Service service = new Service(latch);
        Thread t1 = new Thread() {
            @Override
            public void run() {
                service.exec();
            }
        };
        t1.start();

        Thread t2 = new Thread() {
            @Override
            public void run() {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread t2 print all the process was done");
            }
        };
        t2.start();
    }

}

class Service {
    private CountDownLatch latch;

    private static volatile int i = 1;
    private final static int THRESHOLD = 10;
    private static volatile int sum = 0;
    public Service(CountDownLatch latch) {
        this.latch = latch;
    }

    public void exec() {
        try {
            while (i <= THRESHOLD) {
                if(isPrime(i)){
                    sum += i;
                }
                i++;
            }
            System.out.println("Thread t1 get the summary of prime which less than 10 is : " + sum);
        } finally {
            latch.countDown();
        }
    }

    public static boolean isPrime(int n) {
        if (n == 2) {
            return true;
        }
        if (n < 2 || n % 2 == 0) {
            return false;
        }
        for (int i = 3, limit = (int) Math.sqrt(n); i <= limit; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
