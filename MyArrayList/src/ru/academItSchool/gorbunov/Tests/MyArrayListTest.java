package ru.academItSchool.gorbunov.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.academItSchool.gorbunov.myArrayList.MyArrayList;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import static org.testng.Assert.*;

public class MyArrayListTest {
    @DataProvider(name = "Size")
    public Object[][] size() {
        return new Object[][]{
                new Object[]{new MyArrayList<>(), 0}
        };
    }

    @DataProvider(name = "IsEmpty")
    public Object[][] isEmpty() {
        return new Object[][]{
                new Object[]{new MyArrayList<>(), true}
        };
    }

    @DataProvider(name = "Add")
    public Object[][] add() {
        return new Object[][]{
                new Object[]{new MyArrayList<>(), "Это нулевой элемент", true}
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
                        new String[]{"Это нулевой элемент", "Это первый элемент", "Это второй элемент", "Это третий элемент"},
                        new String[]{"Это нулевой элемент", "Это первый элемент", "Это второй элемент", "Это третий элемент",
                                "Это нулевой элемент", "Это первый элемент", "Это второй элемент"}}
        };
    }


    @DataProvider(name = "Remove")
    public Object[][] remove() {
        return new Object[][]{
                new Object[]{new MyArrayList<>("Это нулевой элемент", "Это первый элемент", "Это второй элемент"),
                        "Это первый элемент",
                        true}
        };
    }

    @DataProvider(name = "ContainsAll")
    public Object[][] containsAll() {
        return new Object[][]{
                new Object[]{new MyArrayList<>("Это нулевой элемент", "Это первый элемент", "Это второй элемент"),
                        new MyArrayList<>("Это первый элемент", "Это нулевой элемент"),
                        true}
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

    @DataProvider(name = "AddAll1")
    public Object[][] addAll1() {
        return new Object[][]{
                new Object[]{new MyArrayList<>("Это нулевой элемент", "Это первый элемент", "Это второй элемент"),
                        1,
                        new MyArrayList<>("Это первый элемент", "Это нулевой элемент"),
                        true}
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

    @DataProvider(name = "RetainAll")
    public Object[][] retainAll() {
        return new Object[][]{
                new Object[]{new MyArrayList<>("Это нулевой элемент", "Это первый элемент", "Это второй элемент"),
                        new MyArrayList<>("Это первый элемент", "Это нулевой элемент"),
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

    @DataProvider(name = "Set")
    public Object[][] set() {
        return new Object[][]{
                new Object[]{new MyArrayList<>("Это нулевой элемент", "Это первый элемент", "Это второй элемент"),
                        1,
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
                        new MyArrayList<>("Это нулевой элемент", "1.5","Это первый элемент", "Это второй элемент")}
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

    @DataProvider(name = "IndexOf")
    public Object[][] indexOf() {
        return new Object[][]{
                new Object[]{new MyArrayList<>(new String[5]),
                        "Это второй элемент", 2}
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
        assertEquals(list.toArray(array), result);
    }

    @Test(dataProvider = "Add")
    public void testAdd(MyArrayList list, String element, boolean result) {
        assertEquals(list.add(element), result);
    }

    @Test(dataProvider = "Remove")
    public void testRemove(MyArrayList list, String element, boolean result) {
        assertEquals(list.remove(element), result);
    }

    @Test(dataProvider = "ContainsAll")
    public void testContainsAll(MyArrayList list, MyArrayList list2, boolean result) {
        assertEquals(list.containsAll(list2), result);
    }

    @Test(dataProvider = "AddAll")
    public void testAddAll(MyArrayList list, MyArrayList list2, boolean result) {
        assertEquals(list.addAll(list2), result);
    }

    @Test(dataProvider = "AddAll1")
    public void testAddAll1(MyArrayList list, int index, MyArrayList list2, boolean result) {
        assertEquals(list.addAll(index, list2), result);
    }

    @Test(dataProvider = "RemoveAll")
    public void testRemoveAll(MyArrayList list, MyArrayList list2, boolean result) {
        ArrayList<String> List = new ArrayList<>(Arrays.asList("Это нулевой элемент", "Это первый элемент",
                "Это второй элемент", "Это третий элемент"));
        ArrayList<String> List1 = new ArrayList<>(Arrays.asList("Это первый элемент",
                "Это второй элемент", "dfsdfs"));
        List.removeAll(List1);
        assertEquals(list.removeAll(list2), result);
    }

    @Test(dataProvider = "RetainAll")
    public void testRetainAll(MyArrayList list, MyArrayList list2, boolean result) {
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

    @Test(dataProvider = "Set")
    public void testSet(MyArrayList list, int index, String element, String result) {
        assertEquals(list.set(index, element), result);
    }

    @Test(dataProvider = "Add1")
    public void testAdd1(MyArrayList list, int index, String element, MyArrayList result) {
        list.add(index, element);
        assertEquals(list, result);
    }

    @Test(dataProvider = "Remove1")
    public void testRemove1(MyArrayList list, int index,Object result) {
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