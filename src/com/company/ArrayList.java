package com.company;

import java.util.*;
import java.util.Iterator;

public class ArrayList<S> implements List<Student> {
    private int count = 0;
    private int capacity = 10;
    private Student[] studentStorage = new Student[capacity];

    public void print() {
        Iterator<Student> iterator = Arrays.stream(studentStorage).iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }

    /**
     * возвращает колличество элементо
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * Возыращает True если этот список не содержит элементов
     */
    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Проверяет наличие элемента в списке, возвращает boolean
     */
    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    /**
     * перебор списока через итератор
     */
    @Override
    public Iterator<Student> iterator() {
        return new Iterator<Student>() {
            int cursor = 0;
            int lastRet = -1;

            /**
             *проверка наличия следующего элемента в списке
             */
            @Override
            public boolean hasNext() {
                return cursor < count;
            }

            /**
             * Вставка следующего элемента
             */
            @Override
            public Student next() {
                int i = cursor;
                if (i >= count)
                    throw new NoSuchElementException();
                if (i >= studentStorage.length)
                    throw new ConcurrentModificationException();
                cursor = i + 1;
                return (Student) studentStorage[lastRet = i];
            }
        };
    }

    /**
     * Возвращает массив, содержащий все элементы в этом списке в правильной последовательности
     */
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(studentStorage, count);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < count)
            return (T[]) Arrays.copyOf(studentStorage, count, a.getClass());
        System.arraycopy(studentStorage, 0, a, 0, count);
        if (a.length > count)
            a[count] = null;
        return a;
    }

    /**
     * Добавляет новый элемент в конец списка. Возвращает boolean
     */
    @Override
    public boolean add(Student student) {
        if (count == capacity) {
            increaseStudentStorage();
        }
        studentStorage[count] = student;
        count++;
        return true;
    }

    /**
     * увеличение массива
     */
    private void increaseStudentStorage() {
        capacity = capacity + 5;
        Student[] newStudentStorage = new Student[capacity];
        for (int i = 0; i < studentStorage.length; i++) {
            newStudentStorage[i] = studentStorage[i];
        }
        studentStorage = newStudentStorage;
    }

    /**
     * удалене объекта из списка и сдвиг элементов влево
     */
    @Override
    public boolean remove(Object o) {
        if (o == null) {
            throw new NullPointerException("Такого элемента нет");
        }
        for (int i = 0; i < studentStorage.length; i++) {
            if (o.equals(studentStorage[i])) {
                studentStorage[i] = null;
                for (int j = i; j < studentStorage.length - 1; j++) {
                    studentStorage[j] = studentStorage[j + 1];
                }
            }
            count--;
        }
        return true;
    }

    /**
     * проверка наличия переданной коллекции в списке, возвращает boolean
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        for (var item : c) {
            if (!contains(item))
                return false;
        }
        return true;
    }

    /**
     * добавляет все элементы переданной колекции в списак и сдвигает вправо
     */
    @Override
    public boolean addAll(Collection<? extends Student> c) {
        for (var item : c) {
            add(item);
        }
        return true;
    }

    /**
     * добавляет все элементы переданной колекции в списак начиная с индекса и сдвигает вправо
     */
    @Override
    public boolean addAll(int index, Collection<? extends Student> c) {
        for (var item : c) {
            add(index, item);
        }
        return true;
    }

    /**
     * удаляет все элементы переданной коллекции
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        for (var item : c) {
            remove(item);
        }
        return true;
    }

    /**
     * удаляет все элементы, кроме переданной коллекции
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        for (int i = 0; i < count; i++) {
            var item = get(i);
            if (!c.contains(item))
                remove(item);
        }
        return false;
    }

    /**
     * Удаление всех элементов из списка
     */
    @Override
    public void clear() {
        for (int i = 0; i < count; i++) {
            studentStorage[i] = null;
        }
        count = 0;
    }

    /**
     * Возвращает элемент, который расположен в указанной позиции списка.
     */
    @Override
    public Student get(int index) {
        if (index < 0 || index > studentStorage.length) {
            return null;
        }
        return studentStorage[index];
    }

    @Override
    public Student set(int index, Student element) {
        if (index < 0 || index > studentStorage.length) {
            return null;
        }
        return studentStorage[index] = element;
    }

    /**
     * Добавляет элемент в позицию index. При добавлении происходит
     * сдвиг всех элементов справа от указанного индекса на 1 позицию
     */
    @Override
    public void add(int index, Student element) {
        if (index < 0 || index > studentStorage.length) {
            return;
        }
        for (int i = studentStorage.length - 1; i > index; i--) {
            studentStorage[i] = studentStorage[i - 1];
        }
        studentStorage[index] = element;
    }

    /**
     * Удаление элемента в указанной позиции индекса. После удаления сдвигает все элементы влево
     */
    @Override
    public Student remove(int index) {
        if (index < 0 || index > studentStorage.length) {
            return null;
        }
        Student removedStudent = studentStorage[index];
        for (int i = index; i < studentStorage.length - 1; i++) {
            studentStorage[i] = studentStorage[i + 1];
        }
        count--;
        return removedStudent;
    }

    /**
     * Возвращается индекс первого (совпадениея) элемента в списке.
     * Если элемент не найден, также возвращает -1.
     */
    @Override
    public int indexOf(Object o) {
        return indexOfRange(o, count);
    }

    int indexOfRange(Object o, int end) {

        if (o == null) {
            for (int i = 0; i < end; i++) {
                if (studentStorage[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < end; i++) {
                if (o.equals(studentStorage[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Возвращается индекс последнего (совпадениея) элемента в списке.
     * Если элемент не найден, также возвращает -1.
     */
    @Override
    public int lastIndexOf(Object o) {
        return lastIndexOfRange(o, count);
    }

    int lastIndexOfRange(Object o, int end) {
        if (o == null) {
            for (int i = end - 1; i >= 0; i--) {
                if (studentStorage[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = end - 1; i >= 0; i--) {
                if (o.equals(studentStorage[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public ListIterator<Student> listIterator() {
        return new ListIterator<>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return studentStorage[index] != null;
            }

            @Override
            public Student next() {
                return studentStorage[index++];
            }

            @Override
            public boolean hasPrevious() {
                return studentStorage[index] != null;
            }

            @Override
            public Student previous() {
                return studentStorage[index--];
            }

            @Override
            public int nextIndex() {
                if (studentStorage[index++] == null)
                    return count;
                else {
                    return index++;
                }
            }

            @Override
            public int previousIndex() {
                if (studentStorage[index--] == null)
                    return -1;
                else {
                    return index--;
                }
            }

            @Override
            public void remove() {
                studentStorage[index] = null;
                for (int i = index; i < studentStorage.length - 1; i++) {
                    studentStorage[i] = studentStorage[i + 1];
                }
            }

            @Override
            public void set(Student student) {

            }

            @Override
            public void add(Student student) {

            }
        };
    }

    @Override
    public ListIterator<Student> listIterator(int index) {
        return null;
    }

    @Override
    public List<Student> subList(int fromIndex, int toIndex) {
        return null;
    }

}
