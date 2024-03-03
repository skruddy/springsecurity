package com.example.demo.threads;

class Counter{
    int counter = 0;
    public void increment(){
        counter++;
    }
}

public class SynchronisedThreads {
    public static void main(String[] args) {
        Counter c = new Counter();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                c.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                c.increment();
            }
        });

        thread1.start();
        thread2.start();

        System.out.println(c.counter);
    }

}


