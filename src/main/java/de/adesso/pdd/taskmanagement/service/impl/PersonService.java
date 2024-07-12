package de.adesso.pdd.taskmanagement.service.impl;

import java.util.*;

public class PersonService {
    static class Person {
        String name;
        int age;
        String city;

        Person(String name, int age, String city) {
            this.name = name;
            this.age = age;
            this.city = city;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getCity() {
            return city;
        }

        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + ", city='" + city + "'}";
        }
    }

    public static void processList() {
        List<Person> people = Arrays.asList(
                new Person("John", 28, "New York"),
                new Person("Jane", 34, "San Francisco"),
                new Person("Tom", 21, "New York"),
                new Person("Lucy", 22, "Chicago"),
                new Person("Anna", 30, "New York")
        );

        List<Person> filtered = new ArrayList<>();
        for (Person p : people) {
            if (p.getAge() > 25) {
                filtered.add(p);
            }
        }

        filtered.sort(Comparator.comparing(Person::getName));

        List<String> names = new ArrayList<>();
        for (Person p : filtered) {
            names.add(p.getName());
        }

        Set<String> uniqueNames = new LinkedHashSet<>(names);
        List<String> result = new ArrayList<>(uniqueNames);

        for (String name : result) {
            System.out.println(name);
        }
    }
}

