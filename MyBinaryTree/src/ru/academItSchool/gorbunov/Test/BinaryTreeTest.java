package ru.academItSchool.gorbunov.Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.academItSchool.gorbunov.BinaryTree.BinaryTree;
import ru.academItSchool.gorbunov.BinaryTree.Edge;

public class BinaryTreeTest {
    @DataProvider(name = "Add")
    public Object[][] add() {
        return new Object[][]{
                new Object[]{new BinaryTree<Integer>(), new Integer[]{0, 1, 2, 3, 4, 5, 6, 25, 18, 0, 12, 34}},
                new Object[]{new BinaryTree<String>(), new String[]{"0","1","","4564646456","dada","4546","12151545454" }}
        };
    }

    @Test(dataProvider = "Add")
    public void testSize(BinaryTree binaryTree, String[] arr) {
        for (String el : arr) {
            binaryTree.add(new Edge(el));
        }
        System.out.println(binaryTree.toString());
    }
}
