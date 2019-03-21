package ru.academItSchool.gorbunov.myArrayList;

import java.util.*;

public class MyArrayList<T> implements List<T> {
    private final int ARRAY_LENGTH = 10;
    private T[] listElements;
    private int count;
    private int modCount;

    /**
     * Конструктор для создания пустого списка.
     */
    @SuppressWarnings("unchecked")
    public MyArrayList() {
        this.listElements = (T[]) new Object[ARRAY_LENGTH];
        this.count = 0;
        this.modCount = 0;
    }

    /**
     * Конструктор для создания заполненого списка.
     *
     * @param listElements T
     */
    @SuppressWarnings("unchecked")
    public MyArrayList(T... listElements) {
        this.listElements = Arrays.copyOf(listElements, listElements.length + ARRAY_LENGTH);
        this.count = listElements.length;
        this.modCount = 0;
    }

    /**
     * Конструктор с заранее определеным размером.
     *
     * @param capacity int
     */
    @SuppressWarnings("unchecked")
    public MyArrayList(int capacity) {
        throwIllegalArgumentException(capacity);
        this.listElements = (T[]) new Object[capacity];
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
            currentIndex++;
            return listElements[currentIndex];
        }
    }

    /**
     * Кидает исключение , если введеная длина списка меньше нуля.
     *
     * @param capacity int
     */
    private void throwIllegalArgumentException(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Длина списка не может быть меньше 0");
        }
    }

    /**
     * Кидает исключения для индекса если он меньше нуля или больше длины списка.
     *
     * @param index int
     */
    private void throwExceptionForWrongIndex(int index) {
        if (index >= this.count || index < 0) {
            throw new IndexOutOfBoundsException("Индекс не может быть меньше нуля и больше количества строк матрицы");
        }
    }

    /**
     * Увеличивает вместимость списка до указаного размера.
     *
     * @param minCapacity int
     */
    public void ensureCapacity(int minCapacity) {
        throwIllegalArgumentException(minCapacity);
        this.listElements = Arrays.copyOf(this.listElements, minCapacity);
    }

    /**
     * Уменьшает размер массива до размера текущего списка.
     */
    public void trimToSize() {
        if (this.listElements.length != this.count) {
            this.listElements = Arrays.copyOf(this.listElements, this.count);
        }
    }

    /**
     * Увеличивает вместимость списка на ARRAY_LENGTH
     */
    private void increaseCapacity() {
        this.listElements = Arrays.copyOf(this.listElements, this.listElements.length * 2);
    }

    /**
     * Уменьшает массив в указаном индексе тем самым удаляя элемент
     *
     * @param index int
     */
    private void collapseArray(int index) {
        if (index != this.count - 1) {
            System.arraycopy(this.listElements, index + 1, this.listElements, index, this.listElements.length - index - 1);
        }
        this.listElements[this.count] = null;
        this.count--;
        this.modCount++;
    }

    /**
     * Добавляет элемент в конец списка.
     *
     * @param o T
     */
    private void addToEnd(T o) {
        this.listElements[count] = o;
        this.count++;
        this.modCount++;
    }

    /**
     * Возвращает размер массива
     *
     * @return int
     */
    @Override
    public int size() {
        return this.count;
    }

    /**
     * Проверяет пустой ли массив
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Проверяет содержится ли данный элемент в списке
     *
     * @param o Object проверяемый элемент
     * @return boolean true если есть, false если нет.
     */
    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    /**
     * Возвращает иттератор списка
     *
     * @return Iterator
     */
    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    /**
     * Переводит содержимое списка в массив.
     *
     * @return Object[]
     */
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.listElements, this.count);
    }

    /**
     * Добовляет в переданый массив элементы из списка заменяя уже имеющиеся элементы.
     *
     * @param a    T1[]
     * @param <T1> Требуемый массив
     * @return Переделаный массив
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < this.count) {
            return (T1[]) Arrays.copyOf(this.listElements, this.count, a.getClass());
        }
        System.arraycopy(this.listElements, 0, a, 0, this.count);
        if (a.length > this.count) {
            a[this.count] = null;
        }
        return a;
    }

    /**
     * Добавляет новый элемент в конец
     *
     * @param t T
     * @return boolean true если добавился
     */
    @Override
    public boolean add(T t) {
        if (this.count == this.listElements.length) {
            increaseCapacity();
        }
        addToEnd(t);
        return true;
    }

    /**
     * Удаляет данный элемент из списка
     *
     * @param o Object
     * @return boolean true если удалился false если не удалился
     */
    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index == -1) {
            return false;
        }
        collapseArray(index);
        return true;
    }

    /**
     * Проверяет содержит ли список все элементы из данного списка
     *
     * @param c Collection
     * @return boolean true если содержит все элементы false если нет
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element : c) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Добавляет все элементы из данного списка в список.
     *
     * @param c Collection
     * @return boolean true если добавились false если нет
     */
    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c.size() + this.count > this.listElements.length) {
            ensureCapacity(c.size() + this.count);
        }
        for (T element : c) {
            addToEnd(element);
        }
        return true;
    }

    /**
     * Добавляет все элементы из данного списка в список по указаному индексу
     *
     * @param index int
     * @param c     Collection
     * @return boolean true если добавились false если нет
     */
    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throwExceptionForWrongIndex(index);
        if (c.size() + this.count > this.listElements.length) {
            ensureCapacity(c.size() + this.count);
        }
        if (index == this.count - 1) {
            for (T el : c) {
                addToEnd(el);
            }
        } else {
            System.arraycopy(this.listElements, index, this.listElements, index + c.size(), this.count - index);
            int i = index;
            for (T el : c) {
                this.listElements[i] = el;
                i++;
            }
            modCount++;
            this.count += c.size();
        }
        return true;
    }

    /**
     * Удаляет все элементы из списка которые есть в данном списке
     *
     * @param c Collection
     * @return boolean true если удалились все элементы false если нет
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object element : c) {
            int index = indexOf(element);
            while (index >= 0) {
                collapseArray(index);
                index = indexOf(element);
            }
        }
        return true;
    }

    /**
     * Удаляет все элементы из списка кроме тех что содержатся в переданом списке
     *
     * @param c Collection
     * @return boolean true если удалились все элементы false если нет
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        for (int i = 0; i < this.count; i++) {
            if (c.contains(this.listElements[i])) {
                continue;
            }
            collapseArray(i);
            i--;
        }
        return true;
    }

    /**
     * Очищает список
     */
    @Override
    public void clear() {
        for (int i = 0; i < this.count; i++) {
            this.listElements = null;
        }
        this.count = 0;
        this.modCount++;
    }

    /**
     * Достает элемент из списка по указаному индексу
     *
     * @param index int
     * @return T
     */
    @Override
    public T get(int index) {
        throwExceptionForWrongIndex(index);
        return this.listElements[index];
    }

    /**
     * Устанавливает данный элемент по списку
     *
     * @param index   int
     * @param element T
     * @return T старый элемент
     */
    @Override
    public T set(int index, T element) {
        throwExceptionForWrongIndex(index);
        T oldElement = this.listElements[index];
        this.listElements[index] = element;
        return oldElement;
    }

    /**
     * Добавляет элемент по индексу список при этом раздвигается
     *
     * @param index   int
     * @param element T
     */
    @Override
    public void add(int index, T element) {
        throwExceptionForWrongIndex(index);
        if (index == this.count - 1) {
            addToEnd(element);
        } else {
            if (this.count == this.listElements.length) {
                increaseCapacity();
            }
            System.arraycopy(this.listElements, index, this.listElements, index + 1, this.count - index);
            this.listElements[index] = element;
            this.count++;
            this.modCount++;
        }
    }

    /**
     * Удаляет элемент из списка по указаному индексу список при этом схлопывается.
     *
     * @param index int
     * @return T удаленый элемент
     */
    @Override
    public T remove(int index) {
        throwExceptionForWrongIndex(index);
        T delElement = this.listElements[index];
        collapseArray(index);
        return delElement;
    }

    /**
     * Возвращает индекс первого вхождения переданого элемента
     *
     * @param o Object
     * @return int
     */
    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < this.count; i++) {
            if (Objects.equals(this.listElements[i], o)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Возвращает индекс последнего вхождения переданого элемента
     *
     * @param o Object
     * @return int
     */
    @Override
    public int lastIndexOf(Object o) {
        for (int i = this.count - 1; i >= 0; i--) {
            if (Objects.equals(this.listElements[i], o)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Продвинутый Иттератор что может добавлять и удалять элементы по индексу
     *
     * @return null
     */
    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    /**
     * Устанавливает продвинутый иттератор по данному индексу
     *
     * @param index int
     * @return null
     */
    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    /**
     * Возвращает кусок списка начиная с данного индекса до данного индекса
     *
     * @param fromIndex int
     * @param toIndex   int
     * @return bull
     */
    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MyArrayList<?> that = (MyArrayList<?>) o;
        return Arrays.equals(this.listElements, that.listElements);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(this.listElements);
    }

    @Override
    public String toString() {
        if (this.count <= 0) {
            return "Список пуст";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < this.count; i++) {
            stringBuilder.append(this.listElements[i]).append(", ");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        return stringBuilder.append("]").toString();
    }
}