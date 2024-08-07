package Projectschooldatabase;//package Projectschooldatabase;

import java.util.Arrays;

public class Faculty extends Employee {

    private Course[] coursesTaught;
    private int numCoursesTaught;
    private boolean isTenured;

    public Faculty() {
        super();
        coursesTaught = new Course[100];
        numCoursesTaught = 0;
        isTenured = false;
    }

    public Faculty(boolean isTenured) {
        super();
        coursesTaught = new Course[100];
        numCoursesTaught = 0;
        this.isTenured = isTenured;
    }

    public Faculty(String deptName, boolean isTenured) {
        super(deptName);
        coursesTaught = new Course[100];
        numCoursesTaught = 0;
        this.isTenured = isTenured;
    }

    public Faculty(String name, int birthYear, String deptName, boolean isTenured) {
//        super(deptName, birthYear, name);
        super(name, birthYear, deptName);
        coursesTaught = new Course[100];
        numCoursesTaught = 0;
        this.isTenured = isTenured;
    }

    public boolean isTenured() {
        return isTenured;
    }

    public int getNumCoursesTaught() {
        return numCoursesTaught;
    }

    public void setIsTenured(boolean isTenured) {
        this.isTenured = isTenured;
    }

    // appends course to end of existing array
    public void addCourseTaught(Course course) {
        if (numCoursesTaught < 100) {
            coursesTaught[numCoursesTaught] = course;
            numCoursesTaught++;
        }

    }

    // DIFFERENCE: appends courses to end of existing array.
    public void addCoursesTaught(Course[] courses) {
        for (int i = 0; i < courses.length; i++) {
            addCourseTaught(courses[i]);
        }
    }


    public Course getCourseTaught(int index) {
        if (index >= 0 && index < numCoursesTaught) {
            return coursesTaught[index]; // check and verify index
        } else {
            return null; // return null for invalid index
        }

    }

    // helper method
    public String getCourseTaughtAsString(int index) {
        Course course = getCourseTaught(index);
        return (course != null) ? course.getCourseDept() + "-" + course.getCourseNum() : "";
    }

    public String getAllCoursesTaughtAsString() {
//        String allCourses = "";
//        for (int i = 0; i < numCoursesTaught; i++) {
//            allCourses += getCourseTaughtAsString(i);
//            if (i < numCoursesTaught - 1) {
//                allCourses += ", ";
//
//            }
//        }
//        return allCourses;

        StringBuilder allCourses = new StringBuilder();
        for (int i = 0; i < numCoursesTaught; i++) {
            allCourses.append(getCourseTaughtAsString(i));
            if (i < numCoursesTaught - 1) {
                allCourses.append(", ");
            }
        }
        return allCourses.toString();

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Faculty faculty = (Faculty) obj;
        return numCoursesTaught == faculty.numCoursesTaught &&
                isTenured == faculty.isTenured &&
                Arrays.equals(Arrays.copyOf(coursesTaught, numCoursesTaught),
                        Arrays.copyOf(faculty.coursesTaught, faculty.numCoursesTaught));
    }

//    @Override
//    public String toString() {
//        return String.format(" Faculty: %11s | Number of Courses Taught: %3d | Courses Taught: %s", super.toString(), getName(), numCoursesTaught, getAllCoursesTaughtAsString(), (isTenured ? "Tenured" : "Not Tenured"));
//    }

    @Override
    public String toString() {
        return String.format("%s Faculty: %11s | Number of Courses Taught: %3d | Courses Taught: %s",
                super.toString(), (isTenured ? "Tenured" : "Not Tenured"), numCoursesTaught, getAllCoursesTaughtAsString());
    }


//	public int compareTo(Person p) {
//			if (p instanceof Faculty) {
//				return super.compareTo(p);
//			
//			Faculty p = (Faculty) p;
//			return Integer.compare(this.numCoursesTaught, p.numCoursesTaught);
//		} else {
//			return super.compareTo(p);
//		}
//	}
//    public int compareTo(Person p) {
//        if (this.numCoursesTaught < super.compareTo(p)) {
//            return -1;
//        } else if (this.numCoursesTaught > super.compareTo(p)) {
//            return 1;
//        } else {
//            return 0;
//        }
//    }

    @Override
    public int compareTo(Person p) {
        if (p instanceof Faculty) {
            Faculty f = (Faculty) p;
            return Integer.compare(this.numCoursesTaught, f.numCoursesTaught);
        }
        return super.compareTo(p);
    }
}

	
	
	

