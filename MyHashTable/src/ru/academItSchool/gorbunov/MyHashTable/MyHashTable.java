package ru.academItSchool.gorbunov.MyHashTable;

import java.util.*;

public class MyHashTable<T> implements Collection<T> {
    private final int ARRAY_LENGTH = 100;
    private List<T>[] array;
    private int count;
    private int modCount;

    @SuppressWarnings("unchecked")
    public MyHashTable() {
        this.array = new List[ARRAY_LENGTH];
        this.count = 0;
        this.modCount = 0;
    }

    /**
     * Класс необходимый для перебора списка.
     */
    private class MyIterator implements Iterator<T> {
        private int currentIndex = 0;
        private int modification = modCount;
        private int listStep = 0;

        /**
         * Проверяет есть ли следующий элемент в списке.
         *
         * @return boolean
         */
        @Override
        public boolean hasNext() {
            return currentIndex + 1 != count;
        }

        /**
         * Возвращает следующий элемент из списка.
         *
         * @return T
         */
        @Override
        public T next() {
            if (modification != modCount) {
                throw new ConcurrentModificationException("Список был изменен");
            }
            if (!hasNext()) {
                throw new NoSuchElementException("Следующего элемента нет.");
            }
            if (array[currentIndex] != null && array[currentIndex].size() > 1) {
                if (listStep == array[currentIndex].size()) {
                    int tempListStep = listStep;
                    listStep = 0;
                    int tempEndList = currentIndex;
                    currentIndex++;
                    return array[tempEndList].get(tempListStep);
                } else {
                    listStep++;
                    return array[currentIndex].get(listStep);
                }
            } else if (array[currentIndex] != null) {
                int tempEndList = currentIndex;
                currentIndex++;
                return array[tempEndList].get(1);
            } else {
                currentIndex++;
                return null;
            }
        }
    }

    private int getIndex(T o) {
        return Math.abs(o.hashCode() % array.length);
    }

    @Override
    public int size() {
        return count;
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
        return new MyIterator();
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
        int index = getIndex(t);
        if (array[index] == null) {
            array[index] = new ArrayList<>();
        }
        array[index].add(t);
        modCount++;
        count++;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MyHashTable<?> that = (MyHashTable<?>) o;
        return Arrays.equals(this.array, that.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }
}
