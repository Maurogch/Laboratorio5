package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Person> Persons = new ArrayList<>();
        Persons = Arrays.asList(new Person("Karina", "Felice", 37, 28754888),
                new Person("Mariela", "Cagnoli", 36, 29754703),
                new Person ("Matias", "Tassara", 15, 56555555),
                new Person("German", "Gianotti", 17, 59754645));

        System.out.println(String.format("Mayores a 21: %s", Persons.stream().
                filter(Person->Person.getAge()>21).
                collect(Collectors.toList())));

        System.out.println(String.format("Menores a 18: %s", Persons.stream().
                filter(Person->Person.getAge()<18).
                collect(Collectors.toList())));
        System.out.println(String.format("Mayores a 21 y dni mayor a 20 millones: %s", Persons.stream().
                filter(Person->Person.getAge()>21).filter(Person->Person.getDni()>20000000).
                collect(Collectors.toList())));
    }
}
