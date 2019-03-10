package ru.academItSchool.gorbunov.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.academItSchool.gorbunov.myArrayList.MyArrayList;

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
                        new String[]{"Это нулевой элемент", "Это первый элемент", "Это второй элемент","Это третий элемент"},
                        new String[]{"Это нулевой элемент", "Это первый элемент", "Это второй элемент",
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

    @DataProvider(name = "IndexOf")
    public Object[][] indexOf() {
        return new Object[][]{
                new Object[]{new MyArrayList<>("Это нулевой элемент", "Это первый элемент", "Это второй элемент"),
                        "Это второй элемент", 2}
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

    @Test
    public void testContainsAll(MyArrayList list, MyArrayList list2, boolean result) {
        assertEquals(list.contains(list2), result);
    }

    @Test
    public void testAddAll(MyArrayList list, MyArrayList list2, MyArrayList result) {
        assertEquals(list.addAll(list2), result);
    }

    @Test
    public void testAddAll1(MyArrayList list, int index, MyArrayList list2, MyArrayList result) {
        assertEquals(list.addAll(index, list2), result);
    }

    @Test
    public void testRemoveAll(MyArrayList list, MyArrayList list2, MyArrayList result) {
        assertEquals(list.removeAll(list2), result);
    }

    @Test
    public void testRetainAll(MyArrayList list, MyArrayList list2, MyArrayList result) {
        assertEquals(list.retainAll(list2), result);
    }

    @Test
    public void testClear(MyArrayList list, MyArrayList result) {
        list.clear();
        assertEquals(list, result);
    }

    @Test
    public void testGet(MyArrayList list, int index, String result) {
        assertEquals(list.get(index), result);
    }

    @Test
    public void testSet(MyArrayList list, int index, String element, MyArrayList result) {
        assertEquals(list.set(index, element), result);
    }

    @Test
    public void testAdd1(MyArrayList list, int index, String element, MyArrayList result) {
        list.add(index, element);
        assertEquals(list, result);
    }

    @Test
    public void testRemove1(MyArrayList list, int index) {
        assertEquals(list.remove(index), list);
    }

    @Test(dataProvider = "IndexOf")
    public void testIndexOf(MyArrayList list, String element, int result) {
        assertEquals(list.indexOf(element), result);
    }

    @Test
    public void testLastIndexOf(MyArrayList list, String element, String result) {
        assertEquals(list.indexOf(element), result);
    }

    @Test
    public void testReplaceAll(MyArrayList list, MyArrayList result) {
        UnaryOperator<String> operator = x -> x.toLowerCase();
        list.replaceAll(operator);
        assertEquals(list, result);
    }

    @Test
    public void testRemoveIf(MyArrayList list, MyArrayList result) {
        Predicate<String> predicate = n -> n.charAt(0) == 'S';
        assertEquals(list.removeIf(predicate), result);
    }
}