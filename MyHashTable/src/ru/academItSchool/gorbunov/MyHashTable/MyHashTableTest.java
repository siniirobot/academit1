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

    @DataProvider(name = "IsEmpty")
    public Object[][] isEmpty() {
        MyHashTable<String> hashTable = new MyHashTable<>();
        hashTable.add("1");
        MyHashTable<String> hashTable2 = new MyHashTable<>();
        return new Object[][]{
                new Object[]{hashTable, false},
                new Object[]{hashTable2, true},
        };
    }

    @DataProvider(name = "Contains")
    public Object[][] contains() {
        MyHashTable<String> hashTable = new MyHashTable<>();
        hashTable.add("0");
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
                new Object[]{hashTable, "6", true},
                new Object[]{hashTable, "66", false}
        };
    }

    @DataProvider(name = "toArray")
    public Object[][] toArray() {
        MyHashTable<String> hashTable = new MyHashTable<>();
        hashTable.add("0");
        hashTable.add("1");
        return new Object[][]{
                new Object[]{hashTable,
                        new Object[]{"0", "1"}
                }
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
                new Object[]{hashTable, "[[1], [2], [3], [4], [5], [6], [7], [8], [9]]"}
        };
    }


    @Test(dataProvider = "Size")
    public void testSize(MyHashTable table, int result) {
        assertEquals(table.size(), result);
    }

    @Test(dataProvider = "IsEmpty")
    public void testIsEmpty(MyHashTable myHashTable, boolean result) {
        assertEquals(myHashTable.isEmpty(), result);
    }

    @Test(dataProvider = "Contains")
    public void testContains(MyHashTable myHashTable, String element, boolean result) {
        assertEquals(myHashTable.contains(element), result);
    }

    @Test(dataProvider = "toArray")
    public void testToArray(MyHashTable myHashTable, Object[] result) {
        assertEquals(myHashTable.toArray(), result);
    }

    @Test
    public void testToArray1() {
    }

    @Test(dataProvider = "Add")
    public void testAdd(MyHashTable myHashTable, String result) {
        assertEquals(myHashTable.toString(), result);
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