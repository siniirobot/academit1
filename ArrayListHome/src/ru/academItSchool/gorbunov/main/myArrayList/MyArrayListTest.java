package ru.academItSchool.gorbunov.main.myArrayList;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MyArrayListTest {
    @DataProvider(name = "test")
    public Object[][] test () {
        MyArrayList<Integer> list = new MyArrayList<>();
        return new Object[][]{
          new Object[]{list,0}
        };
    }

    @Test(dataProvider = "test")
    public void testSize(MyArrayList list, int result) {
        assertEquals(result,list.size());
    }

    @Test
    public void testIsEmpty() {
    }

    @Test
    public void testContains() {
    }

    @Test
    public void testIterator() {
    }

    @Test
    public void testToArray() {
    }

    @Test
    public void testToArray1() {
    }

    @Test
    public void testAdd() {
    }

    @Test
    public void testRemove() {
    }

    @Test
    public void testContainsAll() {
    }

    @Test
    public void testAddAll() {
    }

    @Test
    public void testAddAll1() {
    }

    @Test
    public void testRemoveAll() {
    }

    @Test
    public void testRetainAll() {
    }

    @Test
    public void testClear() {
    }

    @Test
    public void testGet() {
    }

    @Test
    public void testSet() {
    }

    @Test
    public void testAdd1() {
    }

    @Test
    public void testRemove1() {
    }

    @Test
    public void testIndexOf() {
    }

    @Test
    public void testLastIndexOf() {
    }

    @Test
    public void testListIterator() {
    }

    @Test
    public void testListIterator1() {
    }

    @Test
    public void testSubList() {
    }

    @Test
    public void testReplaceAll() {
    }

    @Test
    public void testSort() {
    }

    @Test
    public void testSpliterator() {
    }

    @Test
    public void testToArray2() {
    }

    @Test
    public void testRemoveIf() {
    }

    @Test
    public void testStream() {
    }

    @Test
    public void testParallelStream() {
    }

    @Test
    public void testForEach() {
    }
}