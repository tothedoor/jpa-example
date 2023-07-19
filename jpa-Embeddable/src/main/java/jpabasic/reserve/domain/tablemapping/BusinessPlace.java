package jpabasic.reserve.domain.tablemapping;

import jakarta.persistence.*;

@Entity
@Table(name = "bsun_ldgr", schema = "dev")
@SecondaryTables({
        @SecondaryTable(
                name = "bsun_address",
                pkJoinColumns = @PrimaryKeyJoinColumn(name = "bsun_id", referencedColumnName = "id")
        ),
        @SecondaryTable(
                name = "bsun_tel",
                pkJoinColumns = @PrimaryKeyJoinColumn(name = "bsun_id", referencedColumnName = "id")
        )
})
public class BusinessPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "bsun_nm")
    private String bsunNm;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "address1", column = @Column(table = "bsun_address", name = "addr1")),
            @AttributeOverride(name = "address2", column = @Column(table = "bsun_address", name = "addr2"))
    })
    private Address address;

    @Embedded
    private TelphoneNumber telphoneNumber;

    protected BusinessPlace() {}

    public BusinessPlace(String bsunNm, Address address, TelphoneNumber telphoneNumber) {
        this.bsunNm = bsunNm;
        this.address = address;
        this.telphoneNumber = telphoneNumber;
    }
}
