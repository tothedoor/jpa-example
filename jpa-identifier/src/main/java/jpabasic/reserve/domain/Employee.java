package jpabasic.reserve.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "employee", schema = "dev")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(name = "reg_dtm")
    private LocalDate regDtm;

    protected Employee() {}

    public Employee(String name, LocalDate regDtm) {
        this.name = name;
        this.regDtm = regDtm;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getRegDtm() {
        return regDtm;
    }
}
