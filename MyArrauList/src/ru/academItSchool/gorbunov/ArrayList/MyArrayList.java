package ru.academItSchool.gorbunov.ArrayList;

import org.omg.CORBA.Object;

import java.util.*;

public class MyArrayList<T> implements List<T> {

    private T[] array;
    private int size = 0;

    public MyArrayList() {
        this.array = (T[]) new Object[10];
    }

    //Размер списка
    @Override
    public int size() {
        return this.size;
    }

    //Проверка на пустоту списка
    @Override
    public boolean isEmpty() {
        return this.size < 0;
    }

    //Проверка на наличие элемента в списке
    @Override
    public boolean contains(java.lang.Object o) {
        for (int i = 0; i < this.size; i++) {
            if (Objects.equals(o,this.array[i])) {
                return true;
            }
        }
        return false;
    }


    @Override
    public Iterator<T> iterator() {
        return null;
    }

    //Перевод списка в массив
    @Override
    public Object[] toArray() {
        Object[] toArray = (Object[]) Arrays.copyOf(this.array, this.size);
        Arrays.sort(toArray);
        return toArray;
    }

    // Перевод
    @Override
    public <T1> T1[] toArray(T1[] a) {
        T1[] toArray = (T1[]) Arrays.copyOf(this.array, this.size);
        Arrays.sort(toArray);
        return toArray;
    }

    @Override
    public boolean add(T t) {
        if (this.size == this.array.length) {
            T[] newArray = Arrays.copyOf(this.array, this.size + 10);
            newArray[this.size] = t;
            this.size++;
            this.array = Arrays.copyOf(newArray, newArray.length);
            return true;
        } else {
            this.array[this.size] = t;
            this.size++;
            return true;
        }
    }

    @Override
    public boolean remove(java.lang.Object o) {
        for (int i = 0; i < this.size; i++) {
            if (Objects.equals(o, this.array[i])) {
                System.arraycopy(this.array, i, this.array, i + 1, this.size - i);
                this.array[this.size - 1] = null;
                this.size--;
            }
        }
        return false;
    }


    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(java.lang.Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(java.lang.Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}