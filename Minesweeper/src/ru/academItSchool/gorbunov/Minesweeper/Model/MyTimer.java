package ru.academItSchool.gorbunov.Minesweeper.Model;

import javax.swing.*;
import java.util.TimerTask;

public class MyTimer extends TimerTask {
    private int time = 0;
    private JLabel jLabel;
    public MyTimer(){ }

    public MyTimer(JLabel jLabel){
        this.jLabel = jLabel;
    }

    public int getTime() {
        return time;
    }

    private JLabel setTimeInLabel(){
        jLabel.setText(toString());
        return jLabel;
    }
    @Override
    public void run() {
        for (; time <= 9999; time++) {
            try {
                setTimeInLabel();
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
        }
    }

    @Override
    public String toString() {
        return ((Integer)time).toString();
    }
}
