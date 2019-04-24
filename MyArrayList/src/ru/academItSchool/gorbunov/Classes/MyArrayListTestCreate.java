package ru.academItSchool.gorbunov.Classes;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.academItSchool.gorbunov.myArrayList.MyArrayList;

import static org.testng.Assert.*;

public class MyArrayListTestCreate {
    @DataProvider(name = "EmptyList")
    public Object[][] emptyList() {
        MyArrayList<Object> list = new MyArrayList<>();
        MyArrayList<String> result = new MyArrayList<>();
        return new Object[][]{
                new Object[]{list, result}
        };
    }

    @DataProvider(name = "ArrayList")
    public Object[][] arrayList() {
        MyArrayList<Object> list = new MyArrayList<>("1", "2", "3");
        MyArrayList<String> result = new MyArrayList<>("1", "2", "3");
        MyArrayList<Object> list1 = new MyArrayList<>();
        MyArrayList<String> result1 = new MyArrayList<>();
        return new Object[][]{
                new Object[]{list, result},
                new Object[]{list1, result1}
        };
    }

    @DataProvider(name = "CapacityList")
    public Object[][] capacityList() {
        MyArrayList<Object> list = new MyArrayList<>(15);
        MyArrayList<String> result = new MyArrayList<>(15);
        MyArrayList<Object> list1 = new MyArrayList<>(0);
        MyArrayList<String> result1 = new MyArrayList<>(0);
        return new Object[][]{
                new Object[]{list, result},
                new Object[]{list1, result1}
        };
    }

    @Test(dataProvider = "EmptyList")
    public void emptyList(MyArrayList list, MyArrayList result) {
        assertEquals(list, result);
    }

    @Test(dataProvider = "ArrayList")
    public void arrayList(MyArrayList list, MyArrayList result) {
        assertEquals(list, result);
    }

    @Test(dataProvider = "CapacityList", expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Длина списка не может быть меньше 0")
    public void capacityList(MyArrayList list, MyArrayList result) {
        MyArrayList<String> result2 = new MyArrayList<>(-5);
        assertEquals(list, result);
    }
}