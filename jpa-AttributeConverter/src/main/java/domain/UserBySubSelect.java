package domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Subselect("(select u.id, u.name, u.dprt_cd, c.com_nm" +
        " from dev.user u left join dev.com_cd c on c.grp_cd = 'GPRT' and u.dprt_cd = c.com_cd)")
@Entity
@Immutable
public class UserBySubSelect {
    @Id
    @Column(name = "id")
    private long id;

    private String name;
    @Column(name = "dprt_cd")
    private String departmentCode;

    @Column(name = "com_nm")
    private String departmentName;

    protected UserBySubSelect() {};

    public UserBySubSelect(long id, String name, String departmentCode, String departmentName) {
        this.id = id;
        this.name = name;
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "UserBySubSelect{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", departmentCode='" + departmentCode + '\'' +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
