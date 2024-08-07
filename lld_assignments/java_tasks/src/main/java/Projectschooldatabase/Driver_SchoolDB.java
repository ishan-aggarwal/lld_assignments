package Projectschooldatabase;//package Projectschooldatabase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Driver_SchoolDB {

    private static ArrayList<Course> courses = new ArrayList<Course>();
    private static ArrayList<GeneralStaff> staff = new ArrayList<GeneralStaff>();
    private static ArrayList<Employee> employees = new ArrayList<Employee>();
    private static ArrayList<Faculty> faculty = new ArrayList<Faculty>();
    private static ArrayList<Student> student = new ArrayList<Student>();

    public static void main(String[] args) {
        loadData();

        // TODO: MENU; have to make a menu

        printData();
    }

    public static void loadData() {
        String line;
        String className;
        String valString;
        String[] vals;

        try (FileInputStream file = new FileInputStream("SchoolDB_Initial.txt"); Scanner scnr = new Scanner(file)) {
            while (scnr.hasNext()) {
                line = scnr.nextLine();
                System.out.println(line);
                // Create an object based on this line.
                // 1. parse the line and reveal all values.
                int indexColon = line.indexOf(":");
                if (indexColon == -1) { // ':' is not found.
                    continue; // go to next line
                } else {
                    className = line.substring(0, indexColon); // extract class name
                    valString = line.substring(indexColon + 1);
                    vals = valString.split(",");
                    // clean the values
                    for (int i = 0; i < vals.length; i++) {
                        vals[i] = vals[i].trim(); // .strip() did not work for me.
                    }

                }

                // 2.use the first value to determine the type of class.
                // 3.use the other values to construct the object.
                // 4.add this object to a container
                if (className.equals("Course")) {
                    // use the wrapper class of data types to convert the arguments
                    boolean arg1 = Boolean.parseBoolean(vals[0]);
                    int arg2 = Integer.parseInt(vals[1]);
                    int arg4 = Integer.parseInt(vals[3]);
                    // construct the object.
                    Course c = new Course(arg1, arg2, vals[2], arg4);
                    courses.add(c);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printData() {
        System.out.println("**************************************************************");
        System.out.println("SCHOOL DATABASE INFO:");
        System.out.println();
        System.out.println("************************************************");
        System.out.println("COURSES:");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println(courses.get(i));
        }
        System.out.println("************************************************");
        System.out.println("************************************************");
        System.out.println("PERSONS:");
        System.out.println("************************************************");
        System.out.println("************************************************");
        System.out.println("EMPLOYEES:");
        System.out.println("************************************************");
        System.out.println("************************************************");
        System.out.println("GENERAL STAFF:");
        for (int i = 0; i < staff.size(); i++) {
            System.out.println(staff.get(i));
        }
        System.out.println("************************************************");
        System.out.println("************************************************");
        System.out.println("FACULTY:");
        for (int i = 0; i < faculty.size(); i++) {
            System.out.println(faculty.get(i));
        }
        System.out.println("************************************************");
        System.out.println("************************************************");
        System.out.println("STUDENTS:");
        for (int i = 0; i < student.size(); i++) {
            System.out.println(student.get(i));
        }
        System.out.println("************************************************");
        System.out.println("**************************************************************");
    }


}
