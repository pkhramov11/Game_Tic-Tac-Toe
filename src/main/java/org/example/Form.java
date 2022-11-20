package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static org.example.Main.fillMassive;
import static org.example.Main.massive;

public class Form {

    static int count = 0;
    static int count2 = 0;
    static Random random = new Random();


    public static void checkQuestions (){
        ArrayList <String> questions = new ArrayList<>();
        for (int i = 0; i < massive.length; i++) {
            for (int j = 0; j < massive[i].length; j++) {
                if(massive[i][j].equals("?")){
                    questions.add(massive[i][j]);
                }
            }
        }
        int counts = 0;
        for (String a:
                questions) {
            if(a.equals("?")){
                counts++;
            }
        }

        if(counts==0){
            fillMassive();
        }

    }


    public static void pcAnswer() {
        while (Main.massive[count][count2].equals("?")) {
            Random random1 = new Random();
            int t = random1.nextInt(3);
            int g = random1.nextInt(3);
            if ("?".equals(Main.massive[t][g])) {
                Main.massive[t][g] = "O";

            }
        }
    }


    private JPanel panel1;
    private JButton button_7;
    private JButton button_3;
    private JButton button_1;
    private JButton button_4;
    private JButton button_5;
    private JButton button_8;
    private JButton button_9;
    private JButton button_6;
    private JButton button_2;

    public static void checkWinner() {
        if (Main.massive[0][0].equals("X") && Main.massive[1][0].equals("X") && Main.massive[2][0].equals("X")) {
            JOptionPane.showMessageDialog(new Form().getPanel1(), "Вы выиграли!");
        }
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public Form() {

        checkWinner();
        button_1.setText(Main.massive[0][0]);
        button_2.setText(Main.massive[0][1]);
        button_3.setText(Main.massive[0][2]);
        button_4.setText(Main.massive[1][0]);
        button_5.setText(Main.massive[1][1]);
        button_6.setText(Main.massive[1][2]);
        button_7.setText(Main.massive[2][0]);
        button_8.setText(Main.massive[2][1]);
        button_9.setText(Main.massive[2][2]);

        ScheduledExecutorService ex = Executors.newScheduledThreadPool(1);

        ex.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                button_1.setText(Main.massive[0][0]);
                button_2.setText(Main.massive[0][1]);
                button_3.setText(Main.massive[0][2]);
                button_4.setText(Main.massive[1][0]);
                button_5.setText(Main.massive[1][1]);
                button_6.setText(Main.massive[1][2]);
                button_7.setText(Main.massive[2][0]);
                button_8.setText(Main.massive[2][1]);
                button_9.setText(Main.massive[2][2]);
            }
        }, 1L, 1L, TimeUnit.SECONDS);

        ScheduledExecutorService ex1 = Executors.newScheduledThreadPool(1);
        ex1.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Random random1 = new Random();
                count = random1.nextInt(3);
                count2 = random1.nextInt(3);

            }
        }, 1L, 1L, TimeUnit.SECONDS);

        button_1.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                boolean response = false;

                if(Main.massive[0][0].equals("O")){
                    JOptionPane.showMessageDialog(panel1, "Выберите свободную ячейку");
                }
                else{
                    button_1.setText("X");
                    Main.massive[0][0] = "X";

                    if (Main.massive[count][count2].equals("?")) {
                        Main.massive[count][count2] = "O";

                    } else if (Main.massive[count][count2].equals("?")) {
                        Main.massive[count][count2] = "O";
                    } else {

                        for (int i = 0; i < Main.massive.length; i++) {
                            for (int j = 0; j < Main.massive[i].length; j++) {
                                if (Main.massive[i][j].equals("?")) {
                                    Main.massive[i][j] = "O";
                                    i = Main.massive.length - 1;
                                    j = Main.massive[i].length - 1;
                                }
                            }
                        }
                    }

                    if ((Main.massive[0][0].equals("X") && Main.massive[1][0].equals("X") && Main.massive[2][0].equals("X")) ||
                            (Main.massive[0][1].equals("X") && Main.massive[1][1].equals("X") && Main.massive[2][1].equals("X")) ||
                            (Main.massive[0][2].equals("X") && Main.massive[1][2].equals("X") && Main.massive[2][2].equals("X"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы выиграли!");
                        fillMassive();
                        response = false;

                    }
                    if ((Main.massive[0][0].equals("X") && Main.massive[0][1].equals("X") && Main.massive[0][2].equals("X")) ||
                            (Main.massive[1][0].equals("X") && Main.massive[1][1].equals("X") && Main.massive[1][2].equals("X")) ||
                            (Main.massive[2][0].equals("X") && Main.massive[2][1].equals("X") && Main.massive[2][2].equals("X"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы выиграли!");
                        fillMassive();
                        response = false;

                    }
                    if ((Main.massive[0][0].equals("X") && Main.massive[1][1].equals("X") && Main.massive[2][2].equals("X")) ||
                            (Main.massive[0][2].equals("X") && Main.massive[1][1].equals("X") && Main.massive[2][0].equals("X"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы выиграли!");
                        fillMassive();
                        response = false;

                    }

                    if ((Main.massive[0][0].equals("O") && Main.massive[1][0].equals("O") && Main.massive[2][0].equals("O")) ||
                            (Main.massive[0][1].equals("O") && Main.massive[1][1].equals("O") && Main.massive[2][1].equals("O")) ||
                            (Main.massive[0][2].equals("O") && Main.massive[1][2].equals("O") && Main.massive[2][2].equals("O"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы проиграли!");
                        fillMassive();
                        response = false;

                    }
                    if ((Main.massive[0][0].equals("O") && Main.massive[0][1].equals("O") && Main.massive[0][2].equals("O")) ||
                            (Main.massive[1][0].equals("O") && Main.massive[1][1].equals("O") && Main.massive[1][2].equals("O")) ||
                            (Main.massive[2][0].equals("O") && Main.massive[2][1].equals("O") && Main.massive[2][2].equals("O"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы проиграли!");
                        fillMassive();
                        response = false;

                    }
                    if ((Main.massive[0][0].equals("O") && Main.massive[1][1].equals("O") && Main.massive[2][2].equals("O")) ||
                            (Main.massive[0][2].equals("O") && Main.massive[1][1].equals("O") && Main.massive[2][0].equals("O"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы проиграли!");
                        fillMassive();
                        response = false;

                    }
                    if(response) {

                        if (Main.massive[count][count2].equals("?")) {
                            Main.massive[count][count2] = "O";

                        } else if (Main.massive[count][count2].equals("?")) {
                            Main.massive[count][count2] = "O";
                        } else {

                            for (int i = 0; i < Main.massive.length; i++) {
                                for (int j = 0; j < Main.massive[i].length; j++) {
                                    if (Main.massive[i][j].equals("?")) {
                                        Main.massive[i][j] = "O";
                                        i = Main.massive.length - 1;
                                        j = Main.massive[i].length - 1;
                                    }
                                }
                            }
                        }
                    }
                }

            checkQuestions();
            }
        });

        button_2.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                boolean response = false;

                if(Main.massive[0][1].equals("O")){
                    JOptionPane.showMessageDialog(panel1, "Выберите свободную ячейку");
                }
                else{
                    button_2.setText("X");
                    Main.massive[0][1] = "X";

                    if (Main.massive[count][count2].equals("?")) {
                        Main.massive[count][count2] = "O";

                    } else if (Main.massive[count][count2].equals("?")) {
                        Main.massive[count][count2] = "O";
                    } else {

                        for (int i = 0; i < Main.massive.length; i++) {
                            for (int j = 0; j < Main.massive[i].length; j++) {
                                if (Main.massive[i][j].equals("?")) {
                                    Main.massive[i][j] = "O";
                                    i = Main.massive.length - 1;
                                    j = Main.massive[i].length - 1;
                                }
                            }
                        }
                    }

                    if ((Main.massive[0][0].equals("X") && Main.massive[1][0].equals("X") && Main.massive[2][0].equals("X")) ||
                            (Main.massive[0][1].equals("X") && Main.massive[1][1].equals("X") && Main.massive[2][1].equals("X")) ||
                            (Main.massive[0][2].equals("X") && Main.massive[1][2].equals("X") && Main.massive[2][2].equals("X"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы выиграли!");
                        fillMassive();
                        response = false;

                    }
                    if ((Main.massive[0][0].equals("X") && Main.massive[0][1].equals("X") && Main.massive[0][2].equals("X")) ||
                            (Main.massive[1][0].equals("X") && Main.massive[1][1].equals("X") && Main.massive[1][2].equals("X")) ||
                            (Main.massive[2][0].equals("X") && Main.massive[2][1].equals("X") && Main.massive[2][2].equals("X"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы выиграли!");
                        fillMassive();
                        response = false;

                    }
                    if ((Main.massive[0][0].equals("X") && Main.massive[1][1].equals("X") && Main.massive[2][2].equals("X")) ||
                            (Main.massive[0][2].equals("X") && Main.massive[1][1].equals("X") && Main.massive[2][0].equals("X"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы выиграли!");
                        fillMassive();
                        response = false;

                    }

                    if ((Main.massive[0][0].equals("O") && Main.massive[1][0].equals("O") && Main.massive[2][0].equals("O")) ||
                            (Main.massive[0][1].equals("O") && Main.massive[1][1].equals("O") && Main.massive[2][1].equals("O")) ||
                            (Main.massive[0][2].equals("O") && Main.massive[1][2].equals("O") && Main.massive[2][2].equals("O"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы проиграли!");
                        fillMassive();
                        response = false;

                    }
                    if ((Main.massive[0][0].equals("O") && Main.massive[0][1].equals("O") && Main.massive[0][2].equals("O")) ||
                            (Main.massive[1][0].equals("O") && Main.massive[1][1].equals("O") && Main.massive[1][2].equals("O")) ||
                            (Main.massive[2][0].equals("O") && Main.massive[2][1].equals("O") && Main.massive[2][2].equals("O"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы проиграли!");
                        fillMassive();
                        response = false;

                    }
                    if ((Main.massive[0][0].equals("O") && Main.massive[1][1].equals("O") && Main.massive[2][2].equals("O")) ||
                            (Main.massive[0][2].equals("O") && Main.massive[1][1].equals("O") && Main.massive[2][0].equals("O"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы проиграли!");
                        fillMassive();
                        response = false;

                    }
                    if(response) {

                        if (Main.massive[count][count2].equals("?")) {
                            Main.massive[count][count2] = "O";

                        } else if (Main.massive[count][count2].equals("?")) {
                            Main.massive[count][count2] = "O";
                        } else {

                            for (int i = 0; i < Main.massive.length; i++) {
                                for (int j = 0; j < Main.massive[i].length; j++) {
                                    if (Main.massive[i][j].equals("?")) {
                                        Main.massive[i][j] = "O";
                                        i = Main.massive.length - 1;
                                        j = Main.massive[i].length - 1;
                                    }
                                }
                            }
                        }
                    }
                }
            checkQuestions();
            }
        });

        button_3.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                boolean response = false;

                if(Main.massive[0][2].equals("O")){
                    JOptionPane.showMessageDialog(panel1, "Выберите свободную ячейку");
                }
                else{
                    button_3.setText("X");
                    Main.massive[0][2] = "X";

                    if (Main.massive[count][count2].equals("?")) {
                        Main.massive[count][count2] = "O";

                    } else if (Main.massive[count][count2].equals("?")) {
                        Main.massive[count][count2] = "O";
                    } else {

                        for (int i = 0; i < Main.massive.length; i++) {
                            for (int j = 0; j < Main.massive[i].length; j++) {
                                if (Main.massive[i][j].equals("?")) {
                                    Main.massive[i][j] = "O";
                                    i = Main.massive.length - 1;
                                    j = Main.massive[i].length - 1;
                                }
                            }
                        }
                    }

                    if ((Main.massive[0][0].equals("X") && Main.massive[1][0].equals("X") && Main.massive[2][0].equals("X")) ||
                            (Main.massive[0][1].equals("X") && Main.massive[1][1].equals("X") && Main.massive[2][1].equals("X")) ||
                            (Main.massive[0][2].equals("X") && Main.massive[1][2].equals("X") && Main.massive[2][2].equals("X"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы выиграли!");
                        fillMassive();
                        response = false;

                    }
                    if ((Main.massive[0][0].equals("X") && Main.massive[0][1].equals("X") && Main.massive[0][2].equals("X")) ||
                            (Main.massive[1][0].equals("X") && Main.massive[1][1].equals("X") && Main.massive[1][2].equals("X")) ||
                            (Main.massive[2][0].equals("X") && Main.massive[2][1].equals("X") && Main.massive[2][2].equals("X"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы выиграли!");
                        fillMassive();
                        response = false;

                    }
                    if ((Main.massive[0][0].equals("X") && Main.massive[1][1].equals("X") && Main.massive[2][2].equals("X")) ||
                            (Main.massive[0][2].equals("X") && Main.massive[1][1].equals("X") && Main.massive[2][0].equals("X"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы выиграли!");
                        fillMassive();
                        response = false;

                    }

                    if ((Main.massive[0][0].equals("O") && Main.massive[1][0].equals("O") && Main.massive[2][0].equals("O")) ||
                            (Main.massive[0][1].equals("O") && Main.massive[1][1].equals("O") && Main.massive[2][1].equals("O")) ||
                            (Main.massive[0][2].equals("O") && Main.massive[1][2].equals("O") && Main.massive[2][2].equals("O"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы проиграли!");
                        fillMassive();
                        response = false;

                    }
                    if ((Main.massive[0][0].equals("O") && Main.massive[0][1].equals("O") && Main.massive[0][2].equals("O")) ||
                            (Main.massive[1][0].equals("O") && Main.massive[1][1].equals("O") && Main.massive[1][2].equals("O")) ||
                            (Main.massive[2][0].equals("O") && Main.massive[2][1].equals("O") && Main.massive[2][2].equals("O"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы проиграли!");
                        fillMassive();
                        response = false;

                    }
                    if ((Main.massive[0][0].equals("O") && Main.massive[1][1].equals("O") && Main.massive[2][2].equals("O")) ||
                            (Main.massive[0][2].equals("O") && Main.massive[1][1].equals("O") && Main.massive[2][0].equals("O"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы проиграли!");
                        fillMassive();
                        response = false;

                    }
                    if(response) {

                        if (Main.massive[count][count2].equals("?")) {
                            Main.massive[count][count2] = "O";

                        } else if (Main.massive[count][count2].equals("?")) {
                            Main.massive[count][count2] = "O";
                        } else {

                            for (int i = 0; i < Main.massive.length; i++) {
                                for (int j = 0; j < Main.massive[i].length; j++) {
                                    if (Main.massive[i][j].equals("?")) {
                                        Main.massive[i][j] = "O";
                                        i = Main.massive.length - 1;
                                        j = Main.massive[i].length - 1;
                                    }
                                }
                            }
                        }
                    }
                }
                checkQuestions();
            }
        });

        button_4.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                boolean response = false;

                if(Main.massive[1][0].equals("O")){
                    JOptionPane.showMessageDialog(panel1, "Выберите свободную ячейку");
                }
                else{
                    button_4.setText("X");
                    Main.massive[1][0] = "X";

                    if (Main.massive[count][count2].equals("?")) {
                        Main.massive[count][count2] = "O";

                    } else if (Main.massive[count][count2].equals("?")) {
                        Main.massive[count][count2] = "O";
                    } else {

                        for (int i = 0; i < Main.massive.length; i++) {
                            for (int j = 0; j < Main.massive[i].length; j++) {
                                if (Main.massive[i][j].equals("?")) {
                                    Main.massive[i][j] = "O";
                                    i = Main.massive.length - 1;
                                    j = Main.massive[i].length - 1;
                                }
                            }
                        }
                    }

                    if ((Main.massive[0][0].equals("X") && Main.massive[1][0].equals("X") && Main.massive[2][0].equals("X")) ||
                            (Main.massive[0][1].equals("X") && Main.massive[1][1].equals("X") && Main.massive[2][1].equals("X")) ||
                            (Main.massive[0][2].equals("X") && Main.massive[1][2].equals("X") && Main.massive[2][2].equals("X"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы выиграли!");
                        fillMassive();
                        response = false;

                    }
                    if ((Main.massive[0][0].equals("X") && Main.massive[0][1].equals("X") && Main.massive[0][2].equals("X")) ||
                            (Main.massive[1][0].equals("X") && Main.massive[1][1].equals("X") && Main.massive[1][2].equals("X")) ||
                            (Main.massive[2][0].equals("X") && Main.massive[2][1].equals("X") && Main.massive[2][2].equals("X"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы выиграли!");
                        fillMassive();
                        response = false;

                    }
                    if ((Main.massive[0][0].equals("X") && Main.massive[1][1].equals("X") && Main.massive[2][2].equals("X")) ||
                            (Main.massive[0][2].equals("X") && Main.massive[1][1].equals("X") && Main.massive[2][0].equals("X"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы выиграли!");
                        fillMassive();
                        response = false;

                    }

                    if ((Main.massive[0][0].equals("O") && Main.massive[1][0].equals("O") && Main.massive[2][0].equals("O")) ||
                            (Main.massive[0][1].equals("O") && Main.massive[1][1].equals("O") && Main.massive[2][1].equals("O")) ||
                            (Main.massive[0][2].equals("O") && Main.massive[1][2].equals("O") && Main.massive[2][2].equals("O"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы проиграли!");
                        fillMassive();
                        response = false;

                    }
                    if ((Main.massive[0][0].equals("O") && Main.massive[0][1].equals("O") && Main.massive[0][2].equals("O")) ||
                            (Main.massive[1][0].equals("O") && Main.massive[1][1].equals("O") && Main.massive[1][2].equals("O")) ||
                            (Main.massive[2][0].equals("O") && Main.massive[2][1].equals("O") && Main.massive[2][2].equals("O"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы проиграли!");
                        fillMassive();
                        response = false;

                    }
                    if ((Main.massive[0][0].equals("O") && Main.massive[1][1].equals("O") && Main.massive[2][2].equals("O")) ||
                            (Main.massive[0][2].equals("O") && Main.massive[1][1].equals("O") && Main.massive[2][0].equals("O"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы проиграли!");
                        fillMassive();
                        response = false;

                    }
                    if(response) {

                        if (Main.massive[count][count2].equals("?")) {
                            Main.massive[count][count2] = "O";

                        } else if (Main.massive[count][count2].equals("?")) {
                            Main.massive[count][count2] = "O";
                        } else {

                            for (int i = 0; i < Main.massive.length; i++) {
                                for (int j = 0; j < Main.massive[i].length; j++) {
                                    if (Main.massive[i][j].equals("?")) {
                                        Main.massive[i][j] = "O";
                                        i = Main.massive.length - 1;
                                        j = Main.massive[i].length - 1;
                                    }
                                }
                            }
                        }
                    }
                }
                checkQuestions();
            }
        });

        button_5.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                boolean response = false;

                if(Main.massive[1][1].equals("O")){
                    JOptionPane.showMessageDialog(panel1, "Выберите свободную ячейку");
                }
                else{
                    button_5.setText("X");
                    Main.massive[1][1] = "X";

                    if (Main.massive[count][count2].equals("?")) {
                        Main.massive[count][count2] = "O";

                    } else if (Main.massive[count][count2].equals("?")) {
                        Main.massive[count][count2] = "O";
                    } else {

                        for (int i = 0; i < Main.massive.length; i++) {
                            for (int j = 0; j < Main.massive[i].length; j++) {
                                if (Main.massive[i][j].equals("?")) {
                                    Main.massive[i][j] = "O";
                                    i = Main.massive.length - 1;
                                    j = Main.massive[i].length - 1;
                                }
                            }
                        }
                    }

                    if ((Main.massive[0][0].equals("X") && Main.massive[1][0].equals("X") && Main.massive[2][0].equals("X")) ||
                            (Main.massive[0][1].equals("X") && Main.massive[1][1].equals("X") && Main.massive[2][1].equals("X")) ||
                            (Main.massive[0][2].equals("X") && Main.massive[1][2].equals("X") && Main.massive[2][2].equals("X"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы выиграли!");
                        fillMassive();
                        response = false;

                    }
                    if ((Main.massive[0][0].equals("X") && Main.massive[0][1].equals("X") && Main.massive[0][2].equals("X")) ||
                            (Main.massive[1][0].equals("X") && Main.massive[1][1].equals("X") && Main.massive[1][2].equals("X")) ||
                            (Main.massive[2][0].equals("X") && Main.massive[2][1].equals("X") && Main.massive[2][2].equals("X"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы выиграли!");
                        fillMassive();
                        response = false;

                    }
                    if ((Main.massive[0][0].equals("X") && Main.massive[1][1].equals("X") && Main.massive[2][2].equals("X")) ||
                            (Main.massive[0][2].equals("X") && Main.massive[1][1].equals("X") && Main.massive[2][0].equals("X"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы выиграли!");
                        fillMassive();
                        response = false;

                    }

                    if ((Main.massive[0][0].equals("O") && Main.massive[1][0].equals("O") && Main.massive[2][0].equals("O")) ||
                            (Main.massive[0][1].equals("O") && Main.massive[1][1].equals("O") && Main.massive[2][1].equals("O")) ||
                            (Main.massive[0][2].equals("O") && Main.massive[1][2].equals("O") && Main.massive[2][2].equals("O"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы проиграли!");
                        fillMassive();
                        response = false;

                    }
                    if ((Main.massive[0][0].equals("O") && Main.massive[0][1].equals("O") && Main.massive[0][2].equals("O")) ||
                            (Main.massive[1][0].equals("O") && Main.massive[1][1].equals("O") && Main.massive[1][2].equals("O")) ||
                            (Main.massive[2][0].equals("O") && Main.massive[2][1].equals("O") && Main.massive[2][2].equals("O"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы проиграли!");
                        fillMassive();
                        response = false;

                    }
                    if ((Main.massive[0][0].equals("O") && Main.massive[1][1].equals("O") && Main.massive[2][2].equals("O")) ||
                            (Main.massive[0][2].equals("O") && Main.massive[1][1].equals("O") && Main.massive[2][0].equals("O"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы проиграли!");
                        fillMassive();
                        response = false;

                    }
                    if(response) {

                        if (Main.massive[count][count2].equals("?")) {
                            Main.massive[count][count2] = "O";

                        } else if (Main.massive[count][count2].equals("?")) {
                            Main.massive[count][count2] = "O";
                        } else {

                            for (int i = 0; i < Main.massive.length; i++) {
                                for (int j = 0; j < Main.massive[i].length; j++) {
                                    if (Main.massive[i][j].equals("?")) {
                                        Main.massive[i][j] = "O";
                                        i = Main.massive.length - 1;
                                        j = Main.massive[i].length - 1;
                                    }
                                }
                            }
                        }
                    }
                }
                checkQuestions();
            }
        });

        button_6.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                boolean response = false;

                if(Main.massive[1][2].equals("O")){
                    JOptionPane.showMessageDialog(panel1, "Выберите свободную ячейку");
                }
                else{
                    button_6.setText("X");
                    Main.massive[1][2] = "X";

                    if (Main.massive[count][count2].equals("?")) {
                        Main.massive[count][count2] = "O";

                    } else if (Main.massive[count][count2].equals("?")) {
                        Main.massive[count][count2] = "O";
                    } else {

                        for (int i = 0; i < Main.massive.length; i++) {
                            for (int j = 0; j < Main.massive[i].length; j++) {
                                if (Main.massive[i][j].equals("?")) {
                                    Main.massive[i][j] = "O";
                                    i = Main.massive.length - 1;
                                    j = Main.massive[i].length - 1;
                                }
                            }
                        }
                    }

                    if ((Main.massive[0][0].equals("X") && Main.massive[1][0].equals("X") && Main.massive[2][0].equals("X")) ||
                            (Main.massive[0][1].equals("X") && Main.massive[1][1].equals("X") && Main.massive[2][1].equals("X")) ||
                            (Main.massive[0][2].equals("X") && Main.massive[1][2].equals("X") && Main.massive[2][2].equals("X"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы выиграли!");
                        fillMassive();
                        response = false;

                    }
                    if ((Main.massive[0][0].equals("X") && Main.massive[0][1].equals("X") && Main.massive[0][2].equals("X")) ||
                            (Main.massive[1][0].equals("X") && Main.massive[1][1].equals("X") && Main.massive[1][2].equals("X")) ||
                            (Main.massive[2][0].equals("X") && Main.massive[2][1].equals("X") && Main.massive[2][2].equals("X"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы выиграли!");
                        fillMassive();
                        response = false;

                    }
                    if ((Main.massive[0][0].equals("X") && Main.massive[1][1].equals("X") && Main.massive[2][2].equals("X")) ||
                            (Main.massive[0][2].equals("X") && Main.massive[1][1].equals("X") && Main.massive[2][0].equals("X"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы выиграли!");
                        fillMassive();
                        response = false;

                    }

                    if ((Main.massive[0][0].equals("O") && Main.massive[1][0].equals("O") && Main.massive[2][0].equals("O")) ||
                            (Main.massive[0][1].equals("O") && Main.massive[1][1].equals("O") && Main.massive[2][1].equals("O")) ||
                            (Main.massive[0][2].equals("O") && Main.massive[1][2].equals("O") && Main.massive[2][2].equals("O"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы проиграли!");
                        fillMassive();
                        response = false;

                    }
                    if ((Main.massive[0][0].equals("O") && Main.massive[0][1].equals("O") && Main.massive[0][2].equals("O")) ||
                            (Main.massive[1][0].equals("O") && Main.massive[1][1].equals("O") && Main.massive[1][2].equals("O")) ||
                            (Main.massive[2][0].equals("O") && Main.massive[2][1].equals("O") && Main.massive[2][2].equals("O"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы проиграли!");
                        fillMassive();
                        response = false;

                    }
                    if ((Main.massive[0][0].equals("O") && Main.massive[1][1].equals("O") && Main.massive[2][2].equals("O")) ||
                            (Main.massive[0][2].equals("O") && Main.massive[1][1].equals("O") && Main.massive[2][0].equals("O"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы проиграли!");
                        fillMassive();
                        response = false;

                    }
                    if(response) {

                        if (Main.massive[count][count2].equals("?")) {
                            Main.massive[count][count2] = "O";

                        } else if (Main.massive[count][count2].equals("?")) {
                            Main.massive[count][count2] = "O";
                        } else {

                            for (int i = 0; i < Main.massive.length; i++) {
                                for (int j = 0; j < Main.massive[i].length; j++) {
                                    if (Main.massive[i][j].equals("?")) {
                                        Main.massive[i][j] = "O";
                                        i = Main.massive.length - 1;
                                        j = Main.massive[i].length - 1;
                                    }
                                }
                            }
                        }
                    }
                }
                checkQuestions();
            }
        });

        button_7.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                boolean response = false;

                if(Main.massive[2][0].equals("O")){
                    JOptionPane.showMessageDialog(panel1, "Выберите свободную ячейку");
                }
                else{
                    button_7.setText("X");
                    Main.massive[2][0] = "X";

                    if (Main.massive[count][count2].equals("?")) {
                        Main.massive[count][count2] = "O";

                    } else if (Main.massive[count][count2].equals("?")) {
                        Main.massive[count][count2] = "O";
                    } else {

                        for (int i = 0; i < Main.massive.length; i++) {
                            for (int j = 0; j < Main.massive[i].length; j++) {
                                if (Main.massive[i][j].equals("?")) {
                                    Main.massive[i][j] = "O";
                                    i = Main.massive.length - 1;
                                    j = Main.massive[i].length - 1;
                                }
                            }
                        }
                    }

                    if ((Main.massive[0][0].equals("X") && Main.massive[1][0].equals("X") && Main.massive[2][0].equals("X")) ||
                            (Main.massive[0][1].equals("X") && Main.massive[1][1].equals("X") && Main.massive[2][1].equals("X")) ||
                            (Main.massive[0][2].equals("X") && Main.massive[1][2].equals("X") && Main.massive[2][2].equals("X"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы выиграли!");
                        fillMassive();
                        response = false;

                    }
                    if ((Main.massive[0][0].equals("X") && Main.massive[0][1].equals("X") && Main.massive[0][2].equals("X")) ||
                            (Main.massive[1][0].equals("X") && Main.massive[1][1].equals("X") && Main.massive[1][2].equals("X")) ||
                            (Main.massive[2][0].equals("X") && Main.massive[2][1].equals("X") && Main.massive[2][2].equals("X"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы выиграли!");
                        fillMassive();
                        response = false;

                    }
                    if ((Main.massive[0][0].equals("X") && Main.massive[1][1].equals("X") && Main.massive[2][2].equals("X")) ||
                            (Main.massive[0][2].equals("X") && Main.massive[1][1].equals("X") && Main.massive[2][0].equals("X"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы выиграли!");
                        fillMassive();
                        response = false;

                    }

                    if ((Main.massive[0][0].equals("O") && Main.massive[1][0].equals("O") && Main.massive[2][0].equals("O")) ||
                            (Main.massive[0][1].equals("O") && Main.massive[1][1].equals("O") && Main.massive[2][1].equals("O")) ||
                            (Main.massive[0][2].equals("O") && Main.massive[1][2].equals("O") && Main.massive[2][2].equals("O"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы проиграли!");
                        fillMassive();
                        response = false;

                    }
                    if ((Main.massive[0][0].equals("O") && Main.massive[0][1].equals("O") && Main.massive[0][2].equals("O")) ||
                            (Main.massive[1][0].equals("O") && Main.massive[1][1].equals("O") && Main.massive[1][2].equals("O")) ||
                            (Main.massive[2][0].equals("O") && Main.massive[2][1].equals("O") && Main.massive[2][2].equals("O"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы проиграли!");
                        fillMassive();
                        response = false;

                    }
                    if ((Main.massive[0][0].equals("O") && Main.massive[1][1].equals("O") && Main.massive[2][2].equals("O")) ||
                            (Main.massive[0][2].equals("O") && Main.massive[1][1].equals("O") && Main.massive[2][0].equals("O"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы проиграли!");
                        fillMassive();
                        response = false;

                    }
                    if(response) {

                        if (Main.massive[count][count2].equals("?")) {
                            Main.massive[count][count2] = "O";

                        } else if (Main.massive[count][count2].equals("?")) {
                            Main.massive[count][count2] = "O";
                        } else {

                            for (int i = 0; i < Main.massive.length; i++) {
                                for (int j = 0; j < Main.massive[i].length; j++) {
                                    if (Main.massive[i][j].equals("?")) {
                                        Main.massive[i][j] = "O";
                                        i = Main.massive.length - 1;
                                        j = Main.massive[i].length - 1;
                                    }
                                }
                            }
                        }
                    }
                }
                checkQuestions();
            }
        });

        button_8.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                boolean response = false;

                if(Main.massive[2][1].equals("O")){
                    JOptionPane.showMessageDialog(panel1, "Выберите свободную ячейку");
                }
                else{
                    button_8.setText("X");
                    Main.massive[2][1] = "X";

                    if (Main.massive[count][count2].equals("?")) {
                        Main.massive[count][count2] = "O";

                    } else if (Main.massive[count][count2].equals("?")) {
                        Main.massive[count][count2] = "O";
                    } else {

                        for (int i = 0; i < Main.massive.length; i++) {
                            for (int j = 0; j < Main.massive[i].length; j++) {
                                if (Main.massive[i][j].equals("?")) {
                                    Main.massive[i][j] = "O";
                                    i = Main.massive.length - 1;
                                    j = Main.massive[i].length - 1;
                                }
                            }
                        }
                    }

                    if ((Main.massive[0][0].equals("X") && Main.massive[1][0].equals("X") && Main.massive[2][0].equals("X")) ||
                            (Main.massive[0][1].equals("X") && Main.massive[1][1].equals("X") && Main.massive[2][1].equals("X")) ||
                            (Main.massive[0][2].equals("X") && Main.massive[1][2].equals("X") && Main.massive[2][2].equals("X"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы выиграли!");
                        fillMassive();
                        response = false;

                    }
                    if ((Main.massive[0][0].equals("X") && Main.massive[0][1].equals("X") && Main.massive[0][2].equals("X")) ||
                            (Main.massive[1][0].equals("X") && Main.massive[1][1].equals("X") && Main.massive[1][2].equals("X")) ||
                            (Main.massive[2][0].equals("X") && Main.massive[2][1].equals("X") && Main.massive[2][2].equals("X"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы выиграли!");
                        fillMassive();
                        response = false;

                    }
                    if ((Main.massive[0][0].equals("X") && Main.massive[1][1].equals("X") && Main.massive[2][2].equals("X")) ||
                            (Main.massive[0][2].equals("X") && Main.massive[1][1].equals("X") && Main.massive[2][0].equals("X"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы выиграли!");
                        fillMassive();
                        response = false;

                    }

                    if ((Main.massive[0][0].equals("O") && Main.massive[1][0].equals("O") && Main.massive[2][0].equals("O")) ||
                            (Main.massive[0][1].equals("O") && Main.massive[1][1].equals("O") && Main.massive[2][1].equals("O")) ||
                            (Main.massive[0][2].equals("O") && Main.massive[1][2].equals("O") && Main.massive[2][2].equals("O"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы проиграли!");
                        fillMassive();
                        response = false;

                    }
                    if ((Main.massive[0][0].equals("O") && Main.massive[0][1].equals("O") && Main.massive[0][2].equals("O")) ||
                            (Main.massive[1][0].equals("O") && Main.massive[1][1].equals("O") && Main.massive[1][2].equals("O")) ||
                            (Main.massive[2][0].equals("O") && Main.massive[2][1].equals("O") && Main.massive[2][2].equals("O"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы проиграли!");
                        fillMassive();
                        response = false;

                    }
                    if ((Main.massive[0][0].equals("O") && Main.massive[1][1].equals("O") && Main.massive[2][2].equals("O")) ||
                            (Main.massive[0][2].equals("O") && Main.massive[1][1].equals("O") && Main.massive[2][0].equals("O"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы проиграли!");
                        fillMassive();
                        response = false;

                    }
                    if(response) {

                        if (Main.massive[count][count2].equals("?")) {
                            Main.massive[count][count2] = "O";

                        } else if (Main.massive[count][count2].equals("?")) {
                            Main.massive[count][count2] = "O";
                        } else {

                            for (int i = 0; i < Main.massive.length; i++) {
                                for (int j = 0; j < Main.massive[i].length; j++) {
                                    if (Main.massive[i][j].equals("?")) {
                                        Main.massive[i][j] = "O";
                                        i = Main.massive.length - 1;
                                        j = Main.massive[i].length - 1;
                                    }
                                }
                            }
                        }
                    }
                }
                checkQuestions();
            }
        });

        button_9.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                boolean response = false;

                if(Main.massive[2][2].equals("O")){
                    JOptionPane.showMessageDialog(panel1, "Выберите свободную ячейку");
                }
                else{
                    button_9.setText("X");
                    Main.massive[2][2] = "X";

                    if (Main.massive[count][count2].equals("?")) {
                        Main.massive[count][count2] = "O";

                    } else if (Main.massive[count][count2].equals("?")) {
                        Main.massive[count][count2] = "O";
                    } else {

                        for (int i = 0; i < Main.massive.length; i++) {
                            for (int j = 0; j < Main.massive[i].length; j++) {
                                if (Main.massive[i][j].equals("?")) {
                                    Main.massive[i][j] = "O";
                                    i = Main.massive.length - 1;
                                    j = Main.massive[i].length - 1;
                                }
                            }
                        }
                    }


                    if ((Main.massive[0][0].equals("X") && Main.massive[1][0].equals("X") && Main.massive[2][0].equals("X")) ||
                            (Main.massive[0][1].equals("X") && Main.massive[1][1].equals("X") && Main.massive[2][1].equals("X")) ||
                            (Main.massive[0][2].equals("X") && Main.massive[1][2].equals("X") && Main.massive[2][2].equals("X"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы выиграли!");
                        fillMassive();
                        response = false;

                    }
                    if ((Main.massive[0][0].equals("X") && Main.massive[0][1].equals("X") && Main.massive[0][2].equals("X")) ||
                            (Main.massive[1][0].equals("X") && Main.massive[1][1].equals("X") && Main.massive[1][2].equals("X")) ||
                            (Main.massive[2][0].equals("X") && Main.massive[2][1].equals("X") && Main.massive[2][2].equals("X"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы выиграли!");
                        fillMassive();
                        response = false;

                    }
                    if ((Main.massive[0][0].equals("X") && Main.massive[1][1].equals("X") && Main.massive[2][2].equals("X")) ||
                            (Main.massive[0][2].equals("X") && Main.massive[1][1].equals("X") && Main.massive[2][0].equals("X"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы выиграли!");
                        fillMassive();
                        response = false;

                    }

                    if ((Main.massive[0][0].equals("O") && Main.massive[1][0].equals("O") && Main.massive[2][0].equals("O")) ||
                            (Main.massive[0][1].equals("O") && Main.massive[1][1].equals("O") && Main.massive[2][1].equals("O")) ||
                            (Main.massive[0][2].equals("O") && Main.massive[1][2].equals("O") && Main.massive[2][2].equals("O"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы проиграли!");
                        fillMassive();
                        response = false;

                    }
                    if ((Main.massive[0][0].equals("O") && Main.massive[0][1].equals("O") && Main.massive[0][2].equals("O")) ||
                            (Main.massive[1][0].equals("O") && Main.massive[1][1].equals("O") && Main.massive[1][2].equals("O")) ||
                            (Main.massive[2][0].equals("O") && Main.massive[2][1].equals("O") && Main.massive[2][2].equals("O"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы проиграли!");
                        fillMassive();
                        response = false;

                    }
                    if ((Main.massive[0][0].equals("O") && Main.massive[1][1].equals("O") && Main.massive[2][2].equals("O")) ||
                            (Main.massive[0][2].equals("O") && Main.massive[1][1].equals("O") && Main.massive[2][0].equals("O"))) {
                        JOptionPane.showMessageDialog(panel1, "Вы проиграли!");
                        fillMassive();
                        response = false;

                        //   00  10  20
                        //   01  11  21
                        //   02  12  22
                    }
                    if(response) {

                        if (Main.massive[count][count2].equals("?")) {
                            Main.massive[count][count2] = "O";

                        } else if (Main.massive[count][count2].equals("?")) {
                            Main.massive[count][count2] = "O";
                        } else {

                            for (int i = 0; i < Main.massive.length; i++) {
                                for (int j = 0; j < Main.massive[i].length; j++) {
                                    if (Main.massive[i][j].equals("?")) {
                                        Main.massive[i][j] = "O";
                                        i = Main.massive.length - 1;
                                        j = Main.massive[i].length - 1;
                                    }
                                }
                            }
                        }
                    }
                }

                checkQuestions();
            }

            //   00  10  20
            //   01  11  21
            //   02  12  22
        });
    }
}
