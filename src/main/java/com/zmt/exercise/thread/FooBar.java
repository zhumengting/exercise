package com.zmt.exercise.thread;

import java.util.concurrent.Semaphore;

class FooBar {
    private int n;
    private static Semaphore semaphore_foo = new Semaphore(1);
    private static Semaphore semaphore_bar = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            semaphore_foo.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            semaphore_bar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            semaphore_bar.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            semaphore_foo.release();
        }
    }
}
