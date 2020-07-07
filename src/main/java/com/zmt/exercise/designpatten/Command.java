package com.zmt.exercise.designpatten;

public class Command {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyThread());
        thread.start();
    }
}
