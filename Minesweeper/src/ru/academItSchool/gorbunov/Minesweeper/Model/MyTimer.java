package ru.academItSchool.gorbunov.Minesweeper.Model;

import javax.swing.*;
import java.util.TimerTask;

public class MyTimer extends TimerTask {
    private int time;
    private JLabel jLabel;
    private boolean stop = false;

    public MyTimer() {
        this.time = 0;
    }

    public MyTimer(JLabel jLabel) {
        this.jLabel = jLabel;
        this.time = 1;
    }

    public int getTime() {
        return time;
    }

    public boolean stop() {
        return stop = true;
    }

    @Override
    public void run() {
        for (; time <= 9999 && !stop; time++) {
            try {
                if (jLabel != null) {
                    jLabel.setText(toString());
                }
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
        }
    }

    @Override
    public String toString() {
        return ((Integer) time).toString();
    }
}
