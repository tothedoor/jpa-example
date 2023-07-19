package jpabasic.reserve.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Money {
    @Column(name = "int_val")
    private long integerVal;
    @Column(name = "decimal_val")
    private long decimalVal;
    @Column(name = "curr")
    private String currency;

    protected Money() {}

    public Money(long integerVal, long decimalVal, String currency) {
        this.integerVal = integerVal;
        this.decimalVal = decimalVal;
        this.currency = currency;
    }

    public long getIntegerVal() {
        return integerVal;
    }

    public long getDecimalVal() {
        return decimalVal;
    }

    public String getCurrency() {
        return currency;
    }
}
