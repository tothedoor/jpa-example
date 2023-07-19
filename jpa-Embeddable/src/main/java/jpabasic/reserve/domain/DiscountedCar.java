package jpabasic.reserve.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "car", schema = "dev")
public class DiscountedCar {
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


    @AttributeOverrides({
            @AttributeOverride(name = "integerVal", column = @Column(name = "discount_int_val")),
            @AttributeOverride(name = "decimalVal", column = @Column(name = "discount_decimal_val")),
            @AttributeOverride(name = "currency", column = @Column(insertable = false))
    })
    @Embedded
    private Money discountPrice;
    @Column(name = "reg_dtm")
    private LocalDate regDtm;

    protected DiscountedCar() {}

    public DiscountedCar(String name, String company, Money price, Money discountPrice, LocalDate regDtm) {
        this.name = name;
        this.company = company;
        this.price = price;
        this.discountPrice = discountPrice;
        this.regDtm = regDtm;
    }
}
