package ru.academItSchool.gorbunov.Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.academItSchool.gorbunov.BinaryTree.BinaryTree;
import ru.academItSchool.gorbunov.BinaryTree.Edge;

import static org.testng.Assert.assertEquals;

public class BinaryTreeTest {
    @DataProvider(name = "Add")
    public Object[][] add() {
        return new Object[][]{
                new Object[]{new BinaryTree<Integer>(),
                        new Object[]{25, 35, 18, 19, 29, 39, 6, 25, 18, 0, 12, 39},
                        "25, 18, 35, 6, 19, 29, 39, 0, 12, 18, 25, 39"},
                new Object[]{new BinaryTree<String>(),
                        new Object[]{"0", "1", "", "4564646456", "dada", "4546", "12151545454"},
                        "0, , 1, 4564646456, 4546, dada, 12151545454"}
        };
    }

    @DataProvider(name = "Search")
    public Object[][] search() {
        return new Object[][]{
                new Object[]{new BinaryTree<Integer>(),
                        new Object[]{0, 1, 2, 3, 4, 5, 6, 25, 18, 0, 12, 34},
                        12,
                        true},
                new Object[]{new BinaryTree<String>(),
                        new Object[]{"0", "1", "", "4564646456", "dada", "4546", "12151545454"},
                        "daddda",
                        false}
        };
    }

    @DataProvider(name = "Delete")
    public Object[][] delete() {
        return new Object[][]{

                new Object[]{new BinaryTree<Integer>(),
                        new Object[]{50, 25, 75, 20, 40, 60, 80, 10, 30, 45, 65, 85},
                        60,
                        true},
                new Object[]{new BinaryTree<String>(),
                        new Object[]{"0", "1", "", "4564646456", "dada", "4546", "12151545454"},
                        "daddda",
                        false},
                new Object[]{new BinaryTree<Integer>(),
                        new Object[]{8, 3, 10, 1, 6, 14, 4, 7, 13, 3},
                        3,
                        true},
                new Object[]{new BinaryTree<Integer>(),
                        new Object[]{8,4,12,2,6,10,14,1,3,5,7,9,11,13,15},
                        4,
                        true},
                new Object[]{new BinaryTree<Integer>(),
                        new Object[]{8,4,12,2,6,10,14,1,3,5,7,9,11,13,15},
                        6,
                        true},
                new Object[]{new BinaryTree<Integer>(),
                        new Object[]{8,4,12,2,6,10,14,1,3,5,7,9,11,13,15},
                        4,
                        true},
                new Object[]{new BinaryTree<Integer>(),
                        new Object[]{8,4,12,2,6,10,14,1,3,5,7,9,11,13,15},
                        2,
                        true},
                new Object[]{new BinaryTree<Integer>(),
                        new Object[]{8,4,12,2,6,10,14,1,3,5,7,9,11,13,15},
                        12,
                        true},
                new Object[]{new BinaryTree<Integer>(),
                        new Object[]{8,4,12,2,6,10,14,1,3,5,7,9,11,13,15},
                        10,
                        true},
                new Object[]{new BinaryTree<Integer>(),
                        new Object[]{8,4,12,2,6,10,14,3,5,7,9,11,13,15},
                        4,
                        true},
                new Object[]{new BinaryTree<Integer>(),
                        new Object[]{8,4,12,2,6,10,14,3,5,7,9,11,13,15},
                        1,
                        false},
        };
    }

    @Test(dataProvider = "Add")
    public void testSize(BinaryTree binaryTree, Object[] arr, String result) {
        for (Object el : arr) {
            binaryTree.add(new Edge<>((Comparable) el));
        }
        System.out.println(binaryTree.toString());
        assertEquals(binaryTree.toString(), result);
    }

    @Test(dataProvider = "Search")
    public void testSearch(BinaryTree binaryTree, Object[] arr, Object find, boolean result) {
        for (Object el : arr) {
            binaryTree.add(new Edge<>((Comparable) el));
        }
        assertEquals(binaryTree.search((Comparable) find), result);
    }

    @Test(dataProvider = "Delete")
    public void testDelete(BinaryTree binaryTree, Object[] arr, Object find, boolean result) {
        for (Object el : arr) {
            binaryTree.add(new Edge<>((Comparable) el));
        }
        assertEquals(binaryTree.delete((Comparable) find), result);
    }
}
