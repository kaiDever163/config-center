package org.example.pojo;

public class CanFly implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("我会飞！！！！！");
    }
}
