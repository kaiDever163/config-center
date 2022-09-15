package org.example.interfaceTest;

public class ClassB implements FunctionInter {
    @Override
    public void say() {
        System.out.println("我是classb说话");
    }

    @Override
    public void dance() {
        System.out.println("我是classb我会跳舞");
    }
}
