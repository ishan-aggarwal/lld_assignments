package Projectschooldatabase;//package Projectschooldatabase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver_SchoolDB {

    private static ArrayList<Course> courses = new ArrayList<>();
    private static ArrayList<GeneralStaff> staff = new ArrayList<>();
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static ArrayList<Faculty> faculty = new ArrayList<>();
    private static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        loadData();
        printData();
    }

    public static void loadData() {
        String line;
        String className;
        String valString;
        String[] vals;


        try (FileInputStream file = new FileInputStream("C:\\Projects\\Java\\lld_assignments\\lld_assignments\\java_tasks\\src\\main\\java\\Projectschooldatabase\\SchoolDB_Initial.txt"); Scanner scnr = new Scanner(file)) {
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

                    if (valString.isEmpty()) {
                        vals = new String[0];
                    } else {
                        vals = valString.split(",");
                    }
                    // clean the values
                    for (int i = 0; i < vals.length; i++) {
                        vals[i] = vals[i].trim(); // .strip() did not work for me.
                    }
                }

                // 2.use the first value to determine the type of class.
                // 3.use the other values to construct the object.
                // 4.add this object to a container
                switch (className) {
                    case "Course":
                        boolean isGraduate = Boolean.parseBoolean(vals[0]);
                        int courseNumber = Integer.parseInt(vals[1]);
                        String courseName = vals[2];
                        int numberOfCredits = Integer.parseInt(vals[3]);
                        Course c = new Course(isGraduate, courseNumber, courseName, numberOfCredits);
                        courses.add(c);
                        break;
                    case "Faculty":
                        Faculty f = null;
                        if (vals.length == 0) {
                            f = new Faculty();
                        } else if (vals.length == 1) {
                            boolean tenured = Boolean.parseBoolean(vals[0]);
                            f = new Faculty(tenured);
                        } else if (vals.length == 2) {
                            String department = vals[0];
                            boolean tenured = Boolean.parseBoolean(vals[1]);
                            f = new Faculty(department, tenured);
                        } else if (vals.length == 4) {
                            String name = vals[0];
                            int birthYear = Integer.parseInt(vals[1]);
                            String department = vals[2];
                            boolean tenured = Boolean.parseBoolean(vals[3]);
                            f = new Faculty(name, birthYear, department, tenured);
                        }
                        faculty.add(f);
//                        employees.add(f);
                        break;
                    case "Student":
                        Student s = null;
                        if (vals.length == 0) {
                            s = new Student();
                        } else if (vals.length == 1) {
                            boolean isGradStudent = Boolean.parseBoolean(vals[0]);
                            s = new Student(isGradStudent);
                        } else if (vals.length == 2) {
                            String major = vals[0];
                            boolean isGradStudent = Boolean.parseBoolean(vals[1]);
                            s = new Student(major, isGradStudent);
                        } else if (vals.length == 4) {
                            String studentName = vals[0];
                            int studentBirthYear = Integer.parseInt(vals[1]);
                            String major = vals[2];
                            boolean isGradStudent = Boolean.parseBoolean(vals[3]);
                            s = new Student(studentName, studentBirthYear, major, isGradStudent);
                        }
                        students.add(s);
                        break;
                    case "GeneralStaff":
                        GeneralStaff gs = null;
                        if (vals.length == 0) {
                            gs = new GeneralStaff();
                        } else if (vals.length == 1) {
                            String staffDuty = vals[0];
                            gs = new GeneralStaff(staffDuty);
                        } else if (vals.length == 2) {
                            String departmentName = vals[0];
                            String staffDuty = vals[1];
                            gs = new GeneralStaff(departmentName, staffDuty);
                        } else if (vals.length == 4) {
                            String staffName = vals[0];
                            int staffBirthYear = Integer.parseInt(vals[1]);
                            String staffDepartment = vals[2];
                            String duty = vals[3];
                            gs = new GeneralStaff(staffName, staffBirthYear, staffDepartment, duty);
                        }
                        staff.add(gs);
//                        employees.add(gs);
                        break;
                    default:
                        System.out.println("Unknown class type: " + className);
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
        for (Course course : courses) {
            System.out.println(course);
        }
        System.out.println("************************************************");
        System.out.println("************************************************");
        System.out.println("PERSONS:");
        System.out.println("************************************************");
        System.out.println("************************************************");
        System.out.println("EMPLOYEES:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println("************************************************");
        System.out.println("************************************************");
        System.out.println("GENERAL STAFF:");
        for (GeneralStaff gs : staff) {
            System.out.println(gs);
        }
        System.out.println("************************************************");
        System.out.println("************************************************");
        System.out.println("FACULTY:");
        for (Faculty fac : faculty) {
            System.out.println(fac);
        }
        System.out.println("************************************************");
        System.out.println("************************************************");
        System.out.println("STUDENTS:");
        for (Student stu : students) {
            System.out.println(stu);
        }
        System.out.println("************************************************");
        System.out.println("**************************************************************");
    }


//    public static void printData() {
//        System.out.println("**************************************************************");
//        System.out.println("SCHOOL DATABASE INFO:");
//        System.out.println();
//        System.out.println("************************************************");
//        System.out.println("COURSES:");
//        for (int i = 0; i < courses.size(); i++) {
//            System.out.println(courses.get(i));
//        }
//        System.out.println("************************************************");
//        System.out.println("************************************************");
//        System.out.println("PERSONS:");
//        System.out.println("************************************************");
//        System.out.println("************************************************");
//        System.out.println("EMPLOYEES:");
//        System.out.println("************************************************");
//        System.out.println("************************************************");
//        System.out.println("GENERAL STAFF:");
//        for (int i = 0; i < staff.size(); i++) {
//            System.out.println(staff.get(i));
//        }
//        System.out.println("************************************************");
//        System.out.println("************************************************");
//        System.out.println("FACULTY:");
//        for (int i = 0; i < faculty.size(); i++) {
//            System.out.println(faculty.get(i));
//        }
//        System.out.println("************************************************");
//        System.out.println("************************************************");
//        System.out.println("STUDENTS:");
//        for (int i = 0; i < students.size(); i++) {
//            System.out.println(students.get(i));
//        }
//        System.out.println("************************************************");
//        System.out.println("**************************************************************");
//    }


}
