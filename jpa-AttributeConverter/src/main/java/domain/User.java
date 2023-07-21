package domain;

import converter.BooleanYNconverter;
import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Formula;

@Entity
@Table(
        schema = "dev",
        name = "user"
)
@DynamicUpdate
@DynamicInsert
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @Column(name = "use_yn")
    @Convert(converter = BooleanYNconverter.class)
    private boolean useYn;

    @Column(name = "dprt_cd")
    private String departmentCode;

    @Formula("(select c.com_nm from dev.com_cd c where c.grp_cd = 'DPRT' and c.com_cd = dprt_cd)")
    private String departmentName;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", useYn=" + useYn +
                ", departmentCode='" + departmentCode + '\'' +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
