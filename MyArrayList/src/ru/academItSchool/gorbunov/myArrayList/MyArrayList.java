package ru.academItSchool.gorbunov.myArrayList;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyArrayList<T> implements List<T> {
    private final int ARRAY_LENGTH = 10;
    private T[] array;
    private int count;
    private int modCount;

    /**
     * Конструктор для создания пустого списка.
     */
    @SuppressWarnings("unchecked")
    public MyArrayList() {
        this.array = (T[]) new Object[ARRAY_LENGTH];
        this.count = 0;
        this.modCount = 0;
    }

    /**
     * Конструктор для создания заполненого списка.
     * @param array T
     */
    @SuppressWarnings("unchecked")
    public MyArrayList(T... array) {
        this.array = Arrays.copyOf(array,array.length + ARRAY_LENGTH);
        this.count = array.length;
        this.modCount = 0;
    }

    /**
     * Конструктор с заранее определеным размером.
     * @param capacity int
     */
    @SuppressWarnings("unchecked")
    public MyArrayList(int capacity) {
        throwIllegalArgumentException(capacity);
        this.array = (T[]) new Object[capacity];
        this.count = 0;
        this.modCount = 0;
    }

    /**
     * Класс необходимый для перебора списка.
     */
    private class MyIterator implements Iterator<T> {
        private int currentIndex = -1;
        private int modification = modCount;

        /**
         * Проверяет есть ли следующий элемент в списке.
         * @return boolean
         */
        @Override
        public boolean hasNext() {
            return currentIndex + 1 != count;
        }

        /**
         * Возвращает следующий элемент из списка.
         * @return T
         */
        @Override
        public T next() {
            if (modification != modCount) {
                throw new ConcurrentModificationException("Список был изменен");
            }
            currentIndex++;
            return array[currentIndex];
        }
    }

    /**
     * Кидает исключение , если введеная длина списка меньше нуля.
     * @param capacity int
     */
    private void throwIllegalArgumentException(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Длина списка не может быть меньше 0");
        }
    }

    /**
     * Кидает исключения для индекса если он меньше нуля или больше длины списка.
     * @param index int
     */
    private void throwExceptionForWrongIndex(int index) {
        if (index >= this.count || index < 0) {
            throw new IndexOutOfBoundsException("Индекс не может быть меньше нуля и больше количества строк матрицы");
        }
    }

    /**
     * Кидает исключение если введеный список пуст.
     * @param c Collection
     */
    private void throwEmptyList(Collection<?> c) {
        if (c.isEmpty()) {
            throw new NullPointerException("Список должен содержать хотя бы один элемент.");
        }
    }


    public void ensureCapacity(int minCapacity) {
        throwIllegalArgumentException(minCapacity);
        this.array = Arrays.copyOf(this.array, minCapacity);
    }

    public void trimToSize() {
        this.array = Arrays.copyOf(this.array, count);
    }

    private void increaseCapacity() {
        this.array = Arrays.copyOf(this.array, this.array.length + ARRAY_LENGTH);
    }

    private void getCollapseArray(int index) {
        System.arraycopy(this.array, index + 1, this.array, index, this.array.length - index - 1);
        this.array[this.count - 1] = null;
        this.count--;
        this.modCount++;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            for (T element : this.array) {
                if (element == null) {
                    return true;
                }
            }
        }
        for (T element : this.array) {
            if (element.equals(o)) {
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
        return Arrays.copyOf(this.array, this.count);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < this.count) {
            return (T1[]) Arrays.copyOf(this.array, this.count, a.getClass());
        }
        System.arraycopy(this.array, 0, a, 0, this.count);
        return a;

    }

    @Override
    public boolean add(T t) {
        System.out.println(t.getClass());
        System.out.println(this.array.getClass());
        if (t.getClass() != this.array.getClass()) {
            throw new IllegalArgumentException("Тип аргумента не соответствует типу списка.");
        }
        if (this.count == this.array.length) {
            increaseCapacity();
        }
        this.array[count] = t;
        this.count++;
        this.modCount++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index == -1) {
            return false;
        }
        getCollapseArray(index);
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throwEmptyList(c);
        for (Object element : c)
            if (!contains(element)) {
                return false;
            }
        return true;
    }


    @SuppressWarnings("unchecked")
    @Override
    public boolean addAll(Collection<? extends T> c) {
        throwEmptyList(c);
        if (c.size() + this.count > this.array.length) {
            ensureCapacity(c.size() + this.count);
        }
        System.arraycopy((T[]) c.toArray(), 0, this.array, this.count, c.size());
        this.modCount++;
        this.count = this.array.length;
        return true;
    }


    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throwEmptyList(c);
        throwExceptionForWrongIndex(index);
        if (c.size() + this.count > this.array.length) {
            ensureCapacity(c.size() + this.count);
        }
        System.arraycopy(this.array, index, this.array, c.size() + index, c.size());
        System.arraycopy(c.toArray(), 0, this.array, index, c.size());
        this.modCount++;
        this.count += c.size();
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throwEmptyList(c);
        for (Object element : c) {
            remove(element);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throwEmptyList(c);
        for (Object element : c) {
            if (!contains(element)) {
                remove(element);
            }
        }
        return true;
    }

    @Override
    public void clear() {
        this.array = null;
        this.count = 0;
        this.modCount++;
    }

    @Override
    public T get(int index) {
        throwExceptionForWrongIndex(index);
        return this.array[index];
    }

    @Override
    public T set(int index, T element) {
        throwExceptionForWrongIndex(index);
        T oldElement = this.array[index];
        this.array[index] = element;
        this.modCount++;
        return oldElement;
    }

    @Override
    public void add(int index, T element) {
        throwExceptionForWrongIndex(index);
        if (this.count == this.array.length) {
            increaseCapacity();
        }
        System.arraycopy(this.array, index, this.array, index + 1, this.count - index);
        this.array[index] = element;
        this.count++;
        this.modCount++;
    }

    @Override
    public T remove(int index) {
        throwExceptionForWrongIndex(index);
        T oldElement = this.array[index];
        getCollapseArray(index);
        return oldElement;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < this.count; i++) {
                if (this.array[i] == null) {
                    return i;
                }
            }
        }
        for (int i = 0; i < this.count; i++) {
            if (this.array[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = this.count - 1; i != 0; i--) {
                if (this.array[i] == null) {
                    return i;
                }
            }
        }
        for (int i = this.count - 1; i != 0; i--) {
            if (this.array[i].equals(o)) {
                return i;
            }
        }
        return -1;
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
