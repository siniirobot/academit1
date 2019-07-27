package ru.academItSchool.gorbunov.Minesweeper.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.academItSchool.gorbunov.Minesweeper.Model.MyTimer;

import java.util.Timer;

public class MyTimerTest {
    @DataProvider(name = "getTime")
    public Object[][] create() {
        return new Object[][]{
                new Object[]{10}
        };
    }

    @Test
    public void testGetTime() throws InterruptedException {
        MyTimer myTimer = new MyTimer();
        Timer timer = new Timer();
        timer.schedule(myTimer,0);
        System.out.println(myTimer.getTime());
        Thread.sleep(5000);
        System.out.println(myTimer.getTime());
        Thread.sleep(10000);
        System.out.println(myTimer.getTime());
    }
}