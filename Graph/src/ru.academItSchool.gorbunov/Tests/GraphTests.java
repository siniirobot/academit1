package ru.academItSchool.gorbunov.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.academItSchool.gorbunov.Graph.Graph;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

import static org.testng.Assert.assertEquals;

public class GraphTests {
    @DataProvider(name = "Bypass")
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
                new Object[]{new Graph(new int[][]{
                        {0,1,0,0,0,0,0},
                        {1,0,1,1,1,1,0},
                        {0,1,0,0,0,0,1},
                        {0,1,0,0,0,1,0},
                        {0,1,0,0,0,1,0},
                        {0,1,0,0,1,0,1},
                        {0,0,1,0,0,1,0}})},
        };
    }

    @Test(dataProvider = "Bypass")
    public void testGetWideBypass(Graph graph) {
        graph.getWideBypass(x-> System.out.println(x));
    }

    @Test(dataProvider = "Bypass")
    public void testGetDepthCrawl(Graph graph) {
        graph.getDepthCrawl(x-> System.out.println(x));
    }
}
