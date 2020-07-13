package com.zmt.exercise;

import com.zmt.exercise.leetcode.LRUCache;

import java.awt.*;
import java.util.logging.Formatter;
import java.util.logging.XMLFormatter;

/**
 * Hello world!
 */
public class App {
    static class A{
        protected void t(){
            System.out.println("a");
        }
    }
    static class B extends A{
        public void t(){
            System.out.println("b");
        }
    }
    public static void main(String[] args) {
        B b = new B();
        b.t();
    }



}
