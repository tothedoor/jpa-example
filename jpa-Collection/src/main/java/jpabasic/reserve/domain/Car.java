package jpabasic.reserve.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @TableGenerator(
            name = "carIdGen",
            table = "id_seq",
            pkColumnName = "entity",
            valueColumnName = "nextval",
            initialValue = 0,
            allocationSize = 1
    )
    @GeneratedValue(generator = "carIdGen")
    private long id;
    private String name;
    private String company;
    @Embedded
    private Money price;
    @Column(name = "reg_dtm")
    private LocalDate regDtm;

    protected Car() {}

    public Car(String name, String company, Money price, LocalDate regDtm) {
        this.name = name;
        this.company = company;
        this.price = price;
        this.regDtm = regDtm;
    }

    //getter 생략
}