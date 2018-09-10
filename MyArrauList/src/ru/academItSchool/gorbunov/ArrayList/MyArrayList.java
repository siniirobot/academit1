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
    public class MyArrayListIterator implements Iterator<T> {
        private int currentIndex = -1;
        private int modification = modCount;

        @Override
        public boolean hasNext() {
            return currentIndex + 1 != size;
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

    //Распечатываем массив
    @Override
    public String toString() {
        Stream<T> stream = Stream.of(this.array).limit(this.size);
        return stream.collect(Collectors.toList()).toString();
    }

    //Получаем увеличиную копию списка
    private void arrayCopy(int size) {
        this.array = Arrays.copyOf(this.array, size);
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
        return new MyArrayListIterator();
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
            arrayCopy(this.array.length + START_ARRAY_SIZE);
        }
        this.array[this.size] = t;
        this.size++;
        this.modCount++;
        return true;
    }

    //Удаление
    @Override
    public boolean remove(java.lang.Object o) {
        boolean del = false;
        for (int i = 0; i < this.size; i++) {
            if (Objects.equals(o, this.array[i])) {
                System.arraycopy(this.array, i + 1, this.array, i, this.size - i - 1);
                this.array[this.size - 1] = null;
                this.size--;
                this.modCount++;
                del = true;
                break;
            }
        }
        return del;
    }

    //Содержит ли текущий список, передаваемый список.
    @Override
    public boolean containsAll(Collection<?> c) {
        if (c.size() > this.size) {
            return false;
        }
        for (int i = 0; i < c.size(); i++) {
            if (!c.contains(this.array[i])) {
                return false;
            }
        }
        return true;
    }

    //Добавление в текущий список, передаваемого списка в конец
    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (this.array.length + c.size() > this.array.length) {
            arrayCopy(this.array.length + c.size());
        }
        for (T e : c) {
            this.array[this.size] = e;
            this.size++;
        }
        modCount++;
        return true;
    }

    //Добавление в текущий список, передаваемого списка по индексу
    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if (this.array.length + c.size() > this.array.length) {
            arrayCopy(this.array.length + c.size());
        }
        T[] temp = (T[]) new Object[this.array.length];
        System.arraycopy(this.array, index, temp, 0, this.size - index);
        for (T e : c) {
            this.array[index] = e;
            index++;
            this.size++;
        }
        System.arraycopy(temp, 0, this.array, index, this.size - index);
        modCount++;
        return true;
    }

    //Удаление из текущего списка всех элементов содержащихся в переданом списке
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean del = false;
        for (int i = 0; i < this.size; i++) {
            if (c.contains(this.array[i])) {
                System.arraycopy(this.array, i + 1, this.array, i, this.size - i - 1);
                this.array[this.size - 1] = null;
                this.size--;
                del = true;
                modCount++;
            }
        }
        return del;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    //Очистка текущего списка
    @Override
    public void clear() {
        this.array = (T[]) new Object[START_ARRAY_SIZE];
        this.size = 0;
        this.modCount=0;
    }

    // Получение значения по текущему индексу
    @Override
    public T get(int index) {
        return this.array[index];
    }

    // установка значения по индексу
    @Override
    public T set(int index, T element) {
        T old = this.array[index];
        this.array[index] = element;
        return old;
    }

    // добавление по индексу
    @Override
    public void add(int index, T element) {
        if (index == this.size) {
            this.array[index] = element;
            this.size++;
            this.modCount++;
        } else {
            this.size++;
            T temp = this.array[index];
            this.array[index] = element;
            T temp2 = this.array[index + 1];
            for (int i = index + 1; i < this.size;i++) {
                this.array[i] = temp;
                temp = this.array[i + 1];
                this.array[i + 1] = temp2;
                i++;
                temp2 = this.array[i + 1];
            }
        }
    }
    //Удаление по текущему индексу.
    @Override
    public T remove(int index) {
        T temp = null;
        if (index == this.size) {
            temp = this.array[index];
            this.array[index] = null;
            this.size--;
            this.modCount++;
        } else {
            temp = this.array[index];
            System.arraycopy(this.array, index + 1, this.array, index, this.size - index - 1);
            this.array[this.size - 1] = null;
            this.size--;
            this.modCount++;
        }
        return temp;
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
