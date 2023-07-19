package jpabasic.reserve.domain.tablemapping;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class TelphoneNumber {
    @Column(table = "bsun_tel")
    private String prefix;
    @Column(table = "bsun_tel")
    private String infix;
    @Column(table = "bsun_tel")
    private String postfix;

    protected TelphoneNumber() {}

    public TelphoneNumber(String prefix, String infix, String postfix) {
        this.prefix = prefix;
        this.infix = infix;
        this.postfix = postfix;
    }
}
