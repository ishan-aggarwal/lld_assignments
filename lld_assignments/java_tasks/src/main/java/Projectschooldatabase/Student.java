package Projectschooldatabase;//package Projectschooldatabase;

public class Student extends Person {
    private static int numStudents;
    private int studentID;
    private Course[] coursesTaken;
    private int numCoursesTaken;
    private boolean isGraduate;
    private String major;

    // Static block to initialize numStudents
    static {
        numStudents = 0;
    }

    public Student() {
        super();
        studentID = ++numStudents; // incrementing numStudents count and assigning studentID
        coursesTaken = new Course[50]; // intializing array with length of 50
        numCoursesTaken = 0;
        isGraduate = false;
        major = "undeclared";
    }

    public Student(boolean isGraduate) {
        this();
        this.isGraduate = isGraduate;
    }

    public Student(String major, boolean isGraduate) {
        this();
        this.major = major;
        this.isGraduate = isGraduate;
    }

    public Student(String name, int birthYear, String major, boolean isGraduate) {
        super(name, birthYear);
        studentID = ++numStudents;
        coursesTaken = new Course[50];
        numCoursesTaken = 0;
        this.isGraduate = isGraduate;
        this.major = major;
    }

    //Getters and setters
    public boolean isGraduate() {
        return isGraduate;
    }

    public int getNumCoursesTaken() {
        return numCoursesTaken;
    }

    public static int getNumStudents() {
        return numStudents;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getMajor() {
        return major;
    }

    public void setIsGraduate(boolean isGraduate) {
        this.isGraduate = isGraduate;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void addCourseTaken(Course course) {
        if (numCoursesTaken < 50) {
            coursesTaken[numCoursesTaken] = course;
            numCoursesTaken++;
        }
    }

    public void addCoursesTaken(Course[] courses) {
        for (Course course : courses) {
            addCourseTaken(course);
        }
    }

    public Course getCourseTaken(int index) {
        if (index >= 0 && index < numCoursesTaken) {
            return coursesTaken[index];
        } else {
            return null; // if index is invalid return null
        }
    }

    public String getCourseTakenAsString(int index) {
        Course course = getCourseTaken(index);
        if (course != null) {
            return course.getCourseDept() + "-" + course.getCourseNum();
        } else {
            return "";
        }
    }

    public String getAllCoursesTakenAsString() {
        String coursesList = "";
        for (int i = 0; i < numCoursesTaken; i++) {
            coursesList += getCourseTakenAsString(i);
            if (i < numCoursesTaken - 1) {
                coursesList += ", "; // comma separation
            }
        }
        return coursesList;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Student student = (Student) obj;
        return studentID == student.studentID &&
                numCoursesTaken == student.numCoursesTaken &&
                isGraduate == student.isGraduate &&
                major.equals(student.major);
    }

    @Override
    public String toString() {
        return String.format("%s Student: studentID: %04d | Major %20s | %14s | Number of Courses Taken: %3d | Courses Taken: %s",
                super.toString(), studentID, major, (isGraduate ? "Graduate" : "Undergraduate"), numCoursesTaken, getAllCoursesTakenAsString());
    }

    // compares Student objects by the number of courses taken
    @Override
    public int compareTo(Person p) {
        if (p instanceof Student) {
            Student other = (Student) p;
            return Integer.compare(this.numCoursesTaken, other.numCoursesTaken);
        }
        return super.compareTo(p);
    }
}

