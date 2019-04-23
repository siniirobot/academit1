package ru.academItSchool.gorbunov.Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.academItSchool.gorbunov.BinaryTree.BinaryTree;

import java.util.Comparator;
import java.util.function.Consumer;

import static org.testng.Assert.assertEquals;

public class BinaryTreeTest {
    private Comparator<Integer> comparatorInteger = new Comparator<Integer>() {
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
                new Object[]{new BinaryTree<Integer>(),
                        new Object[]{0, 1, 2, 3, 4, 5, 6, 25, 18, 0, 12, 34},
                        25,
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
                        new Object[]{9, 11, 4},
                        9,
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
                        new Object[]{50,30,55,25,35,53,60,10,30,37,62,15}},
                new Object[]{new BinaryTree<Integer>(),
                        new Object[]{}},
        };
    }

    @Test(dataProvider = "Size")
    public void testSize(BinaryTree binaryTree, Object[] arr, int result) {
        for (Object el : arr) {
            binaryTree.add(el);
        }
        assertEquals(binaryTree.getSize(), result);
    }

    @Test(dataProvider = "Add")
    public void testAdd(BinaryTree binaryTree, Object[] arr, String result) {
        BinaryTree binaryTree1 = new BinaryTree();
        for (Object el : arr) {
            binaryTree.add(el);
            binaryTree1.add(el);
        }
        binaryTree.equals(binaryTree1);
        assertEquals(binaryTree.toString(), result);
    }

    @Test(dataProvider = "Search")
    public void testSearch(BinaryTree binaryTree, Object[] arr, Object find, boolean result) {
        for (Object el : arr) {
            binaryTree.add(el);
        }
        assertEquals(binaryTree.isSearch((Comparable) find), result);
    }

    @Test(dataProvider = "Delete")
    public void testDelete(BinaryTree binaryTree, Object[] arr, Object find, boolean result) {
        for (Object el : arr) {
            binaryTree.add(el);
        }
        assertEquals(binaryTree.delete(find), result);
    }

    @Test(dataProvider = "Bypass")
    public void testGetWideBypass(BinaryTree binaryTree, Object[] arr) {
        for (Object el : arr) {
            binaryTree.add(el);
        }
        int binaryHash = binaryTree.hashCode();
        binaryTree.wideBypass(new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println(o + ", ");
            }
        });
    }

    @Test(dataProvider = "Bypass")
    public void testGetDepthCrawlByStack(BinaryTree binaryTree, Object[] arr) {
        for (Object el : arr) {
            binaryTree.add(el);
        }
        binaryTree.depthCrawlByStack(new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println(o + ", ");
            }
        });
    }

    @Test(dataProvider = "Bypass")
    public void testGetDepthCrawlByRecursion(BinaryTree binaryTree, Object[] arr) {
        for (Object el : arr) {
            binaryTree.add(el);
        }
        binaryTree.depthCrawlByRecursion(new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println(o + ", ");
            }
        });
    }
}
