package Projectschooldatabase;//package Projectschooldatabase;

public class Employee extends Person {

    private String deptName;
    private static int numEmployees;
    private int employeeID;

    public Employee() {
        // use of the super() to bring attributes of Person class.
        super();
        deptName = "";
//        numEmployees = 0;
        employeeID = ++numEmployees;
        // =++ numEmployees to generate number of employees and id numbers
    }


    public Employee(String deptName) {
        super();
        this.deptName = deptName;
        this.employeeID = ++numEmployees;
    }


    public Employee(String name, int birthYear, String deptName) {
        super(name, birthYear); // calls these from Person class
        this.deptName = deptName;
        this.employeeID = ++numEmployees;
    }

    // Getters and setters methods

    public String getDeptName() {
        return deptName;
    }

    public static int getNumEmployees() {
        return numEmployees;
    }

    public int getEmployeeID() {
        return employeeID;

    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    // attributes to be inherited to match 2 employee objects
    @Override
    public boolean equals(Object obj) {
//        if (obj == null) {
//            return false;
//        }
//        if (obj instanceof Employee) {
//            Employee e = (Employee) obj;
//            if (this.deptName == e.deptName && this.employeeID == e.employeeID) {
//                return true;
//            }
//        }
//        return false;

        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Employee employee = (Employee) obj;
        return employeeID == employee.employeeID &&
                deptName.equals(employee.deptName) &&
                super.equals(employee);
    }

    // super.toString() to print attributes of Person class
    @Override
    public String toString() {
        return super.toString() + String.format(" Employee: Department: %20s | Employee Number: %3d", deptName, employeeID);

    }

    @Override
    public int compareTo(Person p) {
        if (p instanceof Employee) {
            Employee e = (Employee) p;
            return Integer.compare(this.employeeID, e.employeeID);
        }
        return super.compareTo(p);

//        if (this.employeeID < p.compareTo(p)) {
//            return -1;
//        } else if (this.employeeID > p.compareTo(p)) {
//            return 1;
//        } else {
//            return 0;
//        }
    }
}

