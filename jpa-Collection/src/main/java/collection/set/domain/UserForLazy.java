package collection.set.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user", schema = "dev")
public class UserForLazy {

    @Id
    private long id;
    private String name;
    @ElementCollection //default fetch type = FetchType.LAZY
    @CollectionTable(
            name = "user_tel",
            joinColumns = @JoinColumn(name = "user_id")
    )
    @Column(name = "tel_no")
    private Set<String> telNoSet = new HashSet<>();

    protected UserForLazy() {}

    public UserForLazy(String name, Set<String> telNoSet) {
        this.name = name;
        this.telNoSet = telNoSet;
    }

    public Set<String> getTelNoSet() {
        return telNoSet;
    }
}
