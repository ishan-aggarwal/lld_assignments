package comparable_and_comparator;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {

    @Builder
    @Getter
    @Setter
    @ToString
    static class Person1 {
        private String name;
        private int age;
        private int salary;
    }


    public static void main(String[] args) {
        List<Person1> personList = new ArrayList<>();
        personList.add(ComparatorExample.Person1.builder().name("XYZ").age(36).build());
        personList.add(ComparatorExample.Person1.builder().name("Vaibhav").age(38).build());
        personList.add(ComparatorExample.Person1.builder().name("Aadish").age(6).build());

        Collections.sort(personList, new AgeSorter());
        System.out.println(personList);

        Collections.sort(personList, new NameSorter());
        System.out.println(personList);
    }

    static class AgeSorter implements Comparator<Person1> {
        @Override
        public int compare(Person1 o1, Person1 o2) {
            return o1.age - o2.age;
        }
    }

    static class NameSorter implements Comparator<Person1> {
        @Override
        public int compare(Person1 o1, Person1 o2) {
            return o1.name.compareTo(o2.name);
        }
    }

}
