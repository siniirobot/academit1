package ru.academItSchool.gorbunov.Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.academItSchool.gorbunov.BinaryTree.BinaryTree;
import ru.academItSchool.gorbunov.BinaryTree.Node;

import java.util.Comparator;

import static org.testng.Assert.assertEquals;

public class BinaryTreeTest {
    private Comparator<Integer> comparatorInteger  = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 < o2) {
                return -1;
            } else if (o1.equals(o2)) {
                return 0;
            } else {
                return 1;
            }
        }
    };

    @DataProvider(name = "Size")
    public Object[][] size() {
        return new Object[][]{
                new Object[]{new BinaryTree<Integer>(),
                        new Object[]{0, 1, 2, 3, 4, 5, 6, 25, 18, 0, 12, 34},
                        12},
                new Object[]{new BinaryTree<String>(),
                        new Object[]{"0", "1", "", "4564646456", "dada", "4546", "12151545454"},
                        7}
        };
    }

    @DataProvider(name = "Add")
    public Object[][] add() {
        return new Object[][]{
                new Object[]{new BinaryTree<Integer>(comparatorInteger),
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
                        new Object[]{9, 6, 17, 3, 8, 16, 20, 1, 4, 7, 12, 19, 21, 2, 5, 11, 14, 18, 10, 13, 15},
                        7,
                        true},
                new Object[]{new BinaryTree<Integer>(),
                        new Object[]{9, 6, 17, 3, 8, 16, 20, 1, 4, 7, 12, 19, 21, 2, 5, 11, 14, 18, 10, 13, 15},
                        17,
                        true},
                new Object[]{new BinaryTree<Integer>(),
                        new Object[]{9, 6, 17, 3, 8, 16, 20, 1, 4, 7, 12, 19, 21, 2, 5, 11, 14, 18, 10, 13, 15},
                        12,
                        true},
                new Object[]{new BinaryTree<Integer>(),
                        new Object[]{9, 6, 17, 3, 8, 16, 20, 1, 4, 7, 12, 19, 21, 2, 5, 11, 14, 18, 10, 13, 15},
                        14,
                        true},
                new Object[]{new BinaryTree<Integer>(),
                        new Object[]{9, 6, 17, 3, 8, 16, 20, 1, 4, 7, 12, 19, 21, 2, 5, 11, 14, 18, 10, 13, 15},
                        20,
                        true},
                new Object[]{new BinaryTree<Integer>(),
                        new Object[]{9, 6, 17, 3, 8, 16, 20, 1, 4, 7, 12, 19, 21, 2, 5, 11, 14, 18, 10, 13, 15},
                        6,
                        true},
                new Object[]{new BinaryTree<Integer>(),
                        new Object[]{9, 6, 17, 3, 8, 16, 20, 1, 4, 7, 12, 19, 21, 2, 5, 11, 14, 18, 10, 13, 15},
                        3,
                        true},
                new Object[]{new BinaryTree<Integer>(),
                        new Object[]{9, 6, 17, 3, 8, 16, 20, 1, 4, 7, 12, 19, 21, 2, 5, 11, 14, 18, 10, 13, 15},
                        22,
                        false},

        };
    }

    @DataProvider(name = "Bypass")
    public Object[][] getBypass() {
        return new Object[][]{
                new Object[]{new BinaryTree<Integer>(),
                        new Object[]{9, 1, 17, 3, 8, 16, 20, 1, 4, 7, 12, 19, 21, 2, 5, 11, 14, 18, 10, 13, 15}
                        /*"9,6,17,3,8,14,20,1,4,7,12,19,21,2,5,11,14,18,10,13,15"*/},
        };
    }

    @Test(dataProvider = "Size")
    public void testSize(BinaryTree binaryTree, Object[] arr, int result) {
        for (Object el : arr) {
            binaryTree.add(new Node<>((Comparable) el));
        }
        assertEquals(binaryTree.getSize(), result);
    }

    @Test(dataProvider = "Add")
    public void testAdd(BinaryTree binaryTree, Object[] arr, String result) {
        for (Object el : arr) {
            binaryTree.add(new Node<>((Comparable) el));
        }
        assertEquals(binaryTree.toString(), result);
    }

    @Test(dataProvider = "Search")
    public void testSearch(BinaryTree binaryTree, Object[] arr, Object find, boolean result) {
        for (Object el : arr) {
            binaryTree.add(new Node<>((Comparable) el));
        }
        assertEquals(binaryTree.search((Comparable) find), result);
    }

    @Test(dataProvider = "Delete")
    public void testDelete(BinaryTree binaryTree, Object[] arr, Object find, boolean result) {
        for (Object el : arr) {
            binaryTree.add(new Node<>((Comparable) el));
        }
        assertEquals(binaryTree.delete((Comparable) find), result);
    }

    @Test(dataProvider = "Bypass")
    public void testGetWideBypass(BinaryTree binaryTree, Object[] arr) {
        for (Object el : arr) {
            binaryTree.add(new Node<>((Comparable) el));
        }
        binaryTree.getWideBypass();
    }

    @Test(dataProvider = "Bypass")
    public void testGetDepthCrawlByStack(BinaryTree binaryTree, Object[] arr) {
        for (Object el : arr) {
            binaryTree.add(new Node<>((Comparable) el));
        }
        binaryTree.getDepthCrawlByStack();
    }

    @Test(dataProvider = "Bypass")
    public void testGetDepthCrawlByRecursion(BinaryTree binaryTree, Object[] arr) {
        for (Object el : arr) {
            binaryTree.add(new Node<>((Comparable) el));
        }
        binaryTree.getDepthCrawlByRecursion();
    }
}
