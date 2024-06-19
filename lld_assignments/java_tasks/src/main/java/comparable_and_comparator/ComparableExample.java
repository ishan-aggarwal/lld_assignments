package comparable_and_comparator;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ComparableExample {

    // Comparable -> compareTo
    // Comparator -> compare

    @Builder
    @Getter
    @Setter
    @ToString
    static class Person implements Comparable<Person> {
        private String name;
        private int age;

        @Override
        public int compareTo(Person o) {
            return this.age - o.age;
        }
    }


    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(Person.builder().name("Ishan").age(36).build());
        personList.add(Person.builder().name("Vaibhav").age(38).build());
        personList.add(Person.builder().name("Aadish").age(6).build());

        Collections.sort(personList);

        System.out.println(personList);


//        System.out.println("--------------------");
//
//        List<String> stringList = new ArrayList<>();
//        stringList.add("B");
//        stringList.add("A");
//        stringList.add("D");
//        stringList.add("C");
//        Collections.sort(stringList);
//        System.out.println(stringList);

    }

}
