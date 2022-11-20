package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static String [][] massive = new String [3][3];

    public static void fillMassive(){
        for (int i = 0; i < massive.length; i++) {
            for (int j = 0; j < massive[i].length; j++) {
                massive[i][j] = "?";

            }
        }
    }

    public static void main(String[] args) {
        fillMassive();
        System.out.println(Arrays.deepToString(massive));

        JFrame jFrame = new JFrame();
        jFrame.add((new Form()).getPanel1());
        jFrame.setSize(600, 600);
        jFrame.setDefaultCloseOperation(3);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);

        ScheduledExecutorService ex = Executors.newScheduledThreadPool(1);

        ex.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(Arrays.deepToString(massive));
            }
        }, 1L, 1L, TimeUnit.SECONDS);

    }

}
