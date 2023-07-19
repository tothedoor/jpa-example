package jpabasic.reserve.domain.tablemapping;

import jakarta.persistence.*;

@Embeddable
public class Address {
    @Column(name = "addr1")
    private String address1;
    @Column(name = "addr2")
    private String address2;
    protected Address() {}

    public Address(String address1, String address2) {
        this.address1 = address1;
        this.address2 = address2;
    }
}
