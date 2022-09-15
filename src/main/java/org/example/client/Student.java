package org.example.client;

import javafx.util.Callback;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Student
 */
public class Student {

    public void answer(Callback callback){
        try {
            TimeUnit.SECONDS.sleep(3);
            ArrayList<String> list = new ArrayList<>();
            list.add("fankai");
            list.add("liuxu");
            list.add("xiaoming");
            callback.call(list);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

