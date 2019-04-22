package ru.academItSchool.gorbunov.Classes;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.academItSchool.gorbunov.Graph.Graph;

import static org.testng.Assert.assertEquals;

public class GraphTests {
    @DataProvider(name = "Bypass")
    public Object[][] getWideBypass() {
        return new Object[][]{
                new Object[]{new Graph(new int[][]{
                        {0, 1, 0, 0, 0, 0, 0},
                        {1, 0, 1, 1, 1, 1, 0},
                        {0, 1, 0, 0, 0, 0, 1},
                        {0, 1, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 0, 1, 0},
                        {0, 1, 0, 0, 1, 0, 1},
                        {0, 0, 1, 0, 0, 1, 0}})},
                new Object[]{new Graph(new int[][]{
                        {0, 1, 1, 0, 0, 0, 0},
                        {1, 0, 1, 0, 0, 0, 0},
                        {1, 1, 0, 1, 0, 0, 0},
                        {0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1},
                        {0, 0, 0, 0, 0, 1, 0}})},
                new Object[]{new Graph(new int[0][0])},
        };
    }

    @Test(dataProvider = "Bypass")
    public void testGetWideBypass(Graph graph) {
        graph.wideBypass(x -> System.out.println(x));
    }

    @Test(dataProvider = "Bypass")
    public void testGetDepthCrawl(Graph graph) {
        graph.depthCrawlByStack(x -> System.out.println(x));
    }

    @Test(dataProvider = "Bypass")
    public void testGetDepthCrawlByRecursion(Graph graph) {
        graph.depthCrawlByRecursion(x -> System.out.println(x));
    }
}
