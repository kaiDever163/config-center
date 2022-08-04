package org.example.pojo;

public class CannotFly implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("我不会飞");
    }
}
