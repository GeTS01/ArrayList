package com.company;

import java.util.*;

public class ArrayList<S> implements List<Student> {
    int count = 0;
    int capacity = 2;
    private Student[] studentStorage = new Student[capacity];


    public void print() {
        for (var item : studentStorage) {
            System.out.println(item.toString());
        }
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
    public Iterator<Student> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Student student) {
        if (count == capacity) {
            increaseStudentStorage();
        }
        studentStorage[count] = student;
        count++;
        return true;
    }

    private void increaseStudentStorage() {
        capacity = capacity + 1;
        Student[] newStudentStorage = new Student[capacity];
        for (int i = 0; i < studentStorage.length; i++) {
            newStudentStorage[i] = studentStorage[i];
        }
        studentStorage = newStudentStorage;
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
    public boolean addAll(Collection<? extends Student> c) {
        for (var item:c) {   //итератор и итерейбл
            add(item);
        }
       return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Student> c) {
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
        studentStorage = null;
    }

    @Override
    public Student get(int index) {
        return studentStorage[index];
    }

    @Override
    public Student set(int index, Student element) {
        studentStorage[index] = element;
        return element;
    }

    @Override
    public void add(int index, Student element) {
    }

    @Override
    public Student remove(int index) {
        Student copy = studentStorage[index];
        studentStorage[index] = null;
        return copy;
    }

//    @Override
//    public Student remove(int index) {
//        return studentStorage[index] = null;
////        final var student = studentStorage[index];
//    }

    @Override
    public int indexOf(Object o) {

        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<Student> listIterator() {
        return null;
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
