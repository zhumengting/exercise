package com.zmt.exercise.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintSequence {
    static Lock lock = new ReentrantLock();
    static Condition old = lock.newCondition();
    static Condition single = lock.newCondition();
    static int val = 1;

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    while (true) {
                        System.out.println("t1: " + val++);
                        old.signal();
                        single.await();

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    while (true) {
                        System.out.println("t2: " + val++);
                        single.signal();
                        old.await();

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            }
        });
        t1.start();
        t2.start();
    }
}
