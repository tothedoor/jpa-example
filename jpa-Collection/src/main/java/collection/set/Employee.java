package collection.set;

import jakarta.persistence.Embeddable;

@Embeddable
public class Employee {
    String name;
    int age;

    protected Employee() {};

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
