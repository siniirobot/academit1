package ru.academItSchool.gorbunov.MyHashTable;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyHashTable<T> implements Collection<T> {
    private final int ARRAY_LENGTH = 100;
    private Collection<T>[] array;
    private int count;
    private int modCount;

    /**
     * Класс необходимый для перебора списка.
     *//*
    private class MyIterator implements Iterator<T> {
        private int currentIndex = -1;
        private int modification = modCount;

        *//**
         * Проверяет есть ли следующий элемент в списке.
         *
         * @return boolean
         *//*
        @Override
        public boolean hasNext() {
            return currentIndex + 1 != count;
        }

        *//**
         * Возвращает следующий элемент из списка.
         *
         * @return T
         *//*
        @Override
        public T next() {
            if (modification != modCount) {
                throw new ConcurrentModificationException("Список был изменен");
            }
            if (!hasNext()) {
                throw new NoSuchElementException("Следующего элемента нет.");
            }
            currentIndex++;
            return array[currentIndex];
        }
    }*/

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
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
}
