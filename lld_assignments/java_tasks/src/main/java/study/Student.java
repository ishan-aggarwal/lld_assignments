package study;


public class Student {

    int psp;
    Integer age;
    String name;

    public Student() {

    }

    public Student(Student s) {
        this.name = s.name;
        this.age = s.age;
        this.psp = s.psp;
    }

    @Override
    public String toString() {
        return "Student{" +
                "psp=" + psp +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Student s = new Student();
        System.out.println(s);
    }
}
