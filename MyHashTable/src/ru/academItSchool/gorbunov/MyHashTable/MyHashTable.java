package ru.academItSchool.gorbunov.MyHashTable;

import java.util.*;

public class MyHashTable<T> implements Collection<T> {
    private List<T>[] array;
    private int count;
    private int modCount;

    /**
     * Конструктор для инициализации пустой хэштаблицы.
     */
    @SuppressWarnings("unchecked")
    public MyHashTable() {
        this.array = new List[10];
        this.count = 0;
        this.modCount = 0;
    }

    /**
     * Класс необходимый для перебора элементов хэштаблицы.
     */
    private class MyIterator implements Iterator<T> {
        private int currentIndex = -1;
        private int modification = modCount;
        private int arrayIndex = 0;
        private int listIndex = 0;

        /**
         * Проверяет есть ли следующий элемент в хэщтаблице.
         *
         * @return boolean
         */
        @Override
        public boolean hasNext() {
            return currentIndex + 1 != count;
        }

        /**
         * Возвращает следующий элемент из хэштаблцы.
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
                if (array[arrayIndex] == null || array[arrayIndex].isEmpty()) {
                    arrayIndex++;
                    continue;
                }
                int elementIndex = listIndex;
                if (listIndex == array[arrayIndex].size()) {
                    arrayIndex++;
                    listIndex = 0;
                    continue;
                }
                listIndex++;
                currentIndex++;
                return array[arrayIndex].get(elementIndex);
            }
            return null;
        }
    }

    /**
     * Вычисляет индекс в массиве с помощью хэшкода элемента и длины массива.
     *
     * @param o T элемент
     * @return index в виде int
     */
    private int getIndex(Object o) {
        return Math.abs(Objects.hashCode(o) % this.array.length);
    }

    /**
     * Добавляет элемент в массив по индексу вычисленому через хэшкод, если данный индекс пустой создает там список.
     *
     * @param element T элемент который необходимо добавить в список.
     */
    private void addByHashCode(T element) {
        int index = getIndex(element);
        if (this.array[index] == null) {
            this.array[index] = new ArrayList<>();
        }
        this.array[index].add(element);
    }

    /**
     * Выдает количесвто элементов в хэштаблице.
     *
     * @return int
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * Проверяет пустая ли хэштаблица
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Проверяет содержится ли данный элемент в хэштаблице
     *
     * @param o T искомы элемент
     * @return true если искомы элемент есть, false если искомого элемента нет.
     */
    @Override
    public boolean contains(Object o) {
        int index = getIndex(o);
        if (array[index] == null) {
            return false;
        }
        return array[index].contains(o);
    }

    /**
     * Выдает иттератор хэштаблицы
     *
     * @return iterator
     */
    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    /**
     * @return Возвращает содержимое хэштаблицы в виде массива.
     */
    @Override
    public Object[] toArray() {
        Object[] hashTableComponents = new Object[this.count];
        int i = 0;
        for (T el : this) {
            hashTableComponents[i] = el;
            i++;
        }
        return hashTableComponents;
    }

    /**
     * @param a    T1[] передаваемы масив
     * @param <T1> тип переданого масива
     * @return Возвращает содержимое хэштаблицы в виде массива того типа что передали и с содержимым переданого массива.
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T1> T1[] toArray(T1[] a) {
        Object[] hashTableComponents = toArray();
        if (a.length < this.count) {
            return (T1[]) Arrays.copyOf(hashTableComponents, this.count, a.getClass());
        }
        System.arraycopy(hashTableComponents, 0, a, 0, this.count);
        if (a.length > this.count) {
            a[this.count] = null;
        }
        return a;
    }

    /**
     * Добавляет элемент в хэштаблицу.
     *
     * @param t добавляемый элемент
     * @return true если элемент добавлен.
     */
    @Override
    public boolean add(T t) {
        addByHashCode(t);
        modCount++;
        count++;
        return true;
    }

    /**
     * Удаляет элемент из хэштаблицы
     *
     * @param o удаляемый элемент
     * @return true если удалось удалить элемент false если не удалось
     */
    @Override
    public boolean remove(Object o) {
        int index = getIndex(o);
        if (array[index] == null || array[index].isEmpty()) {
            return false;
        }
        if (array[index].remove(o)) {
            this.count--;
            this.modCount++;
            return true;
        }
        return false;
    }

    /**
     * Проверяет содержит ли хэштаблца все элементы из данного списка
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
     * Добавляет все элемменты из списка
     *
     * @param c список элементов
     * @return true если добавил элементы false если передаваемый список пуст и хэштаблица не была изменена.
     */
    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c.isEmpty()) {
            return false;
        }
        for (T el : c) {
            addByHashCode(el);
        }
        this.count += c.size();
        this.modCount++;
        return true;
    }

    /**
     * Удаляет все элементы из хэштаблицы которые есть в данном списке
     *
     * @param c Collection
     * @return boolean true если удалилился хотя бы один элемент false если список
     * пуст или список совпадает с хэштаблицей по элементам
     * то есть хэш таблица была не изменена
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        if (c.isEmpty()) {
            return false;
        }
        boolean arrayListChanged = false;
        for (List list : this.array) {
            if (list == null || list.isEmpty()) {
                continue;
            }
            int listSize = list.size();
            if (list.removeAll(c)) {
                arrayListChanged = true;
                listSize -= list.size();
                this.count -= listSize;
                this.modCount++;
            }
        }
        return arrayListChanged;
    }

    /**
     * Удаляет все элементы из хэштаблицы кроме тех что содержатся в переданом списке
     *
     * @param c Collection
     * @return boolean true если удалился хлья бы один элемент false если не один элемент
     * не был затронут
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        if (c.isEmpty()) {
            if (isEmpty()) {
                return false;
            }
            clear();
            return true;
        }
        boolean arrayListChanged = false;
        for (List list : this.array) {
            if (list == null || list.isEmpty()) {
                continue;
            }
            int listSize = list.size();
            if (list.retainAll(c)) {
                arrayListChanged = true;
                listSize -= list.size();
                this.count -= listSize;
                this.modCount++;
            }
        }
        return arrayListChanged;
    }

    /**
     * Делает хэштаблицу пустой.
     */
    @Override
    public void clear() {
        for (int i = 0; i < this.array.length; i++) {
            this.array[i] = null;
        }
        this.count = 0;
        this.modCount++;
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
        if (this.count != that.count) {
            return false;
        }
        for (int i = 0; i < this.array.length; i++) {
            if (!Objects.equals(that.array[i], this.array[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        for (int i = 0; i < this.count; i++) {
            result = prime * result + Objects.hashCode(this.array[i]);
        }
        return result;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Таблица пуста";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (T el : this) {
            stringBuilder.append(el).append(", ");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        return stringBuilder.append("]").toString();
    }
}
