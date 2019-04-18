package ru.academItSchool.gorbunov.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.academItSchool.gorbunov.Graph.Graph;

import java.util.Comparator;
import java.util.function.Consumer;

import static org.testng.Assert.assertEquals;

public class GraphTests {
    @DataProvider(name = "GetWideBypass")
    public Object[][] getWideBypass() {
        return new Object[][]{
                new Object[]{new Graph(new int[][]{
                        {0,1,1,0,0,0,0},
                        {1,0,1,0,0,0,0},
                        {1,1,0,1,0,0,0},
                        {0,0,1,0,0,0,0},
                        {0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,1},
                        {0,0,0,0,0,1,0}})},
        };
    }

    @Test(dataProvider = "GetWideBypass")
    public void testGetWideBypass(Graph graph) {
        graph.getWideBypass(new Consumer() {
            @Override
            public void accept(Object o) {
                for (int el:(int[]) o) {
                    System.out.println(el);
                }
            }
        });
    }
}
