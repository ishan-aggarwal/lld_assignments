package generics_example;

public class Client {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.age = 10;
        s1.name = "A";
        s1.display();

        Student s2 = s1;
        s2.age = 20;
        s2.name = "B";

        s2.display();

        s1.display();
    }
}
