package doubts;

public class Student {

    // attributes or data members
    private String name;
    private int age;
    private String address;

    // no-argument constructor definition
    public Student() {
        this.name = "Name";
    }

    // first constructor with just one argument in it
    public Student(String name) {
        this.name = name;
    }

//    public Student(String address) {
//        this.address = address;
//    }

    // constructor overloading
    // one more constructor with just one argument in it...
    public Student(int age) {
        this.age = age;
    }

    // One more constructor which is taking 3 arguments...
    public Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    // method overloading means that when you have more than one method with the same name
    // but they are different on the basis of number of arguments or type of arguments
    public int sum(int a, int b) {
        return a + b;
    }

    public int sum(int c, int d, int e) {
        return c + d + e;
    }


    public static void main(String[] args) {

        // constructor is used to create an instance/ object of a class
        // if you don't define any constructor - then java compiler will give you a default constructor.
        // default constructor means that no-argument constructor - so the parameters will be initialised with default values

        Student defaultStudent = new Student(); // default constructor/ no-argument constructor
        System.out.println(defaultStudent.name);
        System.out.println(defaultStudent.age);
        System.out.println(defaultStudent.address);

        Student nameStudent = new Student("Ishan Aggarwal");
        System.out.println(nameStudent.name); // Ishan Aggarwal
        System.out.println(nameStudent.age); // 0
        System.out.println(nameStudent.address); // null

    }

}
