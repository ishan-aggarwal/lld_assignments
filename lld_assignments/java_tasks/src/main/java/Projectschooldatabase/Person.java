package Projectschooldatabase;

public class Person implements Comparable<Person> {

    private String name;
    private int birthYear;

    public Person() {
        name = "";
        birthYear = 0;

    }

    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    // getters and setters methods

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Person) {
            Person p = (Person) obj;
            if (this.name == p.name && this.birthYear == p.birthYear) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String str = String.format("Person: Name: %30s | Birth Year: %4d", name, birthYear);
        return str;
    }

    @Override
    public int compareTo(Person p) {
        if (this.birthYear < p.birthYear) {
            return -1;
        } else if (this.birthYear > p.birthYear) {
            return 1;
        } else {
            return 0;
        }
    }
}
