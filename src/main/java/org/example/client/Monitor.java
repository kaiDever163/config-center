package org.example.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Monitor implements ActionListener {
    private static Student student;

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("hello");
    }

}
