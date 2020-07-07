package com.zmt.exercise.designpatten;

public class MyThread implements Runnable{
    @Override
    public void run() {
        MyObject myObject = new MyObject();
        myObject.doSomething();
    }
}
