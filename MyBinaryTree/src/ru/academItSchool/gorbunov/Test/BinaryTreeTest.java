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
                        new Object[]{0, 1, 2, 3, 4, 5, 6, 25, 18, 0, 12, 34},
                        "0, 1, 0, 2, 3, 4, 5, 6, 25, 18, 12, 34"},
                new Object[]{new BinaryTree<String>(),
                        new Object[]{"0", "1", "", "4564646456", "dada", "4546", "12151545454"},
                        "0, , 1, 4564646456, 4546, 12151545454, dada"}
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

    @Test(dataProvider = "Add")
    public void testSize(BinaryTree binaryTree, Object[] arr, String result) {
        for (Object el : arr) {
            binaryTree.add(new Edge<>((Comparable) el));
        }
        System.out.println(binaryTree.toString());
        assertEquals(binaryTree.toString(), result);
    }

    @Test(dataProvider = "Search")
    public void testSearch(BinaryTree binaryTree, Object[] arr,Object find, boolean result) {
        for (Object el : arr) {
            binaryTree.add(new Edge<>((Comparable) el));
        }
        assertEquals(binaryTree.search((Comparable) find), result);
    }
}
