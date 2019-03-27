package ru.academItSchool.gorbunov.MyHashTable;

import java.util.*;

public class MyHashTable<T> implements Collection<T> {
    private final int ARRAY_LENGTH = 5;
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
        private int currentIndex = -1;
        private int modification = modCount;
        private int arrayIndex = 0;
        private int listIndex = -1;

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
            while (arrayIndex < array.length) {
                if (array[arrayIndex] == null) {
                    arrayIndex++;
                    continue;
                }
                if (array[arrayIndex].size() > 1) {
                    listIndex++;
                    if (listIndex == array[arrayIndex].size()) {
                        listIndex = -1;
                        arrayIndex++;
                        continue;
                    }
                    currentIndex++;
                    return array[arrayIndex].get(listIndex);
                } else {
                    int index = arrayIndex;
                    arrayIndex++;
                    currentIndex++;
                    return array[index].get(0);
                }
            }
            return null;
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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                continue;
            }
            stringBuilder.append("[");
            for (Object el : array[i]) {
                stringBuilder.append(el.toString()).append(", ");
            }
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length()).append("], ");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        return stringBuilder.append("]").toString();
    }
}
