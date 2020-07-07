package com.zmt.exercise.proxy;

public class BenzCar implements ICar {

    @Override
    public void buyCar() {
        System.out.println("奔驰车预定一辆");
    }
}
