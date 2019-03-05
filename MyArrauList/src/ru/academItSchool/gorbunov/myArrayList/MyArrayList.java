package ru.academItSchool.gorbunov.myArrayList;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class MyArrayList<T> implements List<T> {
    private T[] array;
    private int lenhght;
    private int modCount;

    /**
     * Создание списка определение его типа.
     */
    @SuppressWarnings("unchecked")
    public MyArrayList() {
        this.array = (T[]) new Object[10];
        this.lenhght = 0;
        this.modCount = 0;
    }

    /**
     * Создание списка определеного размера и
     * определение его типа.
     */
    @SuppressWarnings("unchecked")
    public MyArrayList(int capacity) {
        this.array = (T[]) new Object[capacity];
        this.lenhght = 0;
        this.modCount = 0;
    }

    private class MyIterator implements Iterator<T> {
        private int currentIndex = -1;

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }
    }

    private class MyListIterator implements ListIterator<T> {
        private int currentIndex = -1;

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }

        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public T previous() {
            return null;
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(T t) {

        }

        @Override
        public void add(T t) {

        }
    }

    private class MySpliterator implements Spliterator<T> {
        @Override
        public void forEachRemaining(Consumer<? super T> action) {

        }

        @Override
        public long getExactSizeIfKnown() {
            return 0;
        }

        @Override
        public boolean hasCharacteristics(int characteristics) {
            return false;
        }

        @Override
        public Comparator<? super T> getComparator() {
            return null;
        }

        @Override
        public boolean tryAdvance(Consumer<? super T> action) {
            return false;
        }

        @Override
        public Spliterator<T> trySplit() {
            return null;
        }

        @Override
        public long estimateSize() {
            return 0;
        }

        @Override
        public int characteristics() {
            return 0;
        }
    }

    private void increaseCapacity () {
        this.array = Arrays.copyOf(this.array,this.lenhght + 10);
    }

    @Override
    public int size() {
        return lenhght;
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
        if (this.lenhght == this.array.length) {
            increaseCapacity();
        }
        this.array[lenhght] = t;
        return true;
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
        return 0;
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

    @Override
    public void replaceAll(UnaryOperator<T> operator) {

    }

    @Override
    public void sort(Comparator<? super T> c) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

    @Override
    public boolean removeIf(Predicate<? super T> filter) {
        return false;
    }

    @Override
    public Stream<T> stream() {
        return null;
    }

    @Override
    public Stream<T> parallelStream() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {

    }
}
