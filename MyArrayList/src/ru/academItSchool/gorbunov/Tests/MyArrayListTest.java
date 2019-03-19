package ru.academItSchool.gorbunov.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.academItSchool.gorbunov.myArrayList.MyArrayList;

import java.util.ArrayList;
import java.util.Arrays;

import static org.testng.Assert.*;

public class MyArrayListTest {
    @DataProvider(name = "Size")
    public Object[][] size() {
        return new Object[][]{
                new Object[]{new MyArrayList<>(), 0},
                new Object[]{new MyArrayList<>("0", "1", "2", "3"), 4}
        };
    }

    @DataProvider(name = "IsEmpty")
    public Object[][] isEmpty() {
        return new Object[][]{
                new Object[]{new MyArrayList<>(), true},
                new Object[]{new MyArrayList<>("0", "1", "2", "3"), false}
        };
    }

    @DataProvider(name = "Add")
    public Object[][] add() {
        return new Object[][]{
                new Object[]{new MyArrayList<String>(),
                        new String[]{"0", "1", "2", "3"},
                        new MyArrayList<>("0", "1", "2", "3")},
                new Object[]{new MyArrayList<String>(),
                        new String[5],
                        new MyArrayList<String>(null, null, null, null, null)},
                new Object[]{new MyArrayList<String>(),
                        new java.lang.String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"},
                        new MyArrayList<>("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11")},

        };
    }

    @DataProvider(name = "AddError")
    public Object[][] addError() {
        return new Object[][]{
                new Object[]{new MyArrayList<String>(),
                        "0",
                        3,
                        new MyArrayList<>("0", 3)}
        };
    }

    @DataProvider(name = "Contains")
    public Object[][] contains() {
        return new Object[][]{
                new Object[]{new MyArrayList<>("Это нулевой элемент", "Это первый элемент", "Это второй элемент"), "Это второй элемент", true}
        };
    }

    @DataProvider(name = "ToArray")
    public Object[][] iterator() {
        return new Object[][]{
                new Object[]{new MyArrayList<>("Это нулевой элемент", "Это первый элемент", "Это второй элемент"),
                        new Object[]{"Это нулевой элемент", "Это первый элемент", "Это второй элемент"}}
        };
    }

    @DataProvider(name = "ToArray1")
    public Object[][] toArray1() {
        return new Object[][]{
                new Object[]{new MyArrayList<>("Это нулевой элемент", "Это первый элемент", "Это второй элемент"),
                        new String[]{"0", "1", "2", "3"},
                        new String[]{"Это нулевой элемент", "Это первый элемент", "Это второй элемент", null
                        }}
        };
    }


    @DataProvider(name = "Remove")
    public Object[][] remove() {
        return new Object[][]{
                new Object[]{new MyArrayList<>("Это нулевой элемент", "Это первый элемент", "Это второй элемент"),
                        "Это первый элемент",
                        true},
                new Object[]{new MyArrayList<>("Это нулевой элемент", "Это первый элемент", null, "Это второй элемент"),
                        null,
                        true}
        };
    }

    @DataProvider(name = "ContainsAll")
    public Object[][] containsAll() {
        return new Object[][]{
                new Object[]{new MyArrayList<String>("Это нулевой элемент", "Это первый элемент", "Это второй элемент"),
                        new MyArrayList<String>("Это первый элемент", "Это нулевой элемент"),
                        true},
                new Object[]{new MyArrayList<String>("Это нулевой элемент", "Это первый элемент", "Это второй элемент"),
                        new MyArrayList<String>("Это первый элемент", "Это нулевой элемент", "0"),
                        false}
        };
    }

    @DataProvider(name = "ContainsAllError")
    public Object[][] containsAllError() {
        return new Object[][]{
                new Object[]{new MyArrayList<String>("Это нулевой элемент", "Это первый элемент", "Это второй элемент"),
                        new MyArrayList<String>(),
                        false}
        };
    }

    @DataProvider(name = "AddAll")
    public Object[][] addAll() {
        return new Object[][]{
                new Object[]{new MyArrayList<>("Это нулевой элемент", "Это первый элемент", "Это второй элемент"),
                        new MyArrayList<>("Это первый элемент", "Это нулевой элемент"),
                        true}
        };
    }

    @DataProvider(name = "AddAllError")
    public Object[][] addAllError() {
        return new Object[][]{
                new Object[]{new MyArrayList<>("Это нулевой элемент", "Это первый элемент", "Это второй элемент"),
                        new MyArrayList<>(),
                        true}
        };
    }

    @DataProvider(name = "AddAll1")
    public Object[][] addAll1() {
        return new Object[][]{
                new Object[]{new MyArrayList<>("Это нулевой элемент", "Это первый элемент", "Это второй элемент"),
                        1,
                        new MyArrayList<>("Это первый элемент", "Это нулевой элемент"),
                        true}
        };
    }

    @DataProvider(name = "AddAll1Error")
    public Object[][] addAll1Error() {
        return new Object[][]{
                new Object[]{new MyArrayList<>("Это нулевой элемент", "Это первый элемент", "Это второй элемент"),
                        18,
                        new MyArrayList<>("Это первый элемент", "Это нулевой элемент"),
                        true},
                new Object[]{new MyArrayList<>("Это нулевой элемент", "Это первый элемент", "Это второй элемент"),
                        1,
                        new MyArrayList<>(),
                        true},
                new Object[]{new MyArrayList<>("Это нулевой элемент", "Это первый элемент", "Это второй элемент"),
                        118,
                        new MyArrayList<>(),
                        true},
        };
    }

    @DataProvider(name = "RemoveAll")
    public Object[][] removeAll() {
        return new Object[][]{
                new Object[]{new MyArrayList<>("Это нулевой элемент", "Это первый элемент", "Это второй элемент"),
                        new MyArrayList<>("Это первый элемент", "Это нулевой элемент"),
                        true}
        };
    }

    @DataProvider(name = "RemoveAllError")
    public Object[][] removeAllError() {
        return new Object[][]{
                new Object[]{new MyArrayList<>("Это нулевой элемент", "Это первый элемент", "Это второй элемент"),
                        new MyArrayList<>(),
                        true}
        };
    }

    @DataProvider(name = "RetainAll")
    public Object[][] retainAll() {
        return new Object[][]{
                new Object[]{new MyArrayList<>("Это нулевой элемент", "Это первый элемент", "Это второй элемент"),
                        new MyArrayList<>("Это первый элемент", "Это нулевой элемент"),
                        true}
        };
    }

    @DataProvider(name = "RetainAllError")
    public Object[][] retainAllError() {
        return new Object[][]{
                new Object[]{new MyArrayList<>("Это нулевой элемент", "Это первый элемент", "Это второй элемент"),
                        new MyArrayList<>(),
                        true}
        };
    }

    @DataProvider(name = "Clear")
    public Object[][] clear() {
        return new Object[][]{
                new Object[]{new MyArrayList<>("Это нулевой элемент", "Это первый элемент", "Это второй элемент"),
                        new MyArrayList<>()}
        };
    }

    @DataProvider(name = "Get")
    public Object[][] get() {
        return new Object[][]{
                new Object[]{new MyArrayList<>("Это нулевой элемент", "Это первый элемент", "Это второй элемент"),
                        1,
                        "Это первый элемент"}
        };
    }

    @DataProvider(name = "GetError")
    public Object[][] getError() {
        return new Object[][]{
                new Object[]{new MyArrayList<>("Это нулевой элемент", "Это первый элемент", "Это второй элемент"),
                        -1,
                        "Это первый элемент"},
                new Object[]{new MyArrayList<>("Это нулевой элемент", "Это первый элемент", "Это второй элемент"),
                        18,
                        "Это первый элемент"},
        };
    }

    @DataProvider(name = "Set")
    public Object[][] set() {
        return new Object[][]{
                new Object[]{new MyArrayList<>("Это нулевой элемент", "Это первый элемент", "Это второй элемент"),
                        1,
                        "Это не первый элемент",
                        "Это первый элемент"}
        };
    }

    @DataProvider(name = "SetError")
    public Object[][] setError() {
        return new Object[][]{
                new Object[]{new MyArrayList<>("Это нулевой элемент", "Это первый элемент", "Это второй элемент"),
                        -1,
                        "Это не первый элемент",
                        "Это первый элемент"},
                new Object[]{new MyArrayList<>("Это нулевой элемент", "Это первый элемент", "Это второй элемент"),
                        -19,
                        "Это не первый элемент",
                        "Это первый элемент"}
        };
    }

    @DataProvider(name = "Add1")
    public Object[][] add1() {
        return new Object[][]{
                new Object[]{new MyArrayList<>("Это нулевой элемент", "Это первый элемент", "Это второй элемент"),
                        1,
                        "1.5",
                        new MyArrayList<>("Это нулевой элемент", "1.5", "Это первый элемент", "Это второй элемент")}
        };
    }

    @DataProvider(name = "Add1Error")
    public Object[][] add1Error() {
        return new Object[][]{
                new Object[]{new MyArrayList<>("Это нулевой элемент", "Это первый элемент", "Это второй элемент"),
                        -1,
                        "1.5",
                        new MyArrayList<>("Это нулевой элемент", "1.5", "Это первый элемент", "Это второй элемент")},
                new Object[]{new MyArrayList<>("Это нулевой элемент", "Это первый элемент", "Это второй элемент"),
                        18,
                        "1.5",
                        new MyArrayList<>("Это нулевой элемент", "1.5", "Это первый элемент", "Это второй элемент")}
        };
    }

    @DataProvider(name = "Remove1")
    public Object[][] remove1() {
        return new Object[][]{
                new Object[]{new MyArrayList<>("Это нулевой элемент", "Это первый элемент", "Это второй элемент"),
                        1,
                        "Это первый элемент"}
        };
    }

    @DataProvider(name = "Remove1Error")
    public Object[][] remove1Error() {
        return new Object[][]{
                new Object[]{new MyArrayList<>("Это нулевой элемент", "Это первый элемент", "Это второй элемент"),
                        -1,
                        "Это первый элемент"},
                new Object[]{new MyArrayList<>("Это нулевой элемент", "Это первый элемент", "Это второй элемент"),
                        18,
                        "Это первый элемент"}
        };
    }

    @DataProvider(name = "IndexOf")
    public Object[][] indexOf() {
        return new Object[][]{
                new Object[]{new MyArrayList<>("Это нулевой элемент", "Это первый элемент", "Это второй элемент", "Это первый элемент", null),
                        null,
                        4}
        };
    }

    @DataProvider(name = "LastIndexOf")
    public Object[][] lastIndexOf() {
        return new Object[][]{
                new Object[]{new MyArrayList<>("Это нулевой элемент", "Это первый элемент", "Это второй элемент", "Это первый элемент"),
                        "Это первый элемент", 3}
        };
    }

    @Test(dataProvider = "Size")
    public void testSize(MyArrayList list, int result) {
        assertEquals(list.size(), result);
    }

    @Test(dataProvider = "IsEmpty")
    public void testIsEmpty(MyArrayList list, boolean result) {
        assertEquals(list.isEmpty(), result);
    }

    @Test(dataProvider = "Contains")
    public void testContains(MyArrayList list, String element, boolean result) {
        assertEquals(list.contains(element), result);
    }

    @Test(dataProvider = "ToArray")
    public void testToArray(MyArrayList list, Object[] result) {
        assertEquals(list.toArray(), result);
    }

    @Test(dataProvider = "ToArray1")
    public void testToArray1(MyArrayList list, String[] array, String[] result) {
        String[] toArray = (String[]) list.toArray();
        ArrayList<String> List = new ArrayList<>(Arrays.asList(toArray));
        toArray = List.toArray(array);
        for (String lis:toArray) {
            System.out.println(lis);
        }
        System.out.println("Второй массив");
        String[] toArray2 = (String[]) list.toArray(array);
        for (String lis2:toArray2) {
            System.out.println(lis2);
        }
        assertEquals(list.toArray(array), result);
    }

    @Test(dataProvider = "Add")
    public void testAdd(MyArrayList<String> list, String[] elements, MyArrayList result) {
        ArrayList<String> list1 = new ArrayList<>();
        for (String element : elements) {
            list1.add(element);
        }
        assertEquals(list1, result);
    }

    @Test(dataProvider = "AddError", expectedExceptions = IllegalArgumentException.class,enabled = false)
    public void testAddError(MyArrayList list, String element, int element1, MyArrayList result) {
        list.add(element);
        list.add(element1);
        assertEquals(list, result);
    }

    @Test(dataProvider = "Remove")
    public void testRemove(MyArrayList list, String element, boolean result) {
        assertEquals(list.remove(element), result);
    }

    @Test(dataProvider = "ContainsAll")
    public void testContainsAll(MyArrayList list, MyArrayList list2, boolean result) {
        assertEquals(list.containsAll(list2), result);
    }

    @Test(dataProvider = "ContainsAllError", expectedExceptions = NullPointerException.class)
    public void testContainsAllError(MyArrayList list, MyArrayList list2, boolean result) {
        assertEquals(list.containsAll(list2), result);
    }

    @Test(dataProvider = "AddAll")
    public void testAddAll(MyArrayList list, MyArrayList list2, boolean result) {
        assertEquals(list.addAll(list2), result);
    }

    @Test(dataProvider = "AddAllError", expectedExceptions = NullPointerException.class)
    public void testAddAllError(MyArrayList list, MyArrayList list2, boolean result) {
        assertEquals(list.addAll(list2), result);
    }

    @Test(dataProvider = "AddAll1")
    public void testAddAll1(MyArrayList list, int index, MyArrayList list2, boolean result) {
        assertEquals(list.addAll(index, list2), result);
    }

    @Test(dataProvider = "AddAll1Error", expectedExceptions = {IndexOutOfBoundsException.class, NullPointerException.class})
    public void testAddAll1Error(MyArrayList list, int index, MyArrayList list2, boolean result) {
        assertEquals(list.addAll(index, list2), result);
    }

    @Test(dataProvider = "RemoveAll")
    public void testRemoveAll(MyArrayList list, MyArrayList list2, boolean result) {
        assertEquals(list.removeAll(list2), result);
    }

    @Test(dataProvider = "RemoveAllError", expectedExceptions = {NullPointerException.class})
    public void testRemoveAllError(MyArrayList list, MyArrayList list2, boolean result) {
        assertEquals(list.removeAll(list2), result);
    }

    @Test(dataProvider = "RetainAll")
    public void testRetainAll(MyArrayList list, MyArrayList list2, boolean result) {
        assertEquals(list.retainAll(list2), result);
    }

    @Test(dataProvider = "RetainAllError", expectedExceptions = {NullPointerException.class})
    public void testRetainAllError(MyArrayList list, MyArrayList list2, boolean result) {
        assertEquals(list.retainAll(list2), result);
    }

    @Test(dataProvider = "Clear")
    public void testClear(MyArrayList list, MyArrayList result) {
        list.clear();
        assertEquals(list, result);
    }

    @Test(dataProvider = "Get")
    public void testGet(MyArrayList list, int index, String result) {
        assertEquals(list.get(index), result);
    }

    @Test(dataProvider = "GetError", expectedExceptions = IndexOutOfBoundsException.class)
    public void testGetError(MyArrayList list, int index, String result) {
        assertEquals(list.get(index), result);
    }

    @Test(dataProvider = "Set")
    public void testSet(MyArrayList list, int index, String element, String result) {
        assertEquals(list.set(index, element), result);
    }

    @Test(dataProvider = "SetError", expectedExceptions = IndexOutOfBoundsException.class)
    public void testSetError(MyArrayList list, int index, String element, String result) {
        assertEquals(list.set(index, element), result);
    }

    @Test(dataProvider = "Add1")
    public void testAdd1(MyArrayList list, int index, String element, MyArrayList result) {
        list.add(index, element);
        assertEquals(list, result);
    }

    @Test(dataProvider = "Add1Error", expectedExceptions = {IndexOutOfBoundsException.class})
    public void testAdd1Error(MyArrayList list, int index, String element, MyArrayList result) {
        list.add(index, element);
        assertEquals(list, result);
    }

    @Test(dataProvider = "Remove1")
    public void testRemove1(MyArrayList list, int index, Object result) {
        assertEquals(list.remove(index), result);
    }

    @Test(dataProvider = "Remove1Error", expectedExceptions = {IndexOutOfBoundsException.class})
    public void testRemove1Error(MyArrayList list, int index, Object result) {
        assertEquals(list.remove(index), result);
    }

    @Test(dataProvider = "IndexOf")
    public void testIndexOf(MyArrayList list, String element, int result) {
        assertEquals(list.indexOf(element), result);
    }

    @Test(dataProvider = "LastIndexOf")
    public void testLastIndexOf(MyArrayList list, String element, int result) {
        assertEquals(list.lastIndexOf(element), result);
    }
}