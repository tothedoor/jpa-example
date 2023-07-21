package collection.list;

import jakarta.persistence.Embeddable;

@Embeddable
public class Department {
    private String name;
    private String location;

    protected Department() {}

    public Department(String name, String location) {
        this.name = name;
        this.location = location;
    }
}
