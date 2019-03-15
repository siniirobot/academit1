package ru.academItSchool.gorbunov.myArrayList;

import java.util.*;

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
     *
     * @param array T
     */
    @SuppressWarnings("unchecked")
    public MyArrayList(T... array) {
        this.array = Arrays.copyOf(array, array.length + ARRAY_LENGTH);
        this.count = array.length;
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
            currentIndex++;
            return array[currentIndex];
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
     * Кидает исключение если введеный список пуст.
     *
     * @param c Collection
     */
    private void throwEmptyList(Collection<?> c) {
        if (c.isEmpty()) {
            throw new NullPointerException("Список должен содержать хотя бы один элемент.");
        }
    }

    /**
     * Увеличивает вместимость списка до указаного размера.
     *
     * @param minCapacity int
     */
    public void ensureCapacity(int minCapacity) {
        throwIllegalArgumentException(minCapacity);
        this.array = Arrays.copyOf(this.array, minCapacity);
    }

    /**
     * Уменьшает размер массива до размера текущего списка.
     */
    public void trimToSize() {
        this.array = Arrays.copyOf(this.array, count);
    }

    /**
     * Увеличивает вместимость списка на ARRAY_LENGTH
     */
    private void increaseCapacity() {
        this.array = Arrays.copyOf(this.array, this.array.length + ARRAY_LENGTH);
    }

    /**
     * Уменьшает массив в указаном индексе тем самым удаляя элемент
     *
     * @param index int
     */
    private void getCollapseArray(int index) {
        System.arraycopy(this.array, index + 1, this.array, index, this.array.length - index - 1);
        this.array[this.count - 1] = null;
        this.count--;
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
        return Arrays.copyOf(this.array, this.count);
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
            return (T1[]) Arrays.copyOf(this.array, this.count, a.getClass());
        }
        System.arraycopy(this.array, 0, a, 0, this.count);
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
        if (this.count == this.array.length) {
            increaseCapacity();
        }
        this.array[count] = t;
        this.count++;
        this.modCount++;
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
        getCollapseArray(index);
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
        throwEmptyList(c);
        for (Object element : c)
            if (!contains(element)) {
                return false;
            }
        return true;
    }

    /**
     * Добавляет все элементы из данного списка в список.
     *
     * @param c Collection
     * @return boolean true если добавились false если нет
     */
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

    /**
     * Добавляет все элементы из данного списка в список по указаному индексу
     *
     * @param index int
     * @param c     Collection
     * @return boolean true если добавились false если нет
     */
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

    /**
     * Удаляет все элементы из списка которые есть в данном списке
     *
     * @param c Collection
     * @return boolean true если удалились все элементы false если нет
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        throwEmptyList(c);
        for (Object element : c) {
            remove(element);
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
        throwEmptyList(c);
        for (Object element : c) {
            if (!contains(element)) {
                remove(element);
            }
        }
        return true;
    }

    /**
     * Очищает список
     */
    @Override
    public void clear() {
        this.array = null;
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
        return this.array[index];
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
        T oldElement = this.array[index];
        this.array[index] = element;
        this.modCount++;
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
        if (this.count == this.array.length) {
            increaseCapacity();
        }
        System.arraycopy(this.array, index, this.array, index + 1, this.count - index);
        this.array[index] = element;
        this.count++;
        this.modCount++;
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
        T delElement = this.array[index];
        getCollapseArray(index);
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

    /**
     * Возвращает индекс последнего вхождения переданого элемента
     *
     * @param o Object
     * @return int
     */
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
}