package com.example.lld1classes.oop5.ex1;

public class Student {
    String name;
    int count = 0;
    static int countStudents = 0; // class member
    // static member belong to the class and not to an object
    // its value is shared by all objects of the class...
    public Student(String name) {
        this.name = name;
    }

    public void test1() {
//        test();
    }

    public static void test() {
        System.out.println("Static methods belongs to the class and not to the object.");
//        test1();
    }

    public static void main(String[] args) {
        Student s1 = new Student("Ishan");
        Student s2 = new Student("Abhishek");
        s1.count = 10;
        s2.count = 40;
        s1.test();
        Student.test();

        s1.countStudents = 50;
//        s2.countStudents = 100;
//
        System.out.println(s1); // Ishan
        System.out.println(s1.countStudents); // 50
        System.out.println(s1.count); // 10

        System.out.println(s2); // Abhishek
        System.out.println(s2.countStudents); // 50
        System.out.println(s2.count); // 40

        System.out.println("---END---");
    }
}
