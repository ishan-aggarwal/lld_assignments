package yash.basics; // package

import java.util.Arrays; // import statements in java
import java.util.Scanner; // import statements in java

// Object is a super class of all your classes

public class Addition { // class is a blueprint

    // class encapsulates both data members and member functions
    // encapsulation//
    // equal importance is given to both the data members and members functions of the class in Java (OOP)

    // c -> function

    // OOP 4- pillars of OOP
    // abstraction
    // encapsulation
    // inheritance
    // polymorphism


    // data members
    int num1;
    int num2;
    int num3;

    int i;
    Integer j;


    // it is not returning anything not even void
    // it's name is same as that of class
    // it is called as constructor of the class
    // it is used to create objects
    public Addition(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    // When there is a method with same name, same return type
    // and they differ on the basis of either number of arguments
    // or type of arguments
    // then it is called as method overloading
    // constructor overloading
    public Addition(int num1, int num2, int num3) {
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
    }

    // member functions

    // object level method
    public int sum() {
        return this.num1 + this.num2;
    }

    public int sumThree() {
        return this.num1 + this.num2 + this.num3;
    }


    // class level utility method
    public static int sum(int n1, int n2) {
        return n1 + n2;
    }

    public static int sum(int n1, int n2, int n3) {
        return n1 + n2 + n3;
    }


    // public -> it is accessible from everywhere
    // static -> it can be called directly by the class name
    // without having a need of the object of the class
    // void -> return type - means we dont want to return anything
    // main -> main is the name of the method
    // String[] args -> these are the program arguments//
    // if you want to supply anything from the command line..
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;

        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();

        // objects of a class
        Addition obj1 = new Addition(num1, num2);
        // new is a keyword to create object a class
        // object/instance variable

        Addition obj2 = new Addition(n1, n2);
        // you can create multiple instance of the same class


        // cout << endln
        // System.out.println (ln)
        // System.out.print
        // non-static method - instance level methods are called
        // using the object
        // these are called as instance/ object level methods
        System.out.println(obj1.sum());
        System.out.println(obj2.sum());
        // obj1 and obj2 are called references of class Addition

        // class level methods
        // static methods are called using class name
        // classname.methodname
        System.out.println(Addition.sum(120, 220));

        Addition obj3 = new Addition(1, 1, 1);
        System.out.println(obj3.sumThree());


        // declare and define
        int[] array = new int[5];
        // start initialising the array
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        array[3] = 4;
        array[4] = 5;
        // printing the array
//        System.out.println(array);
        System.out.println();
        for (int i = 0; i < 5; i++) {
            System.out.print(array[i] + " ");
        }

        int[] array2 = new int[array.length];
        for (int i = 0; i < 5; i++) {
            array2[i] = array[i];
        }

        int l = 0;
        while (l < array.length) {
            System.out.println(l++);
        }

        if (array2[0] % 2 == 0) {

        } else if (array2[0] % 2 != 0){

        } else {

        }

        // it is of fixed size in nature...
        // declaration
        int[][] twoDArray;

        // assigning memory to this reference twoDArray
        twoDArray = new int[2][2];

        // start initialising the 2d array
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                twoDArray[i][j] = i * j;
            }
        }

        System.out.println();
        System.out.println(obj1.i); // 0, 0.0, false
        System.out.println(obj1.j); // null

        // auto boxing
        obj1.j = obj1.i;
        obj1.i = obj1.j;


        // primitive data type
        // int, float, long, double, boolean

        // Let

        // Wrapper classes
        // Non-primitive data types
        // Integer, Float, Long, Double, Boolean, String -> actual classes
        //
    }
}
