package ru.academItSchool.gorbunov.myArrayList;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyArrayList<T> implements List<T> {
    private final int ARRAY_LENGTH = 10;
    private T[] array;
    private int length;
    private int modCount;

    /**
     * Создание списка определение его типа.
     */
    @SuppressWarnings("unchecked")
    public MyArrayList() {
        this.array = (T[]) new Object[ARRAY_LENGTH];
        this.length = 0;
        this.modCount = 0;
    }

    /**
     * Создание исписка определеного типа и одновременно его заполнение.
     *
     * @param array T
     */
    @SuppressWarnings("unchecked")
    public MyArrayList(T... array) {

        this.array = array;
        this.length = array.length;
        this.modCount = 0;
    }

    /**
     * Создание списка определеного размера и
     * определение его типа.
     */
    @SuppressWarnings("unchecked")
    public MyArrayList(int capacity) {
        this.array = (T[]) new Object[capacity];
        this.length = 0;
        this.modCount = 0;
    }

    private class MyIterator implements Iterator<T> {
        private int currentIndex = -1;
        private int modification = modCount;

        @Override
        public boolean hasNext() {
            return currentIndex + 1 != length;
        }

        @Override
        public T next() {
            if (modification != modCount) {
                throw new ConcurrentModificationException("Список был изменен");
            }
            currentIndex++;
            return array[currentIndex];
        }
    }

    private void increaseCapacity() {
        this.array = Arrays.copyOf(this.array, this.array.length + ARRAY_LENGTH);
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (T arr : array) {
            if (arr.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.array, this.length);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length + this.length > this.array.length) {
            T1[] temp = Arrays.copyOf(a,a.length + this.array.length);
            System.arraycopy(this.array,0,temp,a.length ,this.length);
            return temp;
        }
        System.arraycopy(this.array,0,a,a.length,this.length);
        return a;
    }

    @Override
    public boolean add(T t) {
        if (this.length == this.array.length) {
            increaseCapacity();
        }
        this.array[length] = t;
        this.length++;
        this.modCount++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int objectIndex = indexOf(o);
        if (objectIndex == -1) {
            return false;
        }
        System.arraycopy(this.array, objectIndex + 1, this.array, objectIndex, this.array.length - objectIndex - 1);
        this.array[this.length - 1] = null;
        this.length--;
        this.modCount++;
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element : c)
            if (!contains(element))
                return false;
        return true;
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
    public int indexOf(Object o) {
        for (int i = 0; i < this.length; i++) {
            if (this.array[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
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

    /**
     * Вывод элемента списков в виде строки.
     *
     * @return String
     */
    @Override
    public String toString() {
        Stream<T> stream = Stream.of(this.array).limit(this.length);
        return stream.collect(Collectors.toList()).toString();
    }
}
