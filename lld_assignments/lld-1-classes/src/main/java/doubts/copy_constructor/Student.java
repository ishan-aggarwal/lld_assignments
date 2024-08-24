package doubts.copy_constructor;

public class Student {
    int rollNumber;
    String name;
    int age;
    Address address;

    public Student() {

    }

    public Student(int r, String name, int a) {
        this.rollNumber = r;
        this.name = name;
        this.age = a;
    }

    // This is called Copy constructor
    // because it takes only one argument which is same as that of the class
    // and is used to make a new object by copying exactly the same values as that of passed object

    public Student(Student s) {
        this.rollNumber = s.rollNumber;
        this.name = s.name;
        this.age = s.age;
        this.address = new Address(s.address.location);
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNumber=" + rollNumber +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Ishan Aggarwal";
        s1.rollNumber = 1;
        s1.age = 36;
        Address address1 = new Address("Gurgaon"); // 1 baar bana
        s1.address = address1;

//        Student s2 = new Student(2, "Vaibhav", 38);
//        Address ad2 = new Address("Test address");
//        s2.address = ad2;
//
//        Student s3 = new Student(s2);
//
//        System.out.println(s2);
//        System.out.println(s3);

        Student s4 = new Student(s1); // new memory location is because of new keyword
        System.out.println(s1);
        System.out.println(s4);

    }

}
