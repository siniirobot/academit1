package ru.academItSchool.gorbunov.ArrayList;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyArrayList<T> implements List<T> {

    private final int START_ARRAY_SIZE = 10;
    private T[] array;
    private int size = 0;
    private int modCount = 0;

    public MyArrayList() {
        this.array = (T[]) new Object[START_ARRAY_SIZE];
    }

    //Иттератор
    public class MyArrayListIterator<T> implements Iterator<T> {
        private int currentIndex = 0;
        private int modification = modCount;
        //private Collection<?> iteratorObject;

        /*public MyArrayListIterator(T[] iteratorObject) {
            this.iteratorObject = iteratorObject[currentIndex];
        }*/
        @Override
        public boolean hasNext() {
            return currentIndex++ == size;
        }

        @Override
        public T next() {

            if (modification != modCount) {
                throw new ConcurrentModificationException("Список был изменен");
            }
            currentIndex++;
            return (T)array[currentIndex];
        }
    }

    //Распечатываем массив
    @Override
    public String toString() {
        Stream<T> stream = Stream.of(this.array).limit(this.size);
        return stream.collect(Collectors.toList()).toString();
    }

    //Размер списка
    @Override
    public int size() {
        return this.size;
    }

    //Проверка на пустоту списка
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    //Проверка на наличие элемента в списке
    @Override
    public boolean contains(java.lang.Object o) {
        for (int i = 0; i < this.size; i++) {
            if (Objects.equals(o, this.array[i])) {
                return true;
            }
        }
        return false;
    }

    //Иттератор
    @Override
    public Iterator<T> iterator() {
        return new MyArrayListIterator<>();
    }

    //Перевод списка в массив
    @Override
    public T[] toArray() {
        T[] toArray = Arrays.copyOf(this.array, this.size);
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

    //Добавление
    @Override
    public boolean add(T t) {
        if (this.size == this.array.length) {
            this.array = Arrays.copyOf(this.array, this.size + START_ARRAY_SIZE);
        }
        this.array[this.size] = t;
        this.size++;
        this.modCount++;
        return true;
    }

    //Удаление
    @Override
    public boolean remove(java.lang.Object o) {
        for (int i = 0; i < this.size; i++) {
            if (Objects.equals(o, this.array[i])) {
                System.arraycopy(this.array, i, this.array, i + 1, this.size - i);
                this.array[this.size - 1] = null;
                this.size--;
                this.modCount++;
            }
        }
        return false;
    }

    //Содержит ли текущая коллекция все элементы переданой коллекции
    @Override
    public boolean containsAll(Collection<?> c) {
        Iterator iterator = new MyArrayListIterator();
        c.iterator();
        while (c.iterator().hasNext()) {
            boolean contain = false;
            for (int i = 0; i < this.size; ++i) {
                if (this.array[i].equals(c.iterator().next())) {
                    contain = true;
                    break;
                }
            }
            if (!contain) {
                return false;
            }
            c.iterator().next();
        }
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
