package z.ex_student_m1;

public class Student {
    // write the code of student class here
    int age;
    String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    void display() {
        System.out.println("My name is" + name + "I am " + age + "years old");
    }

    void sayHello(String name2) {
        System.out.println(name + "says hello to " + name2);
    }

}
