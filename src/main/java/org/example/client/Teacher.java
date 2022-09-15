package org.example.client;

import javafx.util.Callback;

import java.util.ArrayList;
import java.util.List;

/**
 * Teacher
 */
public class Teacher implements Callback<List<String>,Object> {

    private Student student;

    public Teacher(Student student) {
        this.student = student;
    }

    public void question() {
        System.out.println("布置课后作业");
        new Thread(() -> student.answer(this)).start();
//        student.answer(this);
        System.out.println("下课");
    }

    @Override
    public Object call(List<String> param) {
        ArrayList<String> strings;
        if (param instanceof ArrayList<?>) {
            strings = (ArrayList<String>) param;
            for (String name : strings) {
                System.out.println(name);
            }
        }
        return null;
    }

}
