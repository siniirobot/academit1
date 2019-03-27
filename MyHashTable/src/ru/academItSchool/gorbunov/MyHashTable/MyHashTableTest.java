package ru.academItSchool.gorbunov.MyHashTable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MyHashTableTest {
    @DataProvider(name = "Size")
    public Object[][] size() {
        MyHashTable<String> hashTable = new MyHashTable<>();
        hashTable.add("1");
        hashTable.add("2");
        hashTable.add("3");
        return new Object[][]{
                new Object[]{hashTable, 3}
        };
    }

    @DataProvider(name = "Add")
    public Object[][] add() {
        MyHashTable<String> hashTable = new MyHashTable<>();
        hashTable.add("1");
        hashTable.add("2");
        hashTable.add("3");
        hashTable.add("4");
        hashTable.add("5");
        hashTable.add("6");
        hashTable.add("7");
        hashTable.add("8");
        hashTable.add("9");
        return new Object[][]{
                new Object[]{hashTable,"[[1], [2], [3], [4], [5], [6], [7], [8], [9]]"}
        };
    }

    @Test (dataProvider = "Size")
    public void testSize(MyHashTable table, int result) {
        assertEquals(table.size(),result);
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

    @Test (dataProvider = "Add")
    public void testAdd(MyHashTable myHashTable,String result) {
        for (Object el: myHashTable) {
            System.out.println(el);
        }
        assertEquals(myHashTable.toString(),result);
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
    public void testRemoveAll() {
    }

    @Test
    public void testRetainAll() {
    }

    @Test
    public void testClear() {
    }
}