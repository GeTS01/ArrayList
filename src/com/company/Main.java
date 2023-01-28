package com.company;
import java.util.*;


public class Main {
    static ArrayList<Student> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Выберите действие \n" +
                    "1) Добавить студента\n" +
                    "2) Получить студента по индексу \n" +
                    "3) Заменить одного студента на другого\n" +
                    "4) Удалить студента\n" +
                    "5) Показать всех студентов\n" +
                    "6) Вставить готовых студентов в конец списка\n" +
                    "7) Проверить есть ли такой студент\n" +
                    "8) Получить индекс студента c начало списка\n" +
                    "9) Получить индекс студента c конца списка\n" +
                    "10) Получить колличество студентов\n" +
                    "11) Проверить заполнен ли список\n" +
                    "12) Добавить студента по индексу\n" +
                    "13) Итератор\n" +
                    "14) Проверить есть ли такой список\n" +
                    "15) Удалить несколько элементов коллекции\n" +
                    "16) Удалить коллекцию\n" +
                    "17) Вставить готовых студентов в любое место списка\n" +
                    "18) Очистить список студентов");
            System.out.println("");
            int number = scanner.nextInt();
            if (number == 1) {
                addStudent();
            } else if (number == 2) {
                getStudent();
            } else if (number == 3) {
                setStudent();
            } else if (number == 4) {
                deleteAllStudents();
            } else if (number == 5) {
                arrayList.print();
            } else if (number == 6) {
                addCollection();
            } else if (number == 7) {
                checkContains();
            } else if (number == 8) {
                studentNumber();
            } else if (number == 9) {
                studentNumberEnd();
            } else if (number == 10) {
                System.out.println(arrayList.size());
            } else if (number == 11) {
                System.out.println(arrayList.isEmpty());
            } else if (number == 12) {
                addStudentIndex();
            } else if (number == 13) {
                Iterator<Student> iter = arrayList.iterator();
                while (iter.hasNext())
                    System.out.println(iter.next());
            } else if (number == 14) {
                checkContainsCollection();
            } else if (number == 15) {
                studentRemoveAll();
            } else if (number == 16) {
                deleteСollection();
            } else if (number == 17) {
                addCollectionIndex();
            } else if (number == 18) {
                clearTheList();
            } else if (number == 19) {
                System.out.println(arrayList.isEmpty());
            } else if (number == 20) {
                System.out.println(arrayList.size());
            } else {
                System.out.println("Такого варианта нет");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            menu();
        }
    }

    public static void addStudent() {
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
        Student student1 = new Student("Андрей", 20, 7);
        ArrayList<Student> arrayListTest = new ArrayList<>();
        arrayListTest.add(student1);
        System.out.println("Введите индекс студента, которого хотите заменить");
        int index = scanner.nextInt();
        arrayList.set(index, student1);
    }

    public static void deleteAllStudents() {
        Scanner deleteSt = new Scanner(System.in);
        System.out.println("Выберите вариант удаления студента\n 1) Как обьект \n 2) По индексу ");
        int numberSt = deleteSt.nextInt();
        if (numberSt == 2) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Выберите индекс студента, которого хотите удалить");
            int number = scanner.nextInt();
            arrayList.remove(number);
            System.out.println("Студент успешно удален");
        } else if (numberSt == 1) {
            Student student1 = new Student("2", 2, 2);
            System.out.println(student1);
            arrayList.remove(student1);

        } else {
            System.out.println("Такого варианта нет");
        }
    }

    public static void clearTheList() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вы точно хотите удалить всесь список \n" +
                "1)Да\n2)нет");
        int number = scanner.nextInt();
        if (number == 1) {
            arrayList.clear();
        } else {
            menu();
        }
    }

    public static void studentNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя студента");
        String name = scanner.nextLine();
        System.out.println("Введите индекс студента");
        int age = scanner.nextInt();
        System.out.println("Введите средний рейтинг");
        int averageRating = scanner.nextInt();
        Student student = new Student(name, age, averageRating);
        System.out.println(arrayList.indexOf(student));
    }

    public static void studentNumberEnd() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя студента");
        String name = scanner.nextLine();
        System.out.println("Введите индекс студента");
        int age = scanner.nextInt();
        System.out.println("Введите средний рейтинг");
        int averageRating = scanner.nextInt();
        Student student = new Student(name, age, averageRating);
        System.out.println(arrayList.lastIndexOf(student));
    }

    public static void checkContains() {
        Student student1 = new Student("2", 2, 2);
        System.out.println(student1);
        var res = arrayList.contains(student1);
        System.out.println(res);
    }

    public static void checkContainsCollection() {
        Student student1 = new Student("1", 1, 1);
        Student student2 = new Student("2", 2, 2);
        System.out.println(student1);
        System.out.println(student2);
        ArrayList<Student> testArray = new ArrayList<>();
        testArray.add(student1);
        testArray.add(student2);
        var res = arrayList.containsAll(testArray);
        System.out.println(res);
    }

    public static void addStudentIndex() {
        Scanner scanner = new Scanner(System.in);
        Student student1 = new Student("Леха", 19, 9);
        System.out.println(" Выберите индекс в который хотите добавить студента");
        int number = scanner.nextInt();
        arrayList.add(number, student1);
    }

    public static void addCollectionIndex() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> newArrayList = new ArrayList<>();
        Student student1 = new Student("Иван", 20, 10);
        Student student2 = new Student("Паша", 21, 8);
        newArrayList.add(student1);
        newArrayList.add(student2);
        System.out.println(" Выберите индекс в который хотите добавить студентов");
        int number = scanner.nextInt();
        arrayList.addAll(number, newArrayList);
    }

    public static void addCollection() {
        ArrayList<Student> arrayList2 = new ArrayList<>();
        Student student1 = new Student("Георгйи", 18, 10);
        Student student2 = new Student("Джон", 20, 3);
        arrayList2.add(student1);
        arrayList2.add(student2);
        arrayList.addAll(arrayList2);
    }

    public static void studentRemoveAll() {

        Student student1 = new Student("1", 1, 1);
        Student student2 = new Student("2", 2, 2);
        System.out.println(student1);
        System.out.println(student2);
        ArrayList<Student> testArray = new ArrayList<>();
        testArray.add(student1);
        testArray.add(student2);
        arrayList.retainAll(testArray);
    }

    public static void deleteСollection() {
        Student st1 = new Student("1", 1, 1);
        Student st2 = new Student("3", 3, 3);
        ArrayList<Student> testAr = new ArrayList<>();
        testAr.add(st1);
        testAr.add(st2);
        var res = arrayList.removeAll(testAr);
        System.out.println(res);
    }
}

