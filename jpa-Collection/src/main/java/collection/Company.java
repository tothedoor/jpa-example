package collection;

import collection.list.Department;
import collection.set.Employee;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(schema = "collection", name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ElementCollection
    @CollectionTable(
            schema = "collection",
            name = "employee",
            joinColumns = @JoinColumn(name = "company_id")
    )
    private Set<Employee> employeeSet = new HashSet<>();

    @ElementCollection
    @CollectionTable(
            schema = "collection",
            name = "department",
            joinColumns = @JoinColumn(name = "company_id")
    )
    private List<Department> departmentList = new ArrayList<>();

    @ElementCollection
    @CollectionTable(
            schema = "collection",
            name = "product",
            joinColumns = @JoinColumn(name = "company_id")
    )
    @MapKeyColumn(name = "name")
    @Column(name = "price")
    private Map<String, Long> productMap = new HashMap<>();

    protected Company() {}

    public Company(String name, Set<Employee> employeeSet, List<Department> departmentList, Map<String, Long> productMap) {
        this.name = name;
        this.employeeSet = employeeSet;
        this.departmentList = departmentList;
        this.productMap = productMap;
    }
}
