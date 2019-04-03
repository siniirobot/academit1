package ru.academItSchool.gorbunov.MyHashTable;

import java.util.*;

public class MyHashTable<T> implements Collection<T> {
    private final int ARRAY_LENGTH = 10;
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

    private int getIndex(T o) {
        return Math.abs(o.hashCode() % array.length);
    }

    @Override
    public int size() {
        return count;
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

    @Override
    public boolean contains(Object o) {
        int index = getIndex((T) o);
        return this.array[index] != null;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private Object[] hashTableComponents() {
        Object[] allComponents = new Object[this.count];
        for (int i = 0, j = 0; i < this.array.length; i++) {
            if (this.array[i] != null) {
                if (this.array[i].size() > 1) {
                    for (Object el : this.array[i]) {
                        allComponents[j] = el;
                        j++;
                    }
                } else {
                    allComponents[j] = this.array[i].get(0);
                    j++;
                }
            }
        }
        return allComponents;
    }

    @Override

    public Object[] toArray() {
        return hashTableComponents();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T1> T1[] toArray(T1[] a) {
        Object[] hashTableComponents = hashTableComponents();
        if (a.length < this.count) {
            return (T1[]) Arrays.copyOf(hashTableComponents, this.count, a.getClass());
        }
        System.arraycopy(hashTableComponents, 0, a, 0, this.count);
        if (a.length > this.count) {
            a[this.count] = null;
        }
        return a;
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
        int index = getIndex((T) o);
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

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c.isEmpty()) {
            return false;
        }
        int index;
        for (T el : c) {
            index = getIndex(el);
            if (array[index] == null) {
                array[index] = new ArrayList<>();
                array[index].add(el);
            } else {
                array[index].add(el);
            }
        }
        this.count += c.size();
        this.modCount++;
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
        if (c.isEmpty()) {
            return false;
        }
        int index;
        boolean arrayListChanged = false;
        for (Object element : c) {
            index = getIndex((T) element);
            if (array[index] == null || array[index].isEmpty()) {
                continue;
            }
            while (array[index].remove((T) element)) {
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
     * @return boolean true если удалились все элементы false если не один элемент не был затронут
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        if (c.isEmpty()) {
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
