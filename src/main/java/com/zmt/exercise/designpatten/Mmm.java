package com.zmt.exercise.designpatten;

public class Mmm {
    private String food;
    private String drink;
    private int total_cost;

    public static class Builder {
        private final int total_cost;

        private String food;
        private String drink;

        public Builder(int cost) {
            this.total_cost = cost;
        }

        public Builder food(String val) {
            food = val;

            return this;
        }

        public Builder drink(String val) {
            drink = val;

            return this;
        }

        public Mmm build() {
            System.out.println("select food:" + food);
            System.out.println("select drink:" + drink);
            System.out.println("total cost:" + total_cost);
            return new Mmm(this);
        }
    }

    private Mmm(Builder builder) {
        total_cost = builder.total_cost;
        food = builder.food;
        drink = builder.drink;
    }

    public static void main(String[] args) {
        Mmm cocaCola = new Builder(12).drink("冰淇淋").food("鸡块").build();
    }

}
