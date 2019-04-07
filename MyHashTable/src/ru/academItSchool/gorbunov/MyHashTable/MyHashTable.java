package ru.academItSchool.gorbunov.MyHashTable;

import java.util.*;

public class MyHashTable<T> implements Collection<T> {
    private List<T>[] array;
    private int count;
    private int modCount;

    /**
     * Конструктор для создания списка.
     */
    @SuppressWarnings("unchecked")
    public MyHashTable() {
        this.array = new List[10];
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
                if (array[arrayIndex] == null || array[arrayIndex].isEmpty()) {
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

    /**
     * Вычисляет индекс в массиве с помощью хэшкода элемента и длины массива.
     *
     * @param o T элемент
     * @return index в виде int
     */
    private int getIndex(Object o) {
        return Math.abs(o.hashCode() % this.array.length);
    }

    /**
     * Добавляет элемент в массив по индексу вычисленому через хэшкод, если данный индекс пустой создает там список.
     *
     * @param element T элемент который необходимо добавить в список.
     */
    private void getAddByIndex(T element) {
        int index = getIndex(element);
        if (this.array[index] == null) {
            this.array[index] = new ArrayList<>();
        }
        this.array[index].add(element);
    }

    /**
     * Все логические элементы списка помещаются в массив.
     *
     * @return T[] массив с элементами хэштаблицы
     */
    @SuppressWarnings("unchecked")
    private T[] getHashTableComponents() {
        T[] allComponents = (T[]) new Object[this.count];
        for (int i = 0, j = 0; i < this.array.length; i++) {
            if (this.array[i] == null || this.array[i].isEmpty()) {
                continue;
            }
            if (this.array[i].size() > 1) {
                for (T el : this.array[i]) {
                    allComponents[j] = el;
                    j++;
                }
            } else {
                allComponents[j] = this.array[i].get(0);
                j++;
            }
        }
        return allComponents;
    }

    /**
     * В случае когда масив переполнен увеличивает его и перераспределяет элементы по новым индексам.
     *
     * @param newSize int длина нового массива.
     */
    @SuppressWarnings("unchecked")
    private void getRefactoringArray(int newSize) {
        T[] hashTableComponents = getHashTableComponents();
        this.array = new List[newSize];
        for (T el : hashTableComponents) {
            getAddByIndex(el);
        }
        this.modCount++;
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
        return getHashTableComponents();
    }

    /**
     * @param a    T1[] передаваемы масив
     * @param <T1> тип переданого масива
     * @return Возвращает содержимое хэштаблицы в виде массива того типа что передали и с содержимым переданого массива.
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T1> T1[] toArray(T1[] a) {
        T[] hashTableComponents = getHashTableComponents();
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
        if (this.count == this.array.length) {
            getRefactoringArray(this.array.length * 2);
        }
        getAddByIndex(t);
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
        int minCapacity = this.count + c.size();
        if (this.array.length < minCapacity) {
            getRefactoringArray(minCapacity);
        }
        for (T el : c) {
            getAddByIndex(el);
        }
        this.count += c.size();
        this.modCount++;
        return true;
    }

    /**
     * Удаляет все элементы из хэштаблицы которые есть в данном списке
     *
     * @param c Collection
     * @return boolean true если удалились все элементы false если список
     * пуст или список совпадает с хэштаблицей по элементам
     * то есть хэш таблица была не изменена
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        if (c.isEmpty()) {
            return false;
        }
        int index;
        boolean arrayListChanged = false;
        for (Object element : c) {
            index = getIndex(element);
            if (array[index] == null || array[index].isEmpty()) {
                continue;
            }
            while (array[index].remove(element)) {
                arrayListChanged = true;
                this.count--;
                this.modCount--;
            }
        }
        return arrayListChanged;
    }

    /**
     * Удаляет все элементы из списка кроме тех что содержатся в переданом списке
     *
     * @param c Collection
     * @return boolean true если удалились все элементы false если не один элемент
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
        for (List arr : this.array) {
            if (arr == null || arr.isEmpty()) {
                continue;
            }
            for (int j = 0; j < arr.size(); j++) {
                if (c.contains(arr.get(j))) {
                    continue;
                }
                arr.remove(j);
                arrayListChanged = true;
                this.count--;
                this.modCount--;
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
            if (this.array[i] == null) {
                continue;
            }
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
        if (this.count <= 0) {
            return "Список пуст";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (List collection : this.array) {
            if (collection == null || collection.isEmpty()) {
                continue;
            }
            stringBuilder.append("[");
            for (Object el : collection) {
                stringBuilder.append(el.toString()).append(", ");
            }
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length()).append("], ");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        return stringBuilder.append("]").toString();
    }
}
