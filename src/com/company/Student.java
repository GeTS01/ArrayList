package com.company;

import java.util.Objects;

public class Student {
    public String name;
    public int age;
    public int averageRating;


    public Student(String name, int age, int averageRating) {
        this.name = name;
        this.age = age;
        this.averageRating = averageRating;
    }

    @Override
    public String toString() {    //????
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", averageRating=" + averageRating +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && averageRating == student.averageRating && Objects.equals(name, student.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(int averageRating) {
        this.averageRating = averageRating;
    }
}
