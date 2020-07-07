package com.zmt.exercise.proxy;

public class Main {
    public static void main(String[] args) {
        ICar car = new CarProxy(new BenzCar()).getProxy();
        car.buyCar();

    }
}
