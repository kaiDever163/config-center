package org.example.pojo;

public class UnlucklyDuck extends Duck {
    @ParamName(value = "1")
    private String name;
    @Override
    void swim() {
        System.out.println("丑小鸭在游泳！！！！");
    }

    @Override
    @ParamName(value = "1")
    void display() {
        System.out.println("丑小鸭长的很丑！！！！");
    }

}
