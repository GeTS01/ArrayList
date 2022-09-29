package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static ArrayList<Student> arrayList = new ArrayList<>();
    static Student student;

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
//        try catch
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Выберите действие \n" +
                    "1)Добавить студента\n" +
                    "2)Получить студента по индексу \n" +
                    "3)Заменить одного студента на другого\n" +
                    "4)Удалить студента\n" +
                    "5)Показать всех студентов\n" +
                    "6) Вставить готовых студентов в список\n" +
                    "7) Очистить список студентов\n"+
                    "8) Получить индекс студента");
            int namber = scanner.nextInt();
            if (namber == 1) {
                addStudent();
            } else if (namber == 2) {
                getStudent();
            } else if (namber == 3) {
                setStudent();
            } else if (namber == 4) {
                deleteAllStudents();
            } else if (namber == 5) {
                arrayList.print();
            } else if (namber == 6) {
                addСollection();
            } else if (namber == 7) {
                clearTheList();
            }else if (namber == 8) {
                studentNumber();
            } else {
                System.out.println("Такого варианта нет");
            }
        } finally {
            menu();
        }
    }

    public static void addStudent() {                           // Добавить студента
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя студента");
        String name = scanner.nextLine();
        System.out.println("Введите возраст студента");
        int age = scanner.nextInt();
        System.out.println("Введите средний рейтинг");
        int averageRating = scanner.nextInt();
        Student student = new Student(name, age, averageRating);
        System.out.println("Студент успешно добавлен");
        arrayList.add(student);
//        var random = new Random();
//        random.ints(10, 100);
//        for (int i = 0; i < 6; i++) {
//            arrayList.add(new Student(
//                    "Name" + random.nextInt(),
//                    random.nextInt(),
//                    random.nextInt()
//            ));
//        }
    }

    public static void getStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите студента по индексу");
        int index = scanner.nextInt();
        System.out.println();
        System.out.println(arrayList.get(index));
    }

    public static void setStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Создайте нового студента");
        System.out.println("Введите имя студента");
        String name = scanner.nextLine();
        System.out.println("Введите возраст студента");
        int age = scanner.nextInt();
        System.out.println("Введите средний рейтинг");
        int averageRating = scanner.nextInt();
        student = new Student(name, age, averageRating);
        System.out.println("Введите индекс студента, которого хотите заменить");
        int index = scanner.nextInt();
        System.out.println(arrayList.set(index, student));

    }

    public static void deleteAllStudents() {                  // Удалить всех студентов студента
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите индекс студента, которого хотите удалить");
        int number = scanner.nextInt();
        arrayList.remove(number);
        System.out.println("Студент успешно удален");
    }

    public static void addСollection() {
        java.util.ArrayList<Student> arrayList2 = new java.util.ArrayList<>();
        Student student1 = new Student("Георгйи", 18, 10);
        Student student2 = new Student("Джон", 20, 3);
        arrayList2.add(student1);
        arrayList2.add(student2);
        arrayList.addAll(arrayList2);


    }

    public static void clearTheList() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вы точно хотите удалить всесь список \n"+
                "1)Да\n2)нет");
        int number = scanner.nextInt();
        if (number == 1){
            arrayList.clear();
        }else {
            menu();
        }
    }

    public static void studentNumber(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя студента");
        String name = scanner.nextLine();
        System.out.println("Введите индекс студента");
        int age = scanner.nextInt();
        System.out.println("Введите средний рейтинг");
        int averageRating = scanner.nextInt();
        Student student = new Student(name, age, averageRating);
        arrayList.indexOf(student);

    }
}















