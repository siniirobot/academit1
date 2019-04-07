package ru.academItSchool.gorbunov.Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.academItSchool.gorbunov.MyHashTable.MyHashTable;

import java.util.ArrayList;
import java.util.Arrays;

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
        hashTable.add("2");
        hashTable.add("3");
        hashTable.add("4");
        hashTable.add("5");
        hashTable.add("6");
        hashTable.add("7");
        hashTable.add("8");
        hashTable.add("9");
        hashTable.add("10");
        hashTable.add("11");
        hashTable.add("12");
        hashTable.add("13");
        return new Object[][]{
                new Object[]{hashTable,
                        new Object[]{"10", "0", "11", "1", "12", "2", "13", "3", "4", "5", "6", "7", "8", "9"}
                }
        };
    }

    @DataProvider(name = "ToArray1")
    public Object[][] toArray1() {
        MyHashTable<String> hashTable = new MyHashTable<>();
        hashTable.add("0");
        hashTable.add("1");
        hashTable.add("2");
        hashTable.add("3");

        return new Object[][]{
                new Object[]{hashTable,
                        new Object[]{"0", "1", "2", "3"},
                        new Object[]{"2", "3", "0", "1"}
                },
                new Object[]{hashTable,
                        new Object[]{"0", "1",},
                        new Object[]{"2", "3", "0", "1"}
                },
                new Object[]{hashTable,
                        new Object[]{"0", "1", "2", "3", "4"},
                        new Object[]{"2", "3", "0", "1", null}
                },
                new Object[]{hashTable,
                        new Object[]{"0", "1", "2", "3", "4", "5", "6", "7"},
                        new Object[]{"2", "3", "0", "1", null, "5", "6", "7"}
                }
        };
    }

    @DataProvider(name = "Add")
    public Object[][] add() {
        return new Object[][]{
                new Object[]{new MyHashTable<>(),
                        new Object[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"},
                        "[[2], [3], [4], [5], [6], [7], [8], [9], [1]]"},
                new Object[]{new MyHashTable<>(),
                        new Object[]{"a", "a", "2", "3", "a", "a", "a", "a", "1", "4", "a", "1", "5", "a"},
                        "[[1, 1], [2], [3], [4], [5], [a, a, a, a, a, a, a, a]]"}
        };
    }

    @DataProvider(name = "Remove")
    public Object[][] remove() {
        MyHashTable<String> hashTable = new MyHashTable<>();
        hashTable.add("1");
        hashTable.add("2");
        hashTable.add("3");
        hashTable.add("4");
        hashTable.add("5");

        MyHashTable<String> hashTableWithout3 = new MyHashTable<>();
        hashTableWithout3.add("1");
        hashTableWithout3.add("2");
        hashTableWithout3.add("4");
        hashTableWithout3.add("5");
        return new Object[][]{
                new Object[]{hashTable, hashTableWithout3, "3", true}
        };
    }

    @DataProvider(name = "ContainsAll")
    public Object[][] containsAll() {
        MyHashTable<String> hashTable = new MyHashTable<>();
        hashTable.add("1");
        hashTable.add("2");
        hashTable.add("3");
        hashTable.add("4");
        hashTable.add("5");

        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("1");
        stringArrayList.add("2");
        return new Object[][]{
                new Object[]{hashTable, stringArrayList, true},
                new Object[]{hashTable, new ArrayList<>(Arrays.asList("абракадабра")), false}
        };
    }

    @DataProvider(name = "AddAll")
    public Object[][] addAll() {
        MyHashTable<String> hashTable = new MyHashTable<>();
        hashTable.add("1");
        hashTable.add("2");
        hashTable.add("3");
        hashTable.add("4");
        hashTable.add("5");

        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("6");
        stringArrayList.add("7");

        MyHashTable<String> hashTable1WithResult = new MyHashTable<>();
        hashTable1WithResult.add("1");
        hashTable1WithResult.add("2");
        hashTable1WithResult.add("3");
        hashTable1WithResult.add("4");
        hashTable1WithResult.add("5");
        hashTable1WithResult.add("6");
        hashTable1WithResult.add("7");
        return new Object[][]{
                new Object[]{hashTable, stringArrayList, true, hashTable1WithResult},
                new Object[]{hashTable, new ArrayList<>(), false, hashTable}

        };
    }

    @DataProvider(name = "RemoveAll")
    public Object[][] RemoveAll() {
        MyHashTable<String> hashTable = new MyHashTable<>();
        hashTable.add("1");
        hashTable.add("a");
        hashTable.add("a");
        hashTable.add("2");
        hashTable.add("3");
        hashTable.add("a");
        hashTable.add("a");
        hashTable.add("a");
        hashTable.add("a");
        hashTable.add("1");
        hashTable.add("4");
        hashTable.add("a");
        hashTable.add("1");
        hashTable.add("5");
        hashTable.add("a");

        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("1");
        stringArrayList.add("a");

        MyHashTable<String> hashTable1WithResult = new MyHashTable<>();
        hashTable1WithResult.add("2");
        hashTable1WithResult.add("3");
        hashTable1WithResult.add("4");
        hashTable1WithResult.add("5");
        return new Object[][]{
                new Object[]{hashTable, stringArrayList, true, hashTable1WithResult},
                new Object[]{hashTable, new ArrayList<>(Arrays.asList("абракадабра", "Джони Деб")), false, hashTable1WithResult}
        };
    }

    @DataProvider(name = "RetainAll")
    public Object[][] retainAll() {
        MyHashTable<String> hashTableRetainAll = new MyHashTable<>();
        hashTableRetainAll.add("1");
        hashTableRetainAll.add("a");
        hashTableRetainAll.add("a");
        hashTableRetainAll.add("2");
        hashTableRetainAll.add("3");
        hashTableRetainAll.add("a");
        hashTableRetainAll.add("a");
        hashTableRetainAll.add("a");
        hashTableRetainAll.add("a");
        hashTableRetainAll.add("1");
        hashTableRetainAll.add("4");
        hashTableRetainAll.add("a");
        hashTableRetainAll.add("1");
        hashTableRetainAll.add("5");
        hashTableRetainAll.add("a");

        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("1");
        stringArrayList.add("a");

        MyHashTable<String> hashTableWithResult = new MyHashTable<>();
        hashTableWithResult.add("1");
        hashTableWithResult.add("a");
        hashTableWithResult.add("a");
        hashTableWithResult.add("a");
        hashTableWithResult.add("a");
        hashTableWithResult.add("a");
        hashTableWithResult.add("a");
        hashTableWithResult.add("1");
        hashTableWithResult.add("a");
        hashTableWithResult.add("1");
        hashTableWithResult.add("a");
        return new Object[][]{
                new Object[]{hashTableRetainAll, stringArrayList, true, hashTableWithResult}
        };
    }

    @DataProvider(name = "Clear")
    public Object[][] clear() {
        MyHashTable<String> hashTable = new MyHashTable<>();
        hashTable.add("1");
        hashTable.add("a");
        hashTable.add("a");
        hashTable.add("2");
        hashTable.add("3");
        hashTable.add("a");
        hashTable.add("a");
        hashTable.add("a");
        hashTable.add("a");
        hashTable.add("1");
        hashTable.add("4");
        hashTable.add("a");
        hashTable.add("1");
        hashTable.add("5");
        hashTable.add("a");

        MyHashTable<String> hashTable1WithResult = new MyHashTable<>();
        return new Object[][]{
                new Object[]{hashTable, hashTable1WithResult}
        };
    }

    @DataProvider(name = "HashCodeAndEquals")
    public Object[][] testHashCode() {
        MyHashTable<Integer> intArray = new MyHashTable<>();
        intArray.add(1);
        intArray.add(2);
        MyHashTable<Integer> intArray2 = new MyHashTable<>();
        intArray2.add(1);
        intArray2.add(2);
        MyHashTable<String> line1 = new MyHashTable<>();
        line1.add("1");
        line1.add("2");
        MyHashTable<String> line2 = new MyHashTable<>();
        line2.add("1");
        line2.add("2");
        return new Object[][]{
                new Object[]{intArray, intArray2},
                new Object[]{line1, line2}
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

    @Test(dataProvider = "ToArray1")
    public void testToArray1(MyHashTable myHashTable, Object[] array, Object[] result) {
        assertEquals(myHashTable.toArray(array), result);
    }

    @Test(dataProvider = "Add")
    public void testAdd(MyHashTable myHashTable, Object[] elements, String result) {
        for (Object el : elements) {
            myHashTable.add(el);
        }
        assertEquals(myHashTable.toString(), result);
    }

    @Test(dataProvider = "Remove")
    public void testRemove(MyHashTable myHashTable, MyHashTable myHashTable2, String three, boolean result) {
        assertEquals(myHashTable.remove(three), result);
        assertEquals(myHashTable, myHashTable2);
    }

    @Test(dataProvider = "ContainsAll")
    public void testContainsAll(MyHashTable hashTable, ArrayList arrayList, boolean result) {
        assertEquals(hashTable.containsAll(arrayList), result);
    }

    @Test(dataProvider = "AddAll")
    public void testAddAll(MyHashTable hashTable, ArrayList arrayList, boolean result, MyHashTable hashTableResult) {
        assertEquals(hashTable.addAll(arrayList), result);
        assertEquals(hashTable, hashTableResult);
    }

    @Test(dataProvider = "RemoveAll")
    public void tesRemoveAll(MyHashTable hashTable, ArrayList arrayList, boolean result, MyHashTable hashTableResult) {
        assertEquals(hashTable.removeAll(arrayList), result);
        assertEquals(hashTable, hashTableResult);
    }

    @Test(dataProvider = "RetainAll")
    public void testRetainAll(MyHashTable hashTable, ArrayList arrayList, boolean result, MyHashTable
            hashTableResult) {
        assertEquals(hashTable.retainAll(arrayList), result);
        assertEquals(hashTable, hashTableResult);
    }

    @Test(dataProvider = "Clear")
    public void testClear(MyHashTable hashTable, MyHashTable result) {
        hashTable.clear();
        assertEquals(hashTable, result);
    }

    @Test(dataProvider = "HashCodeAndEquals")
    public void testHashCode(MyHashTable list, MyHashTable list1) {
        int expected = list.hashCode();
        int actual = list1.hashCode();
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "HashCodeAndEquals")
    public void testEquals(MyHashTable list, MyHashTable list1) {
        assertTrue(list.equals(list1));
    }
}